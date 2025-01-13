package org.xmartinez.generics;

import org.xmartinez.poointerfaces.modelo.Cliente;
import org.xmartinez.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        List<Cliente> clientes= new ArrayList<>();
        clientes.add(new Cliente("Xavier", "Martinez"));

        Cliente xavi = clientes.iterator().next();

        Cliente [] clienteArreglo= { new Cliente("Lucas", "Lopez"),
                                        new Cliente("Lola", "Garrido") };

        Integer [] enterosArreglo= {1,2,3,4,5,6,7,8,9};

        List<Cliente> clientesLista= fromArraytoList(clienteArreglo);
        List<Integer> enterosLista= fromArraytoList(enterosArreglo);

        clientesLista.forEach(System.out::println);
        enterosLista.forEach(System.out::println);



        System.out.println("********************************************************************************");
        List<String> nombres= fromArraytoList(new String[]{"Xavi", "Miriam","Shiva", "Jhon"}, enterosArreglo);
        nombres.forEach(System.out::println);

        List<ClientePremium> clientesPremiumList = fromArraytoList(new ClientePremium[] { new ClientePremium( "Jorge", "Linares")});


        imprimirClientes(clientes);
        imprimirClientes(clientesLista);
        imprimirClientes(clientesPremiumList);

        System.out.println("******************");
        System.out.println("Maximno de 1 , 9 y 4 es: "+ maximo(1,9,4));
        System.out.println("Maximo de 3.9, 11.6 y 7.78 es: "+ maximo(3.9,11.6,7.78));
        System.out.println("Maximo de zanahoria, arándanos y manzana es: "+ maximo("zanahoria", "arándanos", "manzano"));






    }
    public static <T> List<T> fromArraytoList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Number> List<T> fromArraytoList(T[] c) {
        return Arrays.asList(c);
    }


    public static <T extends Cliente & Comparable<T> > List<T> fromArraytoList(T[] c) {
        return Arrays.asList(c);
    }



    public static <T, G> List<T> fromArraytoList(T[] c, G[] g) {
        for (G elemntos : g) {
            System.out.println(elemntos);
        }
        return Arrays.asList(c);
    }

    public static void imprimirClientes(List<? extends Cliente> clientes){       // el ? extends es para que coja todos los clientes y clientes premium
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable <T>> T maximo(T a, T b, T c){
        T max= a;
        if (b .compareTo(max) >0) {
            max = b;
        }
        if(c.compareTo(max) > 0){
            max= c;
        }
        return max;
    }
}
