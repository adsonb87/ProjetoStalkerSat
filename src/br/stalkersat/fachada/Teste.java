package br.stalkersat.fachada;

import br.stalkersat.contato.Contato;
import br.stalkersat.usuario.IRepositorioUsuario;
import br.stalkersat.usuario.RepositorioUsuarioJDBC;
import br.stalkersat.usuario.Usuario;

public class Teste {
	public static void main (String[] args){
		
		Fachada f = Fachada.getInstance();
		
		System.out.println(f.removerContato(3));
		
		
		
		
		
		
		
	}
}
