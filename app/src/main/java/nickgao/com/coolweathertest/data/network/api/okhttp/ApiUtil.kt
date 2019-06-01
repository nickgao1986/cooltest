package nickgao.com.coolweathertest.data.network.api.okhttp

import android.content.Context
import okhttp3.Call
import org.json.JSONObject

import java.io.IOException
import java.util.HashMap


abstract class ApiUtil {

    /**
     * 状态码
     */
    protected var mStatus = ""

    /**
     * 上下文
     */
    protected var mContext: Context? = null

    /**
     * API发送监听
     */
    protected var mApiListener: ApiListener? = null


    inner class myHttpCallBack:OkHttpCallback(){

        override fun onSuccess(call: Call, response: JSONObject) {
            if (null != response) {
                mStatus = response.optString("status")

                if (isSuccess) {
                    try {
                        parseData(response)
                        if (null != mApiListener) {
                            mApiListener!!.success(this@ApiUtil)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                } else {
                    if (null != mApiListener) {
                        mApiListener!!.failure(this@ApiUtil)
                    }
                }
            }
        }

        override fun onFailure(call: Call, e: IOException) {
            if (null != mApiListener) {
                mApiListener!!.failure(this@ApiUtil)
            }
        }
    }
    private var mSendListener :myHttpCallBack = myHttpCallBack()

    protected val isBackInMainThread: Boolean
        get() = true

    private val mBodyMap = HashMap<String, String>()

    val isSuccess: Boolean
        get() = "0" == mStatus || "200" == mStatus || "success" == mStatus


    /**
     * 获取url
     * @return：http链接url
     */
    protected abstract val url: String

    /**
     * http get
     *
     * @param context           ：上下文
     * @param listener          ：发送回调
     */
    operator fun get(context: Context, listener: ApiListener) {
        mContext = context
        mApiListener = listener
        OkHttpUtil.get(url,mSendListener)
    }

    fun post(listener: ApiListener) {
        mApiListener = listener
        OkHttpUtil.post(url, mSendListener, mBodyMap)

    }

    fun put(listener: ApiListener) {
        mApiListener = listener
        OkHttpUtil.put(url, mSendListener, mBodyMap)

    }

    fun delete(listener: ApiListener) {
        mApiListener = listener
        OkHttpUtil.delete(url, mSendListener, mBodyMap)

    }

    /**
     * 添加参数
     *
     * @param key
     * @param value
     */
    fun addParam(key: String, value: String) {
        mBodyMap[key] = value
    }


    /**
     * 解析数据
     *
     * @param jsonObject
     */
    @Throws(Exception::class)
    protected abstract fun parseData(jsonObject: JSONObject?)


}