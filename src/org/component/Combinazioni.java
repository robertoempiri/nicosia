package org.component;

// TODO (Refactor of this class)

import java.util.ArrayList;
import java.util.List;

public class Combinazioni {

	List<List<Integer>> consegne;
	List<List<Integer>> ritiri;

	public Combinazioni(){
		
	}

	public void setConsegne(int[] consegne){
		
		List<int[]> listResult = new ArrayList<int[]>();

		int[] temp = new int[consegne.length];
		
		for (int i = 0;i<consegne.length;i++) {
			temp[i] = consegne[i];
		}
		
		listResult.add(consegne);
		
		for (int i=consegne.length-1; i>=0; i--) {
			
			int elemento = consegne[i];

			boolean finito = false;

			while(!finito){
				int index = 0;
				boolean trovato = false;
				while(!trovato){
					if (temp[index]==elemento){
						trovato = true;
					} else {
						index++;
					}
				}
				if(index!=0){
					int ntemp = temp[index-1];
					temp[index-1] = elemento;
					temp[index] = ntemp;
				}
				
				int[] temp2 = new int[temp.length];
				
				for (int j = 0;j<temp.length;j++) {
					temp2[j] = temp[j];
				}

				listResult.add(temp2);

				if(temp[0]==elemento){
					finito = true;
				}
			}
		}

		this.consegne = listResult;


	}

	public void setRitiri(int[] ritiri){
		
		List<int[]> listResult = new ArrayList<int[]>();

		int[] temp = new int[ritiri.length];
		
		for (int i = 0;i<ritiri.length;i++) {
			temp[i] = ritiri[i];
		}
		
		listResult.add(ritiri);
		
		for (int i=ritiri.length-1; i>=0; i--) {
			
			int elemento = ritiri[i];

			boolean finito = false;

			while(!finito){
				int index = 0;
				boolean trovato = false;
				while(!trovato){
					if (temp[index]==elemento){
						trovato = true;
					} else {
						index++;
					}
				}
				if(index!=0){
					int ntemp = temp[index-1];
					temp[index-1] = elemento;
					temp[index] = ntemp;
				}
				
				int[] temp2 = new int[temp.length];
				
				for (int j = 0;j<temp.length;j++) {
					temp2[j] = temp[j];
				}

				listResult.add(temp2);

				if(temp[0]==elemento){
					finito = true;
				}
			}
		}

		this.ritiri = listResult;


	}

	public List<int[]> getConsegne() {
		return consegne;
	}

	public List<int[]> getRitiri() {
		return ritiri;
	}

	public boolean compare(int[] eq, int[] eq2){
		if(eq.length==eq2.length){
		
			boolean[] verify = new boolean[eq.length];
			
			for (int i = 0; i < eq2.length; i++) {
				if(eq[i]==eq2[i]){
					verify[i] = true;
				} else {
					verify[i] = false;
				}
			}
			int count = 0;
			for (int i = 0; i < verify.length; i++) {
				if(verify[i]){
					count++;
				}
			}
			if (count==verify.length-1) {
				return true;
			} else return false;
		} else return false;
	}

	public String toString(int[] percorso){
		String s = "Stazioni visitate: ";
		for (int i = 0; i<percorso.length; i++){
			if (i==percorso.length-1) {
				s = s+" "+percorso[i]+" ";
			} else {
				s = s+" "+percorso[i]+" ";
			}
		}
		return s;
	}
	
}
