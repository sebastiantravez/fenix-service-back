package com.project.fenix.entities.company;

import com.project.fenix.entities.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "country")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Country extends BaseModel {
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "country")
    @Builder.Default
    private List<Province> provinces = new ArrayList<>();
}
