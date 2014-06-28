package org.runtime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.component.Combinazioni;
import org.component.Grafo;
import org.component.In_Out;
import org.component.Risultato;
import org.component.Token;

public class Algoritmo2 {

	public Grafo g;
	public In_Out io;
	public Token t;
	public List<Token> tokenList;

	public Algoritmo2(Grafo g, In_Out io, Token token, List<Token> tokenList) {
		this.g = g;
		this.io = io;
		this.t = token;
		this.tokenList = tokenList;
	}

	public void branchAndBound(Risultato ritiri, Risultato consegne){

		System.out.println("ESECUZIONE BRANCH AND BOUND\n");
		System.out.println("Procedo con l'ottimizzazione dei ritiri");

		t.reset();
		Risultato ritiriOtt = new Risultato();

		for (List<Integer> ritiriList : ritiri.getPercorsi()) {
			int tempo = ritiri.getTempi().get(ritiri.getPercorsi().indexOf(ritiriList));
			System.out.println("Tempo da battere: "+tempo);
			List<Integer> percorsoTemp = ritiri.getPercorsi().get(ritiri.getPercorsi().indexOf(ritiriList));
			Combinazioni c = new Combinazioni(ritiriList);
			c.setCombinazioniList(ritiriList);
			for (Iterator<List<Integer>> iterator = c.getCombList().iterator(); iterator.hasNext();) {
				List<Integer> percorso = iterator.next();
				t.reset();
				t.movePercorso(percorso);
				System.out.println(t.toString());
				if(t.getTempo()<tempo){
					tempo = t.getTempo();
					System.out.println("Nuovo record: "+tempo);
					percorsoTemp.clear();
					percorsoTemp = t.getPercorsoEffettuato();
				}
				if (!iterator.hasNext()){
					ritiriOtt.getPercorsi().add(percorsoTemp);
					ritiriOtt.getTempi().add(tempo);
				}
			}

		}

		System.out.println(ritiriOtt.toString());

		t.reset();
		Risultato consegneOtt = new Risultato();

		for (List<Integer> consegneList : consegne.getPercorsi()) {
			int tempo = consegne.getTempi().get(consegne.getPercorsi().indexOf(consegneList));
			System.out.println("Tempo da battere: "+tempo);
			List<Integer> percorsoTemp = consegne.getPercorsi().get(consegne.getPercorsi().indexOf(consegneList));
			Combinazioni c = new Combinazioni(consegneList);
			c.setCombinazioniListNoTail(consegneList);				
			for (Iterator<List<Integer>> iterator = c.getCombList().iterator(); iterator.hasNext();) {
				List<Integer> percorso = iterator.next();
				t.lega(ritiriOtt.getPercorsi().get(consegne.getPercorsi().indexOf(consegneList)));
				System.out.println("Posizione di partenza: "+ t.getPosizione());
				t.movePercorso(percorso);
				t.move(1);
				System.out.println(t.toString());
				if(t.getTempo()<tempo){
					tempo = t.getTempo();
					System.out.println("Nuovo record: "+tempo);
					percorsoTemp.clear();
					percorsoTemp.addAll(t.getPercorsoEffettuato());
				}
				if (!iterator.hasNext()){
					consegneOtt.getPercorsi().add(percorsoTemp);
					consegneOtt.getTempi().add(tempo);
				}
			}			
		}

		System.out.println(consegneOtt.toString());

		Risultato finale = soluzioneCompleta(ritiriOtt, consegneOtt);

		System.out.println(finale.toString());

	}

	private Risultato soluzioneCompleta(Risultato ritiriOtt, Risultato consegneOtt) {

		Risultato finale = new Risultato();


		for (List<Integer> ritiri : ritiriOtt.getPercorsi()) {
			t.reset();
			List<Integer> newPercorso = new ArrayList<Integer>();
			newPercorso.addAll(ritiri);
			newPercorso.addAll(consegneOtt.getPercorsi().get(ritiriOtt.getPercorsi().indexOf(ritiri)));
			t.movePercorso(newPercorso);
			System.out.println(t.toString());
			finale.getPercorsi().add(t.getPercorsoEffettuato());
			finale.getTempi().add(t.getTempo());
		}

		return finale;

	}

}
