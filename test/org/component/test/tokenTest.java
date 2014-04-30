package org.component.test;

import static org.junit.Assert.*;

import org.component.Token;
import org.component.gestoreFile;
import org.component.Grafo;
import org.junit.Test;


public class tokenTest {
	
	Grafo g;
	
	private gestoreFile ges = new gestoreFile("");
	
	public Token t;

	@Test
	public void muoviTokenTest(){
		
		ges.setPath("C:/RobertoWorkspace/nicosia/res/input.txt");
		t = new Token(0, 0, ges.generaGrafo());
		
		t.minMove();
		
		assertEquals(12, t.getPosizione());
	
	}
	
}
