package org.component;

import java.util.ArrayList;
import java.util.List;

import org.tree.Tree;
import org.tree.TreeUtil;
import org.tree.Node;

public class ComboTree {
	public Tree<Integer> combTree;
	public TreeUtil<Integer> util = new TreeUtil<Integer>();

	public ComboTree(List<Integer> percorso){
		this.combTree = setCombinazioniTree(percorso);
	}

	public Tree<Integer> getCombinazioni() {
		return this.combTree;
	}

	public void setRecursiveTree4Percorso(Node<Integer> parent, List<Integer> percorso){

		for (Integer integer : percorso) {
			Node<Integer> n = new Node<Integer>(integer, parent);
			parent.getChildren().add(n);
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(percorso);
			temp.remove(integer);
			if (!temp.isEmpty()){
				setRecursiveTree4Percorso(parent.getChildren().get(parent.getChildren().indexOf(n)), temp);
			}
		}
	}


	public Tree<Integer> setCombinazioniTree(List<Integer> percorso) {
		Tree<Integer> combinazioni = new Tree<Integer>();
		combinazioni.addRoot(percorso.get(0));
		percorso.remove(0);
		percorso.remove(percorso.size()-1);
		setRecursiveTree4Percorso(combinazioni.root(), percorso);
		return combinazioni;
	}

	public void stampa(){
		util.stampa(this.combTree);
	}
}
