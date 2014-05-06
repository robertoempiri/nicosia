package org.component.test;

import static org.junit.Assert.*;

import org.component.Grafo;
import org.component.GestoreFile;
import org.junit.Test;

public class grafoTest {

	private GestoreFile ges = new GestoreFile("");;
	
	Grafo g;
	
	@Test
	public void estraiArchi() {
		ges.setPath("C:/RobertoWorkspace/nicosia/res/input.txt");
		g = ges.generaGrafo();
		int[] a = g.estraiArchi(0);
		for (int i = 0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
		
		assertEquals(89, a[1]);
		
	}

}
