package org.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Combinazioni {
	
	public List<Integer> seedList;
	public List<List<Integer>> combList = new ArrayList<List<Integer>>();

	public Combinazioni(List<Integer> percorso){
		this.seedList = percorso;
	}

	public void setCombinazioniListNoTail(List<Integer> percorso){
		percorso.remove(percorso.size()-1);
		setRecursiveList4Percorso(percorso, new ArrayList<Integer>());
	}
	
	public void setCombinazioniList(List<Integer> percorso){
		setRecursiveList4Percorso(percorso, new ArrayList<Integer>());
	}
	
	public void setRecursiveList4Percorso(List<Integer> percorso, List<Integer> result2Add){
		
		for(Integer integer : percorso){
			List<Integer> result2AddTemp = new ArrayList<Integer>();
			result2AddTemp.addAll(result2Add);
			result2AddTemp.add(integer);
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(percorso);
			temp.remove(integer);
			if(!temp.isEmpty()){
				setRecursiveList4Percorso(temp, result2AddTemp);
			} else {
				this.combList.add(result2AddTemp);
			}
		}
		
	}
	
	public List<Integer> getSeedList() {
		return seedList;
	}

	public void setSeedList(List<Integer> seedList) {
		this.seedList = seedList;
	}

	public List<List<Integer>> getCombList() {
		return combList;
	}

	public void setCombList(List<List<Integer>> combList) {
		this.combList = combList;
	}

	public String toString(){
		String s = "Lista delle combinazioni a partire da\n";
		for (Iterator<Integer> iterator = this.seedList.iterator(); iterator.hasNext();) {
			Integer i = iterator.next();
			if(iterator.hasNext()){
				s = s + "[" +i+ "]";
			} else {
				s = s + "[" +i+ "]\n";
			}
		}

		s = s + "\nLista: \n";
		int count = 0;
		for (List<Integer> comb : this.combList) {
			count++;
			s = s +"Combinazione n."+ count + " ";
			for (Iterator<Integer> iterator = comb.iterator(); iterator.hasNext();) {
				Integer i = iterator.next();
				if(iterator.hasNext()){
					s = s + "[" +i+ "]";
				} else {
					s = s + "[" +i+ "]\n";
				}
			}
		}
		
		return s;
		
	}
}
