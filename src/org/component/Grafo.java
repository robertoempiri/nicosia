package org.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grafo {

	private List<List<Integer>> grafo;

	public Grafo(){
		this.grafo = new ArrayList<List<Integer>>();
	}

	public List<List<Integer>> getGrafo() {
		return grafo;
	}

	public void setGrafo(List<List<Integer>> grafo) {
		this.grafo = grafo;
	}

	public int getElement(int m, int n) {
		return this.grafo.get(m).get(n);
	}

	public void setElement(int m, int n, int set) {
		this.grafo.get(m).remove(n);
		this.grafo.get(m).add(n, set);
	}

	public int getM() {
		return this.grafo.size();
	}

	public int getN() {
		return this.grafo.get(0).size();
	}

	public List<Integer> estraiArchi(int i){
		if(i<getM()){
			return this.grafo.get(i);
		} else {
			return null;
		}
		
	}

	public String toString(){

		String s = "Grafo "+this.getM()+"x"+this.getN()+"\n";
		for (List<Integer> archi : this.grafo) {
			for (Iterator<Integer> iterator = archi.iterator(); iterator.hasNext();) {
				Integer integer = iterator.next();
				if(iterator.hasNext()){
					s = s + "["+integer+"]";
				} else {
					s = s + "["+integer+"]\n";
				}
			}
		}
		
		return s;
	}
	
	public String toString(List<Integer> archiDisp){
		
		String s = "Set di archi a disposizione: \n";
		
		for (int i : archiDisp) {
			s = s + "["+i+"]";
		}
		return s;
		
	}

}
