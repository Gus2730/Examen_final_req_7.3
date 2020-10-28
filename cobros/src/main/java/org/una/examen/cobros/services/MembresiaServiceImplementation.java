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
import org.una.examen.cobros.dtos.MembresiaDTO;
import org.una.examen.cobros.entities.Membresia;
import org.una.examen.cobros.repositories.IMembresiaRepository;
import org.una.examen.cobros.utils.ConversionLista;
import org.una.examen.cobros.utils.MapperUtils;

/**
 *
 * @author cfugu
 */
@Service
public class MembresiaServiceImplementation implements IMembresiaService {
    
    @Autowired
    private IMembresiaRepository IMembresiaRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<MembresiaDTO>> findAll() {
        return (Optional<List<MembresiaDTO>>) ConversionLista.findList((IMembresiaRepository.findAll()), MembresiaDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<MembresiaDTO> findById(Long id) {
        return (Optional<MembresiaDTO>) ConversionLista.oneToDto(IMembresiaRepository.findById(id), MembresiaDTO.class);
    }
    
    @Override
    @Transactional
    public MembresiaDTO create(MembresiaDTO membresia) {
        Membresia membr = MapperUtils.EntityFromDto(membresia, Membresia.class);
        membr = IMembresiaRepository.save(membr);
        return MapperUtils.DtoFromEntity(membr, MembresiaDTO.class);
    }
    
    @Override
    @Transactional
    public Optional<MembresiaDTO> update(MembresiaDTO membresia, Long id) {
        if (IMembresiaRepository.findById(id).isPresent()) {
            Membresia membr = MapperUtils.EntityFromDto(membresia, Membresia.class);
            membr = IMembresiaRepository.save(membr);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(membr, MembresiaDTO.class));
        } else {
            return null;
        }
    }

    @Override
    public Optional<List<MembresiaDTO>> findByCliente(Long id) {
       return (Optional<List<MembresiaDTO>>) ConversionLista.findList((IMembresiaRepository.findByCliente(id)), MembresiaDTO.class);
    }
    
    
}
