package nickgao.com.coolweathertest.data.network.api.okhttp

import android.os.Handler
import android.os.Looper
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.json.JSONObject
import org.json.JSONTokener


abstract class OkHttpCallback : Callback {

    protected val isPostMainThread: Boolean
        get() = true


    var okHandler: Handler? = null
        get() {
            return Handler(Looper.getMainLooper())
        }


    abstract fun onSuccess(call: Call, response: JSONObject)


    @Throws(Throwable::class)
    protected fun onSuccess(call: Call, response: Response) {
        val responseStr = response.body()!!.string().trim { it <= ' ' }
        val responseObject = JSONTokener(responseStr).nextValue() as JSONObject
        if (responseObject != null) {
            onSuccessRequest(call, responseObject)
        } else {
            onFailureRequest(call)
        }
    }

    fun onSuccessRequest(call: Call, responseObject: JSONObject) {
        if (isPostMainThread) {
            okHandler?.post { onSuccess(call, responseObject) }
        } else {
            onSuccess(call, responseObject)
        }
    }

    fun onFailureRequest(call: Call) {
        if (isPostMainThread) {
            okHandler?.post { onFailure(call, null!!) }
        } else {
            onFailure(call, null!!)
        }
    }


    override fun onResponse(call: Call, response: Response) {
        if (response != null) {
            try {
                if (response.isSuccessful) {
                    onSuccess(call, response)
                } else {
                    onFailureRequest(call)
                }
            } catch (e: Throwable) {
                onFailureRequest(call)
            }

        } else {
            onFailureRequest(call)
        }
    }


}
