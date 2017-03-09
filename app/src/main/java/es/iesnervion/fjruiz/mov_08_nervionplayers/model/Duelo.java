package es.iesnervion.fjruiz.mov_08_nervionplayers.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**************
* Restricciones
* *************
* Lugar<=30 caracteres
* No se insertará en BBDD las fecha de Creación
* 
*/
public class Duelo implements Parcelable
{
    //region Atributos
    private int id;
    private int id_Local;
    private int id_Visitante;
    private int id_Deporte;
    private Date fecha_Creacion;
    private Date fecha_Duelo;
    private Bitmap foto;
    private int resultado_Local;
    private int resultado_Visitante;
    private String lugar;
    private String notas;

    //endregion

    //region Constructores
    public Duelo() { }

    public Duelo(Duelo duelo){
        this.id = duelo.id;
        this.id_Local = duelo.id_Local;
        this.id_Visitante = duelo.id_Visitante;
        this.id_Deporte = duelo.id_Deporte;
        this.fecha_Creacion = duelo.fecha_Creacion;
        this.fecha_Duelo = duelo.fecha_Duelo;
        this.foto = duelo.foto;
        this.resultado_Local = duelo.resultado_Local;
        this.resultado_Visitante = duelo.resultado_Visitante;
        this.lugar = duelo.lugar;
        this.notas = duelo.notas;
    }

    public Duelo(int id, int id_Local, int id_Visitante, int id_Deporte, Date fecha_Creacion, Date fecha_Duelo,
            Bitmap foto, int resultado_Local, int resultado_Visitante, String lugar, String notas)
    {
        this.id = id;
        this.id_Local = id_Local;
        this.id_Visitante = id_Visitante;
        this.id_Deporte = id_Deporte;
        this.fecha_Creacion = fecha_Creacion;
        this.fecha_Duelo = fecha_Duelo;
        this.foto = foto;
        this.resultado_Local = resultado_Local;
        this.resultado_Visitante = resultado_Visitante;
        this.lugar = lugar;
        this.notas = notas;
    }
    //endregion

    //region Propiedades

    protected Duelo(Parcel in) {
        id = in.readInt();
        id_Local = in.readInt();
        id_Visitante = in.readInt();
        id_Deporte = in.readInt();
        foto = in.readParcelable(Bitmap.class.getClassLoader());
        resultado_Local = in.readInt();
        resultado_Visitante = in.readInt();
        lugar = in.readString();
        notas = in.readString();
    }

    public static final Creator<Duelo> CREATOR = new Creator<Duelo>() {
        @Override
        public Duelo createFromParcel(Parcel in) {
            return new Duelo(in);
        }

        @Override
        public Duelo[] newArray(int size) {
            return new Duelo[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Local() {
        return id_Local;
    }

    public void setId_Local(int id_Local) {
        this.id_Local = id_Local;
    }

    public int getId_Visitante() {
        return id_Visitante;
    }

    public void setId_Visitante(int id_Visitante) {
        this.id_Visitante = id_Visitante;
    }

    public int getId_Deporte() {
        return id_Deporte;
    }

    public void setId_Deporte(int id_Deporte) {
        this.id_Deporte = id_Deporte;
    }

    public Date getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public Date getFecha_Duelo() {
        return fecha_Duelo;
    }

    public void setFecha_Duelo(Date fecha_Duelo) {
        this.fecha_Duelo = fecha_Duelo;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public int getResultado_Local() {
        return resultado_Local;
    }

    public void setResultado_Local(int resultado_Local) {
        this.resultado_Local = resultado_Local;
    }

    public int getResultado_Visitante() {
        return resultado_Visitante;
    }

    public void setResultado_Visitante(int resultado_Visitante) {
        this.resultado_Visitante = resultado_Visitante;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(id_Local);
        parcel.writeInt(id_Visitante);
        parcel.writeInt(id_Deporte);
        parcel.writeParcelable(foto, i);
        parcel.writeInt(resultado_Local);
        parcel.writeInt(resultado_Visitante);
        parcel.writeString(lugar);
        parcel.writeString(notas);
    }

    //endregion

    //region Métodos

    //endregion
}
