package org.xmartinez.poointerfaces.repositorio;



import org.xmartinez.poointerfaces.modelo.BaseEntity;

import org.xmartinez.poointerfaces.repositorio.excepciones.*;

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
    public T porId(Integer id) throws LecturaAccesoDatoException {
        if (id == null || id <= 0) {
            throw new LecturaAccesoDatoException("Id invalido tiene que ser mayor que cero!!!");
        }
        T resultado= null;
        for (T item : dataSource) {
            if (item.getId() != null && item.getId().equals(id)) {
                resultado= item;
                break; // Devuelve el elemento encontrado directamente.
            }
        }
        if(resultado== null){
            throw new LecturaAccesoDatoException("No existe el registro con el id: "+ id);
        }
        return resultado; // Si no se encuentra el elemento, devuelve null.
    }




    @Override
    public void crear(T t) throws EscrituraAccesoDatoException {
        if( t == null){
            throw  new EscrituraAccesoDatoException("Error al insertar un objeto null");
        }
        if (this.dataSource.contains(t)){
            throw  new RegistroDuplicadoAccesoDatoException("Error el objeto con id "+ t.getId()+" ya existe en el repositorio");
        }
        this.dataSource.add(t);
    }



    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
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


