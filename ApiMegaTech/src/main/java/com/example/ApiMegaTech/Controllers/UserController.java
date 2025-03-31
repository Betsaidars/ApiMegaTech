package com.example.ApiMegaTech.Controllers;

import com.example.ApiMegaTech.DTO.UserDTO;
import com.example.ApiMegaTech.Exceptions.UserNotFoundException;
import com.example.ApiMegaTech.Models.BannerModel;
import com.example.ApiMegaTech.Models.UserModel;
import com.example.ApiMegaTech.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping
//    public List<UserModel> getAllUsers(){
//        return userService.findAll();
//    }

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
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        try {
            UserDTO userDTO = userService.getUserByUsername(username);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Log the exception here
            e.printStackTrace(); // For debugging purposes
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        try {
            UserDTO userDTO = userService.getUserById(id);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Log the exception here
            e.printStackTrace(); // For debugging purposes
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
