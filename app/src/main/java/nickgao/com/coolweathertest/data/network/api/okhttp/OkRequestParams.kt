package nickgao.com.coolweathertest.data.network.api.okhttp

import okhttp3.FormBody
import okhttp3.RequestBody

import java.net.URLEncoder
import java.util.HashMap


class OkRequestParams @JvmOverloads constructor(source: Map<String, String>? = null) {

    protected val mUrlParams = HashMap<String, String>()


    val requestBody: RequestBody?
        get() {
            try {
                return createEncodingBuilderBody()
            } catch (e: Throwable) {
                e.printStackTrace()
                return null
            }

        }

    /**
     * result="&key1=value1&key2=value2&key3=value3"
     * @return
     */
    val paramString: String
        get() {
            val result = StringBuilder()
            for ((key, value) in mUrlParams) {
                if (result.length > 0)
                    result.append("&")
                try {
                    result.append(key)
                    result.append("=")
                    result.append(URLEncoder.encode(value, "UTF-8"))
                } catch (e: Throwable) {
                    return ""
                }

            }
            return result.toString()
        }

    init {
        if (source != null) {
            for ((key, value) in source) {
                put(key, value)
            }
        }
    }

    fun put(key: String?, value: String?) {
        if (key != null && value != null) {
            mUrlParams[key] = value
        }
    }

    fun put(params: Map<String, String>?) {
        if (params != null && params.size > 0) {
            mUrlParams.putAll(params)
        }
    }


    fun remove(key: String) {
        mUrlParams.remove(key)
    }


    /**
     * 在post的时候，我们将hashMap的值放入FormBody,FormBody是http3的request body的类
     * @return
     */
    @Throws(Throwable::class)
    private fun createEncodingBuilderBody(): RequestBody {
        val builder = FormBody.Builder()

        for ((key, value) in mUrlParams) {
            builder.add(key, value)
        }
        return builder.build()
    }

}
