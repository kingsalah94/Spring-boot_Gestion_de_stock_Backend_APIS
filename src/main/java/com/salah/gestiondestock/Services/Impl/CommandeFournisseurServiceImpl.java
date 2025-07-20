package com.salah.gestiondestock.Services.Impl;

import com.salah.gestiondestock.DtoMappers.CommandFournisseurMapper;
import com.salah.gestiondestock.Dtos.CommandFournisseurDto;
import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
import com.salah.gestiondestock.Repositories.CommandFournisseurRepository;
import com.salah.gestiondestock.Services.CommandeFournisseurService;
import com.salah.gestiondestock.model.CommandFournisseur;

import java.util.List;
import java.util.stream.Collectors;

public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    private final CommandFournisseurRepository commandFournisseurRepository;
    private final CommandFournisseurMapper commandFournisseurMapper;

    public CommandeFournisseurServiceImpl(CommandFournisseurRepository commandFournisseurRepository, CommandFournisseurMapper commandFournisseurMapper) {
        this.commandFournisseurRepository = commandFournisseurRepository;
        this.commandFournisseurMapper = commandFournisseurMapper;
    }

    @Override
    public CommandFournisseurDto save(CommandFournisseurDto dto) {
        CommandFournisseur entity = CommandFournisseurMapper.INSTANCE.toEntity(dto);
        return CommandFournisseurMapper.INSTANCE.toDto(
                commandFournisseurRepository.save(entity)
        );
    }

    @Override
    public CommandFournisseurDto findById(Integer id) {
        return commandFournisseurRepository.findById(id)
                .map(CommandFournisseurMapper.INSTANCE::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Commande fournisseur non trouvée avec ID = " + id));
    }

    @Override
    public CommandFournisseurDto findByCode(String code) {
        return commandFournisseurRepository.findByCode(code)
                .map(CommandFournisseurMapper.INSTANCE::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Commande fournisseur non trouvée avec le code = " + code));
    }

    @Override
    public List<CommandFournisseurDto> findAll() {
        return commandFournisseurRepository.findAll().stream()
                .map(CommandFournisseurMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        commandFournisseurRepository.deleteById(id);
    }
}
