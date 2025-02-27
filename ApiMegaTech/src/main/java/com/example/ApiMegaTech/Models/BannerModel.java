package com.example.ApiMegaTech.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Banners")
public class BannerModel {

    @Id
    private String id;

    private  String name;

    private String imageUrl;

    private String description;

}
