package com.parcial03.p3.models;

import lombok.*;

import javax.persistence.*;
//Modelo de Empleado
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true, length = 6)
    private String codigo;

    @Column(nullable = true, length = 150)
    private String nombre;

    @Column(nullable = true, length = 150)
    private String apellido;

    @Column(nullable = true, length = 1)
    private String genero;

    @Column(nullable = true, length = 150)
    private String direccion;

    @OneToOne
    @JoinColumn(name = "id_municipio", nullable = true, foreignKey = @ForeignKey(name = "FK_MUNI_EMPLE"))
    private Municipio municipio;

    @Column(nullable = true, length = 8)
    private  String telefono;

    @Column(nullable = true, length = 1)
    private  String estado;

    @Column(nullable = true)
    private Float salario;

    @Column(nullable = true, length = 150)
    private  String motivo;
}