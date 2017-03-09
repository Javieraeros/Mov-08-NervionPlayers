package es.iesnervion.fjruiz.mov_08_nervionplayers.principal.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

public class ViewHolder {
    private TextView equipo1;
    private TextView equipo2;

    public ViewHolder(){};

    public ViewHolder(View row,int equipo1, int equipo2) {
        this.equipo1=(TextView) row.findViewById(equipo1);
        this.equipo2=(TextView) row.findViewById(equipo2);
    }

    public TextView getEquipo1() {
        return equipo1;
    }

    public TextView getEquipo2() {
        return equipo2;
    }
}
