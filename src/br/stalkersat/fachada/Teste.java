package br.stalkersat.fachada;

import br.stalkersat.bem.ControladorBem;

public class Teste {
	
	public static void main(String[] args){
	
	Fachada f = Fachada.getInstance();
	
	System.out.println(f.procurarBem(1));

	}
}
