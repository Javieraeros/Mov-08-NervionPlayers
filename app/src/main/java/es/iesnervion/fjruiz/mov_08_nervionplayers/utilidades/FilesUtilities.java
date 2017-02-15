package es.iesnervion.fjruiz.mov_08_nervionplayers.utilidades;

import android.content.Context;
import android.content.SharedPreferences;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import butterknife.BindString;
import es.iesnervion.fjruiz.mov_08_nervionplayers.R;
import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Alumno;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by fjruiz on 15/02/17.
 */

public class FilesUtilities {

    private final Context contexto;
    @BindString(R.string.fichero) String fichero;
    private SharedPreferences sharedPreferences;
    private final String authKey="auth";
    private final String nombreFichero="ficherito.txt";

    public FilesUtilities(Context contexto){
        this.contexto=contexto;
        sharedPreferences=contexto.getSharedPreferences(fichero,MODE_PRIVATE);
    }

    public void saveAuthorization(String auth){
        sharedPreferences.edit().putString(authKey,auth).apply();
    }

    public String loadAtuhorization(){
        return sharedPreferences.getString(authKey,null);
    }

    /**
     * Método que guarda un alumno en el fichero correspondiente
     * @param alumno a guardar, sobrescribe el anterior
     */
    public void saveAlumno(Alumno alumno){
        File ficheroAlumno=new File(contexto.getFilesDir(),nombreFichero);
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            fos=new FileOutputStream(ficheroAlumno,false);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(alumno);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos!=null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Alumno loadAlumno(){
        Alumno miAlumno=null;
        File ficheroAlumno=new File(contexto.getFilesDir(),nombreFichero);
        FileInputStream fis=null;
        ObjectInputStream ois=null;

        try {
            fis=new FileInputStream(ficheroAlumno);
            ois=new ObjectInputStream(fis);
            miAlumno=(Alumno) ois.readObject();
        } catch (IOException | ClassNotFoundException eo) {
            eo.printStackTrace();
        }
        if(ois!=null){
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(fis!=null){
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return miAlumno;
    }

}
