package com.project.fenix.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.fenix.enums.EnumStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.project.fenix.security.TokenUtils.USERLOGGER;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseModelDto {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
    private EnumStatus status = EnumStatus.ACT;
    private String userCreated = USERLOGGER;
}
