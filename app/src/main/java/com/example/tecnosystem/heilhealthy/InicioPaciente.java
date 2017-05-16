package com.example.tecnosystem.heilhealthy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InicioPaciente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_paciente);
    }

    public void cita(View v){
        Intent i =  new Intent(this,Ingresar.class);
        startActivity(i);
    }
}
