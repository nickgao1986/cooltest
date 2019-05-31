package nickgao.com.coolweathertest.user

import retrofit2.http.Body

interface UserApi {
    fun register(@Body req:RequestReq)
}