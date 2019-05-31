package nickgao.com.coolweathertest.data.db

import nickgao.com.coolweathertest.data.db.model.place.City
import nickgao.com.coolweathertest.data.db.model.place.County
import nickgao.com.coolweathertest.data.db.model.place.Province
import org.litepal.LitePal

class PlaceDao {

    fun getProvinceList(): MutableList<Province> = LitePal.findAll(Province::class.java)

    fun getCityList(provinceId: Int): MutableList<City> = LitePal.where("provinceId = ?", provinceId.toString()).find(City::class.java)

    fun getCountyList(cityId: Int): MutableList<County> = LitePal.where("cityId = ?", cityId.toString()).find(County::class.java)

    fun saveProvinceList(provinceList: List<Province>?) {
        if (provinceList != null && provinceList.isNotEmpty()) {
            LitePal.saveAll(provinceList)
        }
    }

    fun saveCityList(cityList: List<City>?) {
        if (cityList != null && cityList.isNotEmpty()) {
            LitePal.saveAll(cityList)
        }
    }

    fun saveCountyList(countyList: List<County>?) {
        if (countyList != null && countyList.isNotEmpty()) {
            LitePal.saveAll(countyList)
        }
    }

}