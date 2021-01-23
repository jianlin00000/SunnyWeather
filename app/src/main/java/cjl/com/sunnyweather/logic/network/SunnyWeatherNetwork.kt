package cjl.com.sunnyweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 *@author: cjl
 *@date: 2021/1/19 0019 23
 *@desc:
 */
object SunnyWeatherNetwork {

    private val placeService=ServiceCreator.create(PlaceService::class.java)

    suspend fun searchPlace(query:String)= placeService.searchPlaces(query).await()

    private suspend fun <T> Call<T>.await():T{
        return suspendCoroutine {continuation->
            enqueue(object:Callback<T>{

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body!=null)continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}