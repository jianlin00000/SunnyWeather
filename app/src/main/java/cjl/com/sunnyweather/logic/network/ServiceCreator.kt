package cjl.com.sunnyweather.logic.network

import cjl.com.sunnyweather.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *@author: cjl
 *@date: 2020/9/20 0020 21
 *@desc:Retrofit构建器
 */
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/"
    val mClient by lazy {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level=if (BuildConfig.DEBUG)HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    }

    private val retroit = Retrofit.Builder()
        .client(mClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T = retroit.create(serviceClass)

    inline fun <reified T> create(): T = create(T::class.java)
}