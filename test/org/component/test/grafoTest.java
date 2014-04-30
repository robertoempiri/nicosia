package org.component.test;

import static org.junit.Assert.*;

import org.component.Grafo;
import org.component.gestoreFile;
import org.junit.Test;

public class grafoTest {

	private gestoreFile ges = new gestoreFile("");;
	
	Grafo g;
	
	@Test
	public void estraiArchi() {
		ges.setPath("/Users/EMPIRI/git/nicosia/nicosia-java/src/main/resources/input.txt");
		g = ges.generaGrafo();
		int[] a = g.estraiArchi(g, 0);
		for (int i = 0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
		
		assertEquals(89, a[1]);
		
	}

}
