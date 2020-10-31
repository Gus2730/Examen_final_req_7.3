/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.examen.cobros.entities.Cliente;

/**
 *
 * @author cfugu
 */
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
    @Query(value = "SELECT t FROM Cliente t  where t.identificacion=:id")
    public Optional<Cliente> findByIdentificacion(@Param("id") String id);

}
