package com.example.CRUD.CRUDUFRO.commons;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class ServicioGenericoImpl<T, ID extends Serializable> implements ServicioGenerico<T, ID> {

    @Override
    public T guardar(T entity) {
        return obtener().save(entity);
    }
    @Override
    public T obtener(ID id) {
        Optional<T> obj = obtener().findById(id);
        if (obj.isPresent()) {
            return obj.get();
        }
        return null;
    }

    @Override
    public void eliminar(ID id) {
        obtener().deleteById(id);
    }

    @Override
    public List<T> getAll() {
        List<T> returnList = new ArrayList<>();
        obtener().findAll().forEach(obj -> returnList.add(obj));
        return returnList;
    }
    
    public abstract CrudRepository<T, ID> obtener();
}
