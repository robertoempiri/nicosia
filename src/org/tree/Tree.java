package org.tree;

//************ Albero n-ario ************

import java.util.ArrayList;
import java.util.Iterator;

public class Tree<E> {
	
	private Node<E> root;
	private int size;
	
	public Tree(){
		root = null;
		size = 0;
	}
	
	public Node<E> addRoot(E e){
		if (!isEmpty())
			throw new RuntimeException("L'albero ha gia una radice");
		Node<E> r = new Node<E>(e, null);
		root = r;
		size++;
		return r;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return root == null;
	}
	
	public Iterator<E> iterator(){
		return iterator(root, new ArrayList<E>()).iterator();
	}
	
	private ArrayList<E> iterator(Node<E> v, ArrayList<E> l){
		for (Node<E> w: v.getChildren())
			l = iterator(w, l);
		l.add(v.getElement());
		return l;
	}
	
	public Iterable<Node<E>> nodes(){
		return nodes(root, new ArrayList<Node<E>>());
	}
	
	private ArrayList<Node<E>> nodes(Node<E> v, ArrayList<Node<E>> l){
		for (Node<E> w: v.getChildren())
			l = nodes(w, l);
		l.add(v);
		return l;
	}
	
	public E replace(Node<E> v, E e){
		E temp = v.getElement();
		v.setElement(e);
		return temp;
	}
	
	public Node<E> root(){
		if (isEmpty()) throw new RuntimeException("L'albero non ha radice");
		return root;
	}
	
	public Node<E> parent(Node<E> v){
		return v.getParent();
	}
	
	public Node<E> addChildren(Node<E> v, E e){
		Node<E> vv = new Node<E>(e, v);
		v.getChildren().add(vv);
		size++;
		return vv;
	}
	
	public Iterable<Node<E>> children(Node<E> v){
		return v.getChildren();
	}
	
	public boolean isInternal(Node<E> v){
		return v.getChildren().size() != 0;
	}
	
	public boolean isExternal(Node<E> v){
		return !isInternal(v);
	}
	
	public boolean isRoot(Node<E> v){
		return v == root;
	}
}
