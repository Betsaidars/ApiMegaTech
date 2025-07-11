package com.example.ApiMegaTech.Services;

import com.example.ApiMegaTech.DTO.UserDTO;
import com.example.ApiMegaTech.Exceptions.UserNotFoundException;
import com.example.ApiMegaTech.Models.UserModel;
import com.example.ApiMegaTech.Repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public UserDTO getUserByUsername(String username) {
        Optional<UserModel> userModelOptional = Optional.ofNullable(userRepository.findByName(username));

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
    public UserDTO getUserById(String idUser) {
        Optional<UserModel> userModelOptional = userRepository.findById(Long.valueOf(idUser));

        if (userModelOptional.isPresent()) {
            UserModel userModel = userModelOptional.get();

            UserDTO userDTO = new UserDTO();
            userDTO.setId(userModel.getId()); // O cualquier otro campo necesario
            userDTO.setName(userModel.getName());
            userDTO.setEmail(userModel.getEmail());

            return userDTO;
        } else {
            throw new UserNotFoundException("Usuario no encontrado con ID: " + idUser);
        }
    }

}