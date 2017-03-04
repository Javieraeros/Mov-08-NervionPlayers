package es.iesnervion.fjruiz.mov_08_nervionplayers.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

/***************
 * Restricciones
 * *************
 * Nombre<=30
 * Apellidos<=50
 * Contraseña<=255 contendrá mínimo un caracter en mayúscula, un número y un carácter especial
 * Alias<=20
 * Correo<=50 será *@*.* donde * es cualquiera cadena
 * Letra<=10
 * No se insertará en BBDD las fecha de Creación
 */
public class Alumno implements Parcelable,Serializable
{
    //region Atributos
    private int id;
    private String nombre;
    private String apellidos;
    private String password;
    private String alias;
    private String correo;
    private Date fecha_Creacion;
    private Byte curso;
    private String letra;
    private String observaciones;
    private boolean confirmado;
    private byte[] foto;

    //endregion

    //region Constructores
    public Alumno()
    {
    }

    public Alumno(int id, String nombre, String apellidos, String password, String alias, String correo,
                  Date fecha_Creacion, Byte curso, String letra, String observaciones, boolean confirmado, byte[] foto)
    {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.alias = alias;
        this.correo = correo;
        this.fecha_Creacion = fecha_Creacion;
        this.curso = curso;
        this.letra = letra;
        this.observaciones = observaciones;
        this.confirmado = confirmado;
        this.foto = foto;
    }

    //endregion

    //region Propiedades

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public Byte getCurso() {
        return curso;
    }

    public void setCurso(Byte curso) {
        this.curso = curso;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }


    //endregion

    //region Metodos

    //TODO cambiar si eso


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nombre);
        parcel.writeString(apellidos);
        parcel.writeString(password);
        parcel.writeString(alias);
        parcel.writeString(correo);
        parcel.writeString(letra);
        parcel.writeString(observaciones);
        parcel.writeByte((byte) (confirmado ? 1 : 0));
        parcel.writeByteArray(foto);
    }


    protected Alumno(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        apellidos = in.readString();
        password = in.readString();
        alias = in.readString();
        correo = in.readString();
        letra = in.readString();
        observaciones = in.readString();
        confirmado = in.readByte() != 0;
        foto = in.createByteArray();
    }

    public static final Creator<Alumno> CREATOR = new Creator<Alumno>() {
        @Override
        public Alumno createFromParcel(Parcel in) {
            return new Alumno(in);
        }

        @Override
        public Alumno[] newArray(int size) {
            return new Alumno[size];
        }
    };

    //endregion

}
