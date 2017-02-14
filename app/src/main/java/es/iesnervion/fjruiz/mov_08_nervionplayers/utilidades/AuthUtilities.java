package es.iesnervion.fjruiz.mov_08_nervionplayers.utilidades;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

public class AuthUtilities {
    /**
     * Generates a basic authentication
     * @param nombre first string of the base64
     * @param password second string of the base64
     * @return a base64 string containing Basic nombre:password (the last in base64)
     */
    public String creaBasicAuth(String nombre,String password) {
        String basicAuth="",aux;
        byte[] bAux=null;
        aux=nombre+":"+password;
        try {
            bAux=aux.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        basicAuth="Basic "+ Base64.encodeToString(bAux,Base64.DEFAULT);

        return basicAuth;
    }
}
