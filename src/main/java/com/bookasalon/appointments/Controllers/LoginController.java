package com.bookasalon.appointments.Controllers;
import com.bookasalon.appointments.Models.User;
import com.bookasalon.appointments.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView loginsubmit(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult, HttpServletRequest request) {
        // Lookup user in database by e-mail
        User userExists = userService.findByEmail(user.getEmail());
        System.out.println(userExists);
        if (userExists != null){
            modelAndView.addObject("username",userExists.getFullname());
            modelAndView.setViewName("home");
        } else {
            modelAndView.addObject("Not a Registered User", "Oops! Please register to login");
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }

//    @PostMapping("/login")
//    public String loginuser(@RequestParam(required = true) String email, @RequestParam(required = true) String password){
//        return ("/home");
//    }
//    public String loginuser(@RequestParam @NotEmpty @Email String email, @RequestParam(required = true) @Min(5) String password, BindingResult result, ModelMap model){
//    //   public String loginuser(@Valid @RequestParam(required = true) String email, @Valid @RequestParam(required = true) String password){
//   }
//
////   @GetMapping("/registersubmit")
////    public String registerSubmit(@Valid @ModelAttribute UserData userdata){
////        userService.registeruser(userdata);
////        return ("/confirmation");
////    }        return ("/home");
//
}

