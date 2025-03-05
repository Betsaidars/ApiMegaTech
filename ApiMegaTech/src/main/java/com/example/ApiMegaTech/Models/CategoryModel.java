package com.example.ApiMegaTech.Models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Categories")
public class CategoryModel {

    @Id
    @Schema(description = "Id único de la categoría", example = "2")
    private String id;

    @Schema(description = "Nombre de la categoría", example = "Móvil")
    private String name;

    @Schema(description = "Url de la imagen", example = "https://firebasestorage.googleapis.com/v0/b/project-200-1.appspot.com/o/cat2.png?alt=media&token=4508a8d0-dc76-4e54-8234-4a7ddcfbfe41")
    private String imageUrl;

    @Schema(description = "Descripción de la categoría", example = "Los mejores móviles del mercado con las últimas tecnologías.")
    private String description;
}
