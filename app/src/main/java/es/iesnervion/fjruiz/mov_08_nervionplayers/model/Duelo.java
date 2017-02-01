package es.iesnervion.fjruiz.mov_08_nervionplayers.model;

import java.util.Date;

/**************
* Restricciones
* *************
* Lugar<=30 caracteres
* No se insertará en BBDD las fecha de Creación
* 
*/
public class Duelo
{
    //region Atributos
    private int id;
    private int id_Local;
    private int id_Visitante;
    private int id_Deporte;
    private Date fecha_Creacion;
    private Date fecha_Duelo;
    private Byte[] foto;
    private int resultado_Local;
    private int resultado_Visitante;
    private String lugar;
    private String notas;

    //endregion

    //region Constructores
    public Duelo() { }

    public Duelo(int id, int id_Local, int id_Visitante, int id_Deporte, Date fecha_Creacion, Date fecha_Duelo,
            Byte[] foto, int resultado_Local, int resultado_Visitante, String lugar, String notas)
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

    //endregion

    //region Métodos

    //endregion
}
