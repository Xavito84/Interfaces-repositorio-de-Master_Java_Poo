package org.xmartinez.poointerfaces.repositorio.lista;

import org.xmartinez.poointerfaces.modelo.Productos;
import org.xmartinez.poointerfaces.repositorio.AbstractaListRepositorio;
import org.xmartinez.poointerfaces.repositorio.Direccion;
import org.xmartinez.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio <Productos> {
    @Override
    public void editar(Productos producto) throws LecturaAccesoDatoException {
        Productos p= porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());

    }

    @Override
    public List<Productos> listar(String campo, Direccion dir) {
        List<Productos> listaOrdenada = new ArrayList<>(this.dataSource);

        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if (dir== Direccion.ASC){
                resultado= ordenar(campo,a,b);
            }else if (dir== Direccion.DESC){
                resultado= ordenar(campo,b,a);
            }
            return resultado;
        });
        return listaOrdenada;
    }

public static int ordenar(String campo, Productos a , Productos b){
    int resultado=0;
    switch (campo) {
        case "id" ->
                resultado = a.getId().compareTo(b.getId());
        case "descripcion" ->
                resultado= a.getDescripcion().compareTo(b.getDescripcion());
        case "precio" ->
                resultado= a.getPrecio().compareTo(b.getPrecio()); // para que te deje usaar el compareTo cambiar en producto el double por Double
    }
    return resultado;
}
}
