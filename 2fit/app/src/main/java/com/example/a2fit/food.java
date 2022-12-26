package com.example.a2fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class food extends AppCompatActivity {
    //reference to button
    Button SubmitFood, exercise;

    //reference to editText of sleep page
    EditText bfast, lunch, dinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);

        SubmitFood = findViewById(R.id.b_food);
        exercise = findViewById(R.id.exercise);
        bfast = findViewById(R.id.bfast);
        lunch = findViewById(R.id.lunch);
        dinner = findViewById(R.id.dinner);

        // clicklistener for the button
        SubmitFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodModel foodModel = null;
                try {
                    foodModel = new foodModel(Integer.parseInt(bfast.getText().toString()), Integer.parseInt(lunch.getText().toString()), Integer.parseInt(dinner.getText().toString()));
                    Toast.makeText(food.this, foodModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception a){
                    Toast.makeText(food.this, "Error", Toast.LENGTH_SHORT).show();
                }
                //db helper class
                dbHelper dbHelper = new dbHelper(food.this);
                boolean tru = dbHelper.addOne(foodModel);
                Toast.makeText(food.this, "bool= " + tru , Toast.LENGTH_SHORT).show();

                //Use intent to switch activity
                Intent myIntent = new Intent (food.this, exercise.class); //intent object
                startActivity(myIntent); //processes the intent to switch activity
            }
        });

    }
}