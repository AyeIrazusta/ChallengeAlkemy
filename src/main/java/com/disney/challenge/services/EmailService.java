/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disney.challenge.services;



public interface EmailService {

    /**
     * Envia un correo electronico de Bienvenida recibiendo como parametro SendGrid
     */
    void sendWelcomeEmailTo(String to);
}
