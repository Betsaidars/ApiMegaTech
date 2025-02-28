package com.example.ApiMegaTech.Controllers;

import com.example.ApiMegaTech.DTO.UserDTO;
import com.example.ApiMegaTech.Models.UserModel;
import com.example.ApiMegaTech.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }

    @GetMapping("/{username}")
    public UserDTO getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

}
