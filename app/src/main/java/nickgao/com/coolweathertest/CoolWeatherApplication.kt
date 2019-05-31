package nickgao.com.coolweathertest

import android.app.Application
import android.content.Context
import org.litepal.LitePal

class CoolWeatherApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        LitePal.initialize(this)
        context = this
    }

    companion object {
        lateinit var context: Context
    }

}