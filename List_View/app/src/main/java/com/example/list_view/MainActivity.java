package com.example.list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  ArrayAdapter<String> adapter;
    private ListView listview;
    private ArrayList<String> names;
    private Button btnAgrear;
    private EditText tfN1;
    private EditText tfN2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tfN1= findViewById(R.id.tfN1);
        tfN2= findViewById(R.id.tfN2);
        btnAgrear= findViewById(R.id.btnAgregar);
        listview = (ListView) findViewById(R.id.listview);

        names = new ArrayList<String>();


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
    Toast.makeText(MainActivity.this, "Has pulsado: "+ names.get(position), Toast.LENGTH_LONG).show();
}

        });
        btnAgrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1=Integer.parseInt(tfN1.getText().toString()),suma=0;
                int n2=Integer.parseInt(tfN2.getText().toString());
                suma=n1+n2;
                String resul = String.valueOf(suma);
                names.add(tfN1.getText().toString()+" + "+tfN2.getText().toString()+" = "+resul);
                adapter.notifyDataSetChanged();
                tfN1.setText("");
                tfN2.setText("");
                tfN1.requestFocus();


            }
        });

    }
}