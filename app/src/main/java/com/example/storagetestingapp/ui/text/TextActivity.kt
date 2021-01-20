package bt.btuzel.storagetestapp.ui.text

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import bt.btuzel.storagetestapp.R

class TextActivity : AppCompatActivity() {

    private lateinit var textViewModel: TextViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_activity)

        initComponents()
        initClickListeners()
        setupObservers()
    }

    private fun initComponents() {
        textViewModel = ViewModelProvider(this).get(TextViewModel::class.java)
    }

    private fun initClickListeners() {

        findViewById<Button>(R.id.button_save).setOnClickListener {
            val input = findViewById<EditText>(R.id.editText).text.toString()
            textViewModel.onSaveTextFile(input, "hello.txt")
        }

        findViewById<Button>(R.id.button_read).setOnClickListener {
            textViewModel.onReadTextFile("hello.txt")
        }

    }

    private fun setupObservers() {

        textViewModel.clearFormLiveData.observe(this, Observer { isClearCommand ->
            if (isClearCommand) findViewById<EditText>(R.id.editText).text = null
        })

        textViewModel.contentLiveData.observe(this, Observer { content ->
            findViewById<EditText>(R.id.editText).setText(content)
        })

        textViewModel.toastViewModel.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        })

    }

}
