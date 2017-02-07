package es.iesnervion.fjruiz.mov_08_nervionplayers.model;

import android.graphics.Bitmap;

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
public class Alumno
{
    //region Atributos
    private int id;
    private String nombre;
    private String apellidos;
    private String contraseña;
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

    public Alumno(int id, String nombre,String apellidos,String contraseña, String alias, String correo,
        Date fecha_Creacion, Byte curso,String letra, String observaciones, boolean confirmado,Bitmap foto)
    {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contraseña = contraseña;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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

    //region Métodos

    //endregion

}
