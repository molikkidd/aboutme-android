package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

//bind your data to the main activity file
    private lateinit var  binding: ActivityMainBinding
//    Set global variable of MyName
    private val myName: MyName= MyName("Molik K")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it)
//        }
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
//        declare the variable upon creation of the app
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }
    private fun addNickname(view: View) {
//        change the variables to be configured to binding
        binding.apply {
//            nicknameText.text = binding.nicknameEdit.text
//            declare nickname variable
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
        //    hide keyboard after submission
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


}