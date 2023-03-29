package com.project.fenix.dto.rol;


import com.project.fenix.dto.BaseModelDto;
import com.project.fenix.dto.permission.PermissionDto;
import com.project.fenix.enums.EnumRol;
import com.project.fenix.enums.EnumStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class RolDto extends BaseModelDto {
    private EnumRol name;
    private Set<PermissionDto> permissions;

    public RolDto() {
    }

    @Builder
    public RolDto(Long id, Long version, LocalDateTime createdAt, LocalDateTime updatedAt, EnumStatus status, EnumRol name, Set<PermissionDto> permissions) {
        super(id, version, createdAt, updatedAt, status);
        this.name = name;
        this.permissions = permissions;
    }
}
