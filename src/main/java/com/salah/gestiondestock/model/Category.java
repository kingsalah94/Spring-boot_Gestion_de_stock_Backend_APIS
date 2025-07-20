package com.salah.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Categories")
public class Category extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "designation")
    private String designation;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "category")
    private List<Articles> articles;
}
