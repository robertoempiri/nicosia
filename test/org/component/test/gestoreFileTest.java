package org.component.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.component.Grafo;
import org.component.GestoreFile;
import org.junit.Test;

public class gestoreFileTest {
	
	private GestoreFile ges = new GestoreFile("");;
	
	Grafo g;
	
	@Test
	public void ottieniDimTest(){

		ges.setPath("C:/RobertoWorkspace/nicosia/res/input.txt");
		
		System.out.println("Test ottieniDim");
		
		assertEquals(15, ges.ottieniDim("Tempi tij"));		
		
	}
	
	@Test
	public void generaGrafoTest(){
		
		ges.setPath("C:/RobertoWorkspace/nicosia/res/input.txt");
		
		assertEquals(15, ges.generaGrafo().getM());
		assertEquals(15,ges.generaGrafo().getN());
		
		
	}
	
	@Test 
	public void popolaGrafoTest(){
		
		ges.setPath("C:/RobertoWorkspace/nicosia/res/input.txt");
		
		g = new Grafo(15, 15);
		
		ges.popolaGrafo(g, 15);
		
//		System.out.println(g.getElement(g, 2, 1));
		
		assertEquals(82,g.getElement(g, 2, 1));
		
	}
	
	@Test
	public void toStringTest(){
		
		ges.setPath("C:/RobertoWorkspace/nicosia/res/input.txt");
	
		g = new Grafo(2,2);
		
		g.setElement(0, 0, 3);
		g.setElement(1, 0, 2);
		g.setElement(0, 1, 1);
		g.setElement(1, 1, 12);
		
		g.toString(g);
		
		g = ges.generaGrafo();
		
		g.toString(g);
		
		
	}
	
	@Test
	public void popolaIOTest(){
		
		ges.setPath("C:/RobertoWorkspace/nicosia/res/input.txt");
		
		List<Integer> consegne = new ArrayList<Integer>();
		ges.popolaIO(consegne, "localita consegna ci");
		
		List<Integer> ritiri = new ArrayList<Integer>();
		ges.popolaIO(ritiri, "localita ritiro ri");
		
		assertTrue(7 == consegne.get(2));
		assertTrue(4 == ritiri.get(1));
		assertTrue(14 == consegne.get(6));
		
	}
	
}
