package com.griga.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Results extends AppCompatActivity {

    ListView listView;
    ImageButton button_back;
    Toolbar toolbar;
    ArrayList<String> res_array;
    ArrayList<String> num_array;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        listView = findViewById(R.id.list_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        ArrayList<HashMap<String, String>> result = (ArrayList<HashMap<String, String>>) getIntent().getSerializableExtra("array_list");
//        ArrayList<String> res_array = getIntent().getStringArrayListExtra("res_array");
//        ArrayList<String> num_array = getIntent().getStringArrayListExtra("num_array");
//        System.out.println(res_array);
//        System.out.println(num_array);





        SimpleAdapter adapter = new SimpleAdapter(this, result, android.R.layout.simple_list_item_2,
                new String[]{"num", "res"},
                new int[]{android.R.id.text1, android.R.id.text2});
        listView.setAdapter(adapter);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView2 = view.findViewById(android.R.id.text2);
                String result = textView2.getText().toString();
                System.out.println(result);
                Intent intent1 = new Intent(Results.this, MainActivity.class);
                intent1.putExtra("result", result);
                startActivity(intent1);


            }
        });



        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_1 = new Intent(Results.this, MainActivity.class);
                startActivity(intent_1);
            }
        });



//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, );
//
//        listView.setAdapter(adapter);









//        button_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent_1 = new Intent(Results.this, MainActivity.class);
//                startActivity(intent_1);
//            }
//        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.result_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.delete) {
            listView.setAdapter(null);
        }
        return super.onOptionsItemSelected(item);
    }


}