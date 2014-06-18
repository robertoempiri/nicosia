package org.component;

import java.util.ArrayList;
import java.util.List;

public class Token {

	public int posizione;
	public int previous;
	public int tempo;
	public List<Integer> archiDisp;
	public Grafo g;
	public List<Integer> percorsoEffettuato = new ArrayList<Integer>();

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

	public List<Integer> getPercorsoEffettuato() {
		return percorsoEffettuato;
	}

	public void setPercorsoEffettuato(List<Integer> percorsoEffettuato) {
		this.percorsoEffettuato = percorsoEffettuato;
	}
	
	public void reset(){
		setPosizione(1);
		setPrevious(1);
		setTempo(0);
		setPercorsoEffettuato(new ArrayList<Integer>());
	}

	/** Metodi di Move **/
	
	public void move(int nodo){
		
//		int[] archiDisp = g.estraiArchi(g, getPosizione()-1);
//		g.toString(archiDisp);
		setPrevious(getPosizione());
//		System.out.println("nodo da visitare "+nodo+" valore archi target "+archiDisp[nodo-1]);
//		System.out.println("posizione attuale: "+getPosizione()+" Tempo: "+getTempo());
		aggiornaTempo(archiDisp.get(nodo-1));
		setPosizione(nodo);
		aggiornaPercorso(getPosizione());
		setArchiDisp();
		
//		System.out.println("posizione aggiornata: "+getPosizione()+" Tempo aggiornato: "+getTempo());
		
	}
	
	public void movePercorso(List<Integer> nodi){
		
		for (Integer i : nodi) {
			move(i);
		}
	}
	
	public void minMove(){

		int minimo = 10000;
		int index = 0;
		
		for (Integer i : archiDisp) {
			if (i<minimo && i!=0){
				minimo = i;
				index = archiDisp.indexOf(i);
			}
		}
		
		move(index+1);
	
	}
	
	public void minMoveNoPrevious(){

		int minimo = 10000;
		int index = 10000;
		
		for (Integer i : archiDisp) {
			if (i<minimo && i!=0 && i!=getPrevious()-1){
				minimo = i;
				index = archiDisp.indexOf(i);
			}
		}		
		move(index+1);
	}
	
	public boolean move2IO(In_Out io){
		
		if(!io.verificaRitiriCompleto()){
			move(io.getRitiri().get(0));
			return true;
		} else if (!io.verificaConsegneCompleto()) {
			move(io.getConsegne().get(0));
			return true;
		} else {
			return false;
		}
		
	}
	
	public void minMove2IO(In_Out io){
		int minimo = 10000;
		int index = 10000;
		if(!io.verificaRitiriCompleto()){
			for (Integer i : io.getRitiri()) {
				if(archiDisp.get(i-1)<minimo && archiDisp.get(i-1) != 0){
					minimo = archiDisp.get(i-1);
					index = i;
				}
			}
			move(index);
		} else if (!io.verificaConsegneCompleto()) {
			for (Integer i : io.getConsegne()) {
				if(archiDisp.get(i-1)<minimo && archiDisp.get(i-1) != 0){
					minimo = archiDisp.get(i-1);
					index = i;
				}
			}
			move(index);
		}
	}
	
	/** Metodi di Costo **/
	
	public void aggiornaTempo(int i){
		this.tempo = this.tempo+i;
	}
	
	/** Metodi di Consegna **/
	
	public void consegnaRitiro(In_Out io, int posizione){

		for(int i = 0;i<io.getConsegne().size();i++){
			if (posizione == io.getConsegne().get(i)){
				io.aggiornaConsegne(io.getConsegne().get(i));
				aggiornaTempo(20);
			}
		}

		for(int i1 = 0;i1<io.getRitiri().size();i1++){
			if (posizione == io.getRitiri().get(i1)){
				io.aggiornaRitiri(io.getRitiri().get(i1));
				aggiornaTempo(20);
			}
		}

	}
	
	/** Metodi di Percorso **/

	public void aggiornaPercorso(int p){
		this.percorsoEffettuato.add(p);	
	}
	
	public String toString(){
		
		String s = "Stazioni visitate: \n";

		for (Integer i : this.percorsoEffettuato) {
			s = s + " " +i+ " ";
		}
		return s;
	}
	
}
