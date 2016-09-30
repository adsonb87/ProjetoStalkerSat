package br.stalkersat.fachada;

import br.stalkersat.tipocontato.ControladorTipoContato;

public class Teste {
	
	public static void main(String[] args){
	
		Fachada f = Fachada.getInstance();
		
		System.out.println(f.listarBens());
		
	}
}
