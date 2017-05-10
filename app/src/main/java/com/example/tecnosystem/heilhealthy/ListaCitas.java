package com.example.tecnosystem.heilhealthy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListaCitas extends AppCompatActivity {

    ListView listacitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_citas);

        listacitas = (ListView) findViewById(R.id.listaCitas);
    }






}
