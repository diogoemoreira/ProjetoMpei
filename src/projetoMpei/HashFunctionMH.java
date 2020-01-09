package projetoMpei;

import java.util.ArrayList;

public class HashFunctionMH {
	
	int hcode;
	
	private static ArrayList<Integer> rndList=new ArrayList<Integer>(); // guarda os random para  serem utilizados na geracao de varias funcoes hash
	private ArrayList<Integer> minArray=new ArrayList<Integer>();
	
	public HashFunctionMH(String s,int k) {
	/* s- string que precisamos de dar hascode
	 * k- numero de funcoes hash
	 */
	while( rndList.size()<k ) { 
		//guardar os random caso seja necessario fazer o mesmo numero de funcoes para ver se uma frase e igual
		int irnd = (int) (Math.random()*(8009-109 +1)+1);
		rndList.add(irnd);
	}
	
	String safter= s.toLowerCase();
	ArrayList<String> arrayString=new ArrayList<String>();
	//arrayString=safter.split(" ");
	Shingles ks=new Shingles(safter,5);
	arrayString=ks.getKshingle();	
	
	for(int j=0;j<k;j++) { //cada hash function
		int min=Integer.MAX_VALUE;
		int hcode = 0;
		
		for(int z=0;z<arrayString.size();z++) { //cada palavra do shingle
			int strlen = arrayString.get(z).length();
			for(int i=0;i<strlen;i++) { //calculo do hash code
				hcode+= hcode*997*rndList.get(j) + arrayString.get(z).charAt(i);
			}
			hcode=hcode%6217;
			hcode=Math.abs(hcode);
			this.hcode=hcode;
			
			if(min>hcode) {
				min=hcode;
			}	
		}
		minArray.add(min); //adicionar o minimo da frase ao array de minimos
	}
}

public ArrayList<Integer> getMinArray() {
		return minArray;
	}

public long getHcode() {
	return hcode;
}
}
