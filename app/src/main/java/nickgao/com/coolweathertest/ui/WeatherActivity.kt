package nickgao.com.coolweathertest.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import nickgao.com.coolweathertest.ui.weather.WeatherViewModel
import nickgao.com.coolweathertest.util.InjectorUtil

class WeatherActivity : AppCompatActivity(){

    val viewModel by lazy { ViewModelProviders.of(this, InjectorUtil.getWeatherModelFactory()).get(WeatherViewModel::class.java) }


}