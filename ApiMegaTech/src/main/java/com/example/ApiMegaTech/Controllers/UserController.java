package com.example.ApiMegaTech.Controllers;

import com.example.ApiMegaTech.DTO.UserDTO;
import com.example.ApiMegaTech.Models.UserModel;
import com.example.ApiMegaTech.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserModel userModel) {
        try {
            UserDTO createdUser = userService.createUser(userModel);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByName(@PathVariable String name) {
        try {
            UserDTO userDTO = userService.getUserByName(name);
            if (userDTO != null) {
                return new ResponseEntity<>(userDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) { // Manejar excepciones específicas si es posible
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
