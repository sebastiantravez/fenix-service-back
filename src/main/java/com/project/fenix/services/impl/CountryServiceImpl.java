package com.project.fenix.services.impl;

import com.project.fenix.dto.company.CityDto;
import com.project.fenix.dto.company.CountryDto;
import com.project.fenix.dto.company.ProvinceDto;
import com.project.fenix.entities.company.City;
import com.project.fenix.entities.company.Country;
import com.project.fenix.entities.company.Province;
import com.project.fenix.repository.CityRepository;
import com.project.fenix.repository.CountryRepository;
import com.project.fenix.repository.ProvinceRepository;
import com.project.fenix.services.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CountryDto> getAllCountries() {
        return countryRepository.findAll().stream().map(this::modelCountryDto).toList();
    }

    public CountryDto modelCountryDto(Country country) {
        return modelMapper.map(country, CountryDto.class);
    }

    @Override
    public List<ProvinceDto> getAllProvinces() {
        return provinceRepository.findAll().stream().map(this::modelProvinceDto).toList();
    }

    public ProvinceDto modelProvinceDto(Province province) {
        return modelMapper.map(province, ProvinceDto.class);
    }

    @Override
    public List<CityDto> getAllCities() {
        return cityRepository.findAll().stream().map(this::modelCityDto).toList();
    }

    public CityDto modelCityDto(City city) {
        return modelMapper.map(city, CityDto.class);
    }
}
