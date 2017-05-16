package com.example.tecnosystem.heilhealthy;

/**
 * Created by CAMILO on 11/05/2017.
 */

public class General {

    public  static final String ipServidor = "192.168.27.188";

    public static String getIpServidor() {
        return ipServidor;
    }

    public static String usuLogeado;

    public static String getUsuLogeado() {
        return usuLogeado;
    }

    public static void setUsuLogeado(String usuLogeado) {
        General.usuLogeado = usuLogeado;
    }
}
