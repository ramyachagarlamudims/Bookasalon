package com.bookasalon.org.Services;

import com.bookasalon.org.Model.User;
import com.bookasalon.org.Repository.UserRepository;
import com.bookasalon.org.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class Services {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public User searchUser(String email, String password) {
        User user = (User) userRepository.findbyusername(email, password);
        return user;
    }

    public User registerUser(String user, String email, String password) {
      userRepository.saveUser(user, email, password);
        User userdata = (User) userRepository.findbyusername(email, password);
        return userdata;
    }
}
