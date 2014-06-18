package org.runtime;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Risultato {

	HashMap<Integer, List<Integer>> percorsi;
	HashMap<Integer, Integer> tempi;
	
	public Risultato(){
		this.percorsi= new HashMap<Integer, List<Integer>>();
		this.tempi = new HashMap<Integer, Integer>();
	}
	
	public Risultato(HashMap<Integer, List<Integer>> percorsi, HashMap<Integer, Integer> tempi){
		this.percorsi = percorsi;
		this.tempi = tempi;
	}

	public HashMap<Integer, List<Integer>> getPercorsi() {
		return percorsi;
	}

	public void setPercorsi(HashMap<Integer, List<Integer>> percorsi) {
		this.percorsi = percorsi;
	}

	public HashMap<Integer, Integer> getTempi() {
		return tempi;
	}

	public void setTempi(HashMap<Integer, Integer> tempi) {
		this.tempi = tempi;
	}
	
	public String toString(){
		
		String s = "Il risultato dell'esecuzione dell'algoritmo è: \n";
		
		for (Integer i: percorsi.keySet()) {
			s = s + "Macchina: "+i+" Tempo: "+tempi.get(i)+" Percorso: ";
			for (Iterator<Integer> iterator = percorsi.get(i).iterator(); iterator.hasNext();) {
				Integer x = iterator.next();
				if (iterator.hasNext()){
					s = s + String.valueOf(x)+ " ";
				} else {
					s = s + String.valueOf(x)+ "\n";
				}
			}
			
		}
		
		return s;
	}
}
