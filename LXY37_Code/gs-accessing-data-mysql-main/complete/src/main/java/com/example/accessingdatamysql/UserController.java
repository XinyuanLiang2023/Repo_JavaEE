package com.example.accessingdatamysql;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping(path="/add")
    private String showForm (User user){
        return "userForm";
    }

    @PostMapping(path="/add")
    public String addNewUser (@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "userForm";
        }
        userRepository.save(user);
        return "redirevt:/user/all";
    }

    @GetMapping(value="all")
    public String getAllUsers(Model model) {
        Iterable<User> userList = userRepository.findAll();
        model.addAttribute("userList",userList);

        return "userList";
    }
    

    
}
