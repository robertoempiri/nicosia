package org.runtime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.component.Combinazioni;
import org.component.CrossCost;
import org.component.Grafo;
import org.component.In_Out;
import org.component.Risultato;
import org.component.Token;

public class Algoritmo3 {
	public Grafo g;
	public In_Out io;
	public Token t;
	public List<Token> tokenList;

	public Algoritmo3(Grafo g, In_Out io, Token token, List<Token> tokenList) {
		this.g = g;
		this.io = io;
		this.t = token;
		this.tokenList = tokenList;
	}

	public List<CrossCost> crossCostList(Risultato ritiri, Risultato consegne){

		List<CrossCost> interscambiList = new ArrayList<CrossCost>();

		for (List<Integer> ritiri4interscambio : ritiri.getPercorsi()) {
			CrossCost c = new CrossCost();
			c.setT(t);
			c.calcolaInterscambi(ritiri4interscambio, consegne.getPercorsi().get(ritiri.getPercorsi().indexOf(ritiri4interscambio)));
			interscambiList.add(c);
		}

		return interscambiList;
	}

	public void solutionBuilder(Risultato ritiri, Risultato consegne){

		List<CrossCost> interscambiList = crossCostList(ritiri, consegne);
		Risultato minInterscambi = new Risultato();

		for (CrossCost crossCost : interscambiList) {
			t.reset();
			t.setPosizione(crossCost.minCrossCost().get(0));
			t.setArchiDisp();
			minInterscambi.getPercorsi().add(crossCost.minCrossCost());
			t.move(crossCost.minCrossCost().get(1));
			minInterscambi.getTempi().add(t.getTempo());
		}
		
		System.out.println(minInterscambi.toString());
		
		Risultato ritiriOtt = new Risultato();

		for (List<Integer> ritiriList : ritiri.getPercorsi()) {
			int tempo = ritiri.getTempi().get(ritiri.getPercorsi().indexOf(ritiriList));
			System.out.println("Tempo da battere: "+tempo);
			List<Integer> percorsoTemp = ritiri.getPercorsi().get(ritiri.getPercorsi().indexOf(ritiriList));
			ritiriList.remove(minInterscambi.getPercorsi().get(ritiri.getPercorsi().indexOf(ritiriList)).get(0));
			Combinazioni c = new Combinazioni(ritiriList);
			c.setCombinazioniList(ritiriList);
			for (Iterator<List<Integer>> iterator = c.getCombList().iterator(); iterator.hasNext();) {
				List<Integer> percorso = iterator.next();
				t.reset();
				t.movePercorso(percorso);
				System.out.println(t.toString());
				if(t.getTempo()<tempo){tempo = t.getTempo();
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
		
	}

}
