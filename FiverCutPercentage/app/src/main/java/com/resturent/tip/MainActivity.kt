package com.resturent.tip

import android.icu.text.NumberFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.resturent.tip.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{
            calculate()
        }
    }

    private fun calculate() {
        val stringInTextField=binding.amount.text.toString()
        val cost=stringInTextField.toDoubleOrNull()
        if (cost==null){
            binding.tipResult.text=""
            return
        }
        val tipPercentage=when (binding.tipOptions.checkedRadioButtonId){
            R.id.option_twenty_percent -> 0.20
            R.id.option_fifteen_percent -> 0.15
            else -> 0.05

        }
      var tip=tipPercentage*cost
        val formattedTip=NumberFormat.getCurrencyInstance(Locale("en-BD", "BD")).format(tip)
        binding.tipResult.text=getString(R.string.tip_amount,formattedTip)
    }
}