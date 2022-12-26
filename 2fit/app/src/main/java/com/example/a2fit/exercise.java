package com.example.a2fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class exercise extends AppCompatActivity {
    //reference to buttons
    Button b_exercise;

    //reference to editText of exercise page
    EditText t_exercise, b_kcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise);

        b_exercise = findViewById(R.id.b_exercise);
        t_exercise = findViewById(R.id.t_exercise);
        b_kcal = findViewById(R.id.b_kcal);

        // clicklistener for the button
        b_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exerciseModel exerciseModel = null;
                try {
                    exerciseModel= new exerciseModel(t_exercise.getText().toString(), Integer.parseInt(b_kcal.getText().toString()));
                    Toast.makeText(exercise.this, "supp", Toast.LENGTH_SHORT).show();
                }
                catch (Exception a){
                    Toast.makeText(exercise.this, "Error", Toast.LENGTH_SHORT).show();
                }

                dbHelper dbHelper = new dbHelper(exercise.this);
                boolean tru = dbHelper.addTwo(exerciseModel);
                Toast.makeText(exercise.this, "bool= " + tru , Toast.LENGTH_SHORT).show();
                //Use intent to switch activity
                Intent myIntent = new Intent (exercise.this, sleep.class); //intent object
                startActivity(myIntent); //processes the intent to switch activity
            }
        });
    }
}