package com.bookasalon.appointments.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String homePage(Model model)
    {
        return "home";
    }

    @GetMapping("/forgotpassword")
    public String forgotPage(Model model)
    {
        return "forgotpassword";
    }

    @GetMapping("/appointment")
    public String appointmentPage(Model model)
    {
        return "appointment";
    }

}
