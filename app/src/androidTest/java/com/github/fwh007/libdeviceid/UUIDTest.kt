package com.github.fwh007.libdeviceid

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Base64
import android.util.Log
import code.solution.uuid.AESUtil
import code.solution.uuid.RSAUtil
import code.solution.uuid.UUIDUtil
import org.json.JSONObject
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class UUIDTest {

    @Test
    fun testRSA() {
        Log.d("uuidT", "========================== start testRSA ==========================")
        val plainText = "7c08267e4fd3df75dcec3d7d490c4d8e"
        Log.d("uuidT", "plain text -> $plainText")
        val keys = RSAUtil.genKeyPair()
        assertTrue(keys.isNotEmpty())
        val publicKey = keys[0]
        Log.d("uuidT", "public key -> ${publicKey.size} $publicKey")
        val privateKey = keys[1]
        Log.d("uuidT", "private key -> ${privateKey.size} $privateKey")
        val keyString = String(privateKey)
        Log.d("uuidT", "private key -> ${keyString.length} ${keyString}")
        val encryptedText = RSAUtil.encrypt(plainText.toByteArray(), publicKey)
        Log.d("uuidT", "encrypted text ${encryptedText.size} -> ${Base64.encode(encryptedText, Base64.DEFAULT)}")
        assertTrue(encryptedText.isNotEmpty())
        val decryptedText = String(RSAUtil.decrypt(encryptedText, privateKey))
        Log.d("uuidT", "decrypted text -> $decryptedText")
        assertTrue(decryptedText.isNotEmpty())
        val decryptedText2 = String(RSAUtil.decrypt(encryptedText, keyString.toByteArray()))
        Log.d("uuidT", "decrypted text -> $decryptedText2")
        assertTrue(decryptedText2.isNotEmpty())
    }

    @Test
    fun testEncryptedUUID() {
        Log.d("uuidT", "========================== start testEncryptedUUID ==========================")
        val appContext = InstrumentationRegistry.getTargetContext()
        val uuid = UUIDUtil.getEncryptedUUID(appContext)
        Log.d("uuidT", "uuid -> $uuid")
        val json = JSONObject(uuid)
        val key = json.getString("rkey")
        Log.d("uuidT", "key -> $key")
        assertTrue(key.isNotEmpty())
        val data = json.getString("rdata")
        Log.d("uuidT", "data -> $data")
        assertTrue(data.isNotEmpty())
        val rsaPrivateKey = TestConfig2.RSA_PRIVATE_KEY
        val aesKey = RSAUtil.decrypt(Base64.decode(key, Base64.DEFAULT), rsaPrivateKey.toByteArray())
        Log.d("uuidT", "aesKey -> ${String(aesKey)}")
        assertTrue(aesKey.isNotEmpty())
        val plainText = AESUtil.decrypt("CBC", "PKCS5Padding", Base64.decode(data, Base64.DEFAULT), aesKey, TestConfig2.AES_IV.toByteArray())
        Log.d("uuidT", "plainText -> ${String(plainText)}")
        assertTrue(plainText.isNotEmpty())
        val plainTextJson = JSONObject(String(plainText))
        assertTrue(plainTextJson.has("u")
                && plainTextJson.has("st")
                && plainTextJson.has("r")
                && plainTextJson.has("m"))
    }
}
