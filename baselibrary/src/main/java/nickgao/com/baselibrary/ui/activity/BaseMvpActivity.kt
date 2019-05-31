package nickgao.com.baselibrary.ui.activity

import android.os.Bundle
import nickgao.com.baselibrary.presenter.BasePresenter
import nickgao.com.baselibrary.view.BaseView
import org.jetbrains.anko.toast

abstract open class BaseMvpActivity<T : BasePresenter<*>>:BaseActivity(),BaseView {


    lateinit var mPresenter: T;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toast("aaa")
    }

}