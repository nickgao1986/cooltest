package nickgao.com.coolweathertest.data


import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import nickgao.com.coolweathertest.data.db.PlaceDao
import nickgao.com.coolweathertest.data.network.CoolWeatherNetwork

class PlaceRepository private constructor(private val placeDao: PlaceDao, private val network: CoolWeatherNetwork) {

    suspend fun getProvinceList() = withContext(Dispatchers.IO) {
        var list = placeDao.getProvinceList()
        Log.d("TAG","<<<<getProvinceList="+list+"network="+network)
        if (list.isEmpty()) {
            list = network.fetchProvinceList()
            Log.d("TAG","<<<<list111="+list)
            placeDao.saveProvinceList(list)
        }
        list
    }

    suspend fun getCityList(provinceId: Int) = withContext(Dispatchers.IO) {
        var list = placeDao.getCityList(provinceId)
        if (list.isEmpty()) {
            list = network.fetchCityList(provinceId)
            list.forEach { it.provinceId = provinceId }
            placeDao.saveCityList(list)
        }
        list
    }

    suspend fun getCountyList(provinceId: Int, cityId: Int) = withContext(Dispatchers.IO) {
        var list = placeDao.getCountyList(cityId)
        if (list.isEmpty()) {
            list = network.fetchCountyList(provinceId, cityId)
            list.forEach { it.cityId = cityId }
            placeDao.saveCountyList(list)
        }
        list
    }

    companion object {

        private var instance: PlaceRepository? = null

        fun getInstance(placeDao: PlaceDao, network: CoolWeatherNetwork): PlaceRepository {
            if (instance == null) {
                synchronized(PlaceRepository::class.java) {
                    if (instance == null) {
                        instance = PlaceRepository(placeDao, network)
                    }
                }
            }
            return instance!!
        }

    }

}