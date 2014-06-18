package org.component.test;

import static org.junit.Assert.*;

import java.util.List;

import org.component.Grafo;
import org.component.GestoreFile;
import org.junit.Test;

public class grafoTest {

	private GestoreFile ges = new GestoreFile("C:/RobertoWorkspace/nicosia/res/input.txt");;
	
	Grafo g;
	
	@Test
	public void estraiArchi() {
		g = ges.generaGrafo();
		List<Integer> a = g.estraiArchi(0);
		g.toString(a);
		
		assertTrue(89 == a.get(1));
		
	}
	
	@Test
	public void toStringTest() {
		g = ges.generaGrafo();
		System.out.println(g.toString());
	}

}
