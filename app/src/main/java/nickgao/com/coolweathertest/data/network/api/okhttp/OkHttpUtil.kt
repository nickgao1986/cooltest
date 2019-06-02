package nickgao.com.coolweathertest.data.network.api.okhttp

import okhttp3.*
import java.io.IOException
import java.net.URLEncoder
import java.util.HashMap
import java.util.concurrent.TimeUnit

object OkHttpUtil {

    private lateinit var mOkHttpClient: OkHttpClient

    public enum class REQUEST_TYPE {
        POST, PUT, DELETE
    }

    fun init() {
        val clientBuilder = OkHttpClient()
            .newBuilder()
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .writeTimeout(5000, TimeUnit.MILLISECONDS)
        mOkHttpClient = clientBuilder.build()
    }


    operator fun get(url: String, okHttpCallback: OkHttpCallback) {
        var url = url
        var call: Call? = null
        try {
            val commonHap = ApiCommonParams.fetchCommonsParams()
            url = getFinalUrl(url, commonHap)
            val request = Request.Builder().url(url).build()
            call = mOkHttpClient?.newCall(request)
            call?.enqueue(okHttpCallback)
        } catch (e: Throwable) {
            e.printStackTrace()
        }

    }

    fun getFinalUrl(url: String, urlParamsMap: HashMap<String, String>?): String {
        var url = url
        if (urlParamsMap != null) {
            val paramString = getUrlAppendStr(urlParamsMap)
            url += if (url.contains("?")) "&" else "?"
            url += paramString
        }
        return url
    }

    private fun getUrlAppendStr(urlParamsMap: HashMap<String, String>): String {
        val result = StringBuilder()
        for ((key, value) in urlParamsMap) {
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


    private fun createEncodingBuilderBody(bodyMap: HashMap<String, String>): RequestBody {
        val builder = FormBody.Builder()

        for ((key, value) in bodyMap) {
            builder.add(key, value)
        }
        return builder.build()
    }

    fun sendRequestWithBody(
        url: String, okHttpCallback: OkHttpCallback, bodyMap: HashMap<String, String>,
        type: REQUEST_TYPE
    ) {

        var call: Call? = null
        try {
            val body = createEncodingBuilderBody(bodyMap)
            var request: Request? = null
            if (type == REQUEST_TYPE.POST) {
                request = Request.Builder().post(body).url(url).build()
            } else if (type == REQUEST_TYPE.PUT) {
                request = Request.Builder().put(body).url(url).build()
            } else if (type == REQUEST_TYPE.DELETE) {
                request = Request.Builder().delete(body).url(url).build()
            }
            call = mOkHttpClient!!.newCall(request!!)
            call!!.enqueue(okHttpCallback)
        } catch (e: Throwable) {
            e.printStackTrace()
            okHttpCallback.onFailure(call!!, IOException("get", e))
        }

    }


    fun post(url: String, okHttpCallback: OkHttpCallback, bodyMap: HashMap<String, String>) {
        var call: Call? = null
        try {
            val body = createEncodingBuilderBody(bodyMap)
            val request = Request.Builder().post(body).url(url).build()
            call = mOkHttpClient!!.newCall(request)
            call!!.enqueue(okHttpCallback)
        } catch (e: Throwable) {
            e.printStackTrace()
            okHttpCallback.onFailure(call!!, IOException("get", e))
        }

    }


    fun put(url: String, okHttpCallback: OkHttpCallback, bodyMap: HashMap<String, String>) {
        var call: Call? = null
        try {
            val body = createEncodingBuilderBody(bodyMap)
            val request = Request.Builder().put(body).url(url).build()

            call = mOkHttpClient!!.newCall(request)
            call!!.enqueue(okHttpCallback)
        } catch (e: Throwable) {
            e.printStackTrace()
            okHttpCallback.onFailure(call!!, IOException("put", e))
        }

    }


    fun delete(url: String, okHttpCallback: OkHttpCallback, bodyMap: HashMap<String, String>) {
        var call: Call? = null
        try {
            val body = createEncodingBuilderBody(bodyMap)
            val request = Request.Builder().delete(body).url(url).build()

            call = mOkHttpClient!!.newCall(request)
            call!!.enqueue(okHttpCallback)
        } catch (e: Throwable) {
            e.printStackTrace()
            okHttpCallback.onFailure(call!!, IOException("delete", e))
        }

    }

}
