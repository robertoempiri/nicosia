package org.component.test;

import static org.junit.Assert.*;

import java.util.List;

import org.component.In_Out;
import org.component.Token;
import org.component.GestoreFile;
import org.component.Grafo;
import org.junit.Test;

public class In_OutTest {
	
	private GestoreFile ges = new GestoreFile("C:/RobertoWorkspace/nicosia/res/input.txt");
	private Grafo g = ges.generaGrafo();;
	Token t;
	In_Out io;

	@Test
	public void aggiornaIOTest() {

		t = new Token(4,1,0,g);
		io = ges.generaIO();
		
		int[] a = io.aggiornaIo(4, io.getRitiri());	
		
		for(int i = 0; i<a.length; i++){
			assertNotEquals(4, a[i]);
		}
	}
	
	@Test
	public void verificaCompletoTest(){
		
		int[] a = new int[0];
		int[] b = new int[0];
		In_Out io1 = new In_Out(a,b);
		assertTrue(io1.verificaCompleto());
		io = ges.generaIO();
		assertFalse(io.verificaCompleto());
		
	}
	
	@Test
	public void toSingleArrayTest(){
		List<Integer> a = ges.generaIO().toSingleList();
		for (Integer integer : a) {
			System.out.println(integer);
		}
	}
}
