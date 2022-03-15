/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disney.challenge.services.Implementations;

import com.disney.challenge.services.EmailService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailSeviceImpl implements EmailService {

    
    @Autowired
    private Environment environment;

    @Value("${alkemy.disneyapi.email.sender}")
    private String emailSender;
    @Value("${alkemy.disneyapi.email.enabled}")
    private boolean enabled;

    @Override
    public void sendWelcomeEmailTo(String to) {
        // SendGrid API Key como variable de entorno
        String apiKey = environment.getProperty("EMAIL_API_KEY");
        // Definición de partes del correo electrónico como remitente, destinatario, contenido y asunto
        Email fromEmail = new Email(emailSender);
        Email toEmail = new Email(to);
        Content content = new Content(
                "text/plain",
                "Bienvenidos al Maravilloso Mundo de Disney!!!"
        );
        String subject = "Getting Started at Disney API";
        // Creación del correo electrónico con todas sus partes, un objeto SendGrid con la clave API y una solicitud
        Mail mail = new Mail(fromEmail, subject, toEmail, content);
        SendGrid sendGrid = new SendGrid(apiKey);
        Request request = new Request();
        // Definir atributos de solicitud y guardar la respuesta de esa solicitud
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            //Mostrara los detalles de respuesta en consola...
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException e) {System.out.println("Error al intentar enviar un email");}
    }
}
