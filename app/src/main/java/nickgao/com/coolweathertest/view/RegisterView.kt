package nickgao.com.coolweathertest.view

import android.util.Log
import nickgao.com.baselibrary.view.BaseView

interface RegisterView:BaseView{


    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Log.d("TAG","show loading");
    }

    fun onRegisterResult(result:Boolean)

}