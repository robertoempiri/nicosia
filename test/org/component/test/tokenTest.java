package org.component.test;

import static org.junit.Assert.*;

import org.component.In_Out;
import org.component.Token;
import org.component.gestoreFile;
import org.junit.Test;


public class tokenTest {
	
	private gestoreFile ges = new gestoreFile("C:/RobertoWorkspace/nicosia/res/input.txt");
	
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
	public void moveToAIO(){

		t = new Token(1, 1, 0, ges.generaGrafo());
		In_Out io = ges.generaIO();
		t.moveToAIO(io.getConsegne());
		assertEquals(3, t.getPosizione());
		assertEquals(82, t.getTempo());
	}
	
	@Test
	public void moveNotToAIO(){

		t = new Token(1, 1, 0, ges.generaGrafo());
		In_Out io = ges.generaIO();
		int fine = io.getConsegne().length;
		
		for(int i = 0; i<fine; i++){
			t.moveToAIO(io.getConsegne());
			t.consegnaRitiro(io, t.getPosizione());
		}
		
		assertEquals(0, io.getConsegne().length);
		ges.generaGrafo().toString(io.getConsegne());
		t.moveToAIO(io.getConsegne());
		
	}
	
	@Test
	public void minMoveToAIO(){
		t = new Token(1, 1, 0, ges.generaGrafo());
		In_Out io = ges.generaIO();
		t.minMoveToAIO(io);
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
}
