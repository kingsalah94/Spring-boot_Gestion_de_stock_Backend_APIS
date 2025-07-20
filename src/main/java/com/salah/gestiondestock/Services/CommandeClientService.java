package com.salah.gestiondestock.Services;

import com.salah.gestiondestock.Dtos.CommandClientDto;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CommandeClientService {
    CommandClientDto save(CommandClientDto dto);

    CommandClientDto findById(Integer id);

    List<CommandClientDto> findAll();

    void delete(Integer id);
}
