package com.project.fenix.dto.company;

import com.project.fenix.dto.BaseModelDto;
import com.project.fenix.enums.EnumTypeCenter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class SubsidiaryDto extends BaseModelDto {
    private String name;
    private String address;
    private String emissionPoint;
    private String establishmentPoint;
    private String phone;
    private EnumTypeCenter typeCenter;
    private String description;
    private CompanyDto company;
    private ProvinceDto province;
}
