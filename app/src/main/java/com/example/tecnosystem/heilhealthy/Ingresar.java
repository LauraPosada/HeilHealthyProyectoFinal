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
import modelo.Agenda;
import modelo.Ciudad;
import modelo.Hora;
import modelo.Medico;
import modelo.Persona;
import modelo.Sede;
import modelo.TipoCita;
import modelo.TipoEps;

public class Ingresar extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spEspe;
    String enlaceEspe;
    Persona persona;

   // Spinner spHorarioFecha;
    //String[] horas = {"Seleccione","7:00 am","7:30 am","8:00 am","8:30 am","9:00 am","9:30 am"};

    Spinner spSedess;
    String enlaceSedes;

    Spinner sagenda;
    String enlaceAgenda;
    List<Agenda> listaAgenda;

    HttpConecction connection;
    List<Sede> listaSede;
    List<Persona> listaMedico;
    //String listaHora;

    String enlaceTipo;
    Spinner spTipoCita;
    List<TipoCita> listaTipoCita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

     //   spHorarioFecha = (Spinner) findViewById(R.id.spHorario);
        spSedess =(Spinner) findViewById(R.id.spSede);
        spEspe = (Spinner) findViewById(R.id.spEspecialista);

      //  listaHora = findViewById(R.id.spHorario).toString();


     //   ArrayAdapter<String>adaptador = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,horas);

        //spHorarioFecha.setAdapter(adaptador);
        //spHorarioFecha.setOnItemSelectedListener(this);

        connection = new HttpConecction();

        spTipoCita = (Spinner) findViewById(R.id.spTipoCita);
        sagenda = (Spinner) findViewById(R.id.spHorario);
        cargarSedes();
        cargarMedicoEspe();
        cargarTipoCitas();
        cargarAgendas();
    }

    public void cargarAgendas(){
        enlaceAgenda = "http://"+General.getIpServidor()+"/HealHealthy/buscarAgenda.php";
        new hiloAgenda().execute(enlaceAgenda);
    }

    public void cargarMedicoEspe(){
        enlaceEspe = "http://"+General.getIpServidor()+"/HealHealthy/buscarMedicos.php";
        new hiloEspe().execute(enlaceEspe);
    }

    public void cargarSedes(){
        enlaceSedes= "http://"+General.getIpServidor()+"/HealHealthy/sedes.php";
        new hilosedes().execute(enlaceSedes);
    }

    public class hiloAgenda extends AsyncTask<String,Float,String> {
        @Override
        protected void onPreExecute() {super.onPreExecute();}
        @Override
        protected String doInBackground(String... strings) {
            String rta = connection.enviarDatosGet(enlaceAgenda);
            return rta;
        }
        @Override
        protected void onPostExecute(String rta) {
            super.onPostExecute(rta);

            listaAgenda = obtenerDatosJSON(rta);
            if(listaAgenda.size()>0){
                ArrayAdapter<Agenda> adaptador = new ArrayAdapter<Agenda>(getApplicationContext(),android.R.layout.simple_spinner_item,listaAgenda);
                sagenda.setAdapter(adaptador);
            }else{
                Toast.makeText(getApplicationContext(),"ERROR, registre generos en la base de datos",Toast.LENGTH_SHORT).show();
            }
        }
        /**
         * obtiene los datos de un json
         * @param rta es las respuesta json
         * @return
         */
        public List<Agenda> obtenerDatosJSON(String rta){
            Log.e("Agenda JSON",rta);
            // La lista de generos a retornar
            List<Agenda> lista = new ArrayList<Agenda>();
            try{
                /**
                 * accedemos al json como array, ya que estamos 100% seguros de que lo que devuelve es un array
                 * y no un objeto.
                 */
                JSONArray json = new JSONArray(rta);
                for (int i=0; i<json.length(); i++){
                    JSONObject row = json.getJSONObject(i);
                    Agenda g = new Agenda();
                    g.setId(row.getInt("id_agenda"));
                    g.setFecha_cita(row.getString("fecha_inicio"));
                   // g.setMedico((Medico) row.get("medico"));
                  // g.setHora((Hora) row.get("hora"));
                    lista.add(g);


                }
            } catch (JSONException e){
                e.printStackTrace();
            }
            return lista;
        }
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
                    g.setNombre(row.getString("nombre_sede"));
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

    public class hiloEspe extends AsyncTask<String,Float,String> {
        @Override
        protected void onPreExecute() {super.onPreExecute();}
        @Override
        protected String doInBackground(String... strings) {
            String rta = connection.enviarDatosGet(enlaceEspe);
            return rta;
        }
        @Override
        protected void onPostExecute(String rta) {
            super.onPostExecute(rta);
            // Generos
            listaMedico = obtenerDatosJSONm(rta);
            if(listaMedico.size()>0){
                ArrayAdapter<Persona> adaptador = new ArrayAdapter<Persona>(getApplicationContext(),android.R.layout.simple_spinner_item,listaMedico);
                spEspe.setAdapter(adaptador);
            }else{
                Toast.makeText(getApplicationContext(),"ERROR, registre generos en la base de datos",Toast.LENGTH_SHORT).show();
            }
        }
        /**
         * obtiene los datos de un json
         * @param rta es las respuesta json
         * @return
         */
        public List<Persona> obtenerDatosJSONm(String rta){
            Log.e("Persona JSON",rta);
            // La lista de generos a retornar
            List<Persona> lista = new ArrayList<Persona>();
            try{
                /**
                 * accedemos al json como array, ya que estamos 100% seguros de que lo que devuelve es un array
                 * y no un objeto.
                 */
                JSONArray json = new JSONArray(rta);
                for (int i=0; i<json.length(); i++){
                    JSONObject row = json.getJSONObject(i);
                    Persona g = new Persona();
                    g.setNombre(row.getString("nombre"));
                    g.setCedula(row.getInt("cedula"));
                    lista.add(g);

                }
            } catch (JSONException e){
                e.printStackTrace();
            }
            return lista;
        }
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
                spTipoCita.setAdapter(adaptador);
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
                    g.setNombre(row.getString("nombre_tipo_cita"));
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

        Persona elEspecialista = listaMedico.get(spEspe.getSelectedItemPosition());
        String nom = elEspecialista.getNombre();
        int cedula = elEspecialista.getCedula();
        i.putExtra("nombreEs", nom);
        i.putExtra("ced",cedula);

        Agenda agenda = listaAgenda.get(sagenda.getSelectedItemPosition());
        String fe = agenda.getFecha_cita();
        int idd = agenda.getId();
        i.putExtra("fec",fe);
        i.putExtra("iddd",idd);

        String elHorario = String.valueOf(sagenda.getSelectedItem());
        i.putExtra("ho",elHorario);

        TipoCita tipoCita = listaTipoCita.get(spTipoCita.getSelectedItemPosition());
        String ci = tipoCita.getNombre();
        int idc = tipoCita.getId();
        i.putExtra("cita",ci);
        i.putExtra("idcc",idc);

        General.setEspecialistaCapturado(nom);
        General.setTipoCitaCaptu(ci);
        General.setTipoIdCitaCaptu(String.valueOf(idc));
        General.setHorari(String.valueOf(idd));
       // General.setHorari(fe);
        startActivity(i);

     //  startActivity(i);

    }

    public void general(View v){
        Intent i = new Intent(this,SolicitarCita.class);
        Persona elEspecialista = listaMedico.get(spEspe.getSelectedItemPosition());
        String nom = elEspecialista.getNombre();
        i.putExtra("nombreEs", nom);

     //   String elHorario = String.valueOf(spHorarioFecha.getSelectedItem());
       // i.putExtra("ho",elHorario);

        General.setEspecialistaCapturado(nom);
        startActivity(i);
    }

    public void especialista(View v){
        Intent i = new Intent(this,SolicitarCita.class);
        Persona elEspecialista = listaMedico.get(spEspe.getSelectedItemPosition());
        String nom = elEspecialista.getNombre();
        i.putExtra("nombreEs", nom);

        //String elHorario = String.valueOf(spHorarioFecha.getSelectedItem());
        //i.putExtra("ho",elHorario);

        General.setEspecialistaCapturado(nom);
        startActivity(i);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
