package org.runtime;

public class Risultato {

	int[] percorso1;
	int[] percorso2;
	int tempo1;
	int tempo2;
	
	public Risultato(){
		
	}
	
	public Risultato(int[] percorso1, int[] percorso2, int tempo1, int tempo2){
		this.percorso1 = percorso1;
		this.percorso2 = percorso2;
		this.tempo1 = tempo1;
		this.tempo2 = tempo2;
	}

	public int[] getPercorso1() {
		return percorso1;
	}

	public void setPercorso1(int[] percorso1) {
		this.percorso1 = percorso1;
	}

	public int[] getPercorso2() {
		return percorso2;
	}

	public void setPercorso2(int[] percorso2) {
		this.percorso2 = percorso2;
	}

	public int getTempo1() {
		return tempo1;
	}

	public void setTempo1(int tempo1) {
		this.tempo1 = tempo1;
	}

	public int getTempo2() {
		return tempo2;
	}

	public void setTempo2(int tempo2) {
		this.tempo2 = tempo2;
	}
	
	public String toString(){
		
		return "\nIl risultato dell'esecuzione dell'algoritmo è:\n"
				+ "Macchina 1:\nTempo:"+getTempo1()+" "+toString(getPercorso1())+"\n"
				+ "Macchina 2:\nTempo:"+getTempo2()+" "+toString(getPercorso2());
	}
	
	public String toString(int[] percorso){
		String s = "Stazioni visitate: ";
		for (int i = 0; i<percorso.length; i++){
			if (i==percorso.length-1) {
				s = s+" "+percorso[i]+" ";
			} else {
				s = s+" "+percorso[i]+" ";
			}
		}
		return s;
	}
}
