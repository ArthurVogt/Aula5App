package com.example.aula5app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {

    ListView list;

    String[] names = {"Arthur", "Lucas", "Rafael", "Augusto", "Bruna", "Mariana"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        list = findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Arrays.asList(names));

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = names[position];
                Intent it = new Intent(MainActivity2.this, MainActivity3.class);
                it.putExtra("name", item);
                startActivity(it);

            }
        });
    }
}