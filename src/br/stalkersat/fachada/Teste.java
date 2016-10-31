package br.stalkersat.fachada;

import br.stalkersat.bem.Bem;

public class Teste {
	public static void main (String[] args){
		
		Fachada f = Fachada.getInstance();
		
		Bem bem = new Bem("chassi", "placa 100", f.procurarTipoBem(1), f.procurarUsuario(1));
		
		f.removerBem(4);
		
		System.out.println(f.listarBens());
	
		
		
	}
}
	
