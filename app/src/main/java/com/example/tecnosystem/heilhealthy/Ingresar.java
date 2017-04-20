package com.example.tecnosystem.heilhealthy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Ingresar extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spHorarioFecha;
    String[] horas = {"Seleccione","7:00 am","7:30 am"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        spHorarioFecha = (Spinner) findViewById(R.id.spHorario);

        ArrayAdapter<String>adaptador = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,horas);

        spHorarioFecha.setAdapter(adaptador);
        spHorarioFecha.setOnItemSelectedListener(this);
    }

    public void prioritaria(View v){
        Intent i = new Intent(this,SolicitarCita.class);
        startActivity(i);
    }

    public void general(View v){
        Intent i = new Intent(this,SolicitarCita.class);
        startActivity(i);
    }

    public void especialista(View v){
        Intent i = new Intent(this,SolicitarCita.class);
        startActivity(i);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
