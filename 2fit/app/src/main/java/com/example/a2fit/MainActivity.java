package com.example.a2fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //reference to button of signUp
    Button btn_signUp;

    //reference to editText of signUp
    EditText p_name, p_surname, p_age, p_height, p_weight, t_weight;

    //reference to checkbox of signUp
    CheckBox g_m, g_f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_signUp = findViewById(R.id.btn_signUp);
        p_name = findViewById(R.id.p_name);
        p_surname = findViewById(R.id.p_surname);
        p_age = findViewById(R.id.p_age);
        p_height = findViewById(R.id.p_height);
        p_weight = findViewById(R.id.p_weight);
        t_weight = findViewById(R.id.t_weight);
        g_m = findViewById(R.id.g_m);
        g_f = findViewById(R.id.g_f);

        // clicklistener for the button
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel UserModel = null;
                try {
                    UserModel = new UserModel(p_name.getText().toString(), p_surname.getText().toString(), Integer.parseInt(p_age.getText().toString()), Integer.parseInt(p_height.getText().toString()), Integer.parseInt(p_weight.getText().toString()), Integer.parseInt(t_weight.getText().toString()), g_m.isChecked(), g_f.isChecked(), -1);
                    Toast.makeText(MainActivity.this, UserModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception a){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

                //db helper class
                dbHelper dbHelper = new dbHelper(MainActivity.this);
                boolean tru = dbHelper.addFour(UserModel);
                Toast.makeText(MainActivity.this, "bool= " + tru , Toast.LENGTH_SHORT).show();
                //Use intent to switch activity
                Intent myIntent = new Intent (MainActivity.this, food.class); //intent object
                startActivity(myIntent); //processes the intent to switch activity
            }
        });
    }
}