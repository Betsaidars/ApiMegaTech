package com.example.ApiMegaTech.Models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Users")
public class UserModel {

    @Id
    @Schema(description = "Id único del usuario", example = "4")
    private String id;

    @Schema(description = "Nombre del usuario", example = "Betsaida")
    private String name;

    @Schema(description = "Email del usuario", example = "betsaida@gmail.com")
    private String email;

    @Schema(description = "Contraseña del usuario", example = "1234")
    private String pass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
