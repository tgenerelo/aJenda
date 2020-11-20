package aJenda;

import java.util.Scanner;

public class aJenda {

	public static void main(String[] args) {

		Scanner leer = new Scanner(System.in);
		int tam = 10, opcionMenu=0;
		boolean salir=false;
		String mContactos[][] = new String[tam][2];

		inicializarMatriz(mContactos);

		mContactos[2][0] = "Fulano";
		mContactos[2][1] = "123456";
		mContactos[9][0] = "Zutano";
		mContactos[9][1] = "838276";

		ordenarContactos(mContactos);
		
		do {
			opcionMenu=mostrarMenu();
			
			switch (opcionMenu) {
			case 1: {
				verContactos(mContactos);
				break;
			}
			case 2: {
				buscarContacto();
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
			
			System.out.println();
			
			salir=salir();
			
		} while (salir==false);
		
		
		
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
		System.out.println("              AGENDA - MENÚ PRINCIPAL             ");
		System.out.println("--------------------------------------------------");
		System.out.println("1) Ver contactos          4) Modificar un contacto  ");
		System.out.println("2) Buscar un contacto     5) Eliminar un contacto   ");
		System.out.println("3) Añadir un contacto     6) Salir                  ");
		
		System.out.println();
		System.out.print("Introduce la opción deseada: ");
		opcionMenu = leer.nextInt();

		System.out.println();
		
		return opcionMenu;
	}

	// VER CONTACTOS
	public static void verContactos(String mContactos[][]) {
		int agendaVacia = 0;
		for (int i = 0; i < mContactos.length; i++) {
			if (!(mContactos[i][0].equals("") & mContactos[i][1].equals(""))) {
				System.out.print("CONTACTO " + (i + 1) + ": ");
				System.out.println(mContactos[i][0] + " - " + mContactos[i][1]);
				agendaVacia++;
			}

		}
		if (agendaVacia == 0) {
			System.out.println("No se ha añadido ningún contacto.");
		}
	}

	// MOSTRAR UN CONTACTO
	public static void mostrarContacto(String mContactos[][], int numContacto) {
		System.out.print("CONTACTO " + (numContacto) + ": ");
		System.out.println(mContactos[numContacto-1][0] + " - " + mContactos[numContacto-1][1]);
	}
	
	// BUSCAR CONTACTOS
	public static void buscarContacto() {

	}

	// AÑADIR CONTACTO
	public static void agregarContacto(String mContactos[][]) {
		String nombreContacto="", numContacto="";
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Introduce el nombre del nuevo contacto: ");
		nombreContacto=leer.nextLine();
		System.out.println("Introduce el número de teléfono: ");
		numContacto=leer.nextLine();
		
		for (int i=0; i<mContactos.length; i++) {
			if (mContactos[i][0].equals("") & mContactos[i][1].equals("")) {
				mContactos[i][0]=nombreContacto;
				mContactos[i][1]=numContacto;
				System.out.println("El contacto se ha guardado con éxito como CONTACTO " + (i+1) + ".");
				break;
				
			}
		}
	}

	// MODIFICAR CONTACTO
	public static void modificarContacto(String mContactos[][]) {
		Scanner leer=new Scanner(System.in);
		int idContacto=0;
		
		System.out.print("Introduce el ID del contacto que deseas modificar: ");
		idContacto=leer.nextInt();
		
		System.out.println();
		System.out.println("Se modificará el siguiente contacto:");
		mostrarContacto(mContactos, idContacto);
		System.out.println();
		System.out.println("Nombre: ");
		mContactos[idContacto-1][0]=leer.nextLine();
		System.out.println("Telf: ");
		mContactos[idContacto-1][1]=leer.nextLine();
		
		
		System.out.println("El contacto se ha guardado correctamente.");
		
		
	}

	// ELIMINAR CONTACTO
	public static void eliminarContacto(String mContactos[][]) {
		Scanner leer=new Scanner(System.in);
		String userInput="";
		int numContacto=0;
		
		System.out.print("Introduce el ID del contacto que deseas eliminar: ");
		numContacto=leer.nextInt();
		
		System.out.println();
		System.out.println("Se eliminará el siguiente contacto:");
		mostrarContacto(mContactos, numContacto);
		System.out.println();
		System.out.println("¿Estás seguro? (S/N: )");
		userInput=leer.next();
		if (userInput.equalsIgnoreCase("s")) {
			mContactos[numContacto-1][0]="";
			mContactos[numContacto-1][1]="";
			ordenarContactos(mContactos);
			System.out.println("El contacto se ha eliminado correctamente.\nLos contactos se han reordenado.");
		}
	}

	// SALIR
	public static boolean salir() {
		Scanner leer=new Scanner(System.in);
		String userInput="";
		boolean salir=false;
		
		System.out.print("¿Quieres volver al menú? (S/N): ");
		userInput=leer.next();
		
		if (userInput.equalsIgnoreCase("s")) {
			salir=false;
		} else {
			salir=true;
		}
		
		System.out.println();
		
		return salir;
	}

}
