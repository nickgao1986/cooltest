package nickgao.com.coolweathertest.data.network.api.okhttp

import android.content.Context
import android.text.TextUtils
import nickgao.com.coolweathertest.CoolWeatherApplication


import java.util.HashMap


object ApiCommonParams {

    /**
     * 上下文
     */
    private var mContext: Context? = null
    /**
     * 版本号(每个接口调用都需要传)
     */
    private val mVersion: String? = null

    /**
     * IMEI
     */
    private val mImei: String? = null
    /**
     * android id
     */
    private val mAndroidId: String? = null
    /**
     * build_serial
     */
    private val mBuildSerial: String? = null

    /**
     * 手机型号
     */
    private val mPhoneModel: String? = null
    /**
     * 手机厂商
     */
    private val mManufacturer: String? = null

    private val mUid = "u01234345"


    init {
        mContext = CoolWeatherApplication.context
        // 获取版本号
        //		mVersion = Util.getAppVersionName(mContext);
        //		// 获取mac
        //        mImei = Util.getImei(mContext);
        //        mAndroidId = Util.getAndroidId(mContext);
        //        mBuildSerial = Util.getBuildSerial(mContext);
        //        mPhoneModel = Util.getPhoneModel();
        //		mManufacturer = Util.getManufacturer();
    }


    /**
     * 获取通用公共参数
     */
    fun fetchCommonsParams(): HashMap<String, String> {
        val params = HashMap<String, String>()

        params["client_type"] = "android"
        params["uid"] = mUid

        //		if (TextUtils.isEmpty(mImei)) {
        //			mImei = Util.getImei(mContext);
        //		}
        //		if (TextUtils.isEmpty(mAndroidId)) {
        //			mAndroidId = Util.getAndroidId(mContext);
        //		}

//        if (!TextUtils.isEmpty(mAndroidId)) {
//            params["android_id"] = mAndroidId
//        }
//        if (!TextUtils.isEmpty(mBuildSerial)) {
//            params["build_serial"] = mBuildSerial
//        }
//
//        if (!TextUtils.isEmpty(mVersion)) {
//            params["version"] = mVersion
//        }
//
//        if (!TextUtils.isEmpty(mManufacturer)) {
//            params["device_brand"] = mManufacturer//厂商
//        }
//        if (!TextUtils.isEmpty(mPhoneModel)) {
//            params["device_model"] = mPhoneModel//型号
//        }
        return params
    }


}
