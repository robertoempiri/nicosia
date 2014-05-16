package org.runtime;

import org.component.Grafo;
import org.component.In_Out;
import org.component.GestoreFile;

public class Ottimizzazione{
	
	public static void main(String[] args) {

		GestoreFile ges = new GestoreFile("");
		
		ges.setPath("C:/RobertoWorkspace/nicosia/res/input.txt");

		Grafo g = ges.generaGrafo();
		
		g.toString(g);
		
		In_Out io = ges.generaIO();
		
		io.toString(io);
		
		Algoritmo1 alg = new Algoritmo1(g, ges.generaIO(), ges.generaArrayToken());
		
		alg.greedy();
		alg.io = ges.generaIO();
		
		for (int i = 0; i<alg.arrayToken.length; i++){
			alg.arrayToken[i].reset();
		}
		
		alg.greedyPlus();
		
	}

}
