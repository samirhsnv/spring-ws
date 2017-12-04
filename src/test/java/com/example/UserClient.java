/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.samirhasanov.spring.ws.domain.GetUserByIdRequest;
import com.samirhasanov.spring.ws.domain.GetUserByIdResponse;
import com.samirhasanov.spring.ws.domain.GetUsersRequest;
import com.samirhasanov.spring.ws.domain.GetUsersResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 *
 * @author Hasanov (Asus)
 */
public class UserClient extends WebServiceGatewaySupport {
    
    public GetUsersResponse getUsers() {
        GetUsersRequest request = new GetUsersRequest();
        
        return (GetUsersResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
    
    public GetUserByIdResponse getUserById(Long id) {
        GetUserByIdRequest request = new GetUserByIdRequest();
        request.setId(id);
        
        return (GetUserByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
