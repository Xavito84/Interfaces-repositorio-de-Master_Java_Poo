package org.xmartinez.bolsaSupermercado;

import org.xmartinez.bolsaSupermercado.genericos.BolsaSupermercado;

import org.xmartinez.bolsaSupermercado.productos.*;

import java.util.List;

public class Start {
    public static void main(String[] args) {

        //Bolsa de Lacteos
        BolsaSupermercado<Lacteo> bolsaLacteos = new BolsaSupermercado<>();
        bolsaLacteos.addProducto(new Lacteo("Leche", 5.0, 1, 10));
        bolsaLacteos.addProducto(new Lacteo("Queso", 3.5, 2, 15));
        bolsaLacteos.addProducto(new Lacteo("Nata", 7.5, 1, 25));
        bolsaLacteos.addProducto(new Lacteo("Mantequilla", 3.5, 1, 12));
        bolsaLacteos.addProducto(new Lacteo("Yogur", 2.5, 1, 30));

        imprimir(bolsaLacteos.getProductos());
        System.out.println("*************************************************************");


        // Bolsa de Frutas
        BolsaSupermercado<Fruta> bolsaFrutas = new BolsaSupermercado<>();
        bolsaFrutas.addProducto(new Fruta("Manzana", 1.2, 0.5, "Rojo"));
        bolsaFrutas.addProducto(new Fruta("Plátano", 0.8, 0.3, "Amarillo"));
        bolsaFrutas.addProducto(new Fruta("Uva", 2.5, 1.0, "Morado"));
        bolsaFrutas.addProducto(new Fruta("Pera", 1.5, 0.4, "Verde"));
        bolsaFrutas.addProducto(new Fruta("Naranja", 1.0, 0.6, "Naranja"));

        imprimir(bolsaFrutas.getProductos());
        System.out.println("*************************************************************");

        // Bolsa de Productos de Limpieza
        BolsaSupermercado<Limpieza> bolsaLimpieza = new BolsaSupermercado<>();
        bolsaLimpieza.addProducto(new Limpieza("Detergente", 3.5, "Cloro", 2.0));
        bolsaLimpieza.addProducto(new Limpieza("Jabón líquido", 2.5, "Glicerina", 1.5));
        bolsaLimpieza.addProducto(new Limpieza("Desinfectante", 4.0, "Pino", 1.2));
        bolsaLimpieza.addProducto(new Limpieza("Limpia Vidrios", 3.0, "Alcohol", 0.8));
        bolsaLimpieza.addProducto(new Limpieza("Suavizante", 2.0, "Aromas", 2.0));

        imprimir(bolsaLimpieza.getProductos());
        System.out.println("*************************************************************");

        // Bolsa de No Perecibles
        BolsaSupermercado<NoPerecible> bolsaNoPerecibles = new BolsaSupermercado<>();
        bolsaNoPerecibles.addProducto(new NoPerecible("Arroz", 1.5, 500, 300));
        bolsaNoPerecibles.addProducto(new NoPerecible("Lentejas", 2.0, 400, 250));
        bolsaNoPerecibles.addProducto(new NoPerecible("Harina", 1.2, 1000, 400));
        bolsaNoPerecibles.addProducto(new NoPerecible("Azúcar", 1.0, 1000, 380));
        bolsaNoPerecibles.addProducto(new NoPerecible("Sal", 0.5, 500, 0));

        imprimir(bolsaNoPerecibles.getProductos());
        System.out.println("*************************************************************");



    }

    private static <T extends Producto> void imprimir(List<T> productos) {
        for (T producto : productos) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            if (producto instanceof Fruta) {
                Fruta f = (Fruta) producto;
                System.out.println("Peso: " + f.getPeso());
                System.out.println("Color: " + f.getColor());
            } else if (producto instanceof Limpieza) {
                Limpieza l = (Limpieza) producto;
                System.out.println("Componentes: " + l.getComponentes());
                System.out.println("Litros: " + l.getLitros());
            } else if (producto instanceof Lacteo) {
                Lacteo la = (Lacteo) producto;
                System.out.println("Cantidad: " + la.getCantidad());
                System.out.println("Proteínas: " + la.getProteinas());
            } else if (producto instanceof NoPerecible) {
                NoPerecible np = (NoPerecible) producto;
                System.out.println("Contenido: " + np.getContenido());
                System.out.println("Calorías: " + np.getCalorias());
            }
            System.out.println("----------------------");
        }
    }
}

