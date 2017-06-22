package com.github.fwh007.libdeviceid;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Random;
import java.util.UUID;

/**
 * 工具集合
 *
 * @author : Winter
 */


public class IDUtil {

    /**
     * 获取Device Id
     *
     * @param context
     * @return
     */
    public static String getDeviceId(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = telephonyManager.getDeviceId().toString();
        return deviceId;
    }

    /**
     * 获取Wifi Mac地址，适用于6.0以下版本
     *
     * @param context
     * @return
     */
    public static String getWifiMacAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        String wifiMacAddress = wifiInfo.getMacAddress();
        return wifiMacAddress;
    }

    /**
     * 获取Wifi Mac地址，适用于6.0及以上版本
     *
     * @return
     * @throws SocketException
     */
    @TargetApi(Build.VERSION_CODES.M)
    public static String getWifiMacAddress() throws SocketException {
        StringBuilder wifiMacAddressBuild = new StringBuilder();
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface anInterface = interfaces.nextElement();
            if (!"wlan0".equals(anInterface.getName())) {
                //测试发现wlan0和才是正确的Wifi Mac地址
                continue;
            }
            byte[] address = anInterface.getHardwareAddress();
            if (address == null || address.length == 0) {
                continue;
            }

            StringBuilder builder = new StringBuilder();
            for (byte b : address) {
                builder.append(String.format("%02X:", b));
            }
            if (builder.length() > 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            wifiMacAddressBuild.append(anInterface.getName()).append(" -> ").append(builder).append("\n");
        }
        if (wifiMacAddressBuild.length() > 0) {
            wifiMacAddressBuild.deleteCharAt(wifiMacAddressBuild.length() - 1);
        }
        return wifiMacAddressBuild.toString();
    }

    /**
     * 获取Android Id
     *
     * @param context
     * @return
     */
    public static String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    /**
     * 获取Build的部分信息
     *
     * @return
     */
    public static String getBuildInfo() {
        //这里选用了几个不会随系统更新而改变的值
        StringBuffer buildSB = new StringBuffer();
        buildSB.append(Build.BRAND).append("/");
        buildSB.append(Build.PRODUCT).append("/");
        buildSB.append(Build.DEVICE).append("/");
        buildSB.append(Build.ID).append("/");
        buildSB.append(Build.VERSION.INCREMENTAL);
        return buildSB.toString();
//        return Build.FINGERPRINT;
    }

    /**
     * 最终方案，获取设备ID
     *
     * @param context
     * @return
     */
    public static String getDeviceUUID(Context context) {
        String uuid = loadDeviceUUID(context);
        if (TextUtils.isEmpty(uuid)) {
            uuid = buildDeviceUUID(context);
            saveDeviceUUID(context, uuid);
        }
        return uuid;
    }

    private static String buildDeviceUUID(Context context) {
        String androidId = getAndroidId(context);
        if (!"9774d56d682e549c".equals(androidId)) {
            Random random = new Random();
            androidId = Integer.toHexString(random.nextInt())
                    + Integer.toHexString(random.nextInt())
                    + Integer.toHexString(random.nextInt());
        }
        return new UUID(androidId.hashCode(), getBuildInfo().hashCode()).toString();
    }

    private static void saveDeviceUUID(Context context, String uuid) {
        context.getSharedPreferences("device_uuid", Context.MODE_PRIVATE)
                .edit()
                .putString("uuid", uuid)
                .apply();
    }

    @Nullable
    private static String loadDeviceUUID(Context context) {
        return context.getSharedPreferences("device_uuid", Context.MODE_PRIVATE)
                .getString("uuid", null);
    }
}
