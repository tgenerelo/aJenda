package aJendaObjetos;

import java.util.Scanner;

public class Agenda {

	private String propietario;
	private Contacto[] vAgenda;

	static Scanner leer = new Scanner(System.in);

	private final int NUMCONTACTOS = 100;

	public Agenda() {
		propietario = "";
		vAgenda = new Contacto[NUMCONTACTOS];
	}

	public Agenda(String propietario) {
		this.propietario = propietario;
		vAgenda = new Contacto[NUMCONTACTOS];
	}

	public Agenda(String propietario, int tam) {
		this.propietario = propietario;
		vAgenda = new Contacto[tam];
	}

	public Contacto[] getvAgenda() {
		return vAgenda;
	}

	public String getPropietario() {
		return propietario;
	}

	@Override
	public String toString() {
		return "asdfasdfasdf";
	}

	/**
	 * Menú principal
	 * 
	 * @return Devuelve al programa principal la opción escogida por el usuario.
	 */
	public int menu() {

		int opcionMenu = 0;
		boolean error = false;

		cabeceraCentrada();
		System.out.println(" 1) Ver contactos          5) Eliminar un contacto ");
		System.out.println(" 2) Buscar un contacto                             ");
		System.out.println(" 3) Añadir un contacto     6) Guardar y salir      ");
		System.out.println(" 4) Modificar un contacto  7) Salir sin guardar    ");

		System.out.println();

		do {
			error = false;
			System.out.print("Introduce la opción deseada: > ");

			try {
				opcionMenu = leer.nextInt();
			} catch (java.util.InputMismatchException e) {
				error = true;
				System.out.println("Opción no válida. Inténtalo de nuevo.");
				leer = new Scanner(System.in);
			}

			if (error == false && (opcionMenu < 1 || opcionMenu > 7)) {
				error = true;
				System.out.println("Opción no válida. Inténtalo de nuevo.");
			}

			System.out.println();

		} while (error == true);

		return opcionMenu;
	}

	public void cabeceraCentrada() {
		String cabecera1 = "Agenda de";
		String cabecera2 = "MENÚ PRINCIPAL";
		int ancho = 52;
		int anchoTexto = cabecera1.length() + propietario.length() + cabecera2.length() + 3;

		if (anchoTexto % 2 == 0) {
			cabecera2 += " ";
		}

		anchoTexto = cabecera1.length() + propietario.length() + cabecera2.length() + 3;

		if (anchoTexto > ancho) {
			ancho = anchoTexto + 5;
		}

		System.out.print("┌");
		for (int i = 0; i < ancho - 2; i++) {
			System.out.print("─");
		}

		System.out.println("┐");
		System.out.print("│");

		for (int i = 0; i < ((ancho - (anchoTexto + 2)) / 2); i++) {
			System.out.print(" ");
		}

		System.out.print(cabecera1 + " " + propietario + " - " + cabecera2);

		for (int i = 0; i < ((ancho - (anchoTexto + 2)) / 2); i++) {
			System.out.print(" ");
		}

		System.out.println("│");

		System.out.print("└");
		for (int i = 0; i < ancho - 2; i++) {
			System.out.print("─");
		}

		System.out.println("┘");
	}

	/**
	 * Mostrar contactos
	 * 
	 * @param vAgenda Vector de contactos.
	 */
	public void mostrarContactos() {
		boolean vacia = true;
		reordenarContactos();
		for (int i = 0; i < vAgenda.length; i++) {
			if (vAgenda[i] != null) {
				mostrarContacto(i);
				vacia = false;
			}
		}

		if (vacia == true) {
			System.out.println("La agenda está vacía. No hay contactos que mostrar.");
		}

		System.out.println();
	}

	/**
	 * Volver al menú
	 * 
	 * @return Devuelve si el usuario desea salir del programa (true) o si desea
	 *         regresar al menú principal (false).
	 */
	public boolean volverMenu() {
		return siNo("¿Quieres regresar al menú?");
	}

	private static boolean siNo(String mensaje) {
		String userInput;

		do {
			System.out.print(mensaje + " (S/N): > ");
			userInput = leer.next();
			System.out.println();
			if (userInput.equalsIgnoreCase("s")) {
				return true;
			} else {
				if (userInput.equalsIgnoreCase("n")) {
					return false;
				}
			}
			System.out.println("Opción no válida. Vuelve a intentarlo.");
		} while (true);
	}

