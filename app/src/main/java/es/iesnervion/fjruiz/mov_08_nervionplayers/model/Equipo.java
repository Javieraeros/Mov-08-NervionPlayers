package es.iesnervion.fjruiz.mov_08_nervionplayers.model;

import android.graphics.Bitmap;

import java.util.Date;

public class Equipo
{
    private int id;
    private int id_Creador;
    private int categoria;
    private String nombre;
    private Date fecha_Creacion;
    private Bitmap foto;
    private boolean confirmado;

    public Equipo(){}

    public Equipo(int id, int id_Creador,int categoria, String nombre, Date fecha_Creacion, Bitmap foto, boolean confirmado)
    {
        this.id = id;
        this.id_Creador = id_Creador;
        this.nombre = nombre;
        this.categoria=categoria;
        this.fecha_Creacion = fecha_Creacion;
        this.foto = foto;
        this.confirmado = confirmado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Creador() {
        return id_Creador;
    }

    public void setId_Creador(int id_Creador) {
        this.id_Creador = id_Creador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
