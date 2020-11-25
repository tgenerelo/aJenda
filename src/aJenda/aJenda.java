package aJenda;

import java.util.Scanner;

public class aJenda {

	public static void main(String[] args) {

		Scanner leer = new Scanner(System.in);
		int tam = 10, opcionMenu = 0;
		boolean salir = false;
		String mContactos[][] = new String[tam][2];

		inicializarMatriz(mContactos);

		mContactos[0][0] = "José Sazatornil";
		mContactos[0][1] = "611111111";
		mContactos[1][0] = "Yennefer de Vengerberg";
		mContactos[1][1] = "622222222";
		mContactos[2][0] = "Felipe Castro";
		mContactos[2][1] = "633333333";
		mContactos[3][0] = "Enrique González";
		mContactos[3][1] = "644444444";
		mContactos[4][0] = "María Ibáñez";
		mContactos[4][1] = "655555555";
		mContactos[5][0] = "Martín Pescador";
		mContactos[5][1] = "666666666";
		mContactos[6][0] = "Joaquín de Luis";
		mContactos[6][1] = "677777777";
		mContactos[7][0] = "David Robert Jones";
		mContactos[7][1] = "688888888";
		mContactos[8][0] = "Íñigo Montoya";
		mContactos[8][1] = "699999999";

		ordenarContactos(mContactos);

		do {
			boolean error = false;
			do {
				opcionMenu = mostrarMenu();
				if (opcionMenu < 1 || opcionMenu > 6) {
					if (opcionMenu == 22688) {
						about();
					} else {
						error = true;
						System.out.println("ERROR: Opción no válida. Por favor, inténtalo de nuevo.");
						System.out.println();
					}
				} else {
					break;
				}
			} while (error = true);

			switch (opcionMenu) {
			case 1: {
				verContactos(mContactos);
				break;
			}
			case 2: {
				buscarContacto(mContactos);
				break;
			}
			case 3: {
				agregarContacto(mContactos);
				break;
			}
			case 4: {
				modificarContacto(mContactos);
				break;
			}
			case 5: {
				eliminarContacto(mContactos);
				break;
			}
			case 6: {
				break;
			}
			}

			if (opcionMenu == 6) {
				salir = true;
			} else {
				salir = salir();
			}

		} while (!salir);

		System.out.println("Gracias por utilizar aJenda.\nEl programa se cerrará.");
	}

// /////////////// FUNCIONES /////////////// //

	// INICIALIZAR MATRIZ
	public static void inicializarMatriz(String mContactos[][]) {
		for (int i = 0; i < mContactos.length; i++) {
			mContactos[i][0] = "";
			mContactos[i][1] = "";

		}
	}

	// REORDENAR CONTACTOS
	public static void ordenarContactos(String mContactos[][]) {
		for (int i = 0; i < mContactos.length - 1; i++) {
			int j = i + 1;
			if (mContactos[i][0].equals("") & mContactos[i][1].equals("")) {
				while (mContactos[j][0].equals("") & mContactos[j][1].equals("") & j < mContactos.length - 1) {
					j++;
				}
				mContactos[i][0] = mContactos[j][0];
				mContactos[i][1] = mContactos[j][1];
				mContactos[j][0] = "";
				mContactos[j][1] = "";
			}
		}
	}