	/**
	 * Busca el último contacto libre en el vector.
	 * 
	 * @param vAgenda Vector de contactos.
	 * @return Última posición libre del vector. Si no queda ninguno se devuelve el
	 *         valor -1.
	 */
	private int buscarUltimoContacto() {
		for (int i = 0; i < vAgenda.length; i++) {
			if (vAgenda[i] == null) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Añadir un nuevo contacto.
	 * 
	 * @param vAgenda Vector de contactos.
	 */
	public void nuevoContacto() {

		int ultimoContacto = buscarUltimoContacto();
		leer = new Scanner(System.in);

		String nomb = null, apell, telf;

		if (ultimoContacto != -1) {
			while (nomb == null) {
				System.out.print("Introduce el nombre del nuevo contacto: > ");
				nomb = leer.nextLine();
				if (nomb.equals(""))
					nomb = null;
			}

			System.out.print("Introduce el apellido del nuevo contacto: > ");
			apell = leer.nextLine();
			if (apell.equals(""))
				apell = null;
			System.out.print("Introduce el teléfono del nuevo contacto: > ");
			telf = leer.nextLine();
			if (telf.equals(""))
				telf = null;

			vAgenda[ultimoContacto] = new Contacto(nomb, apell, telf);

			System.out
					.println("\nEl contacto se ha añadido correctamente como CONTACTO " + (ultimoContacto + 1) + ".\n");

		} else {
			System.out.println("La agenda está llena. No se pueden añadir nuevos contactos.\n");
		}
	}

	/**
	 * Añadir un nuevo contacto en la primera posición libre del vector.
	 * 
	 * @param contacto El contacto que se incorporará al vector.
	 */
	public void nuevoContacto(Contacto contacto) {

		int ultimoContacto = buscarUltimoContacto();
		leer = new Scanner(System.in);

		if (ultimoContacto != -1) {
			vAgenda[ultimoContacto] = contacto;
		}
	}

	/**
	 * Reorganiza los contactos para que no haya huecos libres.
	 * 
	 * @param vAgenda Vector de contactos que se reordenará.
	 */
	private void reordenarContactos() {
		for (int i = 0; i < vAgenda.length - 1; i++) {
			if (vAgenda[i] == null) {
				vAgenda[i] = vAgenda[i + 1];
				vAgenda[i + 1] = null;
			}
		}
	}

	public void mostrarContacto(int id) {
		System.out.println("  CONTACTO " + (id + 1) + ": " + vAgenda[id].toString());
	}

	/**
	 * Modificar un contacto existente.
	 * 
	 * @param vAgenda Vector de contactos.
	 */
	public void modificarContacto() {
		leer = new Scanner(System.in);
		int id = 0;

		String nomb = null, apell, telf;

		System.out.print("Introduce el ID del contacto que deseas modificar: > ");
		id = leer.nextInt() - 1;
		System.out.println("\nSe modificará el siguiente contacto:");
		mostrarContacto(id);
		System.out.println();
		if (siNo("¿Estás seguro?") == true) {
			leer = new Scanner(System.in);
			while (nomb == null) {
				System.out.print("Introduce el nuevo nombre del contacto: > ");
				nomb = leer.nextLine();
				if (nomb.equals("")) {
					System.out.println("Error: El nombre no puede estar vacío.");
					nomb = null;
				}
			}
			vAgenda[id].setNombre(nomb);
			System.out.print("Introduce el nuevo apellido del contacto: > ");
			apell = leer.nextLine();
			if (apell.equals(""))
				apell = null;
			vAgenda[id].setApellido(apell);
			System.out.print("Introduce el nuevo teléfono del contacto: > ");
			telf = leer.nextLine();
			if (telf.equals(""))
				telf = null;
			vAgenda[id].setTelefono(telf);

			System.out.println("\nCONTACTO " + (id + 1) + " se ha modificado correctamente.\n");

		} else {
			System.out.println("Se ha cancelado la operación. No se han realizado cambios.");
		}
	}

	/**
	 * Elimina un contacto especificado por el usuario.
	 * 
	 * @param vAgenda Vector de contactos.
	 */
	public void eliminarContacto() {
		leer = new Scanner(System.in);
		int id = 0;

		System.out.print("Introduce el ID del contacto que deseas eliminar: > ");
		id = leer.nextInt();

		if (vAgenda[id - 1] != null) {
			System.out.println("\nSe eliminará el siguiente contacto:");
			mostrarContacto(id - 1);
			System.out.println();
			if (siNo("¿Estás seguro?") == true) {
				vAgenda[id - 1] = null;
				reordenarContactos();
				System.out.println("CONTACTO " + id + " se ha eliminado correctamente.");
				System.out.println("Los contactos se han reordenado.\n");
			} else {
				System.out.println("Se ha cancelado la operación. No se han realizado cambios.\n");
			}
		} else {
			System.out.println("\n El contacto especificado no existe.\n");
		}
	}

	public void buscarContacto() {

		String userInput = "";
		int coincidencias = 0;
		leer = new Scanner(System.in);

		System.out.print("Introduce un término de búsqueda: > ");
		userInput = leer.nextLine();

		for (int i = 0; i < vAgenda.length; i++) {
			boolean encontrado = false;

			if (vAgenda[i] != null && vAgenda[i].getNombre() != null) {
				for (int j = 0; j < (vAgenda[i].getNombre().length() - userInput.length()) + 1; j++) {
					if (userInput.substring(0, userInput.length())
							.equalsIgnoreCase(vAgenda[i].getNombre().substring(j, j + userInput.length()))) {
						encontrado = true;
						break;
					}
				}
			}

			if (encontrado == false && vAgenda[i] != null && vAgenda[i].getApellido() != null) {
				for (int j = 0; j < (vAgenda[i].getApellido().length() - userInput.length()) + 1; j++) {
					if (userInput.substring(0, userInput.length())
							.equalsIgnoreCase(vAgenda[i].getApellido().substring(j, j + userInput.length()))) {
						encontrado = true;
						break;
					}
				}
			}

			if (encontrado == false && vAgenda[i] != null && vAgenda[i].getTelefono() != null) {
				for (int j = 0; j < (vAgenda[i].getTelefono().length() - userInput.length()) + 1; j++) {
					if (userInput.substring(0, userInput.length())
							.equalsIgnoreCase(vAgenda[i].getTelefono().substring(j, j + userInput.length()))) {
						encontrado = true;
						break;
					}
				}
			}

			if (encontrado == true) {
				coincidencias++;
				if (coincidencias == 1)
					System.out.println("\nSe han encontrado las siguientes coincidencias:");
				mostrarContacto(i);
			}
		}

		if (coincidencias == 0) {
			System.out.println("No se han encontrado coincidencias.\n");
		}

		System.out.println();
	}
}
