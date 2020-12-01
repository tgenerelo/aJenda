package aJenda;

import java.util.Scanner;

public class aJenda {

	public static void main(String[] args) {

		Scanner leer = new Scanner(System.in);
		int tam = 10, opcionMenu = 0;
		boolean salir = false;
		String mContactos[][] = new String[tam][2];

		Metodos.inicializarMatriz(mContactos);

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

		Metodos.ordenarContactos(mContactos);

		do {
			boolean error = false;
			do {
				opcionMenu = Metodos.mostrarMenu();
				if (opcionMenu < 1 || opcionMenu > 6) {
					if (opcionMenu == 22688) {
						Metodos.about();
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
				Metodos.verContactos(mContactos);
				break;
			}
			case 2: {
				Metodos.buscarContacto(mContactos);
				break;
			}
			case 3: {
				Metodos.agregarContacto(mContactos);
				break;
			}
			case 4: {
				Metodos.modificarContacto(mContactos);
				break;
			}
			case 5: {
				Metodos.eliminarContacto(mContactos);
				
				break;
			}
			case 6: {
				break;
			}
			}

			if (opcionMenu == 6) {
				salir = true;
			} else {
				salir = Metodos.salir();
			}

		} while (!salir);

		System.out.println("Gracias por utilizar aJenda.\nEl programa se cerrará.");
	}
	
}
