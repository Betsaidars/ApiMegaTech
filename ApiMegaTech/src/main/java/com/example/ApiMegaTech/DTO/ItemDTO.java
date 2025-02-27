package com.example.ApiMegaTech.DTO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.ArrayList;

@Data
public class ItemDTO {

    private String categoryId;

    private String name;

    private String description;

    private String brand;

    private String model;

    private ArrayList availableColor;

    private ArrayList imageUrl;

    private double price;

    private double rating;
}
