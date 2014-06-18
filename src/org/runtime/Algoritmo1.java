package org.runtime;

import java.util.List;

import org.component.Grafo;
import org.component.In_Out;
import org.component.Token;

public class Algoritmo1 {

	public Grafo g;
	public In_Out io;
	public List<Token> tokenList;
	
	public Algoritmo1(Grafo g, In_Out io, List<Token> tokenList) {
		this.g = g;
		this.io = io;
		this.tokenList = tokenList;
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
			System.out.println(arrayToken[i].toString());
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
			System.out.println(arrayToken[i].toString());
		}
		
		System.out.println();
		System.out.println("FINE ESECUZIONE");
		System.out.println();
		
	}
}
