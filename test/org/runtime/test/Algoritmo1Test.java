package org.runtime.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.runtime.Algoritmo1;
import org.component.*;
import org.junit.Test;

public class Algoritmo1Test {

	GestoreFile ges = new GestoreFile("C:/RobertoWorkspace/nicosia/res/input.txt");
	In_Out io = ges.generaIO();
	Grafo g = ges.generaGrafo();
	int nToken = ges.parametri("Numero mezzi m");
	List<Token> tokenList = new ArrayList<Token>();
	Algoritmo1 alg;

	@Test
	public void greedyTest() {
		
		for (int i = 0;i<nToken; i++){
			tokenList.add(new Token(1,0,0,g));
		}
		
		alg = new Algoritmo1(g, io, tokenList);
		
		alg.greedy();
		
		for (Token t : tokenList) {
			assertEquals(1, t.getPosizione());
		}
	}
	
	@Test
	public void greedyPlusTest() {
		
		for (int i = 0;i<nToken; i++){
			tokenList.add(new Token(1,0,0,g));
		}
		
		alg = new Algoritmo1(g, io, tokenList);
		
		alg.greedyPlus();
		
		for (Token t : tokenList) {
			assertEquals(1, t.getPosizione());
		}
		
	}

}
