/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.examen.cobros.dtos.CobroPendienteDTO;
import org.una.examen.cobros.services.IClienteService;
import org.una.examen.cobros.services.ICobroPendienteService;

/**
 *
 * @author cfugu
 */
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/cobros_pendientes")
public class CobroPendienteController {

    @Autowired
    private ICobroPendienteService ICobroPendienteService;

    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(ICobroPendienteService.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cliente/{id}")
    public @ResponseBody
    ResponseEntity<?> findByIdCliente(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity<>(ICobroPendienteService.findByIdCliente(id), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/identificacion/{cedula}")
    public @ResponseBody
    ResponseEntity<?> findByIdIdentificacion(@PathVariable(value = "cedula") String identificacion) {
        try {
            return new ResponseEntity<>(ICobroPendienteService.findByIdIdentificacion(identificacion), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity(ICobroPendienteService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody CobroPendienteDTO CobroPendienteDTO) {

        try {
            return new ResponseEntity(ICobroPendienteService.create(CobroPendienteDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CobroPendienteDTO CobroPendienteDTO) {
        try {
            Optional<CobroPendienteDTO> clienteUpdated = ICobroPendienteService.update(CobroPendienteDTO, id);
            if (clienteUpdated.isPresent()) {
                return new ResponseEntity(clienteUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
