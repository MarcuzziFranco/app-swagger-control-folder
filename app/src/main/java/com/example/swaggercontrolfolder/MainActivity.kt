package com.example.swaggercontrolfolder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.swaggercontrolfolder.core.IApiServices
import com.example.swaggercontrolfolder.core.RetrofitHelper
import com.example.swaggercontrolfolder.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private  var  retrofit: Retrofit = RetrofitHelper.getRetrofit();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnCheckConnection.setOnClickListener {
            Log.i("Click","btnCheckConnection")

            CoroutineScope(Dispatchers.IO).launch {
                val call = retrofit.create(IApiServices::class.java).getCheckOnline("/help")
                val greeting = call.body()

                runOnUiThread{
                    if(call.isSuccessful)
                        greeting?.let { data ->
                            binding.txtGreeting.text = data.msn
                        }
                    else Log.i("Click","Error")
                }

            }
        }
    }


}