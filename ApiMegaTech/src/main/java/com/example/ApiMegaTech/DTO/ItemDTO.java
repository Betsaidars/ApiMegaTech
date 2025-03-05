package com.example.ApiMegaTech.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.ArrayList;

@Data
public class ItemDTO {

    @Schema(description = "Nombre del itemDTO")
    private String name;

    @Schema(description = "Descripción del itemDTO")
    private String description;

    @Schema(description = "Marca del itemDTO")
    private String brand;

    @Schema(description = "Modelo del itemDTO")
    private String model;

    @Schema(description = "Colores disponibles del itemDTO")
    private ArrayList availableColor;

    @Schema(description = "Url de la imagen del itemDTO")
    private ArrayList imageUrl;

    @Schema(description = "Precio del itemDTO")
    private double price;

    @Schema(description = "Clasificación del itemDTO")
    private double rating;

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
