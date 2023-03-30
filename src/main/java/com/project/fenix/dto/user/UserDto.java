package com.project.fenix.dto.user;

import com.project.fenix.dto.BaseModelDto;
import com.project.fenix.dto.rol.RolDto;
import com.project.fenix.enums.EnumStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDto extends BaseModelDto {
    private String username;
    private String password;
    private String email;
    private String avatar;
    private Boolean changePassword;
    private Set<RolDto> roles;

    public UserDto() {
    }

    @Builder
    public UserDto(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, EnumStatus status, String username, String password, String email, String avatar, Boolean changePassword, Set<RolDto> roles) {
        super(id, createdAt, updatedAt, status);
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.changePassword = changePassword;
        this.roles = roles;
    }
}
