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
@RequestMapping("/api/banners") /** NO SE SI ES CON MAYÚSCULA O SIN MINÚSCULA **/
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
    public ResponseEntity<String> createBanner(@RequestBody BannerModel bannerModel){
        boolean ok = bannerService.register(bannerModel);
        if (ok){
            return new ResponseEntity<>("Se ha insertado correctamente", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha insertado correctamente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BannerDTO> updateBanner(@PathVariable String id, @RequestBody BannerDTO bannerDTO){
        try{
            bannerService.updateItem(id, bannerDTO);
            return new ResponseEntity<>(bannerDTO, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(bannerDTO, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBanner(@PathVariable String id){
        if (id == null || id.isEmpty()) {
            return new ResponseEntity<>("Nombre del Banner no proporcionado", HttpStatus.BAD_REQUEST);
        }

        boolean ok = bannerService.deleteBannerById(id);

        if(ok){
            return new ResponseEntity<>(id, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
        }
    }


}
