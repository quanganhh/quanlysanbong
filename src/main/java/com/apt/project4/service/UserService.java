package com.apt.project4.service;

import com.apt.project4.model.Role;
import com.apt.project4.model.RoleName;
import com.apt.project4.model.User;
import com.apt.project4.payload.UserRegisteringRequest;
import com.apt.project4.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerNewAccount(UserRegisteringRequest registerRequest) {
        registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        Role role = roleService.findByRoleName(registerRequest.getRoleName());

        User user = objectMapper.convertValue(registerRequest, User.class);
        user.setRole(role);

        return userRepository.save(user);
    }

    public User findById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    // add new user 
    public  User addNewUser(UserRegisteringRequest userRequestobj) {
        userRequestobj.setPassword(passwordEncoder.encode(userRequestobj.getPassword()));
        Role roles = roleService.findByRoleName(userRequestobj.getRoleName());
        
        User user = objectMapper.convertValue(userRequestobj, User.class);
        user.setRole(roles);
        
        return userRepository.save(user);
    }
    //update user
    public User updateUser(UserRegisteringRequest usersRequestobj) {
        User user = userRepository.getOne(parseInt(usersRequestobj.getId()));
        User us = objectMapper.convertValue(usersRequestobj, User.class);
        
        return  userRepository.save(us);
    }
    //delete user
    public void deleteUser(String id){
        User user = userRepository.getOne(parseInt(id));
        userRepository.delete(user);
    }
}

