package nickgao.com.coolweathertest.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import nickgao.com.coolweathertest.R
import nickgao.com.coolweathertest.data.network.api.GetQuestionInfoApi
import nickgao.com.coolweathertest.data.network.api.okhttp.ApiListener
import nickgao.com.coolweathertest.data.network.api.okhttp.ApiUtil
import nickgao.com.coolweathertest.ui.area.ChooseAreaFragment
import nickgao.com.coolweathertest.util.InjectorUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this, InjectorUtil.getMainModelFactory()).get(MainViewModel::class.java)


        var url = "http://guolin.tech/api/china"
         GetQuestionInfoApi().get(this,myListener());
        if (viewModel.isWeatherCached()) {
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.container, ChooseAreaFragment()).commit()
        }

    }

    class myListener:ApiListener {
        override fun success(api: ApiUtil) {
            Log.d("TAG","<<<<success api");
        }

        override fun failure(api: ApiUtil) {
            Log.d("TAG","<<<<failure api");
        }

    }
}
