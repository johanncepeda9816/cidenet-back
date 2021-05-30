package com.cidenet.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        try {
            Log log = new Log("./log.txt");
            Log.resetLog();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo auxiliar para cuando el puerto de despliegue no este configurado
     * @return puerto
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8080; // returns default port if heroku-port isn't set (i.e. onlocalhost)
    }
}
