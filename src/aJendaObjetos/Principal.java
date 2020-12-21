package aJendaObjetos;

public class Principal {

	public static void main(String[] args) {

		int opcionMenu = 0, tam = 10;
		boolean salir = false;

		Contacto vContactos[] = new Contacto[tam];
		Metodos.inicializarVector(vContactos);
		vContactos[0] = new Contacto("Juan", "971111111");
		vContactos[1] = new Contacto("Gordon", "Freeman", "912222222");
		vContactos[2] = new Contacto("Yennefer", "de Vengerberg", "973333333");
		vContactos[3] = new Contacto("José", "Sazatornil", "945444444");
		vContactos[4] = new Contacto("Martín", "Pescador", "935555555");
		vContactos[5] = new Contacto("David Robert", "Jones", "976666666");
		vContactos[6] = new Contacto("Íñigo", "Montoya", "917777777");
		vContactos[7] = new Contacto("Alyx", "Vance", "95888888");

		do {
			switch (Metodos.menu()) {
			case 1: {
				Metodos.mostrarContactos(vContactos);
				System.out.println();
				salir = Metodos.volverMenu(); 
				break;
			}

			case 2: {

				break;
			}

			case 3: {

				break;
			}

			case 4: {

				break;
			}

			case 5: {

				break;
			}

			case 6: {
				salir = true;
				break;
			}

			}
		} while (salir == false);

		System.out.println("Gracias por utilizar aJenda. El programa se cerrará.");

	}

}
