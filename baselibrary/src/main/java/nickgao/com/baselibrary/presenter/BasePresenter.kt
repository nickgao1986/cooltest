package nickgao.com.baselibrary.presenter

import nickgao.com.baselibrary.view.BaseView

/*
    MVP中P层 基类
 */
open class BasePresenter<T: BaseView>{

    lateinit var mView:T


}
