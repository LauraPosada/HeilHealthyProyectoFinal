package com.example.tecnosystem.heilhealthy;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import HttpConecction.HttpConecction;
import modelo.EstadoCita;
import modelo.Persona;
import modelo.Sede;
import modelo.TipoCita;

public class SolicitarCita extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView usu,espe,horaa,tipoo,espe2;
    Spinner spDispon;
    String [] dis={"Disponible","No disponible"};

    Spinner spEstadoCitaC;
    String enlaceEstado;
    List<EstadoCita> listaEstadoCita;
    HttpConecction connection;


    String mierda ;
    String mierda2;

    EditText id,medico,hora,tipo,costo,descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_cita);

        spEstadoCitaC = (Spinner) findViewById(R.id.spEstadpCita);


        id = (EditText)findViewById(R.id.etIdPaciente);
        medico = (EditText)findViewById(R.id.etMedicoCap);
        hora = (EditText)findViewById(R.id.etHoraCap);
        tipo = (EditText)findViewById(R.id.etTipoCitaCap);
        costo = (EditText)findViewById(R.id.etValor);
        descripcion = (EditText)findViewById(R.id.etDescripcion);


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


        tipoo = (TextView) findViewById(R.id.etTipoCitaCap);
        String tipoC = General.getTipoCitaCaptu();
        tipoo.setText(tipoC);


        spDispon = (Spinner) findViewById(R.id.spDisponibilidad);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,dis);
        spDispon.setAdapter(adaptador);
        spDispon.setOnItemSelectedListener(this);


        connection = new HttpConecction();


        cargarEstado();
    }


    public void cargarEstado(){
        enlaceEstado = "http://"+General.getIpServidor()+"/HealHealthy/buscarEstadoCita.php";
        new hiloEstado().execute(enlaceEstado);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public class hiloEstado extends AsyncTask<String,Float,String> {
        @Override
        protected void onPreExecute() {super.onPreExecute();}
        @Override
        protected String doInBackground(String... strings) {
            String rta = connection.enviarDatosGet(enlaceEstado);
            return rta;
        }
        @Override
        protected void onPostExecute(String rta) {
            super.onPostExecute(rta);

            listaEstadoCita = obtenerDatosJSON(rta);
            if(listaEstadoCita.size()>0){
                ArrayAdapter<EstadoCita> adaptador = new ArrayAdapter<EstadoCita>(getApplicationContext(),android.R.layout.simple_spinner_item,listaEstadoCita);
                spEstadoCitaC.setAdapter(adaptador);
            }else{
                Toast.makeText(getApplicationContext(),"ERROR, registre generos en la base de datos",Toast.LENGTH_SHORT).show();
            }
        }
        /**
         * obtiene los datos de un json
         * @param rta es las respuesta json
         * @return
         */
        public List<EstadoCita> obtenerDatosJSON(String rta){
            Log.e("Agenda JSON",rta);
            // La lista de generos a retornar
            List<EstadoCita> lista = new ArrayList<EstadoCita>();
            try{
                /**
                 * accedemos al json como array, ya que estamos 100% seguros de que lo que devuelve es un array
                 * y no un objeto.
                 */
                JSONArray json = new JSONArray(rta);
                for (int i=0; i<json.length(); i++){
                    JSONObject row = json.getJSONObject(i);
                    EstadoCita g = new EstadoCita();
                    g.setId(row.getInt("id"));
                    g.setEstado(row.getString("estado"));
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

    public  void crearCita(View v){
    //    Toast.makeText(getApplicationContext(),descripcion.getText().toString(),Toast.LENGTH_SHORT).show();

        String dispo = (String) spDispon.getSelectedItem();
        int estado = spEstadoCitaC.getSelectedItemPosition()+1;
        enlaceEstado = "http://"+General.getIpServidor()+"/HealHealthy/registrarCita.php?descripcion=" + descripcion.getText().toString()+
                "&valorConsulta=" + costo.getText().toString() +
                "&disponibilidad="+dispo+
                "&idEstado="+estado+
                "&idTipoCita="+General.getTipoIdCitaCaptu()+
                "&idUsuario="+id.getText().toString()+
                "&hora="+General.getHorari();

        Toast.makeText(getApplicationContext(),"yib"+enlaceEstado,Toast.LENGTH_SHORT).show();
new guardarDatosCita().execute(enlaceEstado);

    }


    class guardarDatosCita extends AsyncTask<String, Float, String> {

        @Override
        protected String doInBackground(String... params) {
            String resultado = connection.enviarDatosGet(enlaceEstado);
            return resultado;
        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);
            Log.e("Cadena: ", resultado);
            int r = obtenerDatosJSON(resultado);
            if (r > 0) {
                Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_LONG).show();
               // Intent i = new Intent(getApplicationContext(),InicioAdmin.class);
               // startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "No se pudo completar el registro", Toast.LENGTH_LONG).show();
            }
        }
    }

    public int obtenerDatosJSON(String respuesta) {
        Log.e("respuesta ", respuesta);
        int resultado = 0;
        try {
            JSONArray json = new JSONArray(respuesta);
            Log.e("tamaño json", "" + json.length());
            if (json.length() > 0) {
                resultado = 1;
                JSONObject row = json.getJSONObject(0);
                String resp = row.getString("respuesta");
                Log.e("respuesta: ", resp);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resultado;
    }



}
