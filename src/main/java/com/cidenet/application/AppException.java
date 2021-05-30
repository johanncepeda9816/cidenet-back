package com.cidenet.application;

public class AppException extends Exception{

    public final static String EL_NUMERO_DE_DOCUMENTO_YA_SE_ENCUENTRA_REGISTRADO = "EL NUMERO DE DOCUMENTO YA SE ENCUENTRA REGISTRADO";
    public final static String EL_CORREO_ELECTRONICO_YA_SE_ENCUENTRA_REGISTRADO = "EL CORREO ELECTRONICO YA SE ENCUENTRA REGISTRADO";

    public AppException(String msg){
        super(msg);
    }
}
