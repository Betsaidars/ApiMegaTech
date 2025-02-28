package com.example.ApiMegaTech.Services;

import com.example.ApiMegaTech.DTO.BannerDTO;
import com.example.ApiMegaTech.Models.BannerModel;
import com.example.ApiMegaTech.Repositories.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    public List<BannerModel> findAll() {
        return bannerRepository.findAll();
    }

    public Optional<BannerModel> findById(String id) {
        return bannerRepository.findById(id);
    }

    public Object save(BannerModel bannerModel) {

    }

    public void deleteById(String id) {
    }

    public boolean register(BannerDTO bannerDTO) {
        BannerModel bannerModel = new BannerModel();
        bannerModel.setImageUrl(bannerDTO.getImageUrl());

        return (bannerRepository.save(bannerModel) != null);
    }

    public void updateItem(String id, BannerDTO bannerDTO) {
        Optional<BannerModel> optionalBannerModel = bannerRepository.findById(id);

        if (optionalBannerModel.isPresent()){
            BannerModel bannerModel = optionalBannerModel.get();
            bannerModel.setImageUrl(bannerDTO.getImageUrl());

            bannerRepository.save(bannerModel);
        }
    }

    public boolean deleteBannerById(String id) {
        return false;
    }
}
