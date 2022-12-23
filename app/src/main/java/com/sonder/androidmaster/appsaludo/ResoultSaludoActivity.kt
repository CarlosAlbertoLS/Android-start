package com.sonder.androidmaster.appsaludo

import android.bluetooth.BluetoothDevice.EXTRA_NAME
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sonder.androidmaster.R
import com.sonder.androidmaster.databinding.ActivityResoultSaludoBinding

class ResoultSaludoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResoultSaludoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResoultSaludoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.extras?.getString("EXTRA_NAME")
        val imc = intent.extras?.getInt("EXTRA_IMC")

        binding.tvResult.text = "Hola $imc"
    }
}