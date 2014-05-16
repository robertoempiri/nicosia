package org.runtime;

import org.component.Grafo;
import org.component.In_Out;
import org.component.Token;

public class Algoritmo1 {

	public Grafo g;
	public In_Out io;
	public Token[] arrayToken;
	
	public Algoritmo1(Grafo g, In_Out io, Token[] arrayToken) {
		this.g = g;
		this.io = io;
		this.arrayToken = arrayToken;
	}
	
	public void greedy(){
		
		System.out.println();
		System.out.println("Esecuzione algoritmo GREEDY");
		System.out.println();
		
		while(!io.verificaCompleto()){

			for (int i = 0; i<arrayToken.length; i++){
				arrayToken[i].move2IO(io);
				arrayToken[i].consegnaRitiro(io, arrayToken[i].getPosizione());
				System.out.println("Macchina n: "+i+" Posizione corrente: "
						+arrayToken[i].getPosizione()+" Posizione precedente: "
								+arrayToken[i].getPrevious()+" Tempo attuale: "
									+arrayToken[i].getTempo());
			}
			
		}
		
		for (int i = 0; i<arrayToken.length; i++){
			arrayToken[i].move(1);
			System.out.println("Macchina n: "+i+" Posizione corrente: "
					+arrayToken[i].getPosizione()+" Posizione precedente: "
							+arrayToken[i].getPrevious()+" Tempo attuale: "
								+arrayToken[i].getTempo());
		}
		
		for (int i = 0; i<arrayToken.length; i++){
			arrayToken[i].toString(arrayToken[i].getPercorsoEffettuato());
		}
		
		System.out.println();
		System.out.println("FINE ESECUZIONE");
		System.out.println();
		
	}
	
	public void greedyPlus(){
		
		System.out.println();
		System.out.println("Esecuzione algoritmo GREEDY PLUS");
		System.out.println();
		
		while(!io.verificaCompleto()){

			for (int i = 0; i<arrayToken.length; i++){
				arrayToken[i].minMove2IO(io);
				arrayToken[i].consegnaRitiro(io, arrayToken[i].getPosizione());
				System.out.println("Macchina n: "+i+" Posizione corrente: "
						+arrayToken[i].getPosizione()+" Posizione precedente: "
								+arrayToken[i].getPrevious()+" Tempo attuale: "
									+arrayToken[i].getTempo());
			}
			
		}
		
		for (int i = 0; i<arrayToken.length; i++){
			arrayToken[i].move(1);
			System.out.println("Macchina n: "+i+" Posizione corrente: "
					+arrayToken[i].getPosizione()+" Posizione precedente: "
							+arrayToken[i].getPrevious()+" Tempo attuale: "
								+arrayToken[i].getTempo());
		}
		
		for (int i = 0; i<arrayToken.length; i++){
			System.out.println("Macchina n."+i);
			arrayToken[i].toString(arrayToken[i].getPercorsoEffettuato());
		}
		
		System.out.println();
		System.out.println("FINE ESECUZIONE");
		System.out.println();
		
	}
}