	// MOSTRAR MENÚ
	public static int mostrarMenu() {
		Scanner leer = new Scanner(System.in);
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

	// VER CONTACTOS
	public static void verContactos(String mContactos[][]) {
		boolean agendaVacia = true;

		System.out.println(" -------------------");
		System.out.println(" TODOS LOS CONTACTOS");
		System.out.println(" -------------------");

		for (int i = 0; i < mContactos.length; i++) {
			if (!(mContactos[i][0].equals("") & mContactos[i][1].equals(""))) {
				System.out.print(" ");
				mostrarContacto(mContactos, i);
				agendaVacia = false;
			}

		}
		if (agendaVacia) {
			System.out.println(" No se ha añadido ningún contacto todavía. La agenda está vacía.");
		}
	}

	// MOSTRAR UN CONTACTO
	public static void mostrarContacto(String mContactos[][], int numContacto) {
		System.out.print("CONTACTO " + (numContacto + 1) + ": ");
		System.out.println(mContactos[numContacto][0] + " - " + mContactos[numContacto][1]);
	}

	// BUSCAR CONTACTOS
	public static void buscarContacto(String mContactos[][]) {
		Scanner leer = new Scanner(System.in);
		String userInput = "";
		int contador = 0;

		System.out.println(" --------");
		System.out.println(" BÚSQUEDA");
		System.out.println(" --------");

		System.out.print(" Introduce parte del nombre o teléfono del contacto que deseas buscar:\n > ");
		userInput = leer.nextLine();

		System.out.println();

		for (int i = 0; i < mContactos.length; i++) {
			boolean encontrado;
			encontrado = false;

			for (int j = 0; j < mContactos[i][0].length() - userInput.length() + 1; j++) {
				if (userInput.equalsIgnoreCase(mContactos[i][0].substring(j, j + userInput.length()))) {
					encontrado = true;
					contador++;
					break;
				}
			}

			for (int j = 0; j < mContactos[i][1].length() - userInput.length() + 1; j++) {
				if (userInput.equalsIgnoreCase(mContactos[i][1].substring(j, j + userInput.length()))) {
					encontrado = true;
					contador++;
					break;
				}
			}

			if (encontrado) {
				if (contador == 1) {
					System.out.println(" Se han encontrado las siguientes coincidencias:\n");
				}
				System.out.print("  ");
				mostrarContacto(mContactos, i);
			}
		}

		if (contador == 0) {
			System.out.println("No se ha encontrado ninguna coincidencia.");
		}
	}

	// AÑADIR CONTACTO
	public static void agregarContacto(String mContactos[][]) {
		Scanner leer = new Scanner(System.in);

		System.out.println(" ------------------------");
		System.out.println(" AÑADIR UN NUEVO CONTACTO");
		System.out.println(" ------------------------");

		for (int i = 0; i < mContactos.length; i++) {
			if (mContactos[i][0].equals("") & mContactos[i][1].equals("")) {
				System.out.print("  Introduce el nombre del nuevo contacto: > ");
				mContactos[i][0] = leer.nextLine();
				System.out.print("  Introduce el número de teléfono: > ");
				mContactos[i][1] = leer.nextLine();
				System.out.println();
				System.out.println("El contacto se ha guardado con éxito como CONTACTO " + (i + 1) + ".");
				break;
			} else {
				if (i == mContactos.length - 1) {
					System.out.println(
							" ERROR: La agenda está llena. Elimina algún registro para añadir nuevos contactos.");
				}
			}
		}
	}

	// MODIFICAR CONTACTO
	public static void modificarContacto(String mContactos[][]) {
		Scanner leer = new Scanner(System.in);
		String userInput = "";
		int idContacto = 0;

		System.out.println(" ---------------------");
		System.out.println(" MODIFICAR UN CONTACTO");
		System.out.println(" ---------------------");

		System.out.print(" Introduce el ID del contacto que deseas modificar: > ");
		idContacto = leer.nextInt();

		System.out.println();
		System.out.println(" Se modificará el siguiente contacto:");
		System.out.print("  ");
		mostrarContacto(mContactos, idContacto - 1);
		System.out.println();
		System.out.print(" ¿Es correcto? (S/N): > ");
		leer = new Scanner(System.in);
		userInput = leer.nextLine();
		if (userInput.equalsIgnoreCase("s")) {
			leer = new Scanner(System.in);
			System.out.print(" Introduce el nuevo nombre del contacto: > ");
			mContactos[idContacto - 1][0] = leer.nextLine();
			leer = new Scanner(System.in);
			System.out.print(" Introduce el nuevo teléfono del contacto: >  ");
			mContactos[idContacto - 1][1] = leer.nextLine();

			System.out.println();
			System.out.println("El contacto se ha guardado correctamente.");
		} else {
			System.out.println(" El usuario canceló la operación. No se ha realizado ningún cambio.");
		}

	}

	// ELIMINAR CONTACTO
	public static void eliminarContacto(String mContactos[][]) {
		Scanner leer = new Scanner(System.in);
		String userInput = "";
		int numContacto = 0;

		System.out.println(" --------------------");
		System.out.println(" ELIMINAR UN CONTACTO");
		System.out.println(" --------------------");
		System.out.print(" Introduce el ID del contacto que deseas eliminar: > ");
		numContacto = leer.nextInt();

		System.out.println();
		System.out.println(" Se eliminará el siguiente contacto:");
		System.out.print("  ");
		mostrarContacto(mContactos, numContacto - 1);
		System.out.println();
		System.out.print(" ¿Estás seguro? (S/N): > ");
		userInput = leer.next();
		if (userInput.equalsIgnoreCase("s")) {
			mContactos[numContacto - 1][0] = "";
			mContactos[numContacto - 1][1] = "";
			ordenarContactos(mContactos);
			System.out.println();
			System.out.println(" El contacto se ha eliminado correctamente.\n Los contactos se han reordenado.");
		} else {
			System.out.println(" El usuario canceló la operación. No se ha realizado ningún cambio.");
		}
	}

	// SALIR
	public static boolean salir() {
		Scanner leer = new Scanner(System.in);
		String userInput = "";
		boolean salir = false, error=false;

		System.out.println();
		
		do {
			System.out.print("¿Quieres volver al menú? (S/N): > ");
			userInput = leer.next();

			if (userInput.equalsIgnoreCase("s")) {
				salir = false;
				error=false;
			} else {
				if (userInput.equalsIgnoreCase("n")) {
					salir = true;
					error=false;
				} else {
					error=true;
				}
			} 
		} while (error);

		System.out.println();

		return salir;
	}

	// ABOUT
	public static void about() {
		System.out.println("--------------------------------------------------");
		System.out.println("|              ACERCA DE aJenda 1.0              |");
		System.out.println("--------------------------------------------------");
		System.out.println("|          Gracias por utilizar aJenda,          |");
		System.out.println("|                 con J de Java.                 |");
		System.out.println("|                                                |");
		System.out.println("|            (c) Tomás Generelo, 2020            |");
		System.out.println("--------------------------------------------------");

	}
}
