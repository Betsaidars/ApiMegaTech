package com.example.ApiMegaTech.Services;

import com.example.ApiMegaTech.DTO.UserDTO;
import com.example.ApiMegaTech.Models.UserModel;
import com.example.ApiMegaTech.Repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public UserDTO createUser(UserModel userModel) {
        if (userRepository.findByName(userModel.getName()) != null){
            throw new RuntimeException("Nombre de usuario ya existente");
        }
//
//        String hashedPassword = passwordEncoder.encode(userModel.getPass());
//        userModel.setPass(hashedPassword);

        UserModel savedUser = userRepository.save(userModel);

        UserDTO userDTO = new UserDTO();
        userDTO.setName(savedUser.getName());
        userDTO.setEmail(savedUser.getEmail());

        return userDTO;
    }

    public UserDTO getUserByName(String name) {
        Optional<UserModel> userModelOptional = Optional.ofNullable(userRepository.findByName(name));

        if (userModelOptional.isPresent()) {
            UserModel userModel = userModelOptional.get();
            UserDTO userDTO = new UserDTO();
            userDTO.setName(userModel.getName());
            userDTO.setEmail(userModel.getEmail());
            return userDTO;
        }else {
            return null;
        }
    }
}