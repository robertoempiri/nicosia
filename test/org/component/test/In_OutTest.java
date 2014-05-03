package org.component.test;

import static org.junit.Assert.*;

import org.component.In_Out;
import org.component.Token;
import org.component.gestoreFile;
import org.component.Grafo;
import org.junit.Test;

public class In_OutTest {
	
	private gestoreFile ges = new gestoreFile("");;
	
	Grafo g;
	Token t;
	In_Out io;

	@Test
	public void aggiornaIOTest() {
		
		ges.setPath("C:/RobertoWorkspace/nicosia/res/input.txt");
		t = new Token(4,1,0);
		g = ges.generaGrafo();
		io = ges.generaIO();
		
		int[] a = io.aggiornaIo(4, io.getRitiri());	
		
		for(int i = 0; i<a.length; i++){
			assertNotEquals(4, a[i]);
		}

	}

	@Test
	public void test2() {

	}

}
