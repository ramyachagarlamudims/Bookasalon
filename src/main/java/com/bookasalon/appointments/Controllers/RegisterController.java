package com.bookasalon.appointments.Controllers;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import com.bookasalon.appointments.Models.UserData;
import com.bookasalon.appointments.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RegisterController {
    private UserService userService;

    @Autowired
    public RegisterController( UserService userService) {
        this.userService = userService;
    }
    // Return registration form template
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage(ModelAndView modelAndView, UserData UserData){
        modelAndView.addObject("UserData", UserData);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    // Process form input data
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid UserData userData, BindingResult bindingResult, HttpServletRequest request) {
        // Lookup userData in database by e-mail
        UserData userDataExists = userService.findByEmail(userData.getEmail());
        System.out.println(userDataExists);
        if (userDataExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a userData registered with the email provided.");
            modelAndView.setViewName("register");
            bindingResult.reject("email");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else { // new userData so we create userData and send confirmation e-mail
            // Disable userData until they click on confirmation link in email
            userService.saveUser(userData);
            String appUrl = request.getScheme() + "://" + request.getServerName();
            modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + userData.getEmail());
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }
//
//    // Process confirmation link
//    @RequestMapping(value="/confirmation", method = RequestMethod.GET)
//    public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam("token") String token) {
//       UserData user = userService.findByEmail(user.getEmail());
//        if (user == null) { // No token found in DB
//            modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
//        } else { // Token found
//          //  modelAndView.addObject("confirmationToken", user.getConfirmationToken());
//        }
//        modelAndView.setViewName("confirmation");
//        return modelAndView;
//    }

}