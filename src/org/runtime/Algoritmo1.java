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
		
		System.out.println("Esecuzione algoritmo GREEDY\n");
		
		while(!io.verificaCompleto()){

			for (Token t : tokenList) {
				t.move2IO(io);
				t.consegnaRitiro(io, t.getPosizione());
				System.out.println("Macchina n: "+tokenList.indexOf(t)+" "+toString(tokenList.get(tokenList.indexOf(t))));
			}			
		}
		
		for (Token t : tokenList) {
			t.move(1);
			System.out.println("Macchina n: "+tokenList.indexOf(t)+" "+toString(tokenList.get(tokenList.indexOf(t))));
		}
		
		for (Token t : tokenList) {
			System.out.println(t.toString());
		}
		
		System.out.println("FINE ESECUZIONE\n");
		
	}
	
	public void greedyPlus(){
		
		System.out.println("Esecuzione algoritmo GREEDY PLUS\n");
		
		while(!io.verificaCompleto()){

			for (Token t : tokenList) {
				t.minMove2IO(io);
				t.consegnaRitiro(io, t.getPosizione());
				System.out.println("Macchina n: "+tokenList.indexOf(t)+" "+toString(tokenList.get(tokenList.indexOf(t))));
			}			
		}
		
		for (Token t : tokenList) {
			t.move(1);
			System.out.println("Macchina n: "+tokenList.indexOf(t)+" "+toString(tokenList.get(tokenList.indexOf(t))));
		}
		
		for (Token t : tokenList) {
			System.out.println(t.toString());
		}
		
		System.out.println("FINE ESECUZIONE\n");
		
	}
	
	public String toString(Token n){
		String s = 	"Posizione corrente: "+n.getPosizione()+ " "+
					"Posizione precedente: "+n.getPrevious()+ " "+
					"Tempo attuale: "+n.getTempo();
		return s;
	}
}
