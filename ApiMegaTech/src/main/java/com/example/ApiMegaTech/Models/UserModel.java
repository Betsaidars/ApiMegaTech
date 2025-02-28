package com.example.ApiMegaTech.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Users")
public class UserModel {

    @Id
    private int id;

    private String name;

    private String email;

    private String pass;

}
