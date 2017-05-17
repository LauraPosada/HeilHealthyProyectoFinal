package com.example.tecnosystem.heilhealthy;

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
import modelo.Persona;
import modelo.Sede;
import modelo.TipoCita;

public class SolicitarCita extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView usu,espe,horaa;
    Spinner spDispon;
    String [] dis={"Disponible","No disponible"};

    Spinner sptipoC;
    List<TipoCita> listaTipoCita;

    HttpConecction connection;
    String enlaceTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_cita);

        usu = (TextView) findViewById(R.id.editText2);
        String usuario = General.getUsuLogeado();
        usu.setText(usuario);

        espe = (TextView) findViewById(R.id.etMedicoCap) ;
        String especia = General.getEspecialistaCapturado();
        espe.setText((CharSequence) especia);

        horaa = (TextView) findViewById(R.id.etHoraCap) ;
        Bundle datos = getIntent().getExtras();
        String horarioo = datos.getString("ho");

        horaa.setText(horarioo);

        spDispon = (Spinner) findViewById(R.id.spDisponibilidad);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,dis);
        spDispon.setAdapter(adaptador);
        spDispon.setOnItemSelectedListener(this);

        sptipoC = (Spinner) findViewById(R.id.spTipoCita);
        connection = new HttpConecction();

        cargarTipoCitas();
    }

    public void cargarTipoCitas(){
        enlaceTipo = "http://"+General.getIpServidor()+"/HealHealthy/buscarTipoCita.php";
        new hiloTipoCitas().execute(enlaceTipo);
    }

    public class hiloTipoCitas extends AsyncTask<String,Float,String> {
        @Override
        protected void onPreExecute() {super.onPreExecute();}
        @Override
        protected String doInBackground(String... strings) {
            String rta = connection.enviarDatosGet(enlaceTipo);
            return rta;
        }
        @Override
        protected void onPostExecute(String rta) {
            super.onPostExecute(rta);
            // Generos
            listaTipoCita = obtenerDatosJSON(rta);
            if(listaTipoCita.size()>0){
                ArrayAdapter<TipoCita> adaptador = new ArrayAdapter<TipoCita>(getApplicationContext(),android.R.layout.simple_spinner_item,listaTipoCita);
                sptipoC.setAdapter(adaptador);
            }else{
                Toast.makeText(getApplicationContext(),"ERROR, registre generos en la base de datos",Toast.LENGTH_SHORT).show();
            }
        }
        /**
         * obtiene los datos de un json
         * @param rta es las respuesta json
         * @return
         */
        public List<TipoCita> obtenerDatosJSON(String rta){
            Log.e("Sede JSON",rta);
            // La lista de generos a retornar
            List<TipoCita> lista = new ArrayList<>();
            try{
                /**
                 * accedemos al json como array, ya que estamos 100% seguros de que lo que devuelve es un array
                 * y no un objeto.
                 */
                JSONArray json = new JSONArray(rta);
                for (int i=0; i<json.length(); i++){
                    JSONObject row = json.getJSONObject(i);
                    TipoCita g = new TipoCita();
                    g.setId(row.getInt("id"));
                    g.setNombre(row.getString("nombre"));
                    lista.add(g);


                }
            } catch (JSONException e){
                e.printStackTrace();
            }
            return lista;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
