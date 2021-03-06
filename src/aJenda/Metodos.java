package aJenda;

import java.util.Scanner;

public class Metodos {
	/**
	 * INICIALIZAR MATRIZ
	 * @param mContactos Matriz de contactos
	 */
	public static void inicializarMatriz(String mContactos[][]) {
		for (int i = 0; i < mContactos.length; i++) {
			mContactos[i][0] = "";
			mContactos[i][1] = "";

		}
	}

	/**
	 * REORDENAR CONTACTOS
	 * @param mContactos Matriz de contactos
	 */
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

	/**
	 * MOSTRAR MENÚ
	 * @return La opción seleccionada
	 */
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

	/**
	 * VER CONTACTOS
	 * @param mContactos Matriz de contactos
	 */
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

	/**
	 * MOSTRAR UN CONTACTO
	 * @param mContactos Matriz de contactos
	 * @param numContacto Número de fila de la que se recuperará la información
	 */
	public static void mostrarContacto(String mContactos[][], int numContacto) {
		System.out.print("CONTACTO " + (numContacto + 1) + ": ");
		System.out.println(mContactos[numContacto][0] + " - " + mContactos[numContacto][1]);
	}

	/**
	 * COMPROBAR ID VÁLIDO
	 * @param mContactos	Matriz de contactos.
	 * @param numContacto	ID de contacto introducido por el usuario que se comprobará.
	 * @return
	 */
	public static boolean idValido(String mContactos[][], int numContacto) {
		boolean valido=true;
		if (numContacto<1|| numContacto>mContactos.length || (mContactos[numContacto-1][0].equals("")) & mContactos[numContacto-1][1].equals("")) {
			System.out.println(" Error: el contacto no existe.\n  ");
			valido=false;
		}
		return valido;
	}
	
	/**
	 * BUSCAR CONTACTOS
	 * @param mContactos Matriz de contactos
	 */
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

	/**
	 * AÑADIR CONTACTO
	 * @param mContactos Matriz de contactos
	 */
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

	/**
	 * MODIFICAR CONTACTO
	 * @param mContactos Matriz de contactos
	 */
	public static void modificarContacto(String mContactos[][]) {
		Scanner leer = new Scanner(System.in);
		String userInput = "";
		int idContacto = 0;
		boolean error=false;

		System.out.println(" ---------------------");
		System.out.println(" MODIFICAR UN CONTACTO");
		System.out.println(" ---------------------");

		do {
			System.out.print(" Introduce el ID del contacto que deseas modificar: > ");
			idContacto = leer.nextInt();
			if (idValido(mContactos, idContacto)==true) {
				break;
			} else {
				idContacto=-1;
			}
		} while (idContacto==-1);
		

		System.out.println("\n Se modificará el siguiente contacto:");
		System.out.print("  ");
		mostrarContacto(mContactos, idContacto - 1);
		System.out.println();
		
		do {
			
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
				System.out.println("\n El contacto se ha guardado correctamente.");
				error=false;
			} else {
				if (userInput.equalsIgnoreCase("n")) {
					System.out.println(" El usuario canceló la operación. No se ha realizado ningún cambio.");
					error=false;
				} else {
					error=true;
				}
			}
		} while (error);
	}

	/**
	 * ELIMINAR CONTACTO
	 * @param mContactos Matriz de contactos
	 */
	public static void eliminarContacto(String mContactos[][]) {
		Scanner leer = new Scanner(System.in);
		String userInput = "";
		int numContacto = 0;
		boolean error=false;

		System.out.println(" --------------------");
		System.out.println(" ELIMINAR UN CONTACTO");
		System.out.println(" --------------------");
		do {
			System.out.print(" Introduce el ID del contacto que deseas eliminar: > ");
			numContacto = leer.nextInt();
			if (idValido(mContactos, numContacto)==true) {
				break;
			} else {
				numContacto=-1;
			}
		} while (numContacto==-1);
		
		System.out.println("\n Se eliminará el siguiente contacto:");
		System.out.print("  ");
		mostrarContacto(mContactos, numContacto - 1);
		System.out.println();
		
		do {
			System.out.print(" ¿Estás seguro? (S/N): > ");
			userInput = leer.next();
			if (userInput.equalsIgnoreCase("s")) {
				mContactos[numContacto - 1][0] = "";
				mContactos[numContacto - 1][1] = "";
				ordenarContactos(mContactos);
				System.out.println();
				System.out.println(" El contacto se ha eliminado correctamente.\n Los contactos se han reordenado.");
				error=false;
			} else {
				if (userInput.equalsIgnoreCase("n")) {
					System.out.println(" El usuario canceló la operación. No se ha realizado ningún cambio.");
					error=false;
				} else {
					error=true;
				}
			}
		} while (error);
	}

	/**
	 * SALIR
	 * @return Salir (salir del programa = true, volver al menú = false)
	 */
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

	/**
	 * ABOUT
	 */
	public static void about() {
		System.out.println(".------------------------------------------------.");
		System.out.println("|              ACERCA DE aJenda 1.4              |");
		System.out.println("|------------------------------------------------|");
		System.out.println("|          Gracias por utilizar aJenda,          |");
		System.out.println("|                 con J de Java.                 |");
		System.out.println("|                                                |");
		System.out.println("|            (c) Tomás Generelo, 2020            |");
		System.out.println("·------------------------------------------------·");

	}	
}
