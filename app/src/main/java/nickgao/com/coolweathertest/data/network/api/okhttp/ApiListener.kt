package nickgao.com.coolweathertest.data.network.api.okhttp


interface ApiListener {
    /**
     * 发送成功监听
     *
     * @param api
     */
    fun success(api: ApiUtil)

    /**
     * 发送失败监听
     *
     * @param api
     */
    fun failure(api: ApiUtil)
}
