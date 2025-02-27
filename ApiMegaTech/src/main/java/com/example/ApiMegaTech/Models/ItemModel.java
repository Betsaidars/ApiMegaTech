package com.example.ApiMegaTech.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "Items")
public class ItemModel {

    @Id
    private String id;

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
