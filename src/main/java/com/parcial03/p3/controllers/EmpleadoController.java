package com.parcial03.p3.controllers;

import com.parcial03.p3.dto.EmpleadoDTO;
import com.parcial03.p3.models.Empleado;
import com.parcial03.p3.services.IEmpleadoService;
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
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private IEmpleadoService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> findAll(){
        List<EmpleadoDTO> list = service.findAll().stream().map(e->mapper.map(e,EmpleadoDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> findOne(@PathVariable("id") Integer id){
        EmpleadoDTO empleadoDTO = null;
        Empleado empleado = service.findById(id);
        if (empleado != null){
            empleadoDTO = mapper.map(empleado, EmpleadoDTO.class);
        }
        return new ResponseEntity<>(empleadoDTO,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody EmpleadoDTO dto){
        Empleado empleado = service.save(mapper.map(dto,Empleado.class));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empleado.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Empleado> update(@RequestBody EmpleadoDTO dto){
        Empleado empleado = service.findById(dto.getId());
        if (empleado == null) {
            return new ResponseEntity<>(empleado,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.update(mapper.map(dto, Empleado.class)), HttpStatus.OK);
    }

    @PutMapping("/completar-informacion-empleado")
    public ResponseEntity<Empleado> completarInformacionEmpleado(@RequestBody EmpleadoDTO dto){
        Empleado empleado = service.findById(dto.getId());
        if (empleado == null) {
            return new ResponseEntity<>(empleado,HttpStatus.BAD_REQUEST);
        }
        empleado.setCodigo(dto.getCodigo());
        empleado.setSalario(dto.getSalario());
        return new ResponseEntity<>(service.update(mapper.map(empleado, Empleado.class)), HttpStatus.OK);
    }

    @PutMapping("/inactivar")
    public ResponseEntity<Empleado> innactivar(@RequestBody EmpleadoDTO dto){
        Empleado empleado = service.findById(dto.getId());
        if (empleado == null) {
            return new ResponseEntity<>(empleado,HttpStatus.BAD_REQUEST);
        }
        empleado.setEstado(dto.getEstado());
        empleado.setMotivo(dto.getMotivo());
        return new ResponseEntity<>(service.update(mapper.map(empleado, Empleado.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        Empleado empleado = service.findById(id);
        if (empleado!=null){
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}