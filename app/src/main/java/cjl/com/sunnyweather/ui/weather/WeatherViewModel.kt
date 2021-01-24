package cjl.com.sunnyweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import cjl.com.sunnyweather.logic.Respository
import cjl.com.sunnyweather.logic.model.Location

/**
 *@author: cjl
 *@date: 2021/1/24 0024 11
 *@desc:
 */
class WeatherViewModel :ViewModel(){

    private val locationLiveData=MutableLiveData<Location>()

    var locationLng=""

    var locationLat=""

    var placeName=""

    val weatherLiveData=Transformations.switchMap(locationLiveData){
        Respository.refreshWeather(it.lng,it.lat)
    }

    fun refreshWeather(lng:String,lat:String){
        locationLiveData.value=Location(lng, lat)
    }

}