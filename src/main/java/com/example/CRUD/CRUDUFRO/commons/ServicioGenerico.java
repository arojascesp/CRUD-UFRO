package com.example.CRUD.CRUDUFRO.commons;

import java.io.Serializable;
import java.util.List;

public interface ServicioGenerico <T, ID extends Serializable>{

    T guardar(T entity);

    void eliminar(ID id);

    T obtener(ID id);

    List<T> getAll();
}
