package com.persado.assignment.project.Services.UserServices;

import com.persado.assignment.project.Entities.User;

import java.util.List;

public interface UserService {

     List<User> findAll();


     void save(User theUser);

     void deleteById(long theId);
}
