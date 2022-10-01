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
        val handler = Handler(Looper.getMainLooper())

        Log.d("Patika", "Start")
        /*
         * While Blocks Coroutines, after completing loop Coroutines will start.
         * If loop is while (true) infinite it will block Ui but IO thread will continue running.
         * Therefore we cant reach Main Thread.
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
//        CoroutineScope(Dispatchers.IO).launch {
//            launch (Dispatchers.Default){
//                println("Dispatchers.Default")
//                withContext(Dispatchers.IO){
//                    delay(3000)
//                    println("Dispatchers.IO")
//                }
//            }
//        }