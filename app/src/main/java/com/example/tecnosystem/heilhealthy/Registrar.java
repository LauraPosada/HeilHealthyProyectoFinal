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
import modelo.Ciudad;
import modelo.TipoEps;


public class Registrar extends Activity implements AdapterView.OnItemSelectedListener  {

    Spinner spEps;
    Spinner spGenero;
    String [] genero = {"Seleccione...","Femenino","Masculino"};
    Spinner sppCiudad;

    HttpConecction connection;
    String enlace;
    String enlaceEps;
    String enlaceCiudad;

    List<TipoEps> eps;
    List<Ciudad> listaCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        spEps = (Spinner) findViewById(R.id.spinnerEps);
        sppCiudad = (Spinner) findViewById(R.id.spCiudadRegistro);

        spGenero = (Spinner) findViewById(R.id.spGeneroRegistro);
        ArrayAdapter<String>adaptador = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,genero);
        spGenero.setAdapter(adaptador);
        spGenero.setOnItemSelectedListener(this);

        connection = new HttpConecction();
        enlace = "http://"+General.getIpServidor()+"/HealHealthy/";

cargarEps();
        cargarCiudades();
       // new listaEps().execute(enlace);
    }

    public  void cargarEps(){
        enlaceEps= "http://"+General.getIpServidor()+"/HealHealthy/buscarEPS.php";
        new HiloEps().execute(enlaceEps);
    }

    public void cargarCiudades(){
        enlaceCiudad = "http://"+General.getIpServidor()+"/HealHealthy/buscarCiudades.php";
        new hiloCiudad().execute(enlaceCiudad);
    }

    public class HiloEps extends AsyncTask<String,Float,String> {
        @Override
        protected void onPreExecute() {super.onPreExecute();}
        @Override
        protected String doInBackground(String... strings) {
            String rta = connection.enviarDatosGet(enlaceEps);
            return rta;
        }
        @Override
        protected void onPostExecute(String rta) {
            super.onPostExecute(rta);
            // Generos
            eps = obtenerDatosJSON(rta);
            if(eps.size()>0){
                ArrayAdapter<TipoEps> adaptador = new ArrayAdapter<TipoEps>(getApplicationContext(),android.R.layout.simple_spinner_item,eps);
                spEps.setAdapter(adaptador);
            }else{
                Toast.makeText(getApplicationContext(),"ERROR, registre generos en la base de datos",Toast.LENGTH_SHORT).show();
            }
        }
        /**
         * obtiene los datos de un json
         * @param rta es las respuesta json
         * @return
         */
        public List<TipoEps> obtenerDatosJSON(String rta){
            Log.e("Eps JSON",rta);
            // La lista de generos a retornar
            List<TipoEps> lista = new ArrayList<TipoEps>();
            try{
                /**
                 * accedemos al json como array, ya que estamos 100% seguros de que lo que devuelve es un array
                 * y no un objeto.
                 */
                JSONArray json = new JSONArray(rta);
                for (int i=0; i<json.length(); i++){
                    JSONObject row = json.getJSONObject(i);
                    TipoEps g = new TipoEps();
                    g.setId(row.getInt("id"));
                    g.setNombre(row.getString("nombre_eps"));
                    lista.add(g);
                }
            } catch (JSONException e){
                e.printStackTrace();
            }
            return lista;
        }
    }


    public class hiloCiudad extends AsyncTask<String,Float,String> {
        @Override
        protected void onPreExecute() {super.onPreExecute();}
        @Override
        protected String doInBackground(String... strings) {
            String rta = connection.enviarDatosGet(enlaceCiudad);
            return rta;
        }
        @Override
        protected void onPostExecute(String rta) {
            super.onPostExecute(rta);
            // Generos
            listaCiudades = obtenerDatosJSONC(rta);
            if(listaCiudades.size()>0){
                ArrayAdapter<Ciudad> adaptador = new ArrayAdapter<Ciudad>(getApplicationContext(),android.R.layout.simple_spinner_item,listaCiudades);
                sppCiudad.setAdapter(adaptador);
            }else{
                Toast.makeText(getApplicationContext(),"ERROR, registre generos en la base de datos",Toast.LENGTH_SHORT).show();
            }
        }
        /**
         * obtiene los datos de un json
         * @param rta es las respuesta json
         * @return
         */
        public List<Ciudad> obtenerDatosJSONC(String rta){
            Log.e("Ciudad JSON",rta);
            // La lista de generos a retornar
            List<Ciudad> lista = new ArrayList<Ciudad>();
            try{
                /**
                 * accedemos al json como array, ya que estamos 100% seguros de que lo que devuelve es un array
                 * y no un objeto.
                 */
                JSONArray json = new JSONArray(rta);
                for (int i=0; i<json.length(); i++){
                    JSONObject row = json.getJSONObject(i);
                    Ciudad g = new Ciudad();
                    g.setId(row.getInt("id"));
                    g.setNombre(row.getString("nombre_c"));
                    lista.add(g);
                }
            } catch (JSONException e){
                e.printStackTrace();
            }
            return lista;
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
