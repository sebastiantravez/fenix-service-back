package com.project.fenix.entities.company;

import com.project.fenix.entities.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class City extends BaseModel {
    private String name;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
}
