package projetoMpei;

import java.util.ArrayList;
import java.util.HashMap;

public class MinHash {		
	private int k=100; //n hashfunctions
	static private HashMap<String,ArrayList<Integer>> mapAssinaturas=new HashMap<String,ArrayList<Integer>>();  //<frase,k hash>
	
	public MinHash(ArrayList<String> args) { //recebe as frases
		
		for (int i=0;i<args.size();i++){
			mapAssinaturas.put(args.get(i), assinatura(args.get(i)) ); //adicionar o array dos minimos do elemento ao array
		}
	}
	
	public ArrayList<Integer> assinatura(String arg) {
			HashFunctionMH hash=new HashFunctionMH(arg,this.k); //k=100
			ArrayList<Integer> minArray=hash.getMinArray(); //busca o array de k minimos
			return minArray;//devolve um array com k hash minimos para a string
	}
	
	public ArrayList<String> SimilaridadeJaccard(String s) { //calcula a similaridade de Jaccard
		//a similaridade so funciona quando o inicio da frase é igual a original
		ArrayList<String> similares=new ArrayList<String>();
		ArrayList<Integer> sAssinatura=assinatura(s);
		
		for (HashMap.Entry<String,ArrayList<Integer>> entry : mapAssinaturas.entrySet()) {
		    ArrayList<Integer> value = entry.getValue();
		    double commonElements=0;
		    for(int j=0;j<this.k;j++) {
			    	if(value.contains(sAssinatura.get(j))) {
			    		commonElements++;
			    	}
		    }
		    double similarity = commonElements/this.k;
		    similares.add(entry.getKey()+" ;Similaridade:"+similarity);
		}

		return similares;
	}

	public void addAssinatura(String s) {
		mapAssinaturas.put(s, assinatura(s) );
	}
	
	/*Jaccard coeficient= number of common elements / (total number of elements - number of common elements)
	1. Break down the document a set of shingles.
	2. Calculate the hash value for every shingle.
	3. Store the minimum hash value found in step 2.
	4. Repeat steps 2 and 3 with different hash algorithms	*/
	
	//tranformar um set em um array de inteiros
	//usar varias hashfunctions k=100
	//depois de fazer as 100 hashfunctions ver qual foi o menor valor dos 100 hashcodes e guardamos num array com tamanho k
	//se o hashcode der igual os elementos sao iguais
	// 1-minHash = dist.Jaccard
	// Quanto menor a dist. Jaccard mais similar sao os elementos
	// a funcao minHash deve dar return ao array com os minHash dos elementos
	// Quanto maior for o k maior o grau de granulariade e mais real e a estimativa
}
