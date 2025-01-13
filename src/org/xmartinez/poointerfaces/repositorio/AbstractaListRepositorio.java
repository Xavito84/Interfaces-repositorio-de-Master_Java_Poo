package org.xmartinez.poointerfaces.repositorio;



import org.xmartinez.poointerfaces.modelo.BaseEntity;
import org.xmartinez.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio <T extends BaseEntity> implements IFullReposiorio <T> {


    protected List<T> dataSource;

    //Constructor


    public AbstractaListRepositorio() {
        this.dataSource= new ArrayList<>();
    }

    ////Interface CRUD
    @Override
    public List<T> listar() {
        return dataSource;
    }


    @Override
    public T porId(Integer id) {
        for (T item : dataSource) {
            if (item.getId() != null && item.getId().equals(id)) {
                return item; // Devuelve el elemento encontrado directamente.
            }
        }
        return null; // Si no se encuentra el elemento, devuelve null.
    }




    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }



    @Override
    public void eliminar(Integer id) {
        T resultado= this.porId(id);
        this.dataSource.remove(resultado);
    }



    //Interface Paginable
    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);}



    @Override
    public int total() {
        return this.dataSource.size();
    }


}


