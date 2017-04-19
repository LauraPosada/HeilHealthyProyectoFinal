package com.example.tecnosystem.heilhealthy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ingresar(View v){
        //creamos la intencion de abrir una ventana
        Intent i = new Intent(this,Ingresar.class);
        //Iniciamos la actividad
        startActivity(i);
    }

    public void registrar(View v){

    }
}
