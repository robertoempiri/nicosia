package org.runtime;

import org.component.Grafo;
import org.component.In_Out;
import org.component.GestoreFile;
import org.component.Token;

public class Ottimizzazione{

	public static void main(String[] args) {

		GestoreFile ges = new GestoreFile("");

		ges.setPath("C:/RobertoWorkspace/nicosia/res/input.txt");

		Grafo g = ges.generaGrafo();

		System.out.println(g.toString());

		In_Out io = ges.generaIO();

		System.out.println(io.toString());

		Algoritmo1 alg = new Algoritmo1(g, ges.generaIO(), ges.generaTokenList());

		alg.greedy();
		alg.io = ges.generaIO();

		for (Token t : alg.tokenList) {
			t.reset();
		}

		alg.greedyPlus();

		Risultato result = new Risultato();
		for (Token t : alg.tokenList) {
			result.getPercorsi().put(alg.tokenList.indexOf(t)+1, t.getPercorsoEffettuato());
			result.getTempi().put(alg.tokenList.indexOf(t)+1, t.getTempo());
		}
		
		System.out.println(result.toString());

//		Algoritmo2 alg2 = new Algoritmo2(g, ges.generaIO(), ges.generaArrayToken());
//
//		alg2.branchAndBound(result);

	}

}
