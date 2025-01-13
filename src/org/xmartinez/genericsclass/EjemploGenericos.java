package org.xmartinez.genericsclass;

public class EjemploGenericos {

    public static void main(String[] args) {

        Camion transporteCaballos = new Camion(5);
        transporteCaballos.add(new Animal("Peregrino", "Caballo"));
        transporteCaballos.add(new Animal("Thor", "Caballo"));
        transporteCaballos.add(new Animal("Holi", "Caballo"));
        transporteCaballos.add(new Animal("Grillo", "Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));


        for (Object o : transporteCaballos) {
            Animal a = (Animal) o;
            System.out.println(a.getNombre() + "-- " + a.getTipo());
        }

        Camion transMaquinas = new Camion(3);
        transMaquinas.add(new Maquinaria("Bulldozer"));
        transMaquinas.add(new Maquinaria("Grua Horquilla"));
        transMaquinas.add(new Maquinaria("Perforadora"));

        for (Object o : transMaquinas) {
            Maquinaria m = (Maquinaria) o;
            System.out.println(m.getTipo());
        }

        Camion transAuto = new Camion(3);
        transAuto.add(new Automovil("Toyota"));
        transAuto.add(new Automovil("BMW"));
        transAuto.add(new Automovil("Mercedes"));

        for(Object o: transAuto) {
            Automovil a= (Automovil) o;
            System.out.println(a.getMarca());
        }


    }
}
