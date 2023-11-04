package com.parcial03.p3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmpleadoDTO {
    @EqualsAndHashCode.Include
    private Integer id;
    @Nullable
    private String codigo;
    @Nullable
    private String nombre;
    @Nullable
    private String apellido;
    @Nullable
    private String genero;
    @Nullable
    private String direccion;
    @Nullable
    private MunicipioDTO municipio;
    @Nullable
    private String telefono;
    @Nullable
    private String estado;
    @Nullable
    private String motivo;
    @Nullable
    private Float salario;
}
