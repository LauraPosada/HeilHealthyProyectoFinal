package com.example.tecnosystem.heilhealthy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class InicioAdmin extends AppCompatActivity {

    TextView nickname;
    String idUsuario;
    String nombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_admin);

        nickname = (TextView)findViewById(R.id.tVNickName);

        Bundle datos = getIntent().getExtras();
        nombreUsuario = datos.getString("nombreUsuario");
        idUsuario = datos.getString("idUsuario");
        nickname.setText(getString(R.string.mensajeUsuario, nombreUsuario));

    }

    public void gestionAdmin(View v){
        Intent i = new Intent(getApplicationContext(), GestionAdmin.class);
        startActivity(i);
    }

    public void gestionUsuario(View v){

    }
}
