package servicios;

import java.util.Scanner;

public class MenuClienteImplementacion implements MenuClienteInterfaz {
	public void mostrarMenuCliente() {
		System.out.println("---------------------");
		System.out.println("Menu Cliente");
		System.out.println("Seleccione una opcion");
		System.out.println("1.- Registro cliente");
		System.out.println("2.- Acceso Cliente");
		System.out.println("3.- Volver al Menu Principal");
		System.out.println("---------------------");
	}
	
	public int opcionMenuCliente(Scanner sc) {
		int opcionMenuCliente;
		opcionMenuCliente = sc.nextInt();
		return opcionMenuCliente;
	}

}
