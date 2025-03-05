package com.example.ApiMegaTech.Controllers;

import com.example.ApiMegaTech.DTO.BannerDTO;
import com.example.ApiMegaTech.Models.BannerModel;
import com.example.ApiMegaTech.Services.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/banners") /** NO SE SI ES CON MAYÚSCULA O CON MINÚSCULA **/
public class BannerController {

    @Autowired
    BannerService bannerService;

    @GetMapping
    public List<BannerModel> getAllBanners(){
        return bannerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<BannerModel> getBannerById(@PathVariable String id){
        return bannerService.findById(id);
    }

    @PostMapping
    public ResponseEntity<BannerModel> createBanner(@RequestBody BannerModel bannerModel) {
        BannerModel createdBanner = bannerService.save(bannerModel);
        return new ResponseEntity<>(createdBanner, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BannerDTO> updateBanner(@PathVariable String id, @RequestBody BannerDTO bannerDTO){
        try{
            bannerService.updateBanner(id, bannerDTO);
            return new ResponseEntity<>(bannerDTO, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(bannerDTO, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBanner(@PathVariable String id) {
        try {
            bannerService.deleteBannerById(id);
            return new ResponseEntity<>("Banner deleted successfully", HttpStatus.NO_CONTENT);
        } catch (Exception e) { // Puedes crear una excepción BannerNotFoundException
            return new ResponseEntity<>("Banner not found", HttpStatus.NOT_FOUND);
        }
    }
}
