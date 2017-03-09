package es.iesnervion.fjruiz.mov_08_nervionplayers.principal.fragments;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import es.iesnervion.fjruiz.mov_08_nervionplayers.R;
import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Encuentro;
import es.iesnervion.fjruiz.mov_08_nervionplayers.model.submodel.DueloNombre;
import es.iesnervion.fjruiz.mov_08_nervionplayers.model.submodel.PartidoNombre;


public class ViewAdapter extends ArrayAdapter {

    public ViewAdapter(Context context, int resource, int textViewResourceID, Object[] objects) {
        super(context, resource, textViewResourceID, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder=new ViewHolder();
        Encuentro encuentro = (Encuentro) getItem(position);
        PartidoNombre partido;
        DueloNombre duelo;
        int type = getItemViewType(position);

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.row, parent, false);
            holder = new ViewHolder(v, R.id.equipo1, R.id.equipo2);

            switch (type) {
                case 0:
                    v.setBackgroundColor(Color.parseColor("#ff99cc00"));
                    duelo=(DueloNombre) encuentro;
                    holder.getEquipo1().setText(duelo.getNombreLocal());
                    holder.getEquipo2().setText(duelo.getNombreVisitante());
                    break;
                case 1:
                    v.setBackgroundColor(Color.parseColor("#ffffbb33"));
                    partido=(PartidoNombre) encuentro;
                    holder.getEquipo1().setText(partido.getNombreLocal());
                    holder.getEquipo2().setText(partido.getNombreVisitante());
                    break;
            }
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        return v;
    }

    /**
     * Método que devuelve que tipo de visibilidad va a tener una fila dependiendo
     * de su posición
     *
     * @param position
     * @return 0 si es un duelo, 1 si es un partido
     */
    @Override
    public int getItemViewType(int position) {
        int resultado;
        if(getItem(position).getClass()==DueloNombre.class){
            resultado=0;
        }else{
            resultado=1;
        }

        return resultado;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
