package com.project.fenix.dto.company;

import com.project.fenix.dto.BaseModelDto;
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
public class CityDto extends BaseModelDto {
    private Long id;
    private String name;
}
