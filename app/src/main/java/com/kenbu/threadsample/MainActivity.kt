package com.kenbu.threadsample

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kenbu.threadsample.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        Log.d("Patika", "Start")
        /*
         * While Blocks Coroutines, after completing loop Coroutines will start.
         * If loop is while (true) infinite it will block Ui therefore we cant reach Main Thread.
         */
        var counter = 0
        while (true) {
            CoroutineScope(Dispatchers.IO).launch {
                var data = doNetworkCall()
                withContext(Dispatchers.Main) {
                    Log.d("patika", "Main Thread $counter,$data")
                }
            }
            println("counter $counter ")
            counter++
        }
        Log.d("Patika", "End")
    }
    suspend fun doNetworkCall(): String {
        delay(2000L)
        return "Remote Data"
    }
}
