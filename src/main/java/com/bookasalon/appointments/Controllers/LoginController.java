package com.bookasalon.appointments.Controllers;
import com.bookasalon.appointments.Models.UserData;
import com.bookasalon.appointments.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public  ModelAndView loginPage(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginsubmit(ModelAndView modelAndView, @Valid UserData userData, BindingResult bindingResult, HttpServletRequest request) {
        UserData userDataExists = userService.findByEmail(userData.getEmail());
        System.out.println(userDataExists);
        if (userDataExists == null){
            modelAndView.addObject("Not a Registered UserData", "Oops! Please register to login");
            modelAndView.setViewName("register");
        } else {
            modelAndView.addObject("username", userDataExists.getFullname());
            modelAndView.setViewName("home");
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

