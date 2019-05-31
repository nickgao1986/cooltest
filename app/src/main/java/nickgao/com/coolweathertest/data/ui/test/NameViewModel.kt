package nickgao.com.coolweathertest.data.ui.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {
    private var mCurrentName: MutableLiveData<String>? = null
    // Create a LiveData with a String list
    private var mNameListData: MutableLiveData<List<String>>? = null

    val currentName: MutableLiveData<String>?
        get() {
            if (mCurrentName == null) {
                mCurrentName = MutableLiveData()
            }
            return mCurrentName
        }

    val nameList: MutableLiveData<List<String>>?
        get() {
            if (mNameListData == null) {
                mNameListData = MutableLiveData()
            }
            return mNameListData
        }
}
