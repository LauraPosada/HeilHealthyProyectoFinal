package com.example.tecnosystem.heilhealthy;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
import modelo.Agenda;
import modelo.CitaMedica;
import modelo.Paciente;
import modelo.Persona;

public class CitasFechaMedico extends AppCompatActivity {

    Spinner citaFecha;

    ListView lisCitaFecha;

    String enlace;

    String enlaceLista;

    HttpConecction conecction;

    List<String> listaCItasMedicas;

    List<CitaMedica> listaCitaFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas_fecha_medico);

        citaFecha = (Spinner) findViewById(R.id.spFechaCitaMedico);

        lisCitaFecha = (ListView) findViewById(R.id.listcitafecha);

        conecction = new HttpConecction();
        cargarCombo();

        citaFecha.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //CitaMedica cit = listaCItasMedicas.get(position);
               // Log.e("FECHA ",listaCItasMedicas.get(position).getAgenda().getFecha_cita());
                cargarLista(listaCItasMedicas.get(position));            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }


    public void cargarCombo() {
        enlace = "http://" + General.getIpServidor() + "/HealHealthy/buscarCitaMedico.php?idUsuario=" + General.getCedulaLogeado();
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
                ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, listaCItasMedicas);
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
        public List<String> obtenerDatosJSON(String rta) {
            Log.e("cita JSON", rta);
            // La lista de generos a retornar
            List<String> lista = new ArrayList<>();
            try {

                JSONArray json = new JSONArray(rta);
                for (int i = 0; i < json.length(); i++) {
                    JSONObject row = json.getJSONObject(i);
                   // CitaMedica g = new CitaMedica();

                    /**
                    g.setId(Integer.parseInt(row.getString("id")));
                    Agenda age = new Agenda();
                    age.setId(Integer.parseInt(row.getString("id_agenda")));
                     */
                   // age.setFecha_cita(row.getString("fecha_inicio"));

                   // g.setAgenda(age);
                  //  lista.add(g);
                    lista.add(row.getString("fecha_inicio"));

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return lista;
        }

    }

////////////////////////////////////////////////////////////////////////////////////////////////


    public void cargarLista(String fec) {
       // Toast.makeText(getApplicationContext(), fec, Toast.LENGTH_SHORT).show();
       enlaceLista = "http://" + General.getIpServidor()
                 + "/HealHealthy/buscarCitaFecha.php?fechaCita='" + fec + "'";

         new hiloCItaFecha().execute(enlaceLista);
    }

    public class hiloCItaFecha extends AsyncTask<String, Float, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String rta = conecction.enviarDatosGet(enlaceLista);
            return rta;
        }

        @Override
        protected void onPostExecute(String rta) {
            super.onPostExecute(rta);
            // Generos
            listaCitaFecha = obtenerDatosJSONFecha(rta);
            if (listaCitaFecha.size() > 0) {
                ArrayAdapter<CitaMedica> adaptador = new ArrayAdapter<CitaMedica>(getApplicationContext()
                        , android.R.layout.simple_list_item_1, listaCitaFecha);
                lisCitaFecha.setAdapter(adaptador);
            } else {
                Toast.makeText(getApplicationContext(), "ERROR lista", Toast.LENGTH_SHORT).show();
            }
        }

        /**
         * obtiene los datos de un json
         *
         * @param rta es las respuesta json
         * @return
         */
        public List<CitaMedica> obtenerDatosJSONFecha(String rta) {
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

                    Paciente pac = new Paciente();
                    pac.setCedula(Integer.parseInt(row.getString("cedula")));
                    pac.setNombre(row.getString("nombre"));
                    pac.setApellido(row.getString("apellido"));

                    g.setPaciente(pac);

                    lista.add(g);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return lista;
        }

    }

}

