package com.example.CRUD.CRUDUFRO.servicioImplementación;

import com.example.CRUD.CRUDUFRO.commons.ServicioGenericoImpl;
import com.example.CRUD.CRUDUFRO.interfaz.InterfacePersona;
import com.example.CRUD.CRUDUFRO.modelo.Persona;
import com.example.CRUD.CRUDUFRO.services.ServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicioPersonaImpl extends ServicioGenericoImpl<Persona, Integer> implements ServicioPersona {
    @Autowired
    private InterfacePersona interfacePersona;

    @Autowired
    public CrudRepository<Persona, Integer> obtener(){
        return interfacePersona;
    }
}
