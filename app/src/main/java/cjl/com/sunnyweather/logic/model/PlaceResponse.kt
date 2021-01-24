package cjl.com.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 *@author: cjl
 *@date: 2020/9/20 0020 21
 *@desc:
 */

data class PlaceResponse(val status:String,val places:List<Place>)

data class Place(val name: String, val location: Location,
                 @SerializedName("formatted_address") val address:String)

data class Location(val lng:String,val lat:String)