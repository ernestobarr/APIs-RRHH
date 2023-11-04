package com.parcial03.p3.controllers;

import com.parcial03.p3.dto.DepartamentoDTO;
import com.parcial03.p3.models.Departamento;
import com.parcial03.p3.services.IDepartamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
    @Autowired
    private IDepartamentoService service;
    @Autowired
    private ModelMapper mapper;
    @GetMapping
    public ResponseEntity<List<DepartamentoDTO>> findAll() {
        List<DepartamentoDTO> list = service.findAll().stream().map(p -> mapper.map(p, DepartamentoDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDTO> findById(@PathVariable("id") Integer id) {
        DepartamentoDTO dtoResponse = new DepartamentoDTO();
        Departamento obj = service.findById(id);
        if (obj == null) {

        } else {
            dtoResponse = mapper.map(obj, DepartamentoDTO.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody DepartamentoDTO dto) {
        Departamento p = service.save(mapper.map(dto, Departamento.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Departamento> update(@RequestBody DepartamentoDTO dto) {
        Departamento obj = service.findById(dto.getId());
        if (obj == null) {

        }

        return new ResponseEntity<>(service.update(mapper.map(dto, Departamento.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        Departamento obj = service.findById(id);
        if (obj == null) {

        } else {
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}