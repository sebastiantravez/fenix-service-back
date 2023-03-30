package com.project.fenix.entities.company;

import com.project.fenix.entities.user.BaseModel;
import com.project.fenix.enums.EnumTypeCenter;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Company extends BaseModel {
    private String name;
    private String ruc;
    private String address;
    private String phone;
    @Enumerated(EnumType.STRING)
    private EnumTypeCenter typeCenter;
    private String description;
    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
