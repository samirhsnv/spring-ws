/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.ws.dao;

import com.samirhasanov.spring.ws.domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hasanov (Asus)
 */
@Repository
public class UserDao implements IUserDao {
    private final List<User> users = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        User samir = new User();
        samir.setId(1L);
        samir.setFullname("Samir Hasanov");
        samir.setAge(28);
        
        User murad = new User();
        murad.setId(2L);
        murad.setFullname("Murad Rzayev");
        murad.setAge(28);
        
        User ziya = new User();
        ziya.setId(3L);
        ziya.setFullname("Ziyatay Akbarli");
        ziya.setAge(27);
        
        users.add(samir);
        users.add(murad);
        users.add(ziya);
    }
    
    @Override
    public List<User> getUsers() {
        return this.users;
    }

    @Override
    public User getUserById(Long id) {
        for(User u: users) {
            if(u.getId() == id) {
                return u;
            }
        }
        
        return null;
    }
    
}
