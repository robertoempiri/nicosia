package org.component.test;

import static org.junit.Assert.*;

import org.component.In_Out;
import org.component.Token;
import org.component.gestoreFile;
import org.component.Grafo;
import org.junit.Test;


public class tokenTest {
	
	Grafo g;
	
	private gestoreFile ges = new gestoreFile("");
	
	public Token t;

	@Test
	public void minMoveTest(){
		
		ges.setPath("C:/RobertoWorkspace/nicosia/res/input.txt");
		t = new Token(0, 0, 0);
		g = ges.generaGrafo();
		
		t.minMove(g);
		
		assertEquals(0, t.getPrevious());		
		assertEquals(12, t.getPosizione());
		
		t.minMove(g);
		
		assertEquals(12, t.getPrevious());
		assertEquals(14, t.getPosizione());
		
		t.minMove(g);
		
		assertEquals(14, t.getPrevious());
		assertEquals(12, t.getPosizione());
		assertEquals(220, t.getTempo());
	
	}
	
	@Test
	public void minMoveNoPreviousTest(){
		
		ges.setPath("C:/RobertoWorkspace/nicosia/res/input.txt");
		t = new Token(0, 0, 0);
		g = ges.generaGrafo();
		
		t.minMove(g);
		
		assertEquals(12, t.getPosizione());
		
		t.minMove(g);
		
		assertEquals(14, t.getPosizione());
		
		t.minMoveNoPrevious(g);
		
		assertEquals(0, t.getPosizione());
		assertEquals(224, t.getTempo());
	
	}
	
	@Test
	public void minMoveNoPreviousTest2(){

		ges.setPath("C:/RobertoWorkspace/nicosia/res/input.txt");
		t = new Token(0, 0, 0);
		g = ges.generaGrafo();

		t.minMoveNoPrevious(g);
		assertEquals(12, t.getPosizione());
		
		t.minMoveNoPrevious(g);
		assertEquals(14, t.getPosizione());

		t.minMoveNoPrevious(g);
		assertEquals(0, t.getPosizione());
		assertEquals(224, t.getTempo());

	}
	
	@Test
	public void movePercorsoTest(){
		ges.setPath("C:/RobertoWorkspace/nicosia/res/input.txt");
		t = new Token(0, 0, 0);
		g = ges.generaGrafo();
		In_Out io = ges.generaIO();
		t.movePercorso(io.getConsegne(),g);
		assertEquals(855,t.getTempo());
		assertEquals(13,t.getPosizione());
	}
	
	@Test 
	public void movePercorsoAndRitornoTest(){
		ges.setPath("C:/RobertoWorkspace/nicosia/res/input.txt");
		t = new Token(0, 0, 0);
		g = ges.generaGrafo();
		In_Out io = ges.generaIO();
//		io.toString(io);
		t.movePercorso(io.getConsegne(), g);
		t.move(1, g);
		assertEquals(944,t.getTempo());
		assertEquals(0,t.getPosizione());
	}
}
