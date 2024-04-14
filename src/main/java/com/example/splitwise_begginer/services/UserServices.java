package com.example.splitwise_begginer.services;

import com.example.splitwise_begginer.models.User;
import com.example.splitwise_begginer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    private UserRepository userRepository;
    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(String name, String uName,String password){
        User user = new User();
        user.setUserName(uName);
        user.setName(name);
        user.setPassword(password);

        User savedUser = userRepository.save(user); // get the user id too
        return savedUser;
    }

    public User getUser(Long userId) throws Exception{
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new Exception("User Not found ");
        }

            return userOptional.get();


    }
}
