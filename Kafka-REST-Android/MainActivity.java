package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public Button button1,button2;
    public StringRequest stringRequest;
    public String URL_POST = "http://127.0.0.1:9090/kafka/publish"; <Use Your Localhost IP address>
    public String URL_GET = "http://127.0.0.1:9090/kafka/receive";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button_post);
        button2 = findViewById(R.id.button_get);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postData();
                getData();
            }
        });
    }

    public void getData(){

        stringRequest = new StringRequest(Request.Method.GET, URL_GET, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                Log.i("GetResponse:::",response);
                //responseTextView.setText(stringRequest.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ErrorMsg",error.toString());
            }
        });

        Log.i("stringRequest:::",stringRequest.toString());
        AppController.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void postData(){
        stringRequest = new StringRequest(Request.Method.POST, URL_POST,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("PostResponse:::", response);
                        //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString());
                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<>();
                params.put("message", "Virgil Van Dijk");
                //params.put("message", "Green");

                return params;
            }

        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(0, 0, 0));
        Log.i("stringRequest::", stringRequest.toString());
        AppController.getInstance(this).addToRequestQueue(stringRequest);
    }

}
