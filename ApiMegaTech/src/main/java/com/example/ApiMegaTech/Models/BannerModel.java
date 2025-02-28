package com.example.ApiMegaTech.Models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Banners")
public class BannerModel {

    @Id
    @Schema(description = "Id único del banner", example = "1")
    private String id;

    @Schema(description = "Url de la imagen del abanner", example = "https://firebasestorage.googleapis.com/v0/b/project208-2.appspot.com/o/banner1.png?alt=media&token=91f65188-3bff-4ad6-8b02-31c00aeb3ca6")
    private String imageUrl;

}
