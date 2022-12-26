package com.example.a2fit;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class overall extends Activity {

    //reference to ListView of overall page
    ListView list;
    ArrayAdapter customAdapter;
    dbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overall);

        list = (ListView) findViewById(R.id.list);


        dbHelper = new dbHelper(overall.this);
        List<overallModel> allU = dbHelper.getUser();

        Toast.makeText(overall.this, allU.toString(), Toast.LENGTH_SHORT).show();
        //array adapter
        customAdapter = new ArrayAdapter<overallModel>(overall.this, android.R.layout.simple_list_item_1, dbHelper.getUser());
        list.setAdapter(customAdapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                overallModel overallModel = (overallModel) parent.getItemAtPosition(position);
                dbHelper.deleteOne(overallModel);
                Toast.makeText(overall.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }



}

