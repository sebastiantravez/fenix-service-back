package com.project.fenix.dto;

import com.project.fenix.enums.EnumStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseModelDto {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private EnumStatus status;
}
