package com.example.mcugfinal

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar2.visibility=View.INVISIBLE
        girisSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p1 == 100) {
                    Handler().postDelayed({
                        progressBar2.visibility=View.VISIBLE
                        var gecis = Intent(this@MainActivity, Login::class.java)
                        startActivity(gecis)
                        finish()
                    }, 3000)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

                if(girisSeek != null){
                    girisSeek.progress = 0
                }

            }

        })
    }
}