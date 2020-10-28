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
import org.una.examen.cobros.entities.Cobro;

/**
 *
 * @author cfugu
 */
public interface ICobroRepository extends JpaRepository<Cobro, Long> {

    @Query(value = "SELECT t FROM Cobro t JOIN t.clientesId po where po.id=:id")
    public List<Cobro> findByIdCliente(@Param("id") Long id);
    
    @Query(value = "SELECT t FROM Cobro t JOIN t.clientesId po where po.identificacion=:identificacion")
    public List<Cobro> findByIdIdentificacion(@Param("identificacion") String identificacion);
}
