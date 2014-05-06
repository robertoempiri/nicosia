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
		
		while(!io.verificaCompleto()){

			for (int i = 0; i<arrayToken.length; i++){
				arrayToken[i].move2IO(io);
			}
			
		}
		
	}

	
	
}
