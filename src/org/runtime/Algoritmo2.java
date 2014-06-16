package org.runtime;

import org.component.Combinazioni;
import org.component.Grafo;
import org.component.In_Out;
import org.component.Token;

public class Algoritmo2 {

	public Grafo g;
	public In_Out io;
	public Token[] arrayToken;
	
	public Algoritmo2(Grafo g, In_Out io, Token[] arrayToken) {
		this.g = g;
		this.io = io;
		this.arrayToken = arrayToken;
	}
	
	public void branchAndBound(Risultato result){
		System.out.println("ESECUZIONE BRANCH AND BOUND");
		Combinazioni combinazioni = new Combinazioni();
		combinazioni.setConsegne(io.getConsegne());
		combinazioni.setRitiri(io.getRitiri());
		System.out.println("Macchina 1:");
		for (int[] consegne : combinazioni.getConsegne()) {
			arrayToken[0].movePercorso(consegne);
			arrayToken[0].move(1);
			System.out.print("Tempo: "+arrayToken[0].getTempo());
			System.out.println(combinazioni.toString(consegne));
			if(result.getTempo1()<arrayToken[0].getTempo()){
				
			}else{
				result.setTempo1(arrayToken[0].getTempo());
				result.setPercorso1(arrayToken[0].getPercorsoEffettuato());
			}
			arrayToken[0].reset();
		}
		System.out.println("Macchina 2: ");
		for (int[] ritiri : combinazioni.getRitiri()) {
			arrayToken[1].movePercorso(ritiri);
			arrayToken[1].move(1);
			System.out.print("Tempo: "+arrayToken[1].getTempo()+" ");
			System.out.println(combinazioni.toString(ritiri));
			if(result.getTempo2()<arrayToken[1].getTempo()){
				
			}else{
				result.setTempo2(arrayToken[1].getTempo());
				result.setPercorso2(arrayToken[1].getPercorsoEffettuato());
			}
			arrayToken[1].reset();
		}
		
		System.out.println(result.toString());
		
	}
	
}
