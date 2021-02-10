package aJendaObjetos;

import java.util.Scanner;

import IODatos.IODatos;

public class Principal {

	public static void main(String[] args) {

		boolean volver = true;
		Scanner leer = new Scanner(System.in);
		String propietario = "";
		IODatos io = new IODatos();

		do {
			System.out.print("Introduce tu nombre o teclea \"SALIR\" para salir del programa: > ");
			propietario = leer.nextLine();
			System.out.println();

			if (propietario.equalsIgnoreCase("salir"))
				break;

			Agenda agenda = io.leerFichero(propietario);

			do {
				switch (agenda.menu()) {
				case 1:
					agenda.mostrarContactos();
					volver = true;
					break;

				case 2:
					agenda.buscarContacto();
					volver = true;
					break;

				case 3:
					agenda.nuevoContacto();
					volver = true;
					break;

				case 4:
					agenda.modificarContacto();
					volver = true;
					break;

				case 5:
					agenda.eliminarContacto();
					volver = true;
					break;

				case 6:
					IODatos guardar = new IODatos();
					guardar.guardarVector(agenda);
					volver = false;
					System.out.println("Los cambios se han guardado correctamente.\n");
					break;

				case 7:
					volver = false;
					System.out.println("Los cambios no se han guardado.\n");
					break;
				}

				if (volver == true) {
					volver = agenda.volverMenu();
				}

			} while (volver == true);
		} while (!propietario.equalsIgnoreCase("salir"));

		System.out.println("Gracias por utilizar aJenda. El programa se cerrará.");

		leer.close();

	}
}
