package cjl.com.sunnyweather.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cjl.com.sunnyweather.R
import cjl.com.sunnyweather.ui.app.App

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (App.TOKEN.isEmpty()) {
            Toast.makeText(this, "请在SunnyWeatherApplication中填入你申请到的令牌值", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
