package com.example.ApiMegaTech.Repositories;

import com.example.ApiMegaTech.Models.BannerModel;
import org.springframework.boot.Banner;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BannerRepository extends MongoRepository<BannerModel, String> {


    void deleteBannerById(String id);
}
