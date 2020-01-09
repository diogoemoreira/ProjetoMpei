package projetoMpei;

import java.util.ArrayList;
import java.util.Random;

// for now empty as we used java hash function

public class HashFunctionBF {

	int hcode;
	static ArrayList<Integer> rndList=new ArrayList<Integer>(); // guarda os random para  serem utilizados na geracao de varias funcoes hash
	ArrayList<Integer> hashCodes=new ArrayList<Integer>(); //guarda k hashcodes criados na geracao de k funcoes hash
	
	public HashFunctionBF(String s,int n,int k) {  
		/* s- string que precisamos de dar hascode
		 * n- numero de elementos do array
		 * k- numero de funcoes hash
		 */
		while( rndList.size()<k ) { 
			//guardar os random caso seja necessario fazer o mesmo numero de funcoes para ver se uma frase e igual
			Random rnd=new Random();
			int irnd = rnd.nextInt((n-1)+1)+1;
			rndList.add(irnd);
		}
		
		for(int j=0;j<k;j++) {
			String safter = s.trim().replaceAll(" +", " ");
			safter= safter.toLowerCase();
			int strlen = safter.length();
			int hcode = 109;
			
			for(int i=0;i<strlen;i++) {
				hcode+= hcode*911 *rndList.get(j) + safter.charAt(i	);
			}

			hcode=hcode%n;
			if(hcode<0) {
				hcode=n+hcode;
			}
			this.hcode=hcode;
			
			hashCodes.add(hcode);
		}
	}

	public ArrayList<Integer> getHashCodes() {
		return hashCodes;
	}

	public int getHcode() {
		return hcode;
	}
	
}
