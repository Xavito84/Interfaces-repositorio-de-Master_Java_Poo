package org.xmartinez.poointerfaces.repositorio;



import java.util.List;

public interface ICrudRepositorio <T> {

    List<T> listar();

    T porId(Integer id);

    void crear(T objeto);

    void editar(T objeto);

    void eliminar(Integer id);



}
