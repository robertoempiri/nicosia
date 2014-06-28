package org.component.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.component.ComboTree;
import org.junit.Ignore;
import org.junit.Test;
import org.tree.Tree;
import org.tree.TreeUtil;

public class ComboTreeTest {

	public ComboTree comb;
	
	@Test
	public void setRecursiveTree4PercorsoLvl3Test(){
		Tree<Integer> combinazioni = new Tree<Integer>();
		combinazioni.addRoot(1);
		List<Integer> c = new ArrayList<Integer>();
		c.add(1);
		c.add(9);
		c.add(14);
		c.add(7);
		c.add(1);
		comb = new ComboTree(c);
		TreeUtil<Integer> util = new TreeUtil<Integer>();
		util.stampa(comb.getCombinazioni());
	}
	
	@Test
	public void setRecursiveTree4PercorsoLvl5Test(){
		Tree<Integer> combinazioni = new Tree<Integer>();
		combinazioni.addRoot(1);
		List<Integer> c = new ArrayList<Integer>();
		c.add(1);
		c.add(1);
		c.add(2);
		c.add(3);
		c.add(4);
		c.add(5);
		c.add(1);
		comb = new ComboTree(c);
		TreeUtil<Integer> util = new TreeUtil<Integer>();
		util.stampa(comb.getCombinazioni());
	}
	
	@Test
	public void setRecursiveTree4PercorsoLvl7Test(){
		Tree<Integer> combinazioni = new Tree<Integer>();
		combinazioni.addRoot(1);
		List<Integer> c = new ArrayList<Integer>();
		c.add(1);
		c.add(1);
		c.add(2);
		c.add(3);
		c.add(4);
		c.add(5);
		c.add(6);
		c.add(7);
		c.add(1);
		comb = new ComboTree(c);
		TreeUtil<Integer> util = new TreeUtil<Integer>();
		util.stampa(comb.getCombinazioni());
	}
	
	/*
	 *	Note: Computational time: 7,168 s
	 */
	
	@Test
	public void setRecursiveTree4PercorsoLvl9Test(){
		Tree<Integer> combinazioni = new Tree<Integer>();
		combinazioni.addRoot(1);
		List<Integer> c = new ArrayList<Integer>();
		c.add(1);
		c.add(1);
		c.add(2);
		c.add(3);
		c.add(4);
		c.add(5);
		c.add(6);
		c.add(7);
		c.add(8);
		c.add(9);
		c.add(1);
		comb = new ComboTree(c);
		TreeUtil<Integer> util = new TreeUtil<Integer>();
		util.stampa(comb.getCombinazioni());
	}
	
	/*
	 * 	Note: Computational time: after 388,536 s it fails OutOfMemoryError: Java heap space
	 */
	
	@Test
	@Ignore
	public void setRecursiveTree4PercorsoLvl10Test(){
		Tree<Integer> combinazioni = new Tree<Integer>();
		combinazioni.addRoot(1);
		List<Integer> c = new ArrayList<Integer>();
		c.add(1);
		c.add(1);
		c.add(2);
		c.add(3);
		c.add(4);
		c.add(5);
		c.add(6);
		c.add(7);
		c.add(8);
		c.add(9);
		c.add(10);
		c.add(1);
		comb = new ComboTree(c);
		TreeUtil<Integer> util = new TreeUtil<Integer>();
		util.stampa(comb.getCombinazioni());
	}

}
