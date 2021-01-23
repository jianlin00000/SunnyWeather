package cjl.com.sunnyweather.logic.network

import cjl.com.sunnyweather.logic.model.PlaceResponse
import cjl.com.sunnyweather.ui.app.App
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *@author: cjl
 *@date: 2020/9/20 0020 21
 *@desc:
 */
interface PlaceService {

    /**
     * 城市搜索
     */
    @GET("v2/place?token=${App.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}