package com.salah.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Roles")
public class Roles extends AbstractEntity{

    @Column(name = "role_name")
    private String roleName;
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "roles")
    private List<Authorization> authorities;
}
