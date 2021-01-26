package cjl.com.sunnyweather.logic

import androidx.lifecycle.liveData
import cjl.com.sunnyweather.logic.dao.PlaceDao
import cjl.com.sunnyweather.logic.model.Place
import cjl.com.sunnyweather.logic.model.Weather
import cjl.com.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.RuntimeException
import kotlin.coroutines.CoroutineContext

/**
 *@author: cjl
 *@date: 2021/1/19 0019 23
 *@desc:
 */
object Respository {

    fun searchPlace(query:String)= fire(Dispatchers.IO) {
        val placeResponse = SunnyWeatherNetwork.searchPlace(query)
        if (placeResponse.status=="ok"){
            val places = placeResponse.places
            Result.success(places)
        }else{
            Result.failure(RuntimeException("response status is ${placeResponse.status}"))
        }
    }


    fun refreshWeather(lng:String,lat:String)= fire(Dispatchers.IO){
        coroutineScope {
            val deferredRealTime = async {
                SunnyWeatherNetwork.getRealtimeWeather(lng, lat)
            }
            val deferredDaily = async {
                SunnyWeatherNetwork.getDialyWeather(lng, lat)
            }
            val realTimeResponse = deferredRealTime.await()
            val dailyResponse = deferredDaily.await()
            if (realTimeResponse.status=="ok"&&dailyResponse.status=="ok"){
                val weather = Weather(realTimeResponse.result.realtime, dailyResponse.result.daily)
                Result.success(weather)
            }else{
                Result.failure(RuntimeException("realtime response status is ${realTimeResponse.status}"+"daily response status is ${dailyResponse.status}"))
            }
        }
    }

    private fun <T> fire(context:CoroutineContext,block:suspend ()->Result<T>)= liveData<Result<T>>(context) {
        val result=try {
            block()
        }catch (e:Exception){
            Result.failure<T>(e)
        }
        emit(result)
    }


    fun savePlace(place:Place)=PlaceDao.savePlace(place)

    fun getSavePlace()=PlaceDao.getPlace()

    fun isPlaceSave()=PlaceDao.isPlaceSave()
}