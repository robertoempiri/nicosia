package org.component.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.component.In_Out;
import org.component.Token;
import org.component.GestoreFile;
import org.component.Grafo;
import org.junit.Test;

public class In_OutTest {
	
	private GestoreFile ges = new GestoreFile("C:/RobertoWorkspace/nicosia/res/input.txt");
	private In_Out io;

	@Test
	public void aggiornaConsegneTest() {
		
		io = ges.generaIO();
		
		System.out.println(io.toString());
		
		io.aggiornaConsegne(5);
		
		System.out.println(io.toString());
		
		assertFalse(io.getConsegne().contains(5));
		
	}
	
	@Test
	public void verificaCompletoTest(){
		
		List<Integer> consegne = new ArrayList<Integer>();
		List<Integer> ritiri = new ArrayList<Integer>();
		In_Out io1 = new In_Out(consegne, ritiri);
		assertTrue(io1.verificaCompleto());
		io = ges.generaIO();
		assertFalse(io.verificaCompleto());
		
	}
	
	@Test
	public void toStringTest(){
		List<Integer> consegne = new ArrayList<Integer>();
		List<Integer> ritiri = new ArrayList<Integer>();
		consegne.add(1);
		consegne.add(2);
		consegne.add(3);
		ritiri.add(4);
		ritiri.add(5);
		ritiri.add(6);
		In_Out io = new In_Out(consegne, ritiri);
		System.out.println(io.toString());
	}
}
