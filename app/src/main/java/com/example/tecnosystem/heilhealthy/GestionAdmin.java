package com.example.tecnosystem.heilhealthy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GestionAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_admin);
    }

    public void registroAdmin(View v){
        Intent i = new Intent(this, RegistroAdmin.class);
        startActivity(i);
    }

    public void buscarAdmin(View v){
        Intent i = new Intent(this, BuscarAdmin.class);
        startActivity(i);
    }

    public void listarAdmin(View v){

    }
}
