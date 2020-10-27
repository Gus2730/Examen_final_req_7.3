/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.services;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author cfugu
 */
public interface IMembresiaService {

    public Optional<List<MembresiaDTO>> findAll();

    public Optional<MembresiaDTO> findById(Long id);

    public MembresiaDTO create(MembresiaDTO membresia);

    public Optional<MembresiaDTO> update(MembresiaDTO membresia, Long id);

}
