package com.e.chess_fo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Request.*
import com.android.volley.Request.Method.*
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    private lateinit var textName : EditText;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textName = findViewById(R.id.textPersonName);

    }

    fun getInfo(view: View) {
        val userName : String = textName.text.toString();
        val countryName = call(userName);
        Toast.makeText(this,"User: $userName  Country: $countryName",Toast.LENGTH_LONG).show();
    }

    fun call(userName: String):String{
        lateinit var name : String;
        val queue = Volley.newRequestQueue(this);
        val url = "https://api.chess.com/pub/player/$userName";
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url,null,
            { response ->
                name = response.getString("country");
            },
            Response.ErrorListener {name = "That didn't work!"; }
        )
        queue.add(jsonObjectRequest);
        return name;
    }
}