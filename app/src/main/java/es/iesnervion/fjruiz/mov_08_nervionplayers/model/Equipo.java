import java.util.Date;

public class Equipo
    {
        private int id;
        private int id_Creador;
        private String nombre;
        private Date fecha_Creacion;
        private Byte[] foto;
        private boolean confirmado;

        public Equipo(int id, int id_Creador, String nombre, Date fecha_Creacion, byte[] foto, boolean confirmado)
        {
            this.id = id;
            this.id_Creador = id_Creador;
            this.nombre = nombre;
            this.fecha_Creacion = fecha_Creacion;
            this.foto = foto;
            this.confirmado = confirmado;
        }

        public int Id
        {
            get
            {
                return id;
            }

            set
            {
                id = value;
            }
        }

        public int Id_Creador
        {
            get
            {
                return id_Creador;
            }

            set
            {
                id_Creador = value;
            }
        }

        public string Nombre
        {
            get
            {
                return nombre;
            }

            set
            {
                nombre = value;
            }
        }

        public DateTime Fecha_Creacion
        {
            get
            {
                return fecha_Creacion;
            }

            set
            {
                fecha_Creacion = value;
            }
        }

        public byte[] Foto
        {
            get
            {
                return foto;
            }

            set
            {
                foto = value;
            }
        }

        public bool Confirmado
        {
            get
            {
                return confirmado;
            }

            set
            {
                confirmado = value;
            }
        }
    }
}
