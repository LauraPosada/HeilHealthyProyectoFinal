package com.example.tecnosystem.heilhealthy;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import HttpConecction.HttpConecction;
import modelo.Persona;
import modelo.Usuario;

public class MainActivity extends AppCompatActivity {

    EditText etUsuario;
    EditText etContrasena;
    String enlace;
    String usuario;
    String contrasena;
    String tipoUs;
    String idUsuario;

    HttpConecction conecction;
    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = (EditText) findViewById(R.id.etUsuarioLogin);
        etContrasena = (EditText) findViewById(R.id.etPasswordLogin);

        conecction = new HttpConecction();
    }

    public void registrar(View v) {
        Intent i = new Intent(this, Registrar.class);
        startActivity(i);
    }

    public void validarUsuario(View v) {

        usuario = etUsuario.getText().toString();
        contrasena = etContrasena.getText().toString();

        enlace = "http://"+General.getIpServidor()+"/HealHealthy/logIn.php?nickname="+usuario+"&password="+contrasena+"";

        new loginUsuario().execute(enlace);
    }

    class loginUsuario extends AsyncTask<String, Float, String> {


        @Override
        protected String doInBackground(String... params) {
            String resultado = conecction.enviarDatosGet(enlace);
            return resultado;
        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);

            int r = obtenerDatosJSON(resultado);
            if (r > 0) {

                if(tipoUs.equals("Paciente")) {
                    Intent i = new Intent(getApplicationContext(), ListaCitas.class);
                    i.putExtra("nombreUsuario", usuario);
                    i.putExtra("contrasena", contrasena);
                    i.putExtra("id",idUsuario);
                    startActivity(i);
                }else if(tipoUs.equals("Medico")){
                    Intent i = new Intent(getApplicationContext(), SolicitarCita.class);
                    i.putExtra("nombreUsuario", usuario);
                    i.putExtra("contrasena", contrasena);
                    startActivity(i);
                }else if(tipoUs.equals("adm")){

                }
            } else {
                Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecto", Toast.LENGTH_LONG).show();
            }

        }

    }

    public int obtenerDatosJSON(String respuesta) {
        Log.e("respuesta ", respuesta);
        int resultado = 0;
        try {
            JSONArray json = new JSONArray(respuesta);
            Log.e("tamaño json",""+json.length());
            if (json.length() > 0) {
                resultado = 1;
                JSONObject row = json.getJSONObject(0);

                String nombre = row.getString("nombre_usuario");
                String contrasena = row.getString("contrasena");
                idUsuario = row.getString("personas_cedula");
                tipoUs = row.getString("tipousuario");
                Persona persona = new Persona(Integer.parseInt(idUsuario),"","","",null,null,"",0);

                user = new Usuario(nombre, contrasena,persona,tipoUs);

                Log.e("usuario: ", "" + user.getNombreUsuario());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
