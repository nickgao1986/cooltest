package nickgao.com.coolweathertest.data.ui.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class TestViewModel : ViewModel() {

    private var mCurrentName: MutableLiveData<String>? = null

    fun getCurrentName():MutableLiveData<String>? {
        if(mCurrentName == null) {
            mCurrentName = MutableLiveData()
        }
        return mCurrentName
    }
}
