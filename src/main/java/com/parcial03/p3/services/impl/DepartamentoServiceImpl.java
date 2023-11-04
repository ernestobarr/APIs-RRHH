package com.parcial03.p3.services.impl;

import com.parcial03.p3.models.Departamento;
import com.parcial03.p3.repos.IDepartamentoRepo;
import com.parcial03.p3.repos.IGenericRepo;
import com.parcial03.p3.services.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoServiceImpl extends CRUDImpl<Departamento,Integer> implements IDepartamentoService {
    @Autowired
    private IDepartamentoRepo repo;
    @Override
    protected IGenericRepo<Departamento, Integer> getRepo() {
        return repo;
    }
}