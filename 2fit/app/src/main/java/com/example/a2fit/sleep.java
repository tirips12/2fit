package com.example.a2fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sleep extends AppCompatActivity {
    //reference to button
    Button SubmitSleep;

    //reference to editText of sleep page
    EditText t_sleep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleep);

        SubmitSleep = findViewById(R.id.SubmitSleep);
        t_sleep = findViewById(R.id.t_sleep);


        // clicklistener for the button
        SubmitSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sleepModel sleepModel = null;
                try {
                    sleepModel = new sleepModel(Integer.parseInt(t_sleep.getText().toString()));
                    Toast.makeText(sleep.this, sleepModel.toString(), Toast.LENGTH_SHORT).show();

                }
                catch (Exception a){
                    Toast.makeText(sleep.this, "Error", Toast.LENGTH_SHORT).show();
                }

                dbHelper dbHelper = new dbHelper(sleep.this);
                boolean tru = dbHelper.addThree(sleepModel);
                Toast.makeText(sleep.this, "bool= " + tru , Toast.LENGTH_SHORT).show();

                //Use intent to switch activity
                Intent myIntent = new Intent (sleep.this, overall.class); //intent object
                startActivity(myIntent); //processes the intent to switch activity

            }
        });
    }
}