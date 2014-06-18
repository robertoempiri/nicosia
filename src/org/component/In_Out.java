package org.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class In_Out {

	private List<Integer> consegne;
	private List<Integer> ritiri;

	public In_Out(List<Integer> consegne, List<Integer> ritiri){
		this.consegne = consegne;
		this.ritiri = ritiri;
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
	
	public void aggiornaConsegne(int a){
		this.consegne.remove(this.consegne.indexOf(a));
	}
	
	public void aggiornaRitiri(int a){
		this.ritiri.remove(this.ritiri.indexOf(a));
	}
	
	public boolean verificaCompleto(){
		
		if (this.consegne.isEmpty() && this.ritiri.isEmpty()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean verificaRitiriCompleto(){
		
		if (this.ritiri.isEmpty()){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verificaConsegneCompleto(){
		
		if (this.consegne.isEmpty()){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString(){
		
		String s = "Consegne da effettuare ai nodi: ";
		
		for (Integer i : this.consegne) {
			if(this.consegne.indexOf(i) != this.consegne.size()-1) {
				s = s + String.valueOf(i) + " - ";
			} else {
				s = s + String.valueOf(i) + ";\n";				
			}
		}
		
		s = s + "Ritiri da effettuare ai nodi: ";
		
		for (Integer i : this.ritiri) {
			if(this.ritiri.indexOf(i) != this.ritiri.size()-1) {
				s = s + String.valueOf(i) + " - ";
			} else {
				s = s + String.valueOf(i) + ";\n";				
			}
		}
		
		return s;

	}
	
	public List<Integer> toSingleList(){
		
		List<Integer> a = new ArrayList<Integer>();
		
		for (Integer integer : this.consegne) {
			a.add(integer);
		}
		for (Integer integer : this.ritiri) {
			a.add(integer);
		}
	
		return a;
	}	
}
