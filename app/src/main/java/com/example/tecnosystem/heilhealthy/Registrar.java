package com.example.tecnosystem.heilhealthy;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import HttpConecction.HttpConecction;
import modelo.TipoEps;


public class Registrar extends Activity implements AdapterView.OnItemSelectedListener  {

    Spinner spEps;

    HttpConecction connection;
    String enlace;

    ArrayList<TipoEps> eps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        spEps = (Spinner) findViewById(R.id.spinnerEps);
        spEps.setOnItemSelectedListener(this);

        connection = new HttpConecction();
        enlace = "http://"+General.getIpServidor()+"/HealHealthy/";

        new listaEps().execute(enlace);
    }

    public int obtenerDatosJSON(String respuesta) {
        Log.e("respuesta ", respuesta);
        int resultado = 0;
        try {
            JSONArray json = new JSONArray(respuesta);

            eps = new ArrayList<TipoEps>();

            for (int i = 0; i < json.length(); i++) {
                resultado = 1;
                JSONObject row = json.getJSONObject(i);

                int ide = row.getInt("id");
                String nommbre = row.getString("nombre");
                Log.e("eps: ", "M: " + nommbre);

                eps.add(new TipoEps(ide,nommbre));


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return resultado;
    }

    class  listaEps extends AsyncTask<String,Float,String> {

        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String resultado = connection.enviarDatosGet(enlace);
            return resultado;
        }

        protected  void onPostExecute(String resultado){
            super.onPostExecute(resultado);
            int r = obtenerDatosJSON(resultado);
            if(r<0){
                Toast.makeText(getApplicationContext(),"Usuario no tiene materias regsitradas",Toast.LENGTH_LONG).show();
            }{
                List<String> listaeps = new ArrayList<>();

                for (int i =0;i<eps.size();i++){
                    listaeps.add(eps.get(i).getNombre()+"");
                    Log.e("datos array: ",eps.get(i).getNombre());
                }

                ArrayAdapter<String> adaptador= new ArrayAdapter<String>(Registrar.this,
                        android.R.layout.simple_spinner_dropdown_item, listaeps);

                adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spEps.setAdapter(adaptador);

            }
        }
    }

    public void registrar(View v){

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
