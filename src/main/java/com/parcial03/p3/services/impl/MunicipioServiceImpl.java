package com.parcial03.p3.services.impl;

import com.parcial03.p3.models.Municipio;
import com.parcial03.p3.repos.IGenericRepo;
import com.parcial03.p3.repos.IMunicipioRepo;
import com.parcial03.p3.services.IMunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipioServiceImpl extends CRUDImpl<Municipio,Integer> implements IMunicipioService {
    @Autowired
    private IMunicipioRepo repo;
    @Override
    protected IGenericRepo<Municipio, Integer> getRepo() {
        return repo;
    }
}