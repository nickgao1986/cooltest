package nickgao.com.coolweathertest.data.network.api

import android.util.Log
import com.google.gson.Gson

import nickgao.com.coolweathertest.data.network.api.okhttp.ApiUtil
import org.json.JSONObject

internal class GetQuestionInfoApi : ApiUtil() {


//    override var url: String = "http://guolin.tech/api/china"
    override var url: String = "http://10.0.2.2/test"

    get() = field
        set(value) {
            field = value;
        }

    @Throws(Exception::class)
    override fun parseData(jsonObject: JSONObject?) {
        Log.d("TAG","<<<<JSONObject="+jsonObject)
    }
}
