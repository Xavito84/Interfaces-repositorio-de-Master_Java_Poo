package org.xmartinez.poointerfaces;


import org.xmartinez.poointerfaces.modelo.Productos;
import org.xmartinez.poointerfaces.repositorio.Direccion;
import org.xmartinez.poointerfaces.repositorio.IFullReposiorio;
import org.xmartinez.poointerfaces.repositorio.IOrdenableRepositorio;
import org.xmartinez.poointerfaces.repositorio.IPaginableRepositorio;

import org.xmartinez.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.xmartinez.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.xmartinez.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {

        try{

        IFullReposiorio<Productos> repo= new ProductoListRepositorio();
        repo.crear(new Productos("Mesa", 3.5 ));
        repo.crear(new Productos("Silla", 50));
        repo.crear(new Productos("Lampara", 15.5));
        repo.crear(new Productos("Notebook" , 598));

        List<Productos> clientes=repo.listar();
        clientes.forEach(System.out::println );


        List<Productos> paginable= ((IPaginableRepositorio) repo).listar(1,3);
        System.out.println("************************paginable************************");
        paginable.forEach(System.out::println);

        System.out.println("************************Ordenar ASC************************");
        List<Productos> clientesOrdenASC= ((IOrdenableRepositorio) repo).listar("descripcion", Direccion.ASC);

        for(Productos producto : clientesOrdenASC) {
            System.out.println(producto);
        }

        System.out.println("************************Ordenar DESC************************");
        List<Productos> clientesOrdenDESC= ((IOrdenableRepositorio) repo).listar("descripcion", Direccion.DESC);

        for(Productos producto : clientesOrdenDESC) {
            System.out.println(producto);
        }

        System.out.println("****************************Editar***********************");
        Productos lamparaActualizar= new Productos("Sofa", 50);
        lamparaActualizar.setId(3);
        repo.editar(lamparaActualizar);
        Productos lampara= repo.porId(3);
        System.out.println();
        System.out.println(lampara);

        System.out.println();
        System.out.println("****************************ListaEditada***********************");
        ((IOrdenableRepositorio) repo).listar("descripcion", Direccion.ASC).forEach(System.out::println);


        System.out.println("****************************Eliminar***********************");
        //
        repo.eliminar(1);
        repo.listar().forEach(System.out::println);

        System.out.println("******************************Total***********************");
        System.out.println("Total de registros: "+ repo.total());

    }catch (
    LecturaAccesoDatoException lade) {
        System.out.println(lade.getMessage());
        lade.printStackTrace();
    } catch (
    AccesoDatoException ade) {
        System.out.println(ade.getMessage());
        ade.printStackTrace();
    }


    }
}
