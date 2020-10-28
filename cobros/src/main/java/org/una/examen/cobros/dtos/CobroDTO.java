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
public class CobroDTO {

    private Long id;

    private int periodo;

    private String anno;

    private Double monto;

    private ClienteDTO clientesId;

    private Date fechaVencimiento;

}
