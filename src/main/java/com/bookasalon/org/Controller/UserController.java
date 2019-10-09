package com.bookasalon.org.Controller;
import com.bookasalon.org.Services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private Services services;

    @CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*")
    @RequestMapping(value="/login",method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity loginUser(@RequestParam(name="email", required=true) String email, @RequestParam(name="password",required = true) String password){
        System.out.println("u r here" +email+password);
        return  new ResponseEntity<>(services.searchUser(email,password), HttpStatus.OK);
    }
    @RequestMapping("/")
    public String home(){
        return("index");
    }
    @CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*")
    @RequestMapping(value="/register",method = {RequestMethod.GET})
    public ResponseEntity registerUser(@RequestParam(name="userName", required = true) String userName, @RequestParam(name="email", required=true) String email, @RequestParam(name="password",required = true) String password){
        System.out.println("registered" +email+password+userName);
        return  new ResponseEntity<>(services.registerUser(userName,email,password), HttpStatus.CREATED);
    }

}

