package org.component;

public class Grafo {

	private int[][] grafo;
	private int m;
	private int n;

	public Grafo(int m, int n){
		this.m = m;
		this.n = n;
		this.grafo = new int[m][n];
	}

	public int[][] getGrafo() {
		return grafo;
	}

	public void setGrafo(int[][] grafo) {
		this.grafo = grafo;
	}

	public int getElement(Grafo g, int m, int n) {
		return grafo[m][n];
	}

	public void setElement(int m, int n, int set) {
		grafo[m][n] = set;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
		this.grafo = new int[m][this.n];
	}


	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
		this.grafo = new int[this.m][n];
	}

	public int[] estraiArchi(Grafo g, int i){
		if (i<g.getN()) {
			return g.getGrafo()[i];
		} else return null;

	}

	public void toString(Grafo g){

		System.out.println("Grafo "+g.getM()+"x"+g.getN());
		for (int i = 0; i<this.m; i++){
			for (int j = 0; j<this.n; j++){
				if (j==0){
					System.out.print("{["+g.getElement(g, i, j)+"]");	
				}

				if (j!=0 && j!=this.n-1)
					System.out.print("["+g.getElement(g, i, j)+"]");

				if (j==this.n-1) {
					System.out.println("["+g.getElement(g, i, j)+"]}");
				}
			}
		}
	}

}
