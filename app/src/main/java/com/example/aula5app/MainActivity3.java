package com.example.aula5app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {

    TextView tvName;
    Spinner spUf;
    ListView lvCidade;

    HashMap<String, Integer> array = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        array.put("RS", R.array.RS);
        array.put("SP", R.array.SP);
        array.put("RJ", R.array.RJ);

        Intent it = getIntent();
        String name = it.getStringExtra("name");

        tvName = findViewById(R.id.tvName);
        tvName.setText(name);

        spUf = findViewById(R.id.spUf);
        ArrayAdapter<CharSequence> ufAdapter = ArrayAdapter.createFromResource(this, R.array.uf, android.R.layout.simple_spinner_dropdown_item);
        spUf.setAdapter(ufAdapter);
        spUf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String uf = getResources().getStringArray(R.array.uf)[position];

                ArrayAdapter<CharSequence> cidadeAdapter = ArrayAdapter.createFromResource(MainActivity3.this, array.get(uf), android.R.layout.simple_list_item_1);
                lvCidade.setAdapter(cidadeAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        lvCidade = findViewById(R.id.lvCidade);

    }
}