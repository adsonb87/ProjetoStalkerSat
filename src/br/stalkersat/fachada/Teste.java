package br.stalkersat.fachada;

import br.stalkersat.bem.Bem;

public class Teste {
	public static void main (String[] args){
		
		Fachada f = Fachada.getInstance();
		
		Bem bem = new Bem(2, "adsa123kjj32", "pct1080", f.procurarTipoBem(1), f.procurarUsuario(2));
		
		
		
	
		
		
	}
}
	
