package org.runtime.test;

import static org.junit.Assert.*;

import org.runtime.Algoritmo1;
import org.component.*;
import org.junit.Test;

public class Algoritmo1Test {

	gestoreFile ges = new gestoreFile("C:/RobertoWorkspace/nicosia/res/input.txt");
	In_Out io = ges.generaIO();
	Grafo g = ges.generaGrafo();
	Token[] arrayToken = new Token[ges.parametri("Numero mezzi m")];
	Algoritmo1 alg;

	@Test
	public void greedyTest() {
		
		for (int i = 0;i<arrayToken.length; i++){
			arrayToken[i] = new Token(1,0,0,g);
		}
		
		alg = new Algoritmo1(g, io, arrayToken);
		
		alg.greedy();
		
		for (int i = 0;i<arrayToken.length; i++){
			assertEquals(1, arrayToken[i].getPosizione());
		}
	}

}
