package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public Button button;
    public EditText first_name,last_name,phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.save);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first_name = findViewById(R.id.firstName);
                last_name = findViewById(R.id.lastName);
                phone_number = findViewById(R.id.phoneNumber);

                Intent intent = new Intent(getApplicationContext(),NextActivity.class);
                intent.putExtra("f_name",first_name.getText().toString());
                intent.putExtra("l_name",last_name.getText().toString());
                intent.putExtra("ph_no",phone_number.getText().toString());
                startActivity(intent);

            }
        });
    }
}
