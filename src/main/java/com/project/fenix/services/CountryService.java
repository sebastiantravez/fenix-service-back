package com.project.fenix.services;

import com.project.fenix.dto.company.CityDto;
import com.project.fenix.dto.company.CountryDto;
import com.project.fenix.dto.company.ProvinceDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> getAllCountries();
    List<ProvinceDto> getAllProvinces();
    List<CityDto> getAllCities();
}
