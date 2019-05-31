package nickgao.com.coolweathertest.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nickgao.com.coolweathertest.data.WeatherRepository
import nickgao.com.coolweathertest.data.db.model.weather.Weather

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    var weather = MutableLiveData<Weather>()

    var bingPicUrl = MutableLiveData<String>()

    var refreshing = MutableLiveData<Boolean>()

    var weatherInitialized = MutableLiveData<Boolean>()

    var weatherId = ""

}