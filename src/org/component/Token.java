package org.component;

public class Token {

	public int posizione;
	public int previous;
	public int tempo;
	public int[] archiDisp;
	public Grafo g;

	public Token(int posizione, int tempo){
		this.posizione = posizione;
		this.tempo = tempo;
		this.archiDisp = g.estraiArchi(getPosizione()-1);
	}
	
	public Token(int posizione, int previous, int tempo, Grafo g){
		this.posizione = posizione;
		this.previous = previous;
		this.tempo = tempo;
		this.g = g;
		this.archiDisp = g.estraiArchi(getPosizione()-1);
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
	
	public void setArchiDisp(){
		this.archiDisp = g.estraiArchi(getPosizione()-1);
	}

	/** Metodi di Move **/
	
	public void move(int nodo){
		
//		int[] archiDisp = g.estraiArchi(g, getPosizione()-1);
//		g.toString(archiDisp);
		setPrevious(getPosizione());
//		System.out.println("nodo da visitare "+nodo+" valore archi target "+archiDisp[nodo-1]);
//		System.out.println("posizione attuale: "+getPosizione()+" Tempo: "+getTempo());
		aggiornaTempo(archiDisp[nodo-1]);
		setPosizione(nodo);
		setArchiDisp();
		
//		System.out.println("posizione aggiornata: "+getPosizione()+" Tempo aggiornato: "+getTempo());
		
	}
	
	public void movePercorso(int[] nodi){
		
		for (int i = 0; i<nodi.length; i++){

			move(nodi[i]);
			
		}
	}
	
	public void minMove(){

		int minimo = 10000;
		int index = 0;
			
		for(int i=0; i<archiDisp.length; i++) {

			if (archiDisp[i]<minimo && archiDisp[i]!=0) {	
				minimo = archiDisp[i];
				index = i;
			}
		}
		
		move(index+1);
	
	}
	
	public void minMoveNoPrevious(){

		int minimo = 10000;
		int index = 10000;
			
		for(int i=0; i<archiDisp.length; i++) {

			if (i !=getPrevious()-1 && archiDisp[i]<minimo && archiDisp[i]!=0) {	
				minimo = archiDisp[i];
				index = i;
			}
		}
		
		move(index+1);
	}
	
	public boolean move2IO(In_Out io){
		
		double i;

		if (!io.verificaCompleto()) {
			i = Math.random();
			
			if (i<=0.5 && io.getConsegne().length!=0){
				move(io.getConsegne()[0]);
				return true;
			}

			if (i>0.5 && io.getRitiri().length!=0){
				move(io.getRitiri()[0]);
				return true;
			}
			
		} else if (io.getConsegne().length!=0){
			move(io.getConsegne()[0]);
			return true;
		} else if (io.getRitiri().length!=0){
			move(io.getRitiri()[0]);
			return true;
		}
		
		return false;
		
	}
	
	public void minMove2IO(In_Out io){
		int minimo = 10000;
		int index = 10000;
			
		for(int i=0; i<io.getConsegne().length; i++) {

//			System.out.print("["+archiDisp[io.getConsegne()[i]-1]+"] ");
			if (archiDisp[io.getConsegne()[i]-1]<minimo && archiDisp[io.getConsegne()[i]-1]!=0) {	
				minimo = archiDisp[io.getConsegne()[i]-1];
				index = io.getConsegne()[i];
			}
		}
		
		for(int i=0; i<io.getRitiri().length; i++) {

			if (archiDisp[io.getRitiri()[i]-1]<minimo && archiDisp[io.getRitiri()[i]-1]!=0) {	
				minimo = archiDisp[io.getRitiri()[i]-1];
				index = io.getRitiri()[i];
			}
		}
		
		move(index);
	}
	
	/** Metodi di Costo **/
	
	public void aggiornaTempo(int i){
		this.tempo = this.tempo+i;
	}
	
	/** Metodi di Consegna **/
	
	public void consegnaRitiro(In_Out io, int posizione){

		for(int i = 0;i<io.getConsegne().length;i++){
			if (posizione == io.getConsegne()[i]){
				io.setConsegne(io.aggiornaIo(io.getConsegne()[i], io.getConsegne()));
				aggiornaTempo(20);
			}
		}

		for(int i1 = 0;i1<io.getRitiri().length;i1++){
			if (posizione == io.getRitiri()[i1]){
//				System.out.println(posizione+" posizione "+io.getRitiri()[i1]+" ritiro in posizione");
				io.setRitiri(io.aggiornaIo(io.getRitiri()[i1], io.getRitiri()));
				aggiornaTempo(20);
			}
		}

	}

}
