package com.example.storagetestingapp.ui.serialize

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import bt.btuzel.storagetestapp.R
import com.example.storagetestingapp.model.Person

class SerializationActivity : AppCompatActivity() {

    private lateinit var serializationViewModel: SerializationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.serialization_activity)

        initComponents()
        setupClickListeners()
        setupObservers()
    }

    private fun initComponents() {
        serializationViewModel = ViewModelProvider(this).get(SerializationViewModel::class.java)
    }

    private fun setupClickListeners() {

        findViewById<Button>(R.id.button_save).setOnClickListener {
            val name = findViewById<EditText>(R.id.editText_name).text.toString()
            val age = findViewById<EditText>(R.id.editText_age).text.toString().toInt()
            serializationViewModel.onSaveObject(Person(name, age),"object")
        }

        findViewById<Button>(R.id.button_revive).setOnClickListener {
            serializationViewModel.onReviveObject("object")
        }

    }

    private fun setupObservers() {

        serializationViewModel.toastViewModel.observe(this, { message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        })

        serializationViewModel.reviveViewModel.observe(this, Observer { person ->
            findViewById<TextView>(R.id.textView_revived_object).text = "Person(${person.name}, ${person.age})"
        })

    }

}
