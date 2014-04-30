package org.runtime;

import org.component.Grafo;
import org.component.In_Out;
import org.component.Token;
import org.component.gestoreFile;

public class Ottimizzazione{
	
	public static void main(String[] args) {

		gestoreFile ges = new gestoreFile("");
		
		ges.setPath("/Users/EMPIRI/git/nicosia/nicosia-java/src/main/resources/input.txt");

		Grafo g = ges.generaGrafo();
		
		g.toString(g);
		
		In_Out io = ges.generaIO();
		
		io.toString(io);
		
		int nToken = ges.parametri("Numero mezzi m");
		
		Token[] arrayToken = new Token[nToken];
		
		System.out.println("Numero di mezzi a disposizione: "+arrayToken.length);

	}

}