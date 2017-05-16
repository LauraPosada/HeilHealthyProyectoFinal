package com.example.tecnosystem.heilhealthy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InicioMedico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_medico);
    }

    public void irCitaFecha(View v){
        Intent i = new Intent(this, CitasFechaMedico.class);
        startActivity(i);
    }
}
