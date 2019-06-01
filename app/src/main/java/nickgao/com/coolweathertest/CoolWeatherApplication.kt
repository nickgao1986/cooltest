package nickgao.com.coolweathertest

import android.app.Application
import android.content.Context
import nickgao.com.coolweathertest.data.network.api.okhttp.OkHttpUtil
import org.litepal.LitePal

class CoolWeatherApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        LitePal.initialize(this)
        OkHttpUtil.init()
        context = this
    }

    companion object {
        lateinit var context: Context
    }

}