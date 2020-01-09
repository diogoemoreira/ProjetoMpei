package projetoMpei;
import java.util.*;


public class TextAssist {
	
	// O Bloom Filter vai codificar a frase que for introduzida atribuindo-lhe um indice e depois vai por o valor a 1 nesse indice.
	// Quando escrevemos uma frase vamos codifica-la com a mesma hash function e verificar se esse valor é 1 no array, se for esse valor é provavel ele existe
	
	public static void main(String[] args) {
		
		//TODO:
		//- adicionar um ficheiro pra ler para realizar testes
		//- realizar testes mais pormenorizados para as funcoes feitas
		
		//HashFuntion
		HashFunctionMH a= new HashFunctionMH("bas dwasc",1);
		HashFunctionBF a1= new HashFunctionBF("bas dwasc",100,1);
		HashFunctionBF b= new HashFunctionBF("absd wasc",100,1);
		HashFunctionBF c= new HashFunctionBF("bas wdacs",100,1);
		HashFunctionMH d= new HashFunctionMH("some r a n d o m     sTrInG",1);
		HashFunctionMH d0= new HashFunctionMH("some r a n d o m sTrInG",1);
		HashFunctionMH d2= new HashFunctionMH("some r a n d o m     sTrInG",100);
		HashFunctionMH d02= new HashFunctionMH("some r a n d o m sTrInG",100);
		System.out.println("\"bas dwasc\", hashcode:"+a1.getHcode()+"\n\"bas dwasc\", hashcode:"+a.getHcode() + "\n\"absd wasc\", hashcode: " + b.getHcode()
		+ "\n\"bas wdacs\", hashcode: " + c.getHcode() + "\n\"some r a n d o m     sTrInG\", hashcode: "+d.getHcode()+"\nand its MinArray:"+d2.getMinArray()
		+ "\n\n\"some r a n d o m sTrInG\", hashcode: "+d0.getHcode()+"\nanditsMinArray:"+d02.getMinArray());
		//HashFunction
		
		//shingles + minhash
		Shingles ks=new Shingles("Hoje      nesta manha  um lindo dia",5);
		System.out.println("\n\"Hoje      nesta manha  um lindo dia\"\n"+ks.toString()+ "\n");
		
		Shingles ks0=new Shingles("Nesta manha linda    um dia",5);
		System.out.println("\"Nesta manha linda    um dia\"\n"+ks0.toString()+ "\n");
		
		Shingles ks2=new Shingles("a!b c.d?a guarda-chuva",5);
		System.out.println("\"a!b c.d?a guarda-chuva\"\n"+ks2.toString()+"\n");
		//o shingle funciona por palavra
		
		//minhash
			String str="O aviao de papel passa pela ria";
			String str1="Na ria vimos um aviao a passar";
			ArrayList<String> strg=new ArrayList<String>();
			strg.add(str);strg.add(str1);
			MinHash mh=new MinHash(strg);
			String testString="Na ria vimos um camiao de papel";
			System.out.println("Frase a comparar: "+testString);
			System.out.println(mh.SimilaridadeJaccard(testString).toString());
			String testString2="O aviao de papel";
			System.out.println("\nFrase a comparar: "+testString2);
			System.out.println(mh.SimilaridadeJaccard(testString2).toString());
			String testString3="O aviao de papel passa pela ria";
			System.out.println("\nFrase a comparar: "+testString3);
			System.out.println(mh.SimilaridadeJaccard(testString3).toString());
			String str0="O Joao levantou o braco fazer uma pergunta";
			String str01="A professora continuou a escrever no quadro";
			strg.add(str0);strg.add(str01);
			mh=new MinHash(strg);
			String testString0="O joao levantou uma pergunta";
			System.out.println("\nFrase a comparar: "+testString0);
			System.out.println(mh.SimilaridadeJaccard(testString0).toString());
			String testString02="Nada a ver";
			System.out.println("\nFrase a comparar: "+testString02);
			System.out.println(mh.SimilaridadeJaccard(testString02).toString());
			String testString03="A professora nao escreve no quadro";
			System.out.println("\nFrase a comparar: "+testString03);
			System.out.println(mh.SimilaridadeJaccard(testString03).toString());
			
		//
		
	}
}