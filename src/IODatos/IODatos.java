package IODatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import aJendaObjetos.Agenda;
import aJendaObjetos.Contacto;

public class IODatos {
	private File fichero;
	private FileWriter fw;
	private PrintWriter pw;
	private FileReader fr;
	private Scanner leer;

	public IODatos() {
		fichero = null;
		fw = null;
		pw = null;
		fr = null;
		leer = null;
	}

	public Agenda leerFichero(String propietario) {
		Agenda agenda = new Agenda();
		fichero = new File(("Agendas/Agenda de " + propietario));
		if (!fichero.exists()) {
			fichero = new File("Agendas/Agenda de " + propietario);
			return new Agenda(propietario);
		}

		String aux = null;
		int cont = 0;
		String linea = "";
		String nombre = null;
		String apellido = null;
		String telefono = null;

		if (fichero.exists()) {
			agenda = new Agenda(propietario);

			try {

				fr = new FileReader(fichero);
				leer = new Scanner(fr);

				while (leer.hasNext()) {
					cont = 0;
					aux = leer.nextLine();
					for (int i = 0; i < aux.length(); i++) {
						if (!aux.substring(i, i + 1).equals(";")) {
							linea += aux.substring(i, i + 1);
						} else {
							cont++;
							switch (cont) {

							case 1:
								nombre = linea;
								linea = "";
								break;

							case 2:
								apellido = linea;
								if (apellido.equals(""))
									apellido = null;
								linea = "";
								break;

							case 3:
								telefono = linea;
								if (telefono.equals(""))
									telefono = null;
								linea = "";
								break;
							}
						}
					}
					Contacto contacto = new Contacto(nombre, apellido, telefono);
					agenda.nuevoContacto(contacto);
				}

			} catch (FileNotFoundException e) {
				System.out.println("ERROR 3: No se ha encontrado el archivo.");
			} finally {
				try {
					fr.close();
				} catch (IOException e) {
					System.out.println("ERROR 4: Error al cerrar fr.");
				}
			}
			return agenda;
		} else {
			System.out.println("ERROR 1: No se encuentra el archivo.");
		}

		return null;
	}

	public void guardarVector(Agenda agenda) {

		String agendaFich = "Agenda de " + agenda.getPropietario();
		File directorio = new File("Agendas");
		fichero = new File(agendaFich);
		String ruta = directorio + "/" + fichero;

		if (!directorio.exists())
			directorio.mkdir();

		if (!fichero.exists())
			fichero = new File(ruta);

		try {
			fw = new FileWriter(ruta);
			pw = new PrintWriter(ruta);

			for (int i = 0; i < agenda.getvAgenda().length; i++) {

				if (agenda.getvAgenda()[i] != null) {
					if (i > 0)
						pw.println();

					if (agenda.getvAgenda()[i].getNombre() != null)
						pw.print(agenda.getvAgenda()[i].getNombre());
					pw.print(";");

					if (agenda.getvAgenda()[i].getApellido() != null)
						pw.print(agenda.getvAgenda()[i].getApellido());
					pw.print(";");

					if (agenda.getvAgenda()[i].getTelefono() != null)
						pw.print(agenda.getvAgenda()[i].getTelefono());
					pw.print(";");
				}
			}
		} catch (Exception e) {
			
		} finally {
			try {
				pw.close();
				fw.close();
//				fr.close();
			} catch (IOException e) {
				System.out.println("ERROR 2: Hubo un problema cerrando pw, fw o fr.");
			}

		}

	}

}
