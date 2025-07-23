package com.salah.gestiondestock.Services;

import com.salah.gestiondestock.Dtos.CommandClientDto;
import com.salah.gestiondestock.Dtos.LigneCommandeClientDto;
import com.salah.gestiondestock.Enums.EtatCommande;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CommandeClientService {


    CommandClientDto save(CommandClientDto dto);

    CommandClientDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande);

    CommandClientDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite);

    CommandClientDto updateClient(Integer idCommande, Integer idClient);

    CommandClientDto updateArticle(Integer idCommande, Integer idLigneCommande, Integer newIdArticle);


    // Delete article ==> delete LigneCommandeClient
    CommandClientDto deleteArticle(Integer idCommande, Integer idLigneCommande);

    CommandClientDto findById(Integer id);

    CommandClientDto findByCode(String code);

    List<CommandClientDto> findAll();

    List<LigneCommandeClientDto> findAllLignesCommandesClientByCommandeClientId(Integer idCommande);

    void delete(Integer id);
}
