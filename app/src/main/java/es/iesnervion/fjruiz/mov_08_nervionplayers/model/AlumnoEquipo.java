package es.iesnervion.fjruiz.mov_08_nervionplayers.model;

import java.util.Date;

public class AlumnoEquipo
    {
        //region Atributos
        private int id_Alumno;
        private int id_Equipo;
        private Date fecha_Creacion;

        
        //endregion

        //region Constructores

        public AlumnoEquipo()
        {

        }

        public AlumnoEquipo(int id_alumno,int id_equipo,Date fecha_Creacion)
        {
            this.id_Alumno = id_alumno;
            this.id_Equipo = id_equipo;
            this.fecha_Creacion = fecha_Creacion;
        }

        //endregion

        //region Propiedades

        public int getId_Alumno() {
            return id_Alumno;
        }

        public void setId_Alumno(int id_Alumno) {
            this.id_Alumno = id_Alumno;
        }

        public int getId_Equipo() {
            return id_Equipo;
        }

        public void setId_Equipo(int id_Equipo) {
            this.id_Equipo = id_Equipo;
        }

        public Date getFecha_Creacion() {
            return fecha_Creacion;
        }

        public void setFecha_Creacion(Date fecha_Creacion) {
            this.fecha_Creacion = fecha_Creacion;
        }

        //endregion

}
