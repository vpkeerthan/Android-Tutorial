package com.example.volleyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {

    Button click_button;
    private String url = "https://www.google.com";
    public RequestQueue requestQueue;
    public StringRequest stringRequest;
    //public TextView responseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click_button = findViewById(R.id.button);

        click_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendAndRequest();
            }
        });
    }

    private void sendAndRequest(){

        //responseTextView = findViewById(R.id.textView);

        requestQueue = Volley.newRequestQueue(this);

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                //responseTextView.setText(stringRequest.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ErrorMsg",error.toString());
            }
        });

        requestQueue.add(stringRequest);
    }
}
