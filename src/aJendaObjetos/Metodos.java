package aJendaObjetos;

import java.util.Scanner;

public class Metodos {

	static Scanner leer = new Scanner(System.in);

	public static int menu() {

		int opcionMenu = 0;

		System.out.println("--------------------------------------------------");
		System.out.println("              aJenda - MENÚ PRINCIPAL             ");
		System.out.println("--------------------------------------------------");
		System.out.println("1) Ver contactos          4) Modificar un contacto");
		System.out.println("2) Buscar un contacto     5) Eliminar un contacto ");
		System.out.println("3) Añadir un contacto     6) Salir                ");

		System.out.println();
		System.out.print("Introduce la opción deseada: > ");
		opcionMenu = leer.nextInt();

		System.out.println();

		return opcionMenu;

	}

	public static void mostrarContactos(Contacto vContactos[]) {
		for (int i = 0; i < vContactos.length; i++) {
			if (vContactos[i]!=null || !vContactos[i].getNombre().equals("")) {
				System.out.println("CONTACTO " + (i + 1) + ": " + vContactos[i].toString());
			}

		}
	}
	
	public static void inicializarVector(Contacto vContactos[]) {
		for (int i=0; i<vContactos.length; i++) {
		}
	}

	public static boolean volverMenu() {
		String userInput;

		do {
			System.out.print("¿Quieres volver al menú? (S/N): > ");
			userInput = leer.next();
			System.out.println();
			if (userInput.equalsIgnoreCase("s")) {
				return false;
			} else {
				if (userInput.equalsIgnoreCase("n")) {
					return true;
				}
			}
			System.out.println("Opción no válida. Vuelve a intentarlo.");
		} while (1 == 1);

	}
}
