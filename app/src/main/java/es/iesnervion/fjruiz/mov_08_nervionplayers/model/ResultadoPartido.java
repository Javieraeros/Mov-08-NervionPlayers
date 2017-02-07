package es.iesnervion.fjruiz.mov_08_nervionplayers.model;

public class ResultadoPartido
{
    //region Atributos

    private int id;
    private int id_Equipo;
    private int ganados;
    private int empatados;
    private int perdidos;


    //endregion

    //region Constructores

    public ResultadoPartido()
    {

    }
    public ResultadoPartido(int id, int id_Equipo, int ganados, int empatados, int perdidos)
    {
        this.id = id;
        this.id_Equipo = id_Equipo;
        this.ganados = ganados;
        this.empatados = empatados;
        this.perdidos = perdidos;
    }
    //endregion

    //region Propiedades

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Equipo() {
        return id_Equipo;
    }

    public void setId_Equipo(int id_Equipo) {
        this.id_Equipo = id_Equipo;
    }

    public int getGanados() {
        return ganados;
    }

    public void setGanados(int ganados) {
        this.ganados = ganados;
    }

    public int getEmpatados() {
        return empatados;
    }

    public void setEmpatados(int empatados) {
        this.empatados = empatados;
    }

    public int getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(int perdidos) {
        this.perdidos = perdidos;
    }

    //endregion
}
