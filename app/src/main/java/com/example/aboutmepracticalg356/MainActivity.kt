package com.example.aboutmepracticalg356

import android.content.Context
import android.hardware.input.InputManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutmepracticalg356.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /*findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickName(it)
        }*/
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
/*
        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }*/
        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickName(view: View){
        /*val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_edit)*/

        binding.nicknameText.text = binding.nicknameEdit.text
        binding.nicknameEdit.visibility = View.GONE
        view.visibility = View.GONE
        binding.nicknameText.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun updateNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText,0)

    }
}