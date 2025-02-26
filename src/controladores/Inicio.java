package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import servicios.*;
import dtos.*;

/**
 * Puerta de entrada a mi aplicación
 * @author jmormez
 * @date 24/02/2025
 * 
 * TODO Paso 9 Terminado. Comenzar con paso 10.
 * 		*Mejorar MenuImplementación
 * 		*Subir a Github y commit cambios.
 * 		*Comentar clases y métodos con fecha antes de subir a github.
 * 		
 */
public class Inicio {

	//public static ArrayList<ClienteDto> clientes = new ArrayList<>();
	public static List<ClienteDto> listaClientes = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MenuInterfaz interfaz = new MenuImplementacion();
		MenuEmpleadoInterfaz interfazEmpleado = new MenuEmpleadoImplementacion();
		MenuClienteInterfaz interfazCliente = new MenuClienteImplementacion();
		ClienteInterfaz clienteInterfaz = new ClienteImplementacion();
		EmpleadoInterfaz empleadoInterfaz = new EmpleadoImplementacion();
		
		boolean esCerrado = false;
		boolean esMenuEmpleadoCerrado = false;
		boolean esMenuClienteCerrado = false;
		
		
		int opcionMenuPrincipal;

		while (!esCerrado) {
			interfaz.mostrarMenu();
			opcionMenuPrincipal = interfaz.pedirOpcionUsuario(sc);

		
			switch (opcionMenuPrincipal) {
			//-----------------------------------------------------------------	
			case 1: {
				System.out.println("Ha seleccionado la version empleado");
				sc.nextLine(); //Limpiar buffer
				esMenuEmpleadoCerrado = interfaz.versionEmpleado(sc, interfazEmpleado, 
						empleadoInterfaz, esMenuEmpleadoCerrado);
				
				break;
				
			}
			//-----------------------------------------------------------------			
			case 2: {
				System.out.println("Ha seleccionado la version cliente");
				//sc.nextLine(); //Limpiar buffer
				esMenuClienteCerrado =interfaz.versionCliente(sc, interfazCliente, 
						clienteInterfaz, esMenuClienteCerrado);
				break;
			}
			//-----------------------------------------------------------------				
			case 3: {
				System.out.println("Ha seleccionado salir de la aplicacion");
				esCerrado = true;
				break;
			}
			//------------------------------------------------------------------
			default:
				System.out.println("Error. Seleccione una opcion ente las ofrecidas.");
			}
			
		}
		sc.close();
	}



	




}
