package es.iesnervion.fjruiz.mov_08_nervionplayers.model.submodel;

import android.os.Parcel;
import android.os.Parcelable;

import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Partido;
import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Encuentro;

/**
 * Created by fjruiz on 9/03/17.
 */

public class PartidoNombre extends Partido implements Encuentro {
    private String nombreLocal;
    private String nombreVisitante;
    private String nombreDeporte;

    public PartidoNombre(Partido partido, String nombreLocal, String nombreVisitante, String nombreDeporte)
    {
        super(partido);
        this.nombreLocal = nombreLocal;
        this.nombreVisitante = nombreVisitante;
        this.nombreDeporte = nombreDeporte;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getNombreVisitante() {
        return nombreVisitante;
    }

    public void setNombreVisitante(String nombreVisitante) {
        this.nombreVisitante = nombreVisitante;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
