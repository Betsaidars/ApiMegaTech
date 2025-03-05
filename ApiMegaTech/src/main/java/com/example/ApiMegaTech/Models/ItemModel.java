package com.example.ApiMegaTech.Models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "Items")
public class ItemModel {

    @Id
    @Schema(description = "Id único del item", example = "3")
    private String id;

    @Schema(description = "Id de la categoría del item", example = "3")
    private String categoryId;

    @Indexed
    @Schema(description = "Descripcion del item", example = "Auriculares inalámbricos Pro")
    private String name;

    @Schema(description = "Id único de la categoría", example = "Auriculares con cancelación de ruido, sonido de alta fidelidad y batería de larga duración.")
    private String description;

    @Schema(description = "Manca del item", example = "Sony")
    private String brand;

    @Schema(description = "Modelo del item", example = "WH-1000XM5")
    private String model;

    @Schema(description = "Colores disponibles del item", example = "Negro, blanco, azul")
    private ArrayList availableColor;

    @Schema(description = "Url de la imagen del item", example = "https://m.media-amazon.com/images/I/61fxPWFu6aL.jpg")
    private ArrayList imageUrl;

    @Schema(description = "Precio del item", example = "350.00")
    private double price;

    @Schema(description = "Clasificación del item", example = "4.8")
    private double rating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ArrayList getAvailableColor() {
        return availableColor;
    }

    public void setAvailableColor(ArrayList availableColor) {
        this.availableColor = availableColor;
    }

    public ArrayList getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(ArrayList imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
