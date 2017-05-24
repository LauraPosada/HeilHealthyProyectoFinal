package com.example.tecnosystem.heilhealthy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InicioPaciente extends AppCompatActivity {

    TextView usu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_paciente);

        usu = (TextView) findViewById(R.id.twUsuario);
        String usuario = General.getUsuLogeado();
        usu.setText(usuario);

    }

    public void cita(View v){

        Intent i =  new Intent(this,Ingresar.class);

        startActivity(i);
    }

    public void irMap(View v){
        Intent i =  new Intent(this,MapsActivity.class);
        startActivity(i);
    }
}
