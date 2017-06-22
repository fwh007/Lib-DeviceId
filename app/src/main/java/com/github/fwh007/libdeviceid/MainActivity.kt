package com.github.fwh007.libdeviceid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var contentTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        update()
    }

    fun init() {
        contentTV = findViewById(R.id.tv_content) as TextView
    }

    fun update() {
        val build: StringBuilder = StringBuilder()
        build.append("Device ID:").append("\n")
        build.append(IDUtil.getDeviceId(this)).append("\n\n")
        build.append("Wifi Mac Address:").append("\n")
        build.append(IDUtil.getWifiMacAddress(this)).append("\n\n")
        build.append("Wifi Mac Address:").append("\n")
        build.append(IDUtil.getWifiMacAddress()).append("\n\n")
        build.append("Android Id:").append("\n")
        build.append(IDUtil.getAndroidId(this)).append("\n\n")
        build.append("Build Info:").append("\n")
        build.append(IDUtil.getBuildInfo()).append("\n\n")
        build.append("Device UUID:").append("\n")
        build.append(IDUtil.getDeviceUUID(this))
        contentTV.text = build
    }

    fun buildDeviceId(): String {
        return UUID.randomUUID().toString()
    }
}
