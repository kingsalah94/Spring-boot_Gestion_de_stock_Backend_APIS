package com.salah.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Authorizations")
public class Authorization extends  AbstractEntity{

    @Column(name = "authorizationname")
    private String authorizationName;
    @ManyToOne
    @JoinColumn(name = "idauthorization")
    private Roles roles;
}
