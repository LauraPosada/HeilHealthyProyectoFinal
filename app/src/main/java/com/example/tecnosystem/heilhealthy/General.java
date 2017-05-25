package com.example.tecnosystem.heilhealthy;

import modelo.Persona;

/**
 * Created by CAMILO on 11/05/2017.
 */

public class General {

    public  static final String ipServidor = "192.168.0.13";

    public static String getIpServidor() {
        return ipServidor;
    }

    public static String usuLogeado;

    public static String especialistaCapturado;

    public static String tipoCitaCaptu;

    public static String tipoIdCitaCaptu;

    public static String getTipoIdCitaCaptu() {
        return tipoIdCitaCaptu;
    }

    public static void setTipoIdCitaCaptu(String tipoIdCitaCaptu) {
        General.tipoIdCitaCaptu = tipoIdCitaCaptu;
    }

    public static String horari;

    public static String getHorari() {
        return horari;
    }

    public static void setHorari(String horari) {
        General.horari = horari;
    }

    public static String getTipoCitaCaptu() {
        return tipoCitaCaptu;
    }

    public static void setTipoCitaCaptu(String tipoCitaCaptu) {
        General.tipoCitaCaptu = tipoCitaCaptu;
    }

    public static String getEspecialistaCapturado() {
        return especialistaCapturado;
    }

    public static void setEspecialistaCapturado(String especialistaCapturado) {
        General.especialistaCapturado = especialistaCapturado;
    }

    public static String getUsuLogeado() {
        return usuLogeado;
    }

    public static void setUsuLogeado(String usuLogeado) {
        General.usuLogeado = usuLogeado;
    }

    public static  String cedulaLogeado;

    public static String getCedulaLogeado() {
        return cedulaLogeado;
    }

    public static void setCedulaLogeado(String cedulaLogeado) {
        General.cedulaLogeado = cedulaLogeado;
    }
}
