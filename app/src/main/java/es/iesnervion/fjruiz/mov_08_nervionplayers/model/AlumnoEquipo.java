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

        //endregion

}
