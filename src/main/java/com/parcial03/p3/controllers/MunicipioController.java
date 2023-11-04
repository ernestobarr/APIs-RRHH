package com.parcial03.p3.controllers;

import com.parcial03.p3.dto.MunicipioDTO;
import com.parcial03.p3.models.Municipio;
import com.parcial03.p3.services.IMunicipioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/municipio")
public class MunicipioController {
    @Autowired
    private IMunicipioService service;
    @Autowired
    private ModelMapper mapper;
    @GetMapping
    public ResponseEntity<List<MunicipioDTO>> findAll() {
        List<MunicipioDTO> list = service.findAll().stream().map(p -> mapper.map(p, MunicipioDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MunicipioDTO> findById(@PathVariable("id") Integer id) {
        MunicipioDTO dtoResponse = new MunicipioDTO();
        Municipio obj = service.findById(id);
        if (obj == null) {
        } else {
            dtoResponse = mapper.map(obj, MunicipioDTO.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody MunicipioDTO dto) {
        Municipio p = service.save(mapper.map(dto, Municipio.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Municipio> update(@RequestBody MunicipioDTO dto) {
        Municipio obj = service.findById(dto.getId());
        if (obj == null) {
        }

        return new ResponseEntity<>(service.update(mapper.map(dto, Municipio.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        Municipio obj = service.findById(id);
        if (obj == null) {
        } else {
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}