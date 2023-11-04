package com.parcial03.p3.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MunicipioDTO {
    @EqualsAndHashCode.Include
    private Integer id;
    @NotNull
    private String nombre;
    @NotNull
    private DepartamentoDTO departamento;
}