package org.component.test;

import java.util.ArrayList;
import java.util.List;

import org.component.Combinazioni;
import org.component.GestoreFile;
import org.component.Token;
import org.junit.Ignore;
import org.junit.Test;
import org.tree.Tree;
import org.tree.TreeUtil;

public class CombinazioniTest {
	
	private GestoreFile ges = new GestoreFile("C:/RobertoWorkspace/nicosia/res/input.txt");
	Token t = new Token(1,1,0, ges.generaGrafo());
	Combinazioni comb;

	@Test
	public void setRecursiveList4PercorsoLvl3Test(){
		List<Integer> percorso = new ArrayList<Integer>();
		percorso.add(3);
		percorso.add(5);
		percorso.add(7);
		comb = new Combinazioni(percorso);
		comb.setRecursiveList4Percorso(percorso, new ArrayList<Integer>());
		System.out.println(comb.toString());
	}
	
	@Test
	public void setRecursiveList4PercorsoLvl5Test(){
		List<Integer> percorso = new ArrayList<Integer>();
		percorso.add(3);
		percorso.add(5);
		percorso.add(7);
		percorso.add(2);
		percorso.add(6);
		comb = new Combinazioni(percorso);
		comb.setRecursiveList4Percorso(percorso, new ArrayList<Integer>());
		System.out.println(comb.toString());
	}
	
	/*
	 * 	Note: Computational time: 8,479 s
	 */
	
	@Test
	public void setRecursiveList4PercorsoLvl7Test(){
		List<Integer> percorso = new ArrayList<Integer>();
		percorso.add(3);
		percorso.add(5);
		percorso.add(7);
		percorso.add(2);
		percorso.add(6);
		percorso.add(9);
		percorso.add(13);
		comb = new Combinazioni(percorso);
		comb.setRecursiveList4Percorso(percorso, new ArrayList<Integer>());
		System.out.println(comb.toString());
	}
	
	/*
	 * 	Note: Computational time: 705,188 s
	 */
	
	@Test
	public void setRecursiveList4PercorsoLvl8Test(){
		List<Integer> percorso = new ArrayList<Integer>();
		percorso.add(3);
		percorso.add(5);
		percorso.add(7);
		percorso.add(2);
		percorso.add(6);
		percorso.add(9);
		percorso.add(13);
		percorso.add(12);
		comb = new Combinazioni(percorso);
		comb.setRecursiveList4Percorso(percorso, new ArrayList<Integer>());
		System.out.println(comb.toString());
	}
	
	/*
	 * 	Note: Computational time: after 14h it not ends
	 */
	
	@Test
	public void setRecursiveList4PercorsoLvl9Test(){
		List<Integer> percorso = new ArrayList<Integer>();
		percorso.add(3);
		percorso.add(5);
		percorso.add(7);
		percorso.add(2);
		percorso.add(6);
		percorso.add(9);
		percorso.add(13);
		percorso.add(12);
		percorso.add(1);
		comb = new Combinazioni(percorso);
		comb.setRecursiveList4Percorso(percorso, new ArrayList<Integer>());
		System.out.println(comb.toString());
	}
	

	
}
