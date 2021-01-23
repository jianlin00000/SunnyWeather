package cjl.com.sunnyweather.logic

import androidx.lifecycle.liveData
import cjl.com.sunnyweather.logic.model.Place
import cjl.com.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import java.lang.RuntimeException

/**
 *@author: cjl
 *@date: 2021/1/19 0019 23
 *@desc:
 */
object Respository {

    fun searchPlace(query:String)= liveData(Dispatchers.IO) {
        val result=try {
            val placeResponse = SunnyWeatherNetwork.searchPlace(query)
            if (placeResponse.status=="ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}