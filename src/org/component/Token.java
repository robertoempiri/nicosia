package org.component;

public class Token {

	public int posizione;
	public int previous;
	public int tempo;

	public Token(int posizione, int tempo){
		this.posizione = posizione;
		this.tempo = tempo;
	}
	
	public Token(int posizione, int previous, int tempo){
		this.posizione = posizione;
		this.previous = previous;
		this.tempo = tempo;
	}

	/** Metodi di Classe **/
	
	public int getPosizione() {
		return posizione;
	}

	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}

	public int getPrevious() {
		return previous;
	}

	public void setPrevious(int posizione) {
		this.previous = posizione;
	}
	
	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	/** Metodi di Move **/
	
	public void move(int nodo, Grafo g){
		
		int[] archiDisp = g.estraiArchi(g, getPosizione()-1);
//		g.toString(archiDisp);
		setPrevious(getPosizione());
//		System.out.println("nodo da visitare "+nodo+" valore archi target "+archiDisp[nodo-1]);
//		System.out.println("posizione attuale: "+getPosizione()+" Tempo: "+getTempo());
		aggiornaTempo(archiDisp[nodo-1]);
		setPosizione(nodo);
//		System.out.println("posizione aggiornata: "+getPosizione()+" Tempo aggiornato: "+getTempo());
		
	}
	
	public void movePercorso(int[] nodi, Grafo g){
		
		for (int i = 0; i<nodi.length; i++){

			move(nodi[i],g);
			
		}
	}
	
	public void minMove(Grafo g){

		int[] archiDisp = g.estraiArchi(g, getPosizione()-1);
		int minimo = 10000;
		int index = 0;
			
		for(int i=0; i<archiDisp.length; i++) {

			if (archiDisp[i]<minimo && archiDisp[i]!=0) {	
				minimo = archiDisp[i];
				index = i;
			}
		}
		
		move(index+1, g);
	
	}
	
	public void minMoveNoPrevious(Grafo g){

		int[] archiDisp = g.estraiArchi(g, getPosizione()-1);
		int minimo = 10000;
		int index = 10000;
			
		for(int i=0; i<archiDisp.length; i++) {

			if (i !=getPrevious()-1 && archiDisp[i]<minimo && archiDisp[i]!=0) {	
				minimo = archiDisp[i];
				index = i;
			}
		}
		
		move(index+1, g);
	}
	
	/** Metodi di Costo **/
	
	public void aggiornaTempo(int i){
		this.tempo = this.tempo+i;
	}
	
}
