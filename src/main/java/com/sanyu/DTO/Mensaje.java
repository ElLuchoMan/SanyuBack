package com.sanyu.DTO;


public class Mensaje {
	//Clase para poder responder con un mensaje los mensajes de la API
    private String mensaje;

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}