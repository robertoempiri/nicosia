package org.component;

public class In_Out {

	private int[] consegne;
	private int[] ritiri;

	public In_Out(int[] consegne, int[] arrivi){
		this.consegne = consegne;
		this.ritiri = arrivi;
	}

	public int[] getConsegne() {
		return consegne;
	}

	public void setConsegne(int[] consegne) {
		this.consegne = consegne;
	}

	public int[] getRitiri() {
		return ritiri;
	}

	public void setRitiri(int[] ritiri) {
		this.ritiri = ritiri;
	}
	
	public int[] aggiornaIo(int a, int[] io){
		
		int[] aggiornato = new int[io.length-1];
		int i = 0;
		int agg = 0;
		
		while(i<io.length){
			if (io[i]!=a){
				aggiornato[agg] = io[i];
				agg++;
			}
			i++;
		}
	
		return aggiornato;
	}

	public void toString(In_Out io){

		for (int i = 0; i<this.consegne.length; i++) {
			if (i==this.consegne.length-1) {
				System.out.println(io.getConsegne()[i]+";");
			} else if(i==0){
				System.out.print("Consegne da effettuare ai nodi: "+io.getConsegne()[i]+"-");
			} else { 
				System.out.print(io.getConsegne()[i]+"-");
			}
		}

		for (int i1 = 0; i1<this.ritiri.length; i1++) {
			if (i1==this.ritiri.length-1) {
				System.out.println(io.getRitiri()[i1]+";");
			} else if(i1==0){
				System.out.print("Ritiri da effettuare ai nodi: "+io.getRitiri()[i1]+"-");
			} else { 
				System.out.print(io.getRitiri()[i1]+"-");
			}
		}

	}

}
