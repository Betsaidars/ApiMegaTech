package com.example.ApiMegaTech.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CategoryDTO {

    @Schema(description = "Nombre de la categoriaDTO")
    private String name;

    @Schema(description = "Url de la imagen de la categoríaDTO")
    private String imageUrl;

    @Schema(description = "descripción de la categoríaDTO")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
