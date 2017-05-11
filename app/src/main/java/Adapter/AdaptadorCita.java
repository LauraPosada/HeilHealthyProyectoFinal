package Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tecnosystem.heilhealthy.R;

import java.util.ArrayList;

import modelo.CitaMedica;

/**
 * Created by oscar on 11/05/17.
 */

public class AdaptadorCita extends BaseAdapter{

    private Activity actividad;
    private ArrayList<CitaMedica> citasMedicas;

    public AdaptadorCita(Activity actividad, ArrayList<CitaMedica> citasMedicas) {
        this.actividad = actividad;
        this.citasMedicas = citasMedicas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.elemento_lista, null);
        }

        CitaMedica cita = citasMedicas.get(position);

        TextView codigo = (TextView) v.findViewById(R.id.tvCodigoCita);
        codigo.setText(cita.getId());

        //Revisar porque puse el medico en vez de la fecha---------------->
        TextView fecha = (TextView) v.findViewById(R.id.tvFechaCita);
        fecha.setText(cita.getMedico().getNombre());

        return v;
    }

    @Override
    public int getCount() {
        return citasMedicas.size();
    }

    @Override
    public Object getItem(int position) {
        return citasMedicas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void clear(){
        citasMedicas.clear();
    }

    public void addAll(ArrayList<CitaMedica> citaMedica){
        for (int i = 0; i < citaMedica.size();i++){
            citasMedicas.add(citaMedica.get(i));
        }
    }

}
