package com.example.tecnosystem.heilhealthy;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import HttpConecction.HttpConecction;
import modelo.CitaMedica;
import modelo.EstadoCita;
import modelo.Medico;
import modelo.Paciente;
import modelo.Persona;
import modelo.TipoCita;

public class ListaCitas extends AppCompatActivity {

    ListView listacitas;

    HttpConecction conecction;
    String enlace;



    private ArrayList<CitaMedica> listCitaMedica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_citas);

        //listacitas = (ListView) findViewById(R.id.listaCitas);

        //enlace = "http://192.168.26.137/HealHealthy/buscarCitaUsuario.php?idUsuario=1094";

        //new listaMaterias().execute(enlace);

    }

/*
    public int obtenerDatosJSON(String respuesta) {
        Log.e("respuesta ", respuesta);
        int resultado = 0;
        try {
            JSONArray json = new JSONArray(respuesta);

            listCitaMedica = new ArrayList<CitaMedica>();

            for (int i = 0; i < json.length(); i++) {
                resultado = 1;
                JSONObject row = json.getJSONObject(i);

                String id = row.getString("id");
                String motivoDes = row.getString("motivo_descripcion");
                String valorConsulta = row.getString("valor_consulta");
                String disponibilidad = row.getString("disponibilidad");

                EstadoCita estadoC = new EstadoCita(row.getInt("estados_citas_id"), "");
                TipoCita tipoC = new TipoCita(row.getInt("tipos_citas_id"), "");
                Paciente paciente = new Paciente(row.getInt("pacientes_personas_cedula"), "", "", "", null, null, "", 0, null, null);
                Medico medico = new Medico(row.getInt("medicos_personas_cedula"), "", "", "", null, null, "", 0, null, null);


                Log.e("materia: ", "M: " + id);

                listCitaMedica.add(new CitaMedica(Integer.parseInt(id), motivoDes, Double.parseDouble(valorConsulta),Boolean.parseBoolean(disponibilidad),estadoC,tipoC,medico,paciente));


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return resultado;
    }

    class listaMaterias extends AsyncTask<String, Float, String> {

        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String resultado = conecction.enviarDatosGet(enlace);
            return resultado;
        }

        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);
            int r = obtenerDatosJSON(resultado);
            if (r < 0) {
                Toast.makeText(getApplicationContext(), "Usuario no tiene materias regsitradas", Toast.LENGTH_LONG).show();
            }
            {
                List<String> listaMaterias = new ArrayList<>();

                for (int i = 0; i < listCitaMedica.size(); i++) {
                    listaMaterias.add(listCitaMedica.get(i).getId() + "");
                    Log.e("datos array: ", listCitaMedica.get(i).getEstado_cita().getEstado());
                }

                ArrayAdapter<CitaMedica> adaptador = new ArrayAdapter<>(ListaCitas.this,
                        android.R.layout.simple_list_item_1, listCitaMedica);

                adaptador.setDropDownViewResource(android.R.layout.simple_list_item_1);

                listacitas.setAdapter(adaptador);

            }
        }
    }
*/

}
