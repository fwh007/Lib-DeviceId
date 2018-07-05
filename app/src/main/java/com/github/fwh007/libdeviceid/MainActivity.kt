package com.github.fwh007.libdeviceid

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import code.solution.uuid.UUIDUtil
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var contentTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        update()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_refresh -> {
                update()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun init() {
        contentTV = findViewById(R.id.tv_content) as TextView
    }

    fun update() {
        val build: StringBuilder = StringBuilder()
        build.append("Device ID:").append("\n")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            build.append(IDUtil.getDeviceId(this))
        }
        build.append("\n\n")
        build.append("Wifi Mac Address (System API):").append("\n")
        build.append(IDUtil.getWifiMacAddress(this))
        build.append("\n\n")
        build.append("Wifi Mac Address (Scan Interface):").append("\n")
        build.append(IDUtil.getWifiMacAddress())
        build.append("\n\n")
        build.append("Wifi Mac Address (Analyze IP):").append("\n")
        build.append(IDUtil.getWifiMacAddressByIp())
        build.append("\n\n")
        build.append("Android Id:").append("\n")
        build.append(IDUtil.getAndroidId(this))
        build.append("\n\n")
        build.append("Build Info:").append("\n")
        build.append(IDUtil.getBuildInfo())
        build.append("\n\n")
        build.append("Device UUID:").append("\n")
        build.append(IDUtil.getDeviceUUID(this))
        build.append("\n\n")
        build.append("=========================================")
        build.append("\n\n")
        build.append("Encrypt UUID:").append("\n")
        val encryptedUUID = UUIDUtil.getEncryptedUUID(this)
        Log.d("uuid", encryptedUUID)
        build.append(encryptedUUID)
        build.append("\n\n")
        build.append("Hash UUID:").append("\n")
        val hashUUID = UUIDUtil.getHashUUID(this)
        val hashUUIDString = String(Hex.encodeHex(hashUUID))
        build.append(hashUUIDString)
        contentTV.text = build
    }

    fun buildDeviceId(): String {
        return UUID.randomUUID().toString()
    }
}
