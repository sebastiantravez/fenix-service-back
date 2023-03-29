package com.project.fenix.dto.permission;

import com.project.fenix.dto.BaseModelDto;
import com.project.fenix.enums.EnumStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PermissionDto extends BaseModelDto {
    private String name;
    private EnumStatus status;
}
