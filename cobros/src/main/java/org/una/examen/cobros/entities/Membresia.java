/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author cfugu
 */
@Entity
@Table(name = "exa_gvq_membresias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Membresia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double monto;

    @Column(name = "descripcion", length = 50)
    private String descripcion;

    @Column(length = 20)
    private String periodicidad;
      
    @ManyToOne
    @JoinColumn(name = "exa_gvq_clientes_id")
    private Cliente clientesId;

    private static final long serialVersionUID = 1L;
}
