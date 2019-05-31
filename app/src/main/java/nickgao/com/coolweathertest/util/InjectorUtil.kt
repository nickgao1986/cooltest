package nickgao.com.coolweathertest.util

import nickgao.com.coolweathertest.data.PlaceRepository
import nickgao.com.coolweathertest.data.WeatherRepository
import nickgao.com.coolweathertest.data.db.CoolWeatherDatabase
import nickgao.com.coolweathertest.data.network.CoolWeatherNetwork
import nickgao.com.coolweathertest.ui.MainModelFactory
import nickgao.com.coolweathertest.ui.area.ChooseAreaModelFactory
import nickgao.com.coolweathertest.ui.weather.WeatherModelFactory

object InjectorUtil {

    private fun getPlaceRepository() = PlaceRepository.getInstance(CoolWeatherDatabase.getPlaceDao(), CoolWeatherNetwork.getInstance())


    private fun getWeatherRepository() = WeatherRepository.getInstance(CoolWeatherDatabase.getWeatherDao(), CoolWeatherNetwork.getInstance())

    fun getWeatherModelFactory() = WeatherModelFactory(getWeatherRepository())

    fun getMainModelFactory() = MainModelFactory(getWeatherRepository())

    fun getChooseAreaModelFactory() = ChooseAreaModelFactory(getPlaceRepository())


}