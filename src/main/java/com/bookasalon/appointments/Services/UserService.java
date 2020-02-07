package com.bookasalon.appointments.Services;
import com.bookasalon.appointments.Models.UserData;
import com.bookasalon.appointments.Repositories.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    private UserDataRepository userDataRepository;

    @Autowired
    public UserService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }
    public UserData findByEmail(String email) {
        return userDataRepository.findByEmail(email);
    }

//    public UserData findByConfirmationToken(String confirmationToken) {
//     //   return userDataRepository.findByConfirmationToken(confirmationToken);
//    }

    public void saveUser(UserData userData) {
        userDataRepository.save(userData);
    }

}
