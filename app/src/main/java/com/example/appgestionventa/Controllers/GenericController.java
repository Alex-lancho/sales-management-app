package com.example.appgestionventa.Controllers;

import java.security.SecureRandom;

public class GenericController {
    protected String idCodigo(){
        String caracteres= "@_%&#=ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom RANDOM = new SecureRandom();
        StringBuilder codigo = new StringBuilder(36);
        for (int i = 0; i <36; i++) {
            int indice = RANDOM.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(indice));
        }
        return codigo.toString();
    }
}
