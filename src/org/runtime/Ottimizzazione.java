package org.runtime;

import java.util.ArrayList;
import java.util.List;

import org.component.Grafo;
import org.component.In_Out;
import org.component.GestoreFile;
import org.component.Risultato;
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
			result.getPercorsi().add(t.getPercorsoEffettuato());
			result.getTempi().add(t.getTempo());
		}
		
		System.out.println(result.toString());

		alg.io = ges.generaIO();
		for (Token t : alg.tokenList) {
			t.reset();
		}

		alg.greedyPlusForRitiri();
		
		Risultato resultRitiri = new Risultato();
		for (Token t : alg.tokenList) {
			resultRitiri.getPercorsi().add(t.getPercorsoEffettuato());
			resultRitiri.getTempi().add(t.getTempo());
		}
		
		System.out.println(resultRitiri.toString());
		
		
		alg.io = ges.generaIO();
		for (Token t : alg.tokenList) {
			List<Integer> temp = new ArrayList<Integer>();
			temp = resultRitiri.getPercorsi().get(alg.tokenList.indexOf(t));
			t.lega(temp);
		}

		alg.greedyPlusForConsegne();
		
		Risultato resultConsegne = new Risultato();
		for (Token t : alg.tokenList) {
			resultConsegne.getPercorsi().add(t.getPercorsoEffettuato());
			resultConsegne.getTempi().add(t.getTempo());
		}
		
		System.out.println(resultConsegne.toString());
//		Algoritmo2 alg2 = new Algoritmo2(g, ges.generaIO(), new Token(1, 1, 0, ges.generaGrafo()), ges.generaTokenList());
//
//		alg2.branchAndBound(resultRitiri, resultConsegne);

		Algoritmo3 alg3 = new Algoritmo3(g, ges.generaIO(), new Token(1, 1, 0, ges.generaGrafo()), ges.generaTokenList());
		alg3.solutionBuilder(resultRitiri, resultConsegne);
		
	}

}
