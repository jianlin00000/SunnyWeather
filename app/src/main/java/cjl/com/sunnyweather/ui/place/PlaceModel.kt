package cjl.com.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import cjl.com.sunnyweather.logic.Respository
import cjl.com.sunnyweather.logic.dao.PlaceDao
import cjl.com.sunnyweather.logic.model.Place

/**
 *@author: cjl
 *@date: 2021/1/21 0021 23
 *@desc:
 */
class PlaceModel : ViewModel() {
    private val searchLiveData= MutableLiveData<String>()

    val placeList=ArrayList<Place>()

    val placeLiveData=Transformations.switchMap(searchLiveData){query->
        //每次调用都会返回一个新的LiveData，无法观察，通过switchMap转换成另一个可观察的LiveData
        Respository.searchPlace(query)
    }

    fun searchPlace(query:String){
        searchLiveData.value=query
    }

    fun savePlace(place:Place)= Respository.savePlace(place)

    fun getSavePlace()= Respository.getSavePlace()

    fun isPlaceSave()= Respository.isPlaceSave()
}