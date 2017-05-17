package com.example.tecnosystem.heilhealthy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SolicitarCita extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView usu;
    Spinner spDispon;
    String [] dis={"Disponible","No disponible"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_cita);

        usu = (TextView) findViewById(R.id.editText2);
        String usuario = General.getUsuLogeado();
        usu.setText(usuario);

        spDispon = (Spinner) findViewById(R.id.spDisponibilidad);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,dis);
        spDispon.setAdapter(adaptador);
        spDispon.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
