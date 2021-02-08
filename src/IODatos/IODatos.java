package IODatos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

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

	public Contacto[] leerFichero() {
		Contacto vAgenda[] = new Contacto [10];
	}
	
	
	public void guardarVector(String propietario, Contacto[] vAgenda) {
		
		String titulo = "Agenda de " + propietario;
		
		if (!fichero.exists())
			fichero=new File(titulo);
		
		try {
			fw = new FileWriter(fichero);
			pw = new PrintWriter(fichero);
			for (Contacto contacto : vAgenda) {
				pw.println(contacto);
			}
		} catch(Exception e) {
			
		} finally {
//			pw.close();
//			fw.close();
//			fr.close();
		}
		
	}

}
