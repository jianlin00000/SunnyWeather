package cjl.com.sunnyweather.ui.app

import android.app.Application
import android.content.Context

/**
 *@author: cjl
 *@date: 2020/9/20 0020 21
 *@desc:
 */
class App :Application(){

    companion object{
        const val TOKEN="vfNAXQWzMbEA1BrX"
        lateinit var context:Context
    }

    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }
}