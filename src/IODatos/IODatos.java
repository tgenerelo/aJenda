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
		fichero = new File(("Agendas/Agenda de " + propietario + ".txt"));
		if (!fichero.exists()) {
			fichero = new File("Agendas/Agenda de " + propietario + ".txt");
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
								linea = "";
								break;
							case 3:
								telefono = linea;
								linea = "";
								break;
							}

						}
					}
					Contacto contacto = new Contacto(nombre, apellido, telefono);
					agenda.nuevoContacto(contacto);
				}

			} catch (FileNotFoundException e) {

			} finally {
				try {
					fr.close();
				} catch (IOException e) {

				}
			}
			return agenda;
		} else {
			System.out.println("ERROR: No se encuentra el archivo.");
		}

		return null;
	}

	public void guardarVector(Agenda agenda) {

		String agendaFich = "Agenda de " + agenda.getPropietario();
		File directorio = new File("Agendas");
		fichero = new File(agendaFich + ".txt");
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
					if (i>0)
						pw.println();
					pw.print(agenda.getvAgenda()[i].getNombre() + ";");
					pw.print(agenda.getvAgenda()[i].getApellido() + ";");
					pw.print(agenda.getvAgenda()[i].getTelefono() + ";");
				}
				


			}
		} catch (Exception e) {

		} finally {
			pw.close();
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			fr.close();
		}

	}

}
