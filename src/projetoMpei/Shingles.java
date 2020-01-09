package projetoMpei;

import java.util.ArrayList;

//usamos shingles se a ordem nas palavras for importante
// Similaridade em shingles = #intersecao(a,b) / (#a+#b)-#intersecao(a,b)
public class Shingles {
	
	ArrayList<String> kshingle=new ArrayList<String>();
	//("\\s*(\\s|,)\\s*|[\\.\\?!]+"); regex para espacos e ,!?.
	
	public Shingles(String s,int k) { //k=5 -> doc curtos  , k=10 -> documentos longos
		// the sets are k-shingles
		String safter= s.toLowerCase();
		safter=safter.trim().replaceAll("[^A-Za-z0-9\\-]+", " ");
		
		for(int i=0;i<=(safter.length()-k);i++) {
				this.kshingle.add( safter.substring(i, i+k) );
		}//a funcao shingle esta a dar um bug estranho em que as vezes adiciona um espaco
	}
	
	public ArrayList<String> getKshingle() {
		return kshingle;
	}

	@Override
	public String toString() {
		return "shingle=" + kshingle;
	}

	
	
}
