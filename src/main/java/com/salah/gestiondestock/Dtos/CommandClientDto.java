package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

import com.salah.gestiondestock.Enums.EtatCommande;

@Data
public class CommandClientDto {


    private Integer id;
    private String code;

    private Instant dateCommande;

    private EtatCommande etatCommande;

    private ClientDto clientDto;

    private Integer idEntreprise;

    private List<LigneCommandeClientDto> ligneCommandeClientDtos;
}
