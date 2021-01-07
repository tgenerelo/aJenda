package aJendaObjetos;

public class Principal {

	public static void main(String[] args) {

		int opcionMenu = 0, tam = 10;
		boolean volver = true;

		Contacto vContactos[] = new Contacto[tam];
		Agenda.inicializarVector(vContactos);
		vContactos[0] = new Contacto("Juan", "971111111");
		vContactos[1] = new Contacto("Gordon", "Freeman", "912222222");
		vContactos[2] = new Contacto("Yennefer", "de Vengerberg", "973333333");
		vContactos[3] = new Contacto("José", "Sazatornil", "945444444");
		vContactos[4] = new Contacto("Martín", "Pescador", "935555555");
		vContactos[5] = new Contacto("David Robert", "Jones", "976666666");
		vContactos[6] = new Contacto("Íñigo", "Montoya", "917777777");
		vContactos[7] = new Contacto("Alyx", "Vance", "95888888");

		do {
			switch (Agenda.menu()) {
			case 1: {
				Agenda.mostrarContactos(vContactos);
				System.out.println();
				 
				break;
			}

			case 2: {
				Agenda.buscarContacto(vContactos);
				break;
			}

			case 3: {
				Agenda.nuevoContacto(vContactos);
				break;
			}

			case 4: {
				Agenda.modificarContacto(vContactos);
				break;
			}

			case 5: {
				Agenda.eliminarContacto(vContactos);
				break;
			}

			case 6: {
				volver = false;
				break;
			}

			}
			
			if (volver=true) {
				volver = Agenda.volverMenu();
			}
			
			
		} while (volver == true);

		System.out.println("Gracias por utilizar aJenda. El programa se cerrará.");

	}

}
