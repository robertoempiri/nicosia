package org.component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

		g = new Grafo();

		popolaGrafo(g);

		return g;

	}

	public void popolaGrafo(Grafo g) {
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
		
		while (!finito){
			
			List<Integer> nextLine = new ArrayList<Integer>();
			
			while (popola && s!= null) {
				
				if (s.contains(" ")){
					nextLine.add(Integer.parseInt(s.substring(0, s.indexOf(" "))));
					s = s.substring(s.indexOf(" ")+1);
				} else {
					nextLine.add(Integer.parseInt(s.substring(0, s.length())));
					s = null;
					g.getGrafo().add(nextLine);
				}
			}
			
			try {
				s = b.readLine();
			} catch (IOException e) {
				System.out.println("Something fail on bufferedreader");
				e.printStackTrace();
			}
			
			if (s!=null && s.equals("Tempi tij")) {
				popola = true;
				try {
					s = b.readLine();
				} catch (IOException e) {
					System.out.println("Something fail on bufferedreader");
					e.printStackTrace();
				}
			} else if (s==null) {
				finito = true;
			}
		}
		try {
			b.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	/** Metodi di I/O **/

	public In_Out generaIO() {

		List<Integer> consegne = new ArrayList<Integer>(); //int[ottieniDim("localita consegna ci")];
		List<Integer> ritiri = new ArrayList<Integer>(); //int[ottieniDim("localita ritiro ri")];

		popolaIO(consegne, "localita consegna ci");
		popolaIO(ritiri, "localita ritiro ri");

		io = new In_Out(consegne, ritiri);

		return io;

	}

	public void popolaIO(List<Integer> a, String alpha){
		
		boolean finito = false;
		boolean popola = false;
		String s = null;
		
		try {
			f = new FileReader(path);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString()+" errore fileNotFound");
			e.printStackTrace();
		}

		b = new BufferedReader(f);

		while (!finito){

			try {
				s = b.readLine();
			} catch (IOException e) {
				System.out.println("Something fail on bufferedreader");
				e.printStackTrace();
			}

			while (popola) {
				if (s.contains(" ")) {

					a.add(Integer.parseInt((s.substring(0, s.indexOf(" ")))));

					s = s.substring(s.indexOf(" ")+1);

				} else {

					a.add(Integer.parseInt((s.substring(0, s.length()))));
					popola = false;
					finito = true;
				}
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
	
	public List<Token> generaTokenList(){
		
		int nToken = parametri("Numero mezzi m");
		
		List<Token> tokenList = new ArrayList<Token>();
		
		System.out.println("Numero di mezzi a disposizione: "+nToken);
		
		for (int i = 0; i<nToken; i++){
			tokenList.add(new Token(1,0,0,g));
		}
		
		return tokenList;
	}

	/** Metodi di classe **/

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
}
