package cjl.com.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 *@author: cjl
 *@date: 2021/1/23 0023 18
 *@desc:
 */
data class RealtimeResponse(val status:String,val result:Result) {

    data class Result(val realtime: Realtime)

    data class Realtime(val skycon: String, val temperature: Float, @SerializedName("air_quality") val airQuality: AirQuality)

    data class AirQuality(val aqi: AQI)

    data class AQI(val chn: Float)

}