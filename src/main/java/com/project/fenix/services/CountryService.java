package com.project.fenix.services;

import com.project.fenix.dto.company.CityDto;
import com.project.fenix.dto.company.CountryDto;
import com.project.fenix.dto.company.ProvinceDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> getAllCountries();

    List<ProvinceDto> getAllProvinces();

    List<CityDto> getAllCities();

    ProvinceDto saveProvince(ProvinceDto provinceDto);

    CityDto saveCity(CityDto cityDto);

    ProvinceDto updateProvince(Long provinceId, ProvinceDto provinceDto);

    CityDto updateCity(Long cityId, CityDto cityDto);

    void deleteProvince(Long provinceId);

    void deleteCity(Long cityId);
}
