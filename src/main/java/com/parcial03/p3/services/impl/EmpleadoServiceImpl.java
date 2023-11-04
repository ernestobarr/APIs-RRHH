package com.parcial03.p3.services.impl;

import com.parcial03.p3.models.Empleado;
import com.parcial03.p3.repos.IEmpleadoRepo;
import com.parcial03.p3.repos.IGenericRepo;
import com.parcial03.p3.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl extends CRUDImpl<Empleado, Integer> implements IEmpleadoService {
    @Autowired
    private IEmpleadoRepo repo;

    @Override
    protected IGenericRepo<Empleado,Integer> getRepo(){return repo;}
}