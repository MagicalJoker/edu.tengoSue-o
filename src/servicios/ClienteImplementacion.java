package servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controladores.Inicio;
import dtos.*;

public class ClienteImplementacion implements ClienteInterfaz {
	Scanner sc = new Scanner(System.in);
	//public static List<ClienteDto> listaClientes = new ArrayList<>();
	
	public void nuevoCliente() {
	
        System.out.print("Ingrese el nombre completo del cliente: ");
        sc.nextLine();
        String nombreCompleto = sc.nextLine();
        
        // Solicitar y validar el DNI
        
        String dniClienteString = solicitarDni();
        if (dniClienteString == null) {
            System.out.println("No se ha podido dar de alta al cliente. DNI inválido.");
            return; // Salir del método si el DNI no es válido
        }
        
        //Solicitar email al usuario
        System.out.println("Ingrese su email");
        String email = sc.next();
        
        //Solicitar contraseña al usuario
        System.out.println("Ingrese la contraseña de su email");
        String contraseña = sc.next();
        

        // Separar nombre y apellido
        String[] partesNombre = nombreCompleto.split(" ", 3);
        String nombre = partesNombre[0];
        String apellido1 = (partesNombre.length > 1) ? partesNombre[1] : "";
        String apellido2 = (partesNombre.length > 2) ? partesNombre[2] : "";

        ClienteDto nuevoCliente = new ClienteDto();
        nuevoCliente.setIdCliente(generarNuevoId());
        nuevoCliente.setNombreCliente(nombre);
        nuevoCliente.setApellido1Cliente(apellido1);
        nuevoCliente.setApellido2Cliente(apellido2);
        nuevoCliente.setDniCliente(dniClienteString);
        nuevoCliente.setEmailCliente(email);
        nuevoCliente.setContraseñaCliente(contraseña);
        nuevoCliente.setEsValidado(false);
        
        Inicio.listaClientes.add(nuevoCliente);
    }

	private long generarNuevoId() {
        if (Inicio.listaClientes.isEmpty()) {
            return 1;
        } else {
            return Inicio.listaClientes.get(Inicio.listaClientes.size() - 1).getIdCliente() + 1;
        }
    }
	  
	/**
     * Metodo para solicitar el DNI al usuario. Limitado a 1 intento.
     * @author jmormez
     * @date 17/02/2025
     */
    public String solicitarDni() {
        int intentos = 0;

        if (intentos == 0) {
            System.out.println("Ingrese el DNI (8 dígitos + 1 letra): ");
            String dniClienteString = sc.next();

            if (esDniValido(dniClienteString)) {
            	System.out.println("DNI Valido");
                return dniClienteString;
            } else {
                System.out.println("DNI inválido");
            }
            return dniClienteString;
        }
		return null;
     
    }

    /**
     *	Metodo privado para validar el DNI introducido por el cliente
     *	Uso del matches: https://www.discoduroderoer.es/metodo-string-matches-de-java/
     *	@author jmormez
     *	@date 17/02/2025
     */
    private boolean esDniValido(String dniClienteString) {
        
        if (dniClienteString.matches("\\d{8}[A-Z]")) {
         
            String numeros = dniClienteString.substring(0, 8);
            char letra = dniClienteString.charAt(8);

            int numero = Integer.parseInt(numeros);
            char letraCorrecta = calcularLetraDNI(numero);
            return letra == letraCorrecta;
        }
        return false;
    }

    /**
     *	Metodo que contiene la tabla de letras necesarias para el metodo validarCliente();
     *	@author jmormez
     *	@date 17/02/2025
     */
    public char calcularLetraDNI(int numero) {
        // Tabla de letras 
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 
                         'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 
                         'C', 'K', 'E'};

        // Calcular utilizando el resto de la división entre 23
        int indice = numero % 23;
        return letras[indice];
    }
    
    public void accederCliente() {
        int intentos = 0;
        boolean accesoConcedido = false;
        
        while (intentos < 3 && !accesoConcedido) {
            System.out.println("Introduce su email:");
            String inputEmail = sc.next();
            System.out.println("Introduce su contraseña:");
            String inputContraseña = sc.next();
            
            for (ClienteDto cliente : Inicio.listaClientes) {
                if (inputEmail.equals(cliente.getEmailCliente()) 
                    && inputContraseña.equals(cliente.getContraseñaCliente()) 
                    && cliente.isEsValidado()) {
                    
                    System.out.println("Acceso concedido. ¡Bienvenido!");
                    accesoConcedido = true;
                    break;
                }
            }

            if (!accesoConcedido) {
                intentos++;
                if (intentos < 3) {
                    System.out.println("Datos erróneos. Intento " + intentos + " de 3.");
                } else {
                    System.out.println("Demasiados intentos fallidos. Volviendo al menú principal.");
                }
            }
        }
    }
}