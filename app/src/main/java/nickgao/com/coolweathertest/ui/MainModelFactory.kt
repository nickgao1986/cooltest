package nickgao.com.coolweathertest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import nickgao.com.coolweathertest.data.WeatherRepository

class MainModelFactory(private val repository: WeatherRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}