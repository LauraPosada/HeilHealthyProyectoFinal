package com.example.tecnosystem.heilhealthy;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import HttpConecction.HttpConecction;
import modelo.Ciudad;
import modelo.Sede;
import modelo.TipoEps;

public class Ingresar extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView usu;

    Spinner spHorarioFecha;
    String[] horas = {"Seleccione","7:00 am","7:30 am"};

    Spinner spSedess;
    String enlaceSedes;

    HttpConecction connection;
    List<Sede> listaSede;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        spHorarioFecha = (Spinner) findViewById(R.id.spHorario);
        spSedess =(Spinner) findViewById(R.id.spSede);
        usu = (TextView) findViewById(R.id.usu);

        ArrayAdapter<String>adaptador = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,horas);

        spHorarioFecha.setAdapter(adaptador);
        spHorarioFecha.setOnItemSelectedListener(this);

        connection = new HttpConecction();
        cargarSedes();


        String usuario = General.getUsuLogeado();

        usu.setText(usuario);

    }

    public void cargarSedes(){
        enlaceSedes= "http://"+General.getIpServidor()+"/HealHealthy/sedes.php";
        new hilosedes().execute(enlaceSedes);
    }

    public class hilosedes extends AsyncTask<String,Float,String> {
        @Override
        protected void onPreExecute() {super.onPreExecute();}
        @Override
        protected String doInBackground(String... strings) {
            String rta = connection.enviarDatosGet(enlaceSedes);
            return rta;
        }
        @Override
        protected void onPostExecute(String rta) {
            super.onPostExecute(rta);
            // Generos
            listaSede = obtenerDatosJSON(rta);
            if(listaSede.size()>0){
                ArrayAdapter<Sede> adaptador = new ArrayAdapter<Sede>(getApplicationContext(),android.R.layout.simple_spinner_item,listaSede);
                spSedess.setAdapter(adaptador);
            }else{
                Toast.makeText(getApplicationContext(),"ERROR, registre generos en la base de datos",Toast.LENGTH_SHORT).show();
            }
        }
        /**
         * obtiene los datos de un json
         * @param rta es las respuesta json
         * @return
         */
        public List<Sede> obtenerDatosJSON(String rta){
            Log.e("Sede JSON",rta);
            // La lista de generos a retornar
            List<Sede> lista = new ArrayList<Sede>();
            try{
                /**
                 * accedemos al json como array, ya que estamos 100% seguros de que lo que devuelve es un array
                 * y no un objeto.
                 */
                JSONArray json = new JSONArray(rta);
                for (int i=0; i<json.length(); i++){
                    JSONObject row = json.getJSONObject(i);
                    Sede g = new Sede();
                    g.setId(row.getInt("id"));
                    g.setNombre(row.getString("nombre"));
                    g.setLongitud(row.getString("longitud"));
                    g.setLatitud(row.getString("latitud"));
                    lista.add(g);


                }
            } catch (JSONException e){
                e.printStackTrace();
            }
            return lista;
        }
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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
