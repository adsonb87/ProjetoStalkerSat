package br.stalkersat.fachada;

import br.stalkersat.bem.RepositorioBemJDBC;

public class Teste {
	
	public static void main(String[] args){
	
		RepositorioBemJDBC r= new RepositorioBemJDBC();
				
		System.out.println(r.existe(5));
	}
}
