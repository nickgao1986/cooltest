package nickgao.com.coolweathertest.data.ui.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.test_fragment.*
import nickgao.com.coolweathertest.CoolWeatherApplication
import nickgao.com.coolweathertest.R
import nickgao.com.coolweathertest.data.network.api.GetQuestionInfoApi
import nickgao.com.coolweathertest.ui.MainActivity

class TestFragment : Fragment() {

    companion object {
        fun newInstance() = TestFragment()
    }

    private lateinit var viewModel: TestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.test_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)
        btn.setOnClickListener() {
           // var url = "http://guolin.tech/api/china"
            GetQuestionInfoApi().get(CoolWeatherApplication.context, MainActivity.myListener());
        }

    }

}
