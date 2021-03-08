package com.e.chess_fo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var textName : EditText;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textName = findViewById(R.id.textPersonName);

    }

    fun getInfo(view: View) {
        val userName : String = textName.text.toString();
        Toast.makeText(this,userName,Toast.LENGTH_LONG).show();
    }
}