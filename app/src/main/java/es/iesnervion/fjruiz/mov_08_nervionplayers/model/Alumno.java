package es.iesnervion.fjruiz.mov_08_nervionplayers.model;

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
    private Byte[] foto;

    //endregion

    //region Constructores
    public Alumno()
    {
    }

    public Alumno(int id, String nombre,String apellidos,String contraseña, String alias, String correo,
        Date fecha_Creacion, Byte curso,String letra, String observaciones, boolean confirmado,Byte[] foto)
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


    //endregion

    //region Métodos

    //endregion

}
