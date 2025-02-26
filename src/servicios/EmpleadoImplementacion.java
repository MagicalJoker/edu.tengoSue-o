package servicios;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import controladores.Inicio;
import servicios.*;
import dtos.*;

import dtos.ClienteDto;

public class EmpleadoImplementacion implements EmpleadoInterfaz {
    Scanner sc = new Scanner(System.in);
    
    public void validarCliente() {
      //  List<ClienteDto> listaClientes = ClienteImplementacion.listaClientes;

        // Mostrar todos los clientes que no están validados
        System.out.println("Clientes no validados:");
        for (ClienteDto cliente : Inicio.listaClientes) {
            if (!cliente.isEsValidado()) {
                System.out.println("DNI: " + cliente.getDniCliente() + "\n" +
                                   "ID: " + cliente.getIdCliente() + "\n" + 
                                   "NOMBRE: " + cliente.getApellido1Cliente() + ", " + cliente.getApellido2Cliente() + ", " + cliente.getNombreCliente() + "\n" +
                                   "ESTADO DE VALIDACION: " + cliente.isEsValidado() + "\n" +
                                   "%%%%%%%%%%");
            }
        }

        // Solicitar el DNI del cliente a validar
        System.out.print("Ingrese el DNI del cliente que desea validar: ");
        String dni = sc.next();

        // Buscar el cliente en la lista y validar
        boolean clienteEncontrado = false;
        for (ClienteDto cliente : Inicio.listaClientes) {
            if (cliente.getDniCliente().equals(dni)) {
                cliente.setEsValidado(true);
                clienteEncontrado = true;
                System.out.println("El cliente con DNI " + dni + " ha sido validado.");
                break;
            }
        }

        if (!clienteEncontrado) {
            System.out.println("No se encontró un cliente con el DNI proporcionado.");
        }

    }

	

    
  

}
