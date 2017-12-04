/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 *
 * @author Hasanov (Asus)
 */
@Configuration
@Profile("test")
public class WsTestConfig {
    
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.samirhasanov.spring.ws.domain");
        return marshaller;
    }
    
    @Bean
    public UserClient userClient(Jaxb2Marshaller marshaller) {
        UserClient client = new UserClient();
        client.setDefaultUri("http://localhost:8088/springws/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        
        return client;
    }
}
