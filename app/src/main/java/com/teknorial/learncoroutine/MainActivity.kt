package com.teknorial.learncoroutine

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val TAG = "MyMainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Default).launch {
            //delay : hanya membuat coroutine tertidur, tidak keseluruhan thread
            delay(3000)

            Log.d(TAG, "Hello dari thread : ${Thread.currentThread().name}")

            val data = getDataFromServer()
            Log.d(TAG, data)
        }

        Log.d(TAG, "Hello dari thread : ${Thread.currentThread().name}")

    }

    suspend fun getDataFromServer(): String {
        delay(2000)
        return "Hello ini data dari server"
    }

}