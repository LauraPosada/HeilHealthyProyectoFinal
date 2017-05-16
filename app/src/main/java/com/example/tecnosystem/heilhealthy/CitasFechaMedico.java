package com.example.tecnosystem.heilhealthy;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import HttpConecction.HttpConecction;
import modelo.CitaMedica;

public class CitasFechaMedico extends AppCompatActivity {

    Spinner citaFecha;

    String enlace;

    HttpConecction conecction;

    List<CitaMedica> listaCItasMedicas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas_fecha_medico);

        citaFecha = (Spinner) findViewById(R.id.spFechaCitaMedico);

        conecction = new HttpConecction();
        cargarCombo();

    }


    public void cargarCombo() {
        enlace = "http://" + General.getIpServidor() + "/HealHealthy/buscarCitaMedico.php?idUsuario=1097";
        new hiloCIta().execute(enlace);
    }


    public class hiloCIta extends AsyncTask<String, Float, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String rta = conecction.enviarDatosGet(enlace);
            return rta;
        }

        @Override
        protected void onPostExecute(String rta) {
            super.onPostExecute(rta);
            // Generos
            listaCItasMedicas = obtenerDatosJSON(rta);
            if (listaCItasMedicas.size() > 0) {
                ArrayAdapter<CitaMedica> adaptador = new ArrayAdapter<CitaMedica>(getApplicationContext(), android.R.layout.simple_spinner_item, listaCItasMedicas);
                citaFecha.setAdapter(adaptador);
            } else {
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        }

        /**
         * obtiene los datos de un json
         *
         * @param rta es las respuesta json
         * @return
         */
        public List<CitaMedica> obtenerDatosJSON(String rta) {
            Log.e("Eps JSON", rta);
            // La lista de generos a retornar
            List<CitaMedica> lista = new ArrayList<>();
            try {
                /**
                 * accedemos al json como array, ya que estamos 100% seguros de que lo que devuelve es un array
                 * y no un objeto.
                 */
                JSONArray json = new JSONArray(rta);
                for (int i = 0; i < json.length(); i++) {
                    JSONObject row = json.getJSONObject(i);
                    CitaMedica g = new CitaMedica();

                    g.setId(Integer.parseInt(row.getString("id")));
                  String fecha = row.getString("fecha_cita");
                 //   SimpleDateFormat formato = new SimpleDateFormat("aaaa-mm-dd");
                   // Date fech=formato.parse(fecha);
                    g.setFecha_cita(fecha);
                    lista.add(g);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return lista;
        }

    }
}