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
import org.una.examen.cobros.dtos.CobroDTO;
import org.una.examen.cobros.entities.Cobro;
import org.una.examen.cobros.utils.ConversionLista;
import org.una.examen.cobros.utils.MapperUtils;
import org.una.examen.cobros.repositories.ICobroRepository;

/**
 *
 * @author cfugu
 */
@Service
public class CobroServiceImplementation implements ICobroService {

    @Autowired
    private ICobroRepository ICobroPendienteRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroDTO>> findAll() {
        return (Optional<List<CobroDTO>>) ConversionLista.findList((ICobroPendienteRepository.findAll()), CobroDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CobroDTO> findById(Long id) {
        return (Optional<CobroDTO>) ConversionLista.oneToDto(ICobroPendienteRepository.findById(id), CobroDTO.class);
    }

    @Override
    @Transactional
    public CobroDTO create(CobroDTO cobro) {
        Cobro cobr = MapperUtils.EntityFromDto(cobro, Cobro.class);
        cobr = ICobroPendienteRepository.save(cobr);
        return MapperUtils.DtoFromEntity(cobr, CobroDTO.class);
    }

    @Override
    @Transactional
    public Optional<CobroDTO> update(CobroDTO cobro, Long id) {
        if (ICobroPendienteRepository.findById(id).isPresent()) {
            Cobro cobr = MapperUtils.EntityFromDto(cobro, Cobro.class);
            cobr = ICobroPendienteRepository.save(cobr);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(cobr, CobroDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroDTO>> findByIdCliente(Long id) {
        return (Optional<List<CobroDTO>>) ConversionLista.findList((ICobroPendienteRepository.findByIdCliente(id)), CobroDTO.class);
    }

    @Override
    public Optional<List<CobroDTO>> findByIdIdentificacion(String identificacion) {
        return (Optional<List<CobroDTO>>) ConversionLista.findList((ICobroPendienteRepository.findByIdIdentificacion(identificacion)), CobroDTO.class);
    }

}
