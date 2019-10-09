package com.bookasalon.org.Services;

import com.bookasalon.org.Model.UserData;
import com.bookasalon.org.Repository.UserDataRepository;
import com.bookasalon.org.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {

    @Autowired
    UserDataRepository userDataRepository;

    @Autowired
    RoleRepository roleRepository;

    public UserData searchUser(String email, String password) {
        UserData userData = (UserData) userDataRepository.findbyusername(email, password);
        return userData;
    }

    public UserData registerUser(String userName, String email, String password) {
      userDataRepository.saveUser(userName, email, password);
        UserData userdata = (UserData) userDataRepository.findbyusername(email, password);
        return userdata;
    }
}
