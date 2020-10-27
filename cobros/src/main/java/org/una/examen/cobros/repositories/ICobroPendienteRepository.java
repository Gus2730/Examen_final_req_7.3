/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.examen.cobros.entities.CobroPendiente;

/**
 *
 * @author cfugu
 */
public interface ICobroPendienteRepository extends JpaRepository<CobroPendiente, Long> {

    @Query(value = "SELECT t FROM CobroPendiente t JOIN t.clientesId po where po.id=:id")
    public List<CobroPendiente> findByIdCliente(@Param("id") Long id);
    
    @Query(value = "SELECT t FROM CobroPendiente t JOIN t.clientesId po where po.identificacion=:identificacion")
    public List<CobroPendiente> findByIdIdentificacion(@Param("identificacion") String identificacion);
}
