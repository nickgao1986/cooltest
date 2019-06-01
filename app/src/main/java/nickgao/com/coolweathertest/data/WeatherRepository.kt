package nickgao.com.coolweathertest.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import nickgao.com.coolweathertest.data.db.WeatherDao
import nickgao.com.coolweathertest.data.db.model.weather.Weather
import nickgao.com.coolweathertest.data.network.CoolWeatherNetwork

class WeatherRepository private constructor(private val weatherDao: WeatherDao, private val network: CoolWeatherNetwork){


    fun isWeatherCached() = weatherDao.getCachedWeatherInfo() != null


    suspend fun getBingPic(): String {
        var url = weatherDao.getCachedBingPic()
        if (url == null) url = requestBingPic()
        return url
    }



    fun getCachedWeather() = weatherDao.getCachedWeatherInfo()!!
    suspend fun refreshBingPic() = requestBingPic()

    private suspend fun requestBingPic() = withContext(Dispatchers.IO) {
        val url = network.fetchBingPic()
        weatherDao.cacheBingPic(url)
        url
    }


    suspend fun getWeather(weatherId: String): Weather {
        var weather = weatherDao.getCachedWeatherInfo()
        if (weather == null) weather = requestWeather(weatherId)
        return weather
    }

    suspend fun refreshWeather(weatherId: String) = requestWeather(weatherId)

    private suspend fun requestWeather(weatherId: String) = withContext(Dispatchers.IO) {
        val heWeather = network.fetchWeather(weatherId)
        val weather = heWeather.weather!![0]
        weatherDao.cacheWeatherInfo(weather)
        weather
    }

    companion object {

        private lateinit var instance: WeatherRepository

        fun getInstance(weatherDao: WeatherDao, network: CoolWeatherNetwork): WeatherRepository {
            if (!::instance.isInitialized) {
                synchronized(WeatherRepository::class.java) {
                    if (!::instance.isInitialized) {
                        instance = WeatherRepository(weatherDao, network)
                    }
                }
            }
            return instance
        }

    }

}