package org.component;

public class Token {

	public int posizione;
	public int tempo;
	public Grafo g;

	public Token(int posizione, int tempo, Grafo g){
		this.posizione = posizione;
		this.tempo = tempo;
		this.g = g;
	}

	public int getPosizione() {
		return posizione;
	}

	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public void minMove(){

		int posizione = getPosizione();
		
		int[] archiDisp = g.estraiArchi(g, posizione);
		int minimo;
		
		if (archiDisp[0]!=0) {
			minimo = archiDisp[0];
		} else minimo = archiDisp[1];

		

		for(int i=0; i<=archiDisp.length-1; i++) {
			
			if (archiDisp[i]<minimo && archiDisp[i]!=0) {
				
				minimo = archiDisp[i];
				
				posizione = i;
			}
		}

		setPosizione(posizione);
	}
}
