/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author cfugu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cobro_pendiente {
    private Long id;
    
    private String tipo;

    private String periodo;
    
    private String ano;
    
    private Double monto;
    
    private ClienteDTO clientesId;

    private Date fechaVencimiento;


    
}
