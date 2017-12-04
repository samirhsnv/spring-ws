/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.ws.dao;

import com.samirhasanov.spring.ws.domain.User;
import java.util.List;

/**
 *
 * @author Hasanov (Asus)
 */
public interface IUserDao {
    public List<User> getUsers();
    public User getUserById(Long id);
}
