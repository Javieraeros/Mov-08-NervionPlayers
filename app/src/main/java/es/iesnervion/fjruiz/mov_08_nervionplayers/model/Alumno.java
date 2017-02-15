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
    private Bitmap foto;

    //endregion

    //region Constructores
    public Alumno()
    {
    }

    public Alumno(int id, String nombre, String apellidos, String password, String alias, String correo,
                  Date fecha_Creacion, Byte curso, String letra, String observaciones, boolean confirmado, Bitmap foto)
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

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    //endregion

    //region Metodos

    //TODO cambiar si eso

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;

        if (id != alumno.id) return false;
        if (confirmado != alumno.confirmado) return false;
        if (nombre != null ? !nombre.equals(alumno.nombre) : alumno.nombre != null) return false;
        if (apellidos != null ? !apellidos.equals(alumno.apellidos) : alumno.apellidos != null)
            return false;
        if (password != null ? !password.equals(alumno.password) : alumno.password != null)
            return false;
        if (alias != null ? !alias.equals(alumno.alias) : alumno.alias != null) return false;
        if (correo != null ? !correo.equals(alumno.correo) : alumno.correo != null) return false;
        if (fecha_Creacion != null ? !fecha_Creacion.equals(alumno.fecha_Creacion) : alumno.fecha_Creacion != null)
            return false;
        if (curso != null ? !curso.equals(alumno.curso) : alumno.curso != null) return false;
        if (letra != null ? !letra.equals(alumno.letra) : alumno.letra != null) return false;
        if (observaciones != null ? !observaciones.equals(alumno.observaciones) : alumno.observaciones != null)
            return false;
        return foto != null ? foto.equals(alumno.foto) : alumno.foto == null;

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
        foto = in.readParcelable(Bitmap.class.getClassLoader());
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


    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     * @see #CONTENTS_FILE_DESCRIPTOR
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeString(apellidos);
        dest.writeString(password);
        dest.writeString(alias);
        dest.writeString(correo);
        dest.writeString(letra);
        dest.writeString(observaciones);
        dest.writeByte((byte) (confirmado ? 1 : 0));
        dest.writeParcelable(foto, flags);
    }
    //endregion

}
