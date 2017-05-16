package com.example.tecnosystem.heilhealthy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SolicitarCita extends AppCompatActivity {

    TextView usu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_cita);

        usu = (TextView) findViewById(R.id.editText2);
        String usuario = General.getUsuLogeado();
        usu.setText(usuario);
    }
}
