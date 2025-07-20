package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class CommandClientDto {


    private Integer id;
    private String code;

    private Instant dateCommande;

    private ClientDto clientDto;

    private List<LigneCommandeClientDto> ligneCommandeClientDtos;
}
