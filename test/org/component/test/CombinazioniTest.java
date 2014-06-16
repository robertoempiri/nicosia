package org.component.test;

import static org.junit.Assert.*;

import java.util.List;

import org.component.Combinazioni;
import org.component.GestoreFile;
import org.component.In_Out;
import org.component.Token;
import org.junit.Test;

public class CombinazioniTest {
	
	private GestoreFile ges = new GestoreFile("C:/RobertoWorkspace/nicosia/res/input.txt");
	Token t = new Token(1,1,0, ges.generaGrafo());
	
	@Test
	public void testCombinazioni() {
		In_Out io = ges.generaIO();
		Combinazioni comb = new Combinazioni();
		comb.setConsegne(io.getConsegne());
		System.out.println("Consegne");
		
		List<int[]> consegne = comb.getConsegne();
		for (int[] is : consegne) {
			t.toString(is);
		}
		comb.setRitiri(io.getRitiri());
		System.out.println("Ritiri");
		
		List<int[]> ritiri = comb.getRitiri();
		for (int[] is : ritiri) {
			t.toString(is);
		}
	}

	@Test
	public void testSetConsegne() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRitiri() {
		fail("Not yet implemented");
	}

}
