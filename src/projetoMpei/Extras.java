package projetoMpei;
/*
public class Extras {
	public boolean similarity(String a,String b,int n) {
		if(new HashFunction(a,n)==new HashFunction(b,n)) {
			return a.equalsIgnoreCase(b);
		}
		else {
			return false;
		}
	}
}
*/

/* A measure of how similar these two sets are is known as the Jaccard Coefficient.
 *  It is calculated as number of common elements / (total number of elements - number of common elements).
 * Similaridade de Jaccard = #intersecao(a,b) / #uniao(a,b)  - character-level similarity
*bag-similarity  =  #intersecao(a,b) / #a + #b
*Set a = new Set(["chair", "desk", "rug", "keyboard", "mouse"]);
*Set b = new Set(["chair", "rug", "keyboard"]);
*we have a total of 8 elements. So the Jaccard Coefficient  = 3 / (8 - 3) = 0.6, or 60%
*
*
*
*	public double[][] distanciaJaccard() { //calcula a distancia de Jaccard
		double[][] distJacc=new double[nfrases][nfrases];
		double commonElements=0;
		
		
		for(int i=0;i<nfrases;i++) {
			
			for(int j=i+1;j<nfrases;j++) {
				for(int z=0; z<this.k;z++) {
					if(assinaturas.get(i)[z]==assinaturas.get(j)[z]) {
						commonElements++;
					}
				}
				distJacc[i][j]=1-(commonElements/(double)k);
				}
			}
		return distJacc;
	}
*/
