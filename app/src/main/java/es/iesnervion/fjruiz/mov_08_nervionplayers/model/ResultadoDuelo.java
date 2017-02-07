/**************
* Restricciones
* *************
* ganados,empatados y perdidos>=0
* 
*/
public class ResultadoDuelo
{
    //region Atributos
    private int id;
    private int id_Alumno;
    private int ganados;
    private int empatados;
    private int perdidos;

    //endregion

    //region Constructores
    public ResultadoDuelo(){}

    public ResultadoDuelo(int id, int id_Alumno, int ganados, int empatados, int perdidos)
    {
        this.id = id;
        this.id_Alumno = id_Alumno;
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

    public int getId_Alumno() {
        return id_Alumno;
    }

    public void setId_Alumno(int id_Alumno) {
        this.id_Alumno = id_Alumno;
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

    //region Métodos

    //endregion


}
