package cjl.com.sunnyweather.logic.network

import cjl.com.sunnyweather.logic.model.DailyResponse
import cjl.com.sunnyweather.logic.model.RealtimeResponse
import cjl.com.sunnyweather.ui.app.App
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *@author: cjl
 *@date: 2021/1/23 0023 19
 *@desc:
 */
interface WeatherService {
    /**
     * 根据经纬度获取实时天气
     * @param lng
     * @param lat
     * @return
     */
    @GET("v2.5/${App.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng")lng:String, @Path("lat")lat:String): Call<RealtimeResponse>

    /**
     * 根据经纬度获取未来几天天气
     * @param lng
     * @param lat
     * @return
     */
    @GET("v2.5/${App.TOKEN}/{lng},{lat}/daily.json")
    fun getDialyWeather(@Path("lng")lng:String,@Path("lat")lat:String):Call<DailyResponse>
}