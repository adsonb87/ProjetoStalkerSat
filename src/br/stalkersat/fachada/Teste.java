package br.stalkersat.fachada;

import br.stalkersat.contato.RepositorioContatoJDBC;
import br.stalkersat.localizacao.RepositorioLocalizacaoJDBC;
import br.stalkersat.tipocontato.ControladorTipoContato;
import br.stalkersat.usuario.RepositorioUsuarioJDBC;

public class Teste {
	
	public static void main(String[] args){
	
		RepositorioContatoJDBC c = new RepositorioContatoJDBC();
		
		System.out.println(c.listar());
		
	}
}
