package org.component.test;

import java.util.ArrayList;
import java.util.List;

import org.component.CrossCost;
import org.component.GestoreFile;
import org.component.Grafo;
import org.component.Risultato;
import org.component.Token;
import org.junit.Test;
import org.runtime.Algoritmo1;

public class CrossCostTest {
	
	private GestoreFile ges = new GestoreFile("C:/RobertoWorkspace/nicosia/res/input.txt");
	private Grafo g = ges.generaGrafo();
	private CrossCost cc = new CrossCost();
	private Algoritmo1 alg = new Algoritmo1(g, ges.generaIO(), ges.generaTokenList());
	
	@Test
	public void calcolaInterscambiTest(){
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
		cc.setT(new Token(1,0,0,g));
		cc.calcolaInterscambi(resultRitiri.getPercorsi().get(0), resultConsegne.getPercorsi().get(0));
		
		System.out.println(cc.toString());
		
		for (Integer i : cc.minCrossCost()) {
			System.out.println(i);
		}
	}
	
}
