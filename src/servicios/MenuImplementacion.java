package servicios;

import java.util.Scanner;
import controladores.*;

public class MenuImplementacion implements MenuInterfaz {
	public void mostrarMenu() {
		System.out.println("---------------------");
		System.out.println("Menu Principal");
		System.out.println("Seleccione una opcion");
		System.out.println("1.- Version empleado");
		System.out.println("2.- Version cliente");
		System.out.println("3.- Cerrar aplicacion");
		System.out.println("---------------------");
	}
	public int pedirOpcionUsuario(Scanner sc) {
		int opcionMenuPrincipal;
		opcionMenuPrincipal = sc.nextInt();
		return opcionMenuPrincipal;
	}
	
	public boolean versionEmpleado(Scanner sc, MenuEmpleadoInterfaz interfazEmpleado,
			EmpleadoInterfaz empleadoInterfaz, boolean esMenuEmpleadoCerrado) {
		int opcionMenuEmpleado;
		esMenuEmpleadoCerrado = false;
		while (!esMenuEmpleadoCerrado) {
			interfazEmpleado.mostrarMenuEmpleado();
			opcionMenuEmpleado = interfazEmpleado.opcionMenuEmpleado(sc);
			
			switch (opcionMenuEmpleado) {
			case 1: {
				System.out.println("Ha entrado en la opción Validar Cliente");
				empleadoInterfaz.validarCliente();
				break;
			}
			
			case 2: {
				System.out.println("Ha entrado en la opción Borrar Cliente");
				break;
			}
			
			case 3: {
				System.out.println("Ha entrado en la opcion Mostrar Cliente");
				break;
			}
			
			case 4: {
				System.out.println("Volviendo al menu Principal");
				esMenuEmpleadoCerrado = true;
				sc.nextLine();
				break;
			}
			default:
				System.out.println("Error. Elige una opcion valida");
				break;
			}
		}
		return esMenuEmpleadoCerrado;
	}
	
	public boolean versionCliente(Scanner sc, MenuClienteInterfaz interfazCliente,
			ClienteInterfaz clienteInterfaz, boolean esMenuClienteCerrado) {
		int opcionMenuCliente;
		esMenuClienteCerrado = false;
		while (!esMenuClienteCerrado ) {
			interfazCliente.mostrarMenuCliente();
			opcionMenuCliente = interfazCliente.opcionMenuCliente(sc);
			
		switch (opcionMenuCliente) {
		case 1: {
			System.out.println("Ha entrado en la opción registro cliente");
			clienteInterfaz.nuevoCliente();
			break;
		}
		
		case 2: {
			System.out.println("Ha entrado en la opción acceso cliente");
			clienteInterfaz.accederCliente();
			break;
		}
		
		case 3: {
			System.out.println("Volviendo al menu principal...");
			esMenuClienteCerrado = true;
			//sc.nextLine();
			break;
		}
		default:
			System.out.println("Error. Introduce una opcion valida");
			break;	
			}
		
		}
		return esMenuClienteCerrado;
	}
	

}
