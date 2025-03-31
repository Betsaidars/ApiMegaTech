package com.example.ApiMegaTech.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserDTO {

    @Schema(description = "Id del usuario")
    private String id;

    @Schema(description = "Nombre del usuarioDTO")
    private String username;

    @Schema(description = "Email del usuarioDTO")
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

