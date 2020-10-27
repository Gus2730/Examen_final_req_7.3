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
import org.una.examen.cobros.dtos.MembresiaDTO;
import org.una.examen.cobros.repositories.IMembresiaRepository;
import org.una.examen.cobros.services.IClienteService;
import org.una.examen.cobros.services.IMembresiaService;

/**
 *
 * @author cfugu
 */
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/membresias")
public class MembresiaController {
    @Autowired
    private IMembresiaService IMembresiaService;

    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(IMembresiaService.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity(IMembresiaService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody MembresiaDTO MembresiaDTO) {

        try {
            return new ResponseEntity(IMembresiaService.create(MembresiaDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody MembresiaDTO MembresiaDTO) {
        try {
            Optional<MembresiaDTO> membresiaUpdated = IMembresiaService.update(MembresiaDTO, id);
            if (membresiaUpdated.isPresent()) {
                return new ResponseEntity(membresiaUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
