package org.component;

import java.util.ArrayList;
import java.util.List;

public class CrossCost extends Risultato {

	public Token t;
	public List<Integer> consegne;
	public List<Integer> ritiri;

	public CrossCost(){
		super();
	}

	public void calcolaInterscambi(List<Integer> ritiri, List<Integer> consegne) {
		
		for (Integer i : ritiri) {
			for (Integer j : consegne) {
				if(j!=1){
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				temp.add(j);
				t.setTempo(0);
				t.setPosizione(i);
				t.setArchiDisp();
				t.move(j);
				this.getPercorsi().add(temp);
				this.getTempi().add(t.getTempo());
				}
			}
		}
		
	}
	
	public List<Integer> minCrossCost(){
		int temp = this.getTempi().get(0);
		int index = 0;
		for (Integer tempo : this.getTempi()) {
			if(tempo<temp){
				index = this.getTempi().indexOf(tempo);
				temp = tempo;
			}
		}
		return this.getPercorsi().get(index);
	}
	
	public Token getT() {
		return t;
	}

	public void setT(Token t) {
		this.t = t;
	}

	public List<Integer> getConsegne() {
		return consegne;
	}

	public void setConsegne(List<Integer> consegne) {
		this.consegne = consegne;
	}

	public List<Integer> getRitiri() {
		return ritiri;
	}

	public void setRitiri(List<Integer> ritiri) {
		this.ritiri = ritiri;
	}
	
}
