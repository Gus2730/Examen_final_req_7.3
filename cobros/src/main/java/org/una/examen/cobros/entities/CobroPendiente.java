/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author cfugu
 */
@Entity
@Table(name = "exa_gvq_cobros_pendientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CobroPendiente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String periodo;

    @Column(name = "tipo_servicio", length = 10)
    private String tipo;

    @Column(length = 10)
    private String ano;

    @Column
    private Double monto;

    @Column(name = "fecha_vencimiento", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    private Date fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "exa_gvq_clientes_id")
    private Cliente clientesId;
    
    private static final long serialVersionUID = 1L;
}
