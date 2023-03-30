package com.project.fenix.entities.company;

import com.project.fenix.entities.BaseModel;
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
@Table(name = "subsidiary")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Subsidiary extends BaseModel {
    private String name;
    private String address;
    private String emissionPoint;
    private String establishmentPoint;
    private String phone;
    @Enumerated(EnumType.STRING)
    private EnumTypeCenter typeCenter;
    private String description;
    @OneToOne
    @JoinColumn(name = "province_id")
    private Province province;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
