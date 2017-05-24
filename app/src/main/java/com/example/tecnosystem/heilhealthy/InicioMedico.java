package com.example.tecnosystem.heilhealthy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InicioMedico extends AppCompatActivity {

    TextView usu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_medico);

        usu = (TextView) findViewById(R.id.twUsuarioM);
        String usuario = General.getUsuLogeado();
        usu.setText(usuario);

    }

    public void irCitaFecha(View v){
        Intent i = new Intent(this, CitasFechaMedico.class);
        startActivity(i);
    }

    public void irCitaPaciente(View v){
        Intent i = new Intent(this, CitasPorPaciente.class);
        startActivity(i);
    }
}
