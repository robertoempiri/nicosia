package org.tree;

import java.util.LinkedList;

public class Node<E> {
	
	private Node<E> parent;
	private E elem;
	private LinkedList<Node<E>> children;
	
	public Node(E e, Node<E> p){
		elem = e;
		parent = p;
		children = new LinkedList<Node<E>>();
	}
	
	public E getElement(){
		return elem;
	}
	
	public void setElement(E e){
		elem = e;
	}
	
	public Node<E> getParent(){
		return parent;
	}
	
	public void setParent(Node<E> p){
		parent = (Node<E>) p;
	}
	
	public LinkedList<Node<E>> getChildren(){
		return children;
	}
}
