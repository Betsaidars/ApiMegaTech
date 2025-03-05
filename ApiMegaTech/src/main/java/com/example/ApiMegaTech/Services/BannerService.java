package com.example.ApiMegaTech.Services;

import com.example.ApiMegaTech.DTO.BannerDTO;
import com.example.ApiMegaTech.Exceptions.BannerNotFoundException;
import com.example.ApiMegaTech.Models.BannerModel;
import com.example.ApiMegaTech.Repositories.BannerRepository;
import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    public List<BannerModel> findAll() {
        return bannerRepository.findAll();
    }

    public Optional<BannerModel> findById(String id) {
        return bannerRepository.findById(id);
    }

    public BannerModel save(BannerModel bannerModel){
        return bannerRepository.save(bannerModel);
    }


    public BannerModel updateBanner(String id, BannerDTO bannerDTO) {
        try {
            Optional<BannerModel> optionalBannerModel = bannerRepository.findById(id);

            if (optionalBannerModel.isPresent()) {
                BannerModel bannerModel = optionalBannerModel.get();
                bannerModel.setImageUrl(bannerDTO.getImageUrl());
                return bannerRepository.save(bannerModel);
            } else {
                throw new BannerNotFoundException("Banner con ID " + id + " not existe");
            }
        } catch (IllegalArgumentException e) {
            // Manejar la excepción si el ID es inválido
        } catch (MongoException e) {
            // Manejar la excepción si hay un problema con la base de datos
        }
        return null; // O lanzar una excepción
    }

    public boolean deleteBannerById(String id) {
        try {
            if (bannerRepository.existsById(id)) {
                bannerRepository.deleteById(id);
                return true;
            }
        } catch (Exception e) {
            // Manejar la excepción, por ejemplo, logueando el error
            System.err.println("Error deleting banner: " + e.getMessage());
        }
        return false;
    }
}
