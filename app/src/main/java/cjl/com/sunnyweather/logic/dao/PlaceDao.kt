package cjl.com.sunnyweather.logic.dao

import android.content.Context
import androidx.core.content.edit
import cjl.com.sunnyweather.logic.model.Place
import cjl.com.sunnyweather.ui.app.App
import com.google.gson.Gson

/**
 *@author: cjl
 *@date: 2021/1/26 0026 08
 *@desc:
 */
object PlaceDao {

    fun savePlace(place:Place){
        sp().edit{
            putString("place",Gson().toJson(place))
        }
    }

    fun getPlace():Place{
        val json = sp().getString("place", "")
        return Gson().fromJson(json,Place::class.java)
    }

    fun isPlaceSave()= sp().contains("place")


    private fun sp()=App.context.getSharedPreferences("sunny_weather",Context.MODE_PRIVATE)
}