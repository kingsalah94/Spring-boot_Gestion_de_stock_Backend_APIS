/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author bahac
 */
@Data
@Builder
public class ChangerMotDePasseUtilisateurDto {

        private Integer id;

        private String motDePasse;

        private String confirmMotDePasse;

}
