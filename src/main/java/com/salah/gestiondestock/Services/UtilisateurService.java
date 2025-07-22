/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.salah.gestiondestock.Services;

import java.util.List;
import com.salah.gestiondestock.Dtos.UtilisateurDto;
import com.salah.gestiondestock.Dtos.ChangerMotDePasseUtilisateurDto;

/**
 *
 * @author bahac
 */
public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Integer id);

    List<UtilisateurDto> findAll();

    void delete(Integer id);

    UtilisateurDto findByEmail(String email);

    UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);

}
