package com.project.fenix.dto.company;

import com.project.fenix.dto.BaseModelDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class ProvinceDto extends BaseModelDto {
    private String name;
    private CountryDto country;
    private Set<CityDto> cities;
}
