package com.salah.gestiondestock.Services.Impl;

import com.salah.gestiondestock.DtoMappers.ClientMapper;
import com.salah.gestiondestock.Dtos.ClientDto;
import com.salah.gestiondestock.Enums.ErrorCodes;
import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
import com.salah.gestiondestock.Exceptions.InvalideEntityException;
import com.salah.gestiondestock.Repositories.ClientRepository;
import com.salah.gestiondestock.Services.ClientService;
import com.salah.gestiondestock.Validators.ClientValidator;
import com.salah.gestiondestock.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        Client client = clientMapper.toEntity(dto);
        return clientMapper.toDto(clientRepository.save(client));
    }

    @Override
    public ClientDto findById(Integer id) {
        Optional<Client> clientOpt = clientRepository.findById(id);
        return clientOpt
                .map(clientMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Aucun client trouvé avec l'ID " + id));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }

//
}
