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
import org.una.examen.cobros.entities.Membresia;

/**
 *
 * @author cfugu
 */
public interface IMembresiaRepository extends JpaRepository<Membresia, Long> {

    @Query(value = "SELECT t FROM Membresia t  where t.clientesId=:id")
    public List<Membresia> findByCliente(@Param("id") Long id);
}
