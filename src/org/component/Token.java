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
	
	public void minMove(Grafo g){

		int posizione = getPosizione();
		setPrevious(getPosizione());
		
		int[] archiDisp = g.estraiArchi(g, posizione);
		int minimo;
		
		if (archiDisp[0]!=0) {
			minimo = archiDisp[0];
			posizione = 0;
		} else { 
			minimo = archiDisp[1];
			posizione = 1;
			}

			
		for(int i=0; i<archiDisp.length; i++) {
			
			if (archiDisp[i]<minimo && archiDisp[i]!=0) {
				
				minimo = archiDisp[i];
				
				posizione = i;
			}
		}
		
		aggiornaTempo(archiDisp[posizione]);
		setPosizione(posizione);
	
	}
	
	public void minMoveNoPrevious(Grafo g){

		int posizione = getPosizione();
		int previous = getPrevious();
		int temp = getPosizione();
		
		int[] archiDisp = g.estraiArchi(g, posizione);
		int minimo;
		
		if (archiDisp[0]!=0) {
			minimo = archiDisp[0];
			posizione = 0;
		} else {
			minimo = archiDisp[1];
			posizione = 1;
		}

//		System.out.println("Posizione:"+getPosizione());
//		System.out.println("Precedente:"+getPrevious());
		
//		System.out.println("Dim Vettore archi "+archiDisp.length);
		
		if (posizione<archiDisp.length-1){
//			System.out.println("1");
			for(int i=0; i<archiDisp.length; i++) {
				
//				System.out.println("i "+i+" previous "+previous+" ");
				
				if (i!=previous && archiDisp[i]<minimo && archiDisp[i]!=0) {

					minimo = archiDisp[i];

					posizione = i;
				}
			}
		}
		
		if (posizione==archiDisp.length-1){
//			System.out.println("2");
			for(int i=0; i<archiDisp.length; i++) {

//				System.out.println("i "+i+" previous "+previous+" ");
//				System.out.println("minimo "+minimo);
				
				if (i != previous && archiDisp[i]<minimo && archiDisp[i]!=0) {

//					System.out.println("i "+i+"previous "+previous+"");
					
					minimo = archiDisp[i];

					posizione = i;
				}
			}
		}
		
		aggiornaTempo(archiDisp[posizione]);
		setPrevious(temp);
		setPosizione(posizione);
//		System.out.println("Nuova Posizione:"+getPosizione());
//		System.out.println("Nuovo Precedente:"+getPrevious());
		
	}
	
	/** Metodi di Costo **/
	
	public void aggiornaTempo(int i){
		this.tempo = this.tempo+i;
	}
	
}
