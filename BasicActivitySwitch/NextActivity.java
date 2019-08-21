package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
    public TextView textView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout);

        textView = findViewById(R.id.textView);
        String f_name =  getIntent().getStringExtra("f_name");
        String l_name =  getIntent().getStringExtra("l_name");
        String ph_no =  getIntent().getStringExtra("ph_no");
        textView.setText(f_name+"\n"+l_name+"\n"+ph_no);

    }
}
