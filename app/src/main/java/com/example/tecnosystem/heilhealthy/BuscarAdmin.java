package com.example.tecnosystem.heilhealthy;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import HttpConecction.HttpConecction;
import modelo.Ciudad;
import modelo.Persona;
import modelo.Usuario;

public class BuscarAdmin extends AppCompatActivity {

    private Spinner spGen, spCiudad;
    private String[] gen = {"Seleccione un genero", "Masculino", "Femenino"};

    private EditText nombre, apellido, cedula, email, fechaNac, ingresos, nombreUser, contrasenia;
    private String nombreAdmin,apellidoAdmin,cedulaAdmin,emailAdmin,fechaNacAdmin,ingresosAdmin,nickname,pass;

    private HttpConecction conecction;
    private String enlace, enlaceDos;

    private ArrayList<Ciudad> ciudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_admin);

        spGen = (Spinner) findViewById(R.id.spGenero);
        spCiudad = (Spinner) findViewById(R.id.spCiudad);

        nombre = (EditText) findViewById(R.id.etNombre);
        apellido = (EditText) findViewById(R.id.etApellido);
        cedula = (EditText) findViewById(R.id.etCedula);
        email = (EditText) findViewById(R.id.etEmail);
        fechaNac = (EditText) findViewById(R.id.etFecha);
        ingresos = (EditText) findViewById(R.id.etIngresos);
        nombreUser = (EditText) findViewById(R.id.etNombreUser);
        contrasenia = (EditText) findViewById(R.id.etContrasenia);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, gen);
        spGen.setAdapter(adapter);

        conecction = new HttpConecction();
        enlace = "http://192.168.1.7/Proyectos/Android/HeilHealthy/buscarCiudad.php";

        new listaCiudades().execute(enlace);
    }

    class listaCiudades extends AsyncTask<String, Float, String> {

        @Override
        protected String doInBackground(String... params) {
            String resultado = conecction.enviarDatosGet(enlace);
            return resultado;
        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);

            int r = obtenerDatosCiudadJSON(resultado);
            if (r < 0) {
                Toast.makeText(getApplicationContext(), "No hay ciudades en la base de datos", Toast.LENGTH_LONG).show();
            } else {
                List<String> listaCiudad = new ArrayList<String>();
                listaCiudad.add("Seleccione una ciudad");

                for (int i = 0; i < ciudades.size(); i++) {
                    listaCiudad.add(ciudades.get(i).getNombre() + "");
                    Log.e("Datos array: ", ciudades.get(i).getNombre());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(BuscarAdmin.this,
                        android.R.layout.simple_spinner_dropdown_item, listaCiudad);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spCiudad.setAdapter(adapter);
            }
        }
    }

    public int obtenerDatosCiudadJSON(String respuesta) {
        Log.e("Respuesta: ", respuesta);
        int resultado = 0;
        try {
            JSONArray json = new JSONArray(respuesta);
            ciudades = new ArrayList<Ciudad>();
            for (int i = 0; i < json.length(); i++) {
                resultado = 1;
                JSONObject row = json.getJSONObject(i);
                String id = row.getString("id");
                String nombre = row.getString("nombre");
                Log.e("Ciudad: ", nombre);
                Ciudad c = new Ciudad(Integer.parseInt(id), null, nombre);
                ciudades.add(c);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public void buscarAdministrador(View v){
        enlaceDos = "http://192.168.1.7/Proyectos/Android/HeilHealthy/buscarAdmin.php?idUsuario="+cedula.getText().toString();
        new buscarAdmin().execute(enlaceDos);
    }

    class buscarAdmin extends AsyncTask<String, Float, String> {

        @Override
        protected String doInBackground(String... params) {
            String resultado = conecction.enviarDatosGet(enlace);
            return resultado;
        }
    }
/*
    public int obtenerDatosJSON(String respuesta) {
        Log.e("respuesta ", respuesta);
        int resultado = 0;
        try {
            JSONArray json = new JSONArray(respuesta);
            Log.e("tamaño json",""+json.length());
            if (json.length() > 0) {
                resultado = 1;
                JSONObject row = json.getJSONObject(0);


                cedulaAdmin = row.getString("cedula");
                nombreAdmin = row.getString("nombre");
                apellidoAdmin = row.getString("apellido");
                emailAdmin = row.getString("email");
                fechaNacAdmin = row.getString("fecha_nacimiento");
                ingresosAdmin = row.getString("ingresos");
                nickname = row.getString("nombre_usuario");
                pass = row.getString("contrasena");

                Persona persona = new Persona(Integer.parseInt(idUsuario),nombreAdmin,apellidoAdmin,emailAdmin,null,null,"",ingresosAdmin);

                Usuario user = new Usuario(nickname, pass,persona,"Administrador");

                Log.e("usuario: ", "" + user.getNombreUsuario());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resultado;
    }*/
}