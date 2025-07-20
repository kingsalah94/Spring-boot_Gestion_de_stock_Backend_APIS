package com.salah.gestiondestock.Services.Impl;

import com.salah.gestiondestock.DtoMappers.CommandClientMapper;
import com.salah.gestiondestock.Dtos.CommandClientDto;
import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
import com.salah.gestiondestock.Repositories.CommandClientRepository;
import com.salah.gestiondestock.Services.CommandeClientService;
import com.salah.gestiondestock.model.CommandClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommandeClientServiceImpl implements CommandeClientService {

    private final CommandClientRepository commandClientRepository;
    private final CommandClientMapper commandeClientMapper;

    public CommandeClientServiceImpl(CommandClientRepository commandClientRepository,
                                     CommandClientMapper commandeClientMapper) {
        this.commandClientRepository = commandClientRepository;
        this.commandeClientMapper = commandeClientMapper;
    }

    @Override
    public CommandClientDto save(CommandClientDto dto) {
        CommandClient entity = commandeClientMapper.toEntity(dto);
        return commandeClientMapper.toDto(commandClientRepository.save(entity));
    }

    @Override
    public CommandClientDto findById(Integer id) {
        Optional<CommandClient> entity = commandClientRepository.findById(id);
        return entity
                .map(commandeClientMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Commande client introuvable avec ID: " + id));
    }

    @Override
    public List<CommandClientDto> findAll() {
        return commandClientRepository.findAll()
                .stream()
                .map(commandeClientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        commandClientRepository.deleteById(id);
    }
}
