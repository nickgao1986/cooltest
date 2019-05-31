package nickgao.com.coolweathertest.ui

import androidx.lifecycle.ViewModel
import nickgao.com.coolweathertest.data.WeatherRepository

class MainViewModel(private val repository: WeatherRepository) : ViewModel() {

    fun isWeatherCached() = repository.isWeatherCached()

}