package com.salah.gestiondestock.Services;

import com.salah.gestiondestock.Dtos.CommandClientDto;

import java.util.List;

public interface CommandeClientService {
    CommandClientDto save(CommandClientDto dto);

    CommandClientDto findById(Integer id);

    List<CommandClientDto> findAll();

    void delete(Integer id);
}
