package nickgao.com.coolweathertest.data

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import nickgao.com.coolweathertest.R
import nickgao.com.coolweathertest.data.ui.test.TestFragment

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TestFragment.newInstance())
                .commitNow()

        }


    }

}
