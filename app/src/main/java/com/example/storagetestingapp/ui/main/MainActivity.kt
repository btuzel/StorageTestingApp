package com.example.storagetestingapp.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import bt.btuzel.storagetestapp.R
import com.example.storagetestingapp.ui.serialize.SerializationActivity
import bt.btuzel.storagetestapp.ui.text.TextActivity
import com.example.storagetestingapp.ui.img.ImageActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        setupClickListeners()
    }

    private fun setupClickListeners() {

        findViewById<Button>(R.id.button_open_file_saving).setOnClickListener {
            startActivity(Intent(this, TextActivity::class.java))
        }

        findViewById<Button>(R.id.button_open_image_saving).setOnClickListener {
            startActivity(Intent(this, ImageActivity::class.java))
        }

        findViewById<Button>(R.id.button_open_serialization).setOnClickListener {
            startActivity(Intent(this, SerializationActivity::class.java))
        }

    }

}
