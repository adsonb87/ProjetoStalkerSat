package br.stalkersat.fachada;

import br.stalkersat.localizacao.RepositorioLocalizacaoJDBC;
import br.stalkersat.tipocontato.ControladorTipoContato;
import br.stalkersat.usuario.RepositorioUsuarioJDBC;

public class Teste {
	
	public static void main(String[] args){
	
		RepositorioUsuarioJDBC r = new RepositorioUsuarioJDBC();
		
		System.out.println(r.listar());
		
		
		
	}
}
