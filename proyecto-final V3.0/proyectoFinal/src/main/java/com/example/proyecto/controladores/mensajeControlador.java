/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.proyecto.controladores;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 
 * @author user
 */
@Controller
@RequestMapping("/mensaje")
public class mensajeControlador {

    public static final String ACCOUNT_SID = "ACcc20b39020dc7cd0bdd6879a64d90e78";
    /*twilio cid de max*/
    public static final String AUTH_TOKEN = "3fced43a36732efdb30779f9c07c3a69";

    /*token de max*/


    @GetMapping("/crear")
    public String crear() {
        return "mensaje.html";
    }

    @PostMapping("/enviar")
    public String registro(String numero, String mensaje) {
        String destinatario = "whatsapp:+549" + numero;

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(destinatario),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                mensaje).create();
        
        return "mensaje.html";
    }
}
