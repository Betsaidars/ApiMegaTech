package com.example.ApiMegaTech.DTO;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class BannerDTO {

    private  int id;

    private String imageUrl;
}
