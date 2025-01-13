package org.xmartinez.bolsaSupermercado.genericos;

import org.xmartinez.bolsaSupermercado.productos.Producto;

import java.util.ArrayList;
import java.util.List;

public class BolsaSupermercado  <T extends Producto> {

    private List <T> productos;

    public BolsaSupermercado (){
        this.productos = new ArrayList<>();
    }

    public void addProducto( T producto ){
        if( productos.size() < 5){
            productos.add(producto);
        }else{
            throw  new RuntimeException("La bolsa no puede contener más de 5 productos!!!!!");
        }
    }

    public List<T> getProductos() {
        return productos;
    }

}
