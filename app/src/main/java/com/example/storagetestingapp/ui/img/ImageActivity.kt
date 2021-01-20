package com.example.storagetestingapp.ui.img


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import bt.btuzel.storagetestapp.R
class ImageActivity : AppCompatActivity() {

    private lateinit var imageViewModel: ImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_activity)

        initComponents()
        initClickListeners()
        setupObservers()
    }

    private fun initComponents() {
        imageViewModel = ViewModelProvider(this).get(ImageViewModel::class.java)
    }

    private fun initClickListeners() {

        findViewById<Button>(R.id.button_save).setOnClickListener {
            imageViewModel.onSaveImageFile(R.drawable.test_image, "image.png")
        }

    }

    private fun setupObservers() {

        imageViewModel.toastViewModel.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        })

    }

}
