package com.project.fenix.services.impl;

import com.project.fenix.dto.company.CityDto;
import com.project.fenix.dto.company.CountryDto;
import com.project.fenix.dto.company.ProvinceDto;
import com.project.fenix.entities.company.City;
import com.project.fenix.entities.company.Country;
import com.project.fenix.entities.company.Province;
import com.project.fenix.exceptions.GenericException;
import com.project.fenix.repository.CityRepository;
import com.project.fenix.repository.CountryRepository;
import com.project.fenix.repository.ProvinceRepository;
import com.project.fenix.services.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @Override
    public ProvinceDto saveProvince(ProvinceDto provinceDto) {
        Optional<Province> provincefilter = provinceRepository.findByName(provinceDto.getName());
        if (provincefilter.isPresent()) {
            throw new GenericException("Error: Provincia con nombre: " + provinceDto.getName() + " ya existe");
        }
        Province province = modelMapper.map(provinceDto, Province.class);
        province.setCreatedAt(LocalDateTime.now());
        province.setUpdatedAt(LocalDateTime.now());
        province.getCities().forEach(city -> {
            city.setProvince(province);
            city.setCreatedAt(LocalDateTime.now());
            city.setUpdatedAt(LocalDateTime.now());
        });
        provinceRepository.save(province);
        return provinceDto;
    }

    @Override
    public CityDto saveCity(CityDto cityDto) {
        Optional<City> cityfilter = cityRepository.findByNameAndProvinceId(cityDto.getName(), cityDto.getProvince().getId());
        if (cityfilter.isPresent()) {
            throw new GenericException("Error: Ciudad con nombre: " + cityDto.getName() + " en la provincia de " + cityfilter.get().getProvince().getName() + " ya existe");
        }
        Province province = provinceRepository.findById(cityDto.getProvince().getId())
                .orElseThrow(() -> new GenericException("Error: Provincia no existe, no se puede guardar la ciudad"));

        City city = modelMapper.map(cityDto, City.class);
        city.setProvince(province);
        city.setCreatedAt(LocalDateTime.now());
        city.setUpdatedAt(LocalDateTime.now());
        cityRepository.save(city);
        return cityDto;
    }

    @Override
    public ProvinceDto updateProvince(Long provinceId, ProvinceDto provinceDto) {
        Province province = provinceRepository.findById(provinceId).orElseThrow(() -> new GenericException("Error: No existe la provincia, no se puede actualizar"));
        province.setName(provinceDto.getName());
        provinceRepository.save(province);
        return provinceDto;
    }

    @Override
    public CityDto updateCity(Long cityId, CityDto cityDto) {
        City city = cityRepository.findById(cityId).orElseThrow(() -> new GenericException("Error: No existe la ciudad, no se puede actualizar"));
        city.setName(cityDto.getName());
        return cityDto;
    }

    @Override
    public void deleteProvince(Long provinceId) {
        provinceRepository.findById(provinceId).orElseThrow(() -> new GenericException("Error: No existe la provincia, no se puede eliminar"));
        provinceRepository.deleteById(provinceId);
    }

    @Override
    public void deleteCity(Long cityId) {
        cityRepository.findById(cityId).orElseThrow(() -> new GenericException("Error: No existe la ciudad, no se puede eliminar"));
        cityRepository.deleteById(cityId);
    }

    public CityDto modelCityDto(City city) {
        return modelMapper.map(city, CityDto.class);
    }
}
