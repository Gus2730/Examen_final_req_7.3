/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.examen.cobros.dtos.ClienteDTO;
import org.una.examen.cobros.entities.Cliente;
import org.una.examen.cobros.repositories.IClienteRepository;
import org.una.examen.cobros.utils.ConversionLista;
import org.una.examen.cobros.utils.MapperUtils;

/**
 *
 * @author cfugu
 */
@Service
public class ClienteServiceImplementation implements IClienteService {

    @Autowired
    private IClienteRepository IClienteRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ClienteDTO>> findAll() {
        return (Optional<List<ClienteDTO>>) ConversionLista.findList((IClienteRepository.findAll()), ClienteDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteDTO> findById(Long id) {
        return (Optional<ClienteDTO>) ConversionLista.oneToDto(IClienteRepository.findById(id), ClienteDTO.class);
    }

    @Override
    @Transactional
    public ClienteDTO create(ClienteDTO cliente) {
        Cliente client = MapperUtils.EntityFromDto(cliente, Cliente.class);
        client = IClienteRepository.save(client);
        return MapperUtils.DtoFromEntity(client, ClienteDTO.class);
    }

    @Override
    @Transactional
    public Optional<ClienteDTO> update(ClienteDTO cliente, Long id) {
        if (IClienteRepository.findById(id).isPresent()) {
            Cliente client = MapperUtils.EntityFromDto(cliente, Cliente.class);
            client = IClienteRepository.save(client);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(client, ClienteDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteDTO> findByIdentificacion(String id) {
         return (Optional<ClienteDTO>) ConversionLista.oneToDto(IClienteRepository.findByIdentificacion(id), ClienteDTO.class);
    }

}
