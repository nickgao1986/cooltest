package nickgao.com.coolweathertest.data

import nickgao.com.coolweathertest.data.db.WeatherDao
import nickgao.com.coolweathertest.data.network.CoolWeatherNetwork

class WeatherRepository private constructor(private val weatherDao: WeatherDao, private val network: CoolWeatherNetwork){


    fun isWeatherCached() = weatherDao.getCachedWeatherInfo() != null

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