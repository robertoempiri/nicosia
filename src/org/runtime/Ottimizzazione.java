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

		g.toString(g);

		In_Out io = ges.generaIO();

		io.toString(io);

		Algoritmo1 alg = new Algoritmo1(g, ges.generaIO(), ges.generaArrayToken());

		alg.greedy();
		alg.io = ges.generaIO();

		for (Token t : alg.arrayToken) {
			t.reset();
		}

		alg.greedyPlus();

		Risultato result = new Risultato();

		result.setPercorso1(alg.arrayToken[0].getPercorsoEffettuato());
		result.setPercorso2(alg.arrayToken[1].getPercorsoEffettuato());
		result.setTempo1(alg.arrayToken[0].getTempo());
		result.setTempo2(alg.arrayToken[1].getTempo());

		Algoritmo2 alg2 = new Algoritmo2(g, ges.generaIO(), ges.generaArrayToken());

		alg2.branchAndBound(result);

	}

}
