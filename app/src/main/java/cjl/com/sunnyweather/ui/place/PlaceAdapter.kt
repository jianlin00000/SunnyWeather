package cjl.com.sunnyweather.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import cjl.com.sunnyweather.R
import cjl.com.sunnyweather.logic.model.Place

/**
 *@author: cjl
 *@date: 2021/1/21 0021 23
 *@desc:
 */
class PlaceAdapter(private val fragment:Fragment,private val placeList:List<Place>) :RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = placeList[position]
        holder.placeName.text=place.name
        holder.placeAddress.text=place.address

    }

    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        val placeName:TextView=view.findViewById(R.id.placeName)
        val placeAddress:TextView=view.findViewById(R.id.placeAddress)
    }

}