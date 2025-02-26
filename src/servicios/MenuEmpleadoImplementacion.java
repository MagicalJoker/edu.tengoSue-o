package servicios;

import java.util.Scanner;

public class MenuEmpleadoImplementacion implements MenuEmpleadoInterfaz {
	
	public void mostrarMenuEmpleado() {
		System.out.println("---------------------");
		System.out.println("1.- Validar cliente");
		System.out.println("2.- Borrar cliente");
		System.out.println("3.- Mostrar cliente");
		System.out.println("4.- Menu Inicial");
		System.out.println("---------------------");
	}
	
	public int opcionMenuEmpleado(Scanner sc) {
		int opcionMenuEmpleado;
		opcionMenuEmpleado = sc.nextInt();
		return opcionMenuEmpleado;
	}
	
}
