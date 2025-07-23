package com.salah.gestiondestock.Services;

import com.salah.gestiondestock.Dtos.ClientDto;
import com.salah.gestiondestock.Exceptions.EntityNotFoundException;

import java.util.List;

public interface ClientService {

    
    ClientDto save(ClientDto dto);

    ClientDto findById(Integer id);

    List<ClientDto> findAll();

    void delete(Integer id);

}
