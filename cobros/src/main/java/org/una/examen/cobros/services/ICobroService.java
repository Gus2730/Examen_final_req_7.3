/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.services;

import java.util.List;
import java.util.Optional;
import org.una.examen.cobros.dtos.CobroDTO;

/**
 *
 * @author cfugu
 */
public interface ICobroService {

    public Optional<List<CobroDTO>> findAll();

    public Optional<CobroDTO> findById(Long id);

    public CobroDTO create(CobroDTO cobro);

    public Optional<CobroDTO> update(CobroDTO cobro, Long id);

    public Optional<List<CobroDTO>> findByIdCliente(Long id);

    public Optional<List<CobroDTO>> findByIdIdentificacion(String identificacion);

    public Optional<List<CobroDTO>> findByIdentificacionAndServicio(String identificacion,String tipo);

}
