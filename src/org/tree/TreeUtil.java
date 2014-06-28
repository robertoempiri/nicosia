package org.tree;

import java.util.ArrayList;

public class TreeUtil<E> {
	
	public void printPreOrder(Tree<E> T){
		printPreOrder(T.root());
	}
	
	private void printPreOrder(Node<E> v){
		if (v.getParent() == null)
			System.out.print(v.getElement());
		else
			System.out.print(" " + v.getElement());
		for(Node<E> w: v.getChildren())
			printPreOrder(w);
		if (v.getParent() == null)
			System.out.println();
	}
	
	public Iterable<Node<E>> visitPostOrder(Tree<E> T){
		return visitPostOrder(T.root(), new ArrayList<Node<E>>());
	}
	
	private Iterable<Node<E>> visitPostOrder(Node<E> v, ArrayList<Node<E>> l){
		for(Node<E> w: v.getChildren())
			l = (ArrayList<Node<E>>) visitPostOrder(w,l);
		l.add(v);
		return l;
	}
	
	public int depth(Tree<E> T, Node<E> v){
		if (T.isRoot(v))
			return 0;
		return 1 + depth(T, v.getParent());
	}
	
	public int height(Tree<E> T){
		return height(T, T.root());
	}
	
	private int height(Tree<E> T, Node<E> v){
		if (T.isExternal(v))
			return 0;
		int h = 0;
		for(Node<E> w : T.children(v))
			h = Math.max(h, height(T, w));
		return 1 + h;
	}
	
    public void stampa(Tree<E> tree) {
        stampa(tree.root(), 0);
    }

    private void stampa(Node<E> v, int level) {
        if (v == null) return;
        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }
        if (level > 0)
            System.out.print(" |--");
        System.out.println(v.getElement());
        for (Node<E> children : v.getChildren()) {
            stampa(children, level + 1);
        }
    }
}
