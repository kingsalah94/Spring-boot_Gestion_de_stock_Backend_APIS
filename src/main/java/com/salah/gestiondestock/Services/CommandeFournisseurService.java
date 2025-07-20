package com.salah.gestiondestock.Services;

import com.salah.gestiondestock.Dtos.CommandFournisseurDto;

import java.util.List;

public interface CommandeFournisseurService {
    CommandFournisseurDto save(CommandFournisseurDto dto);

    CommandFournisseurDto findById(Integer id);

    CommandFournisseurDto findByCode(String code);

    List<CommandFournisseurDto> findAll();

    void delete(Integer id);
}
