package com.example.tecnosystem.heilhealthy;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import HttpConecction.HttpConecction;
import modelo.CitaMedica;
import modelo.Paciente;

public class CitasPorPaciente extends AppCompatActivity {

    TextView cedulaPaciente;

    ListView listaCitasPaciente;

    String enlace;

    List<CitaMedica> listaCita;

    HttpConecction conecction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas_por_paciente);
        cedulaPaciente = (TextView) findViewById(R.id.cedulaPacienteBuscar);

        listaCitasPaciente = (ListView) findViewById(R.id.idListaCita);

        conecction = new HttpConecction();

    }

    public void cargarLista(View v) {

         Toast.makeText(getApplicationContext(), cedulaPaciente.getText().toString(), Toast.LENGTH_SHORT).show();
        enlace = "http://" + General.getIpServidor()
                + "/HealHealthy/buscarCitaUsuario.php?idUsuario="+cedulaPaciente.getText().toString();

        new hiloCItaFecha().execute(enlace);
    }

    public class hiloCItaFecha extends AsyncTask<String, Float, String> {
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
            listaCita = obtenerDatosJSONFecha(rta);
            if (listaCita.size() > 0) {
                ArrayAdapter<CitaMedica> adaptador = new ArrayAdapter<CitaMedica>(getApplicationContext()
                        , android.R.layout.simple_list_item_1, listaCita);
                listaCitasPaciente.setAdapter(adaptador);
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

            List<CitaMedica> lista = new ArrayList<>();
            try {

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
