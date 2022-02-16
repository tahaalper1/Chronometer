package com.thalpi.kronometre

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.ImageView
import com.thalpi.kronometre.R.id.*

class MainActivity : AppCompatActivity() {
    private lateinit var start: Button
    private lateinit var reset: Button
    private lateinit var duraksat: Button
    private lateinit var kronometre: Chronometer
    private lateinit var resim1: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start = findViewById(R.id.button)
        reset = findViewById(R.id.button2)
        duraksat = findViewById(R.id.button1)
        kronometre = findViewById(R.id.kronometre)
        resim1 = findViewById(R.id.imageView)
        var zamanDurdur: Long = 0

        start.setOnClickListener {
            kronometre.base = SystemClock.elapsedRealtime() + zamanDurdur
            kronometre.start()
            start.visibility = View.GONE
            duraksat.visibility = View.VISIBLE
            resim1.setImageDrawable(getDrawable(R.drawable.pause))
        }

        duraksat.setOnClickListener {
            zamanDurdur = kronometre.base - SystemClock.elapsedRealtime()
            kronometre.stop()
            start.visibility = View.VISIBLE
            duraksat.visibility = View.GONE
            resim1.setImageDrawable(getDrawable(R.drawable.start))
        }

        reset.setOnClickListener{
            kronometre.base = SystemClock.elapsedRealtime()
            kronometre.stop()
            start.visibility = View.VISIBLE
            duraksat.visibility = View.GONE
            resim1.setImageDrawable(getDrawable(R.drawable.start))
        }
    }
}