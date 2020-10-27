/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.services;

import java.util.List;
import java.util.Optional;
import org.una.examen.cobros.dtos.CobroPendienteDTO;

/**
 *
 * @author cfugu
 */
public interface ICobroPendienteService {

    public Optional<List<CobroPendienteDTO>> findAll();

    public Optional<CobroPendienteDTO> findById(Long id);

    public CobroPendienteDTO create(CobroPendienteDTO cobro);

    public Optional<CobroPendienteDTO> update(CobroPendienteDTO cobro, Long id);
    
    public Optional<List<CobroPendienteDTO>> findByIdCliente(Long id);
    
    public Optional<List<CobroPendienteDTO>> findByIdIdentificacion(String identificacion);
    
}
