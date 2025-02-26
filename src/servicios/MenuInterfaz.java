package servicios;

import java.util.Scanner;

public interface MenuInterfaz {

	void mostrarMenu();

	int pedirOpcionUsuario(Scanner sc);
	
	public boolean versionEmpleado(Scanner sc, MenuEmpleadoInterfaz interfazEmpleado,
			EmpleadoInterfaz empleadoInterfaz, boolean esMenuEmpleadoCerrado);
	
	public boolean versionCliente(Scanner sc, MenuClienteInterfaz interfazCliente,
			ClienteInterfaz clienteInterfaz, boolean esMenuClienteCerrado);

}