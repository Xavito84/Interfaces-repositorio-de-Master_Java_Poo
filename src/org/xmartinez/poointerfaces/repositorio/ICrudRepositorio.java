package org.xmartinez.poointerfaces.repositorio;



import org.xmartinez.poointerfaces.repositorio.excepciones.AccesoDatoException;

import java.util.List;

public interface ICrudRepositorio <T> {

    List<T> listar();

    T porId(Integer id) throws AccesoDatoException;

    void crear(T objeto) throws AccesoDatoException;

    void editar(T objeto) throws AccesoDatoException;

    void eliminar(Integer id) throws AccesoDatoException;



}
