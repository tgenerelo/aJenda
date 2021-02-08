package aJendaObjetos;

import IODatos.IODatos;

public class Principal {

	public static void main(String[] args) {

		boolean volver = true;

		Agenda agenda=new Agenda("Tomás", 10);

		do {
			switch (agenda.menu()) {
			case 1: {
				agenda.mostrarContactos();
				break;
			}

			case 2: {
				agenda.buscarContacto();
				break;
			}

			case 3: {
				agenda.nuevoContacto();
				break;
			}

			case 4: {
				agenda.modificarContacto();
				break;
			}

			case 5: {
				agenda.eliminarContacto();
				break;
			}

			case 6: {
				IODatos guardar = new IODatos();
				guardar.guardarVector(agenda.getvAgenda());
				volver = false;
				break;
			}
			}
			
			if (volver==true) {
				volver = agenda.volverMenu();
			}
			
		} while (volver == true);

		System.out.println("Gracias por utilizar aJenda. El programa se cerrará.");

	}

}
