package com.example.tecnosystem.heilhealthy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ingresar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);
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
}
