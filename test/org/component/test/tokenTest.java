package org.component.test;

import static org.junit.Assert.*;

import org.component.In_Out;
import org.component.Token;
import org.component.GestoreFile;
import org.junit.Test;


public class tokenTest {
	
	private GestoreFile ges = new GestoreFile("C:/RobertoWorkspace/nicosia/res/input.txt");
	
	public Token t;

	@Test
	public void minMoveTest(){
		
		t = new Token(1, 1, 0, ges.generaGrafo());

		t.minMove();
		
		assertEquals(1, t.getPrevious());		
		assertEquals(13, t.getPosizione());
		
		t.minMove();
		
		assertEquals(13, t.getPrevious());
		assertEquals(15, t.getPosizione());
		
		t.minMove();
		
		assertEquals(15, t.getPrevious());
		assertEquals(13, t.getPosizione());
		assertEquals(220, t.getTempo());
	
	}
	
	@Test
	public void minMoveNoPreviousTest(){
		
		t = new Token(1, 1, 0, ges.generaGrafo());

		
		t.minMove();
		
		assertEquals(13, t.getPosizione());
		
		t.minMove();
		
		assertEquals(15, t.getPosizione());
		
		t.minMoveNoPrevious();
		
		assertEquals(1, t.getPosizione());
		assertEquals(224, t.getTempo());
	
	}
	
	@Test
	public void minMoveNoPreviousTest2(){

		t = new Token(1, 1, 0, ges.generaGrafo());

		t.minMoveNoPrevious();
		assertEquals(13, t.getPosizione());
		
		t.minMoveNoPrevious();
		assertEquals(15, t.getPosizione());

		t.minMoveNoPrevious();
		assertEquals(1, t.getPosizione());
		assertEquals(224, t.getTempo());

	}
	
	@Test
	public void movePercorsoTest(){

		t = new Token(1, 1, 0, ges.generaGrafo());

		In_Out io = ges.generaIO();
		t.movePercorso(io.getConsegne());
		assertEquals(855,t.getTempo());
		assertEquals(14,t.getPosizione());
	}
	
	@Test 
	public void movePercorsoAndRitornoTest(){

		t = new Token(1, 1, 0, ges.generaGrafo());

		In_Out io = ges.generaIO();

		t.movePercorso(io.getConsegne());
		t.move(1);
		assertEquals(944,t.getTempo());
		assertEquals(1,t.getPosizione());
	}
	
	@Test
	public void move2IO(){

		t = new Token(1, 1, 0, ges.generaGrafo());
		In_Out io = ges.generaIO();
		assertTrue(t.move2IO(io));

	}
	
	@Test
	public void moveNot2IO(){

		t = new Token(1, 1, 0, ges.generaGrafo());
		In_Out io = ges.generaIO();
		
		while(!io.verificaCompleto()) {
			t.move2IO(io);
			t.consegnaRitiro(io, t.getPosizione());
			System.out.println(io.toString());
		}
		
		assertFalse(t.move2IO(io));
		
	}
	
	@Test
	public void minMove2IO(){
		t = new Token(1, 1, 0, ges.generaGrafo());
		In_Out io = ges.generaIO();
		t.minMove2IO(io);
		assertEquals(13, t.getPosizione());
		assertEquals(74, t.getTempo());
		t.consegnaRitiro(io, t.getPosizione());
		assertEquals(94, t.getTempo());
	}
	
	@Test
	public void consegnaRitiroTest(){

		t = new Token(4,1,0, ges.generaGrafo());
		In_Out io = ges.generaIO();
		t.consegnaRitiro(io, t.getPosizione());
		assertEquals(20, t.getTempo());
	
	}
	
	@Test
	public void resetTest(){
		
		t = new Token(4,3,12, ges.generaGrafo());
		int[] a = new int[2];
		a[0] = 1;
		a[1] = 3;
		t.setPercorsoEffettuato(a);
		
		assertEquals(4, t.getPosizione());
		assertEquals(3, t.getPrevious());
		assertEquals(12, t.getTempo());
		assertEquals(1, t.getPercorsoEffettuato()[0]);
		assertEquals(3, t.getPercorsoEffettuato()[1]);
		
		t.reset();
		
		assertEquals(1, t.getPosizione());
		assertEquals(1, t.getPrevious());
		assertEquals(0, t.getTempo());
		assertEquals(0, t.getPercorsoEffettuato().length);

	}
	
}
