package br.stalkersat.fachada;

import java.util.Random;

public class Teste {

	public static void main(String[] args){
		
//		Random  r = new Random();
//		
//		int num = r.nextInt(2);
//		
//		if(num==0){
//			num = 20;
//		}
		
		System.out.println(sortear());
		
		
	}
	
	public static int sortear(){
		Random r = new Random();
		int num = r.nextInt(3);
		if(num == 0){
			return sortear();
		}else{
			return num;
		}
	}
}
