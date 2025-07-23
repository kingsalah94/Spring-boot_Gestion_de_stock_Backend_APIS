package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

import com.salah.gestiondestock.Enums.EtatCommande;
import com.salah.gestiondestock.model.CommandClient;

@Data
@Builder
public class CommandClientDto {


    private Integer id;
    private String code;

    private Instant dateCommande;

    private EtatCommande etatCommande;

    private ClientDto clientDto;

    private Integer idEntreprise;

    private List<LigneCommandeClientDto> ligneCommandeClientDtos;


     public static CommandClientDto fromEntity(CommandClient commandeClient) {
    if (commandeClient == null) {
      return null;
    }
    return CommandClientDto.builder()
        .id(commandeClient.getId())
        .code(commandeClient.getCode())
        .dateCommande(commandeClient.getDateCommande())
        .etatCommande(commandeClient.getEtatCommande())
        .clientDto(ClientDto.fromEntity(commandeClient.getClient()))
        .idEntreprise(commandeClient.getIdEntreprise())
        .build();

  }

  public static CommandClient toEntity(CommandClientDto dto) {
    if (dto == null) {
      return null;
    }
    CommandClient commandeClient = new CommandClient();
    commandeClient.setId(dto.getId());
    commandeClient.setCode(dto.getCode());
    commandeClient.setClient(ClientDto.toEntity(dto.getClientDto()));
    commandeClient.setDateCommande(dto.getDateCommande());
    commandeClient.setEtatCommande(dto.getEtatCommande());
    commandeClient.setIdEntreprise(dto.getIdEntreprise());
    return commandeClient;
  }
    public boolean isCommandeLivree(){
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }
}
