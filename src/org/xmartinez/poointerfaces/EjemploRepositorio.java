package org.xmartinez.poointerfaces;

import org.xmartinez.poointerfaces.modelo.Cliente;
import org.xmartinez.poointerfaces.repositorio.*;
import org.xmartinez.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.xmartinez.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.xmartinez.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.xmartinez.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;
import org.xmartinez.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        try {


            IFullReposiorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Lucas", "Morales"));
            repo.crear(new Cliente("Lola", "Martinez"));
            repo.crear(new Cliente("Miriam", "Lucena"));
            repo.crear(new Cliente("Xavier", "Garrido"));

            //repo.crear(null);
            List<Cliente> clientes = repo.listar();
            clientes.forEach(System.out::println);


            List<Cliente> paginable = ((IPaginableRepositorio) repo).listar(1, 3);
            System.out.println("************************paginable************************");
            paginable.forEach(System.out::println);

            System.out.println("************************Ordenar ASC************************");
            List<Cliente> clientesOrdenASC = ((IOrdenableRepositorio) repo).listar("nombre", Direccion.ASC);

            for (Cliente cliente : clientesOrdenASC) {
                System.out.println(cliente);
            }

            System.out.println("************************Ordenar DESC************************");
            List<Cliente> clientesOrdenDESC = ((IOrdenableRepositorio) repo).listar("nombre", Direccion.DESC);

            for (Cliente cliente : clientesOrdenDESC) {
                System.out.println(cliente);
            }

            System.out.println("****************************Editar***********************");
            Cliente lucasEditar = new Cliente("Lucas", "Perez");
            System.out.println();
            Cliente lucas = repo.porId(1);
            System.out.println(lucas);
            ((IOrdenableRepositorio) repo).listar("nombre", Direccion.ASC).forEach(System.out::println);


            System.out.println("****************************Eliminar***********************");
            //
            repo.eliminar(1);
            repo.listar().forEach(System.out::println);

            System.out.println("******************************Total***********************");
            System.out.println("Total de registros: " + repo.total());

        }catch (RegistroDuplicadoAccesoDatoException re){
            System.out.println(re.getMessage());
            re.printStackTrace();
        }catch (LecturaAccesoDatoException lade) {
            System.out.println(lade.getMessage());
            lade.printStackTrace();
        } catch (EscrituraAccesoDatoException eade){
            System.out.println(eade.getMessage());
            eade.printStackTrace();

        } catch (AccesoDatoException ade) {
            System.out.println(ade.getMessage());
            ade.printStackTrace();
        }

    }
}
