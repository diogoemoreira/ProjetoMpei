package projetoMpei;

public class BloomFilter {
	/*TODO 
	 * k is not yet implemented
	 * m is not yet calculated
	 * ------??--------
	 * n = n*1.3?
	 * k = ?
	 * Can we use java's hash function?
	 * */
	
	
	//P(bit ser 1) = 1/n; //P(bit ser 0) = 1-1/n;
	private int n; //n bits (size of the bloom array)		<------------ n*1.3
	private int m; //m elements (number of elements)    <------------ Calculado na leitura do ficheiro
	private int k; //k functions (number of hash functions) <------------ Como calcular?
	private int[] filter; //array of bloom 
	
	
	public BloomFilter(int n, int k) { //Constructor
		this.n = (int)Math.ceil(n*1.3);
		this.k = k;
		this.m = 0;
		this.filter = new int[this.n];
	}
	
	
	public void add(String phrase) { //Add element to array
		
		int index = phrase.hashCode()%n;
		filter[index] = 1;
		m++;
		
	}
	
	
	public boolean contains(String phrase) { //Check if element is in array
		int index = phrase.hashCode()%n;
		
		if (filter[index]==1) {
			return true;
		}
		else {
			return false;
		}
		
	}

	//Getters

	public int getN() {
		return n;
	}


	public int getM() {
		return m;
	}


	public int getK() {
		return k;
	}


	public int[] getFilter() {
		return filter;
	}
	
	
}
