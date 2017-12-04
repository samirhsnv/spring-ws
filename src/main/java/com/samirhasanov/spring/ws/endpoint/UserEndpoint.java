/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.ws.endpoint;

import com.samirhasanov.spring.ws.dao.IUserDao;
import com.samirhasanov.spring.ws.domain.GetUserByIdRequest;
import com.samirhasanov.spring.ws.domain.GetUserByIdResponse;
import com.samirhasanov.spring.ws.domain.GetUsersRequest;
import com.samirhasanov.spring.ws.domain.GetUsersResponse;
import com.samirhasanov.spring.ws.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


/**
 *
 * @author Hasanov (Asus)
 */
@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://samirhasanov.com/spring/ws/domain";
    private final IUserDao iUserDao;
    
    @Autowired
    public UserEndpoint(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUsersRequest")
    @ResponsePayload
    public GetUsersResponse getUsers(@RequestPayload GetUsersRequest request) {
        GetUsersResponse response = new GetUsersResponse();
        response.getUser().addAll(this.iUserDao.getUsers());
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUserByIdRequest")
    @ResponsePayload
    public GetUserByIdResponse getUserById(@RequestPayload GetUserByIdRequest request) {
        User user = this.iUserDao.getUserById(request.getId());
        GetUserByIdResponse response = new GetUserByIdResponse();
        response.setUser(user);
        
        return response;
    }
}
