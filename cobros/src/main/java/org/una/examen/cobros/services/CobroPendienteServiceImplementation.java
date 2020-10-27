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
import org.una.examen.cobros.dtos.CobroPendienteDTO;
import org.una.examen.cobros.entities.CobroPendiente;
import org.una.examen.cobros.repositories.ICobroPendienteRepository;
import org.una.examen.cobros.utils.ConversionLista;
import org.una.examen.cobros.utils.MapperUtils;

/**
 *
 * @author cfugu
 */
@Service
public class CobroPendienteServiceImplementation implements ICobroPendienteService {

    @Autowired
    private ICobroPendienteRepository ICobroPendienteRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroPendienteDTO>> findAll() {
        return (Optional<List<CobroPendienteDTO>>) ConversionLista.findList((ICobroPendienteRepository.findAll()), CobroPendienteDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CobroPendienteDTO> findById(Long id) {
        return (Optional<CobroPendienteDTO>) ConversionLista.oneToDto(ICobroPendienteRepository.findById(id), CobroPendienteDTO.class);
    }

    @Override
    @Transactional
    public CobroPendienteDTO create(CobroPendienteDTO cobro) {
        CobroPendiente cobr = MapperUtils.EntityFromDto(cobro, CobroPendiente.class);
        cobr = ICobroPendienteRepository.save(cobr);
        return MapperUtils.DtoFromEntity(cobr, CobroPendienteDTO.class);
    }

    @Override
    @Transactional
    public Optional<CobroPendienteDTO> update(CobroPendienteDTO cobro, Long id) {
        if (ICobroPendienteRepository.findById(id).isPresent()) {
            CobroPendiente cobr = MapperUtils.EntityFromDto(cobro, CobroPendiente.class);
            cobr = ICobroPendienteRepository.save(cobr);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(cobr, CobroPendienteDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroPendienteDTO>> findByIdCliente(Long id) {
        return (Optional<List<CobroPendienteDTO>>) ConversionLista.findList((ICobroPendienteRepository.findByIdCliente(id)), CobroPendienteDTO.class);
    }

    @Override
    public Optional<List<CobroPendienteDTO>> findByIdIdentificacion(String identificacion) {
        return (Optional<List<CobroPendienteDTO>>) ConversionLista.findList((ICobroPendienteRepository.findByIdIdentificacion(identificacion)), CobroPendienteDTO.class);
    }

}
