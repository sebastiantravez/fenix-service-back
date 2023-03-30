package com.project.fenix.entities.company;

import com.project.fenix.entities.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "province")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Province extends BaseModel {
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "province")
    @Builder.Default
    private List<City> cities = new ArrayList<>();
}
