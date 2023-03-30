package com.project.fenix.controller;

import com.project.fenix.dto.company.CityDto;
import com.project.fenix.dto.company.CountryDto;
import com.project.fenix.dto.company.ProvinceDto;
import com.project.fenix.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/getCountries")
    public List<CountryDto> getCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/getProvinces")
    public List<ProvinceDto> getProvinces() {
        return countryService.getAllProvinces();
    }

    @GetMapping("/getCities")
    public List<CityDto> getCities() {
        return countryService.getAllCities();
    }

    @PostMapping("/saveProvince")
    public ProvinceDto saveProvince(@RequestBody ProvinceDto provinceDto) {
        return countryService.saveProvince(provinceDto);
    }

    @PostMapping("/saveCity")
    public CityDto saveCity(@RequestBody CityDto cityDto) {
        return countryService.saveCity(cityDto);
    }

    @PutMapping("/updateProvince/{provinceId}")
    public ProvinceDto updateProvince(@PathVariable Long provinceId, @RequestBody ProvinceDto provinceDto) {
        return countryService.updateProvince(provinceId, provinceDto);
    }

    @PutMapping("/updateCity/{cityId}")
    public CityDto updateCity(@PathVariable Long cityId, @RequestBody CityDto cityDto) {
        return countryService.updateCity(cityId, cityDto);
    }

    @DeleteMapping("/deleteProvince/{provinceId}")
    public void deleteProvinceId(@PathVariable Long provinceId) {
        countryService.deleteProvince(provinceId);
    }

    @DeleteMapping("/deleteCity/{cityId}")
    public void deleteCityId(@PathVariable Long cityId) {
        countryService.deleteCity(cityId);
    }
}
