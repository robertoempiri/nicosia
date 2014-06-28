package org.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Risultato {

	List<List<Integer>> percorsi;
	List<Integer> tempi;
	
	public Risultato(){
		this.percorsi= new ArrayList<List<Integer>>();
		this.tempi = new ArrayList<Integer>();
	}
	
	public Risultato(List<List<Integer>> percorsi, List<Integer> tempi){
		this.percorsi = percorsi;
		this.tempi = tempi;
	}

	public List<List<Integer>> getPercorsi() {
		return percorsi;
	}

	public void setPercorsi(List<List<Integer>> percorsi) {
		this.percorsi = percorsi;
	}

	public List<Integer> getTempi() {
		return tempi;
	}

	public void setTempi(List<Integer> tempi) {
		this.tempi = tempi;
	}
	
	public String toString(){
		
		String s = "Il risultato dell'esecuzione dell'algoritmo è: \n";
		
		for (List<Integer> listPercorsi : percorsi) {
			s = s + "Macchina: "+percorsi.indexOf(listPercorsi)+" Tempo: "+ tempi.get(percorsi.indexOf(listPercorsi))+" Percorso: ";
			for (Iterator<Integer> iterator = percorsi.get(percorsi.indexOf(listPercorsi)).iterator(); iterator.hasNext();) {
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
