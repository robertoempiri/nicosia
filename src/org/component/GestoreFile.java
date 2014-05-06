package org.component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GestoreFile {

	private Grafo g;
	private String path;
	private FileReader f;
	private BufferedReader b;
	private In_Out io;
	
	public GestoreFile(String path){
		this.path = path;
	}

	/** Metodi di Grafo **/

	public Grafo generaGrafo(){

		g = new Grafo(0, 0);

		g.setM(ottieniDim("Tempi tij"));

		g.setN(ottieniDim("Tempi tij"));

		popolaGrafo(g, g.getM());

		return g;

	}

	public void popolaGrafo(Grafo g, int i) {

		try {
			f = new FileReader(path);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString()+" errore fileNotFound");
			e.printStackTrace();
		}

		b = new BufferedReader(f);

		boolean finito = false;
		boolean popola = false;
		String s = null;
		int z = 0;
		int j = 0;

		//		System.out.println("Dimensioni grafo: "+g.getM()+"x"+g.getN());

		while (!finito){

			try {
				s = b.readLine();
			} catch (IOException e) {
				System.out.println("Something fail on bufferedreader");
				e.printStackTrace();
			}

			//			System.out.println("Riga di input.txt = "+s);

			if (popola && z<i) {

				for (j = 0; j<i; j++){

					if (s.contains(" ")) {

						//						System.out.println("Elemento da inject: "+Integer.parseInt((s.substring(0, s.indexOf(" "))))+";");

						g.setElement(j, z, Integer.parseInt((s.substring(0, s.indexOf(" ")))));

						s = s.substring(s.indexOf(" ")+1);

					} else {
						//						System.out.println("Elemento da inject: "+Integer.parseInt(s.substring(0, s.length()))+";");

						g.setElement(j, z, Integer.parseInt((s.substring(0, s.length()))));
					}

					//					System.out.println(s);

					//					System.out.println("elemento: ["+j+"],["+z+"] = "+g.getElement(g, j, z));
				}

				z++;	

			}

			if (z==i) {
				finito = true;
			}

			if (s!=null && s.equals("Tempi tij")) popola = true;

		}

		try {
			b.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int ottieniDim(String alpha) {

		try {
			f = new FileReader(path);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString()+" errore fileNotFound");
			e.printStackTrace();
		}

		b = new BufferedReader(f);

		String s = null;

		boolean finito = false;
		boolean misura = false;
		int i = 1;

		while (!finito){

			try {
				s = b.readLine();
			} catch (IOException e) {
				System.out.println("Something fail on bufferedreader");
				e.printStackTrace();
			}

			while (misura){

				s = s.substring(s.indexOf(" ")+1);

				if (!s.contains(" ")) {
					misura = false;
					finito = true;
				}

				//				System.out.print("Dimensioni di: {"+s+"}");
				//				System.out.println(" = "+i);

				i++;

			}

			if (s!=null && s.equals(alpha)) misura = true;

		}

		try {
			b.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	/** Metodi di I/O **/

	public In_Out generaIO() {

		int[] consegne = new int[ottieniDim("localita consegna ci")];
		int[] ritiri = new int[ottieniDim("localita ritiro ri")];

		popolaIO(consegne, "localita consegna ci");
		popolaIO(ritiri, "localita ritiro ri");

		io = new In_Out(consegne, ritiri);

		return io;

	}

	public void popolaIO(int[] a, String alpha){

		try {
			f = new FileReader(path);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString()+" errore fileNotFound");
			e.printStackTrace();
		}

		b = new BufferedReader(f);

		boolean finito = false;
		boolean popola = false;
		String s = null;
		int j;

		while (!finito){

			try {
				s = b.readLine();
			} catch (IOException e) {
				System.out.println("Something fail on bufferedreader");
				e.printStackTrace();
			}

			//			System.out.println("Riga di input.txt = "+s);

			if (popola) {

				for (j = 0; j<a.length; j++){

					if (s.contains(" ")) {

						//						System.out.println("Elemento da inject: "+Integer.parseInt((s.substring(0, s.indexOf(" "))))+";");

						a[j] = Integer.parseInt((s.substring(0, s.indexOf(" "))));

						s = s.substring(s.indexOf(" ")+1);

					} else {
						//					System.out.println("Elemento da inject: "+Integer.parseInt(s.substring(0, s.length()))+";");

						a[j] = Integer.parseInt((s.substring(0, s.length())));
					}

					//				System.out.println(s);

					//					System.out.println("elemento: ["+j+"]= "+a[j]);
				}

				finito = true;
			}

			if (s!=null && s.equals(alpha)) popola = true;

		}



	}
	
	/** Metodi di parametri **/
	
	public int parametri(String alpha){
		
		try {
			f = new FileReader(path);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString()+" errore fileNotFound");
			e.printStackTrace();
		}

		b = new BufferedReader(f);

		boolean finito = false;
		boolean get = false;
		String s = null;
		int a = 0;
		
		while (!finito){

			try {
				s = b.readLine();
			} catch (IOException e) {
				System.out.println("Something fail on bufferedreader");
				e.printStackTrace();
			}
			
			if (get) {
				a = Integer.parseInt((s.substring(0, s.length())));
				finito = true;
			}
		
			if (s!=null && s.equals(alpha)) {
				get = true;
			}
		
		}
		
		return a;
		
	}

	/** Metodi di classe **/

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
}
