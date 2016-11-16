package br.stalkersat.fachada;

import br.stalkersat.contato.Contato;
import br.stalkersat.usuario.IRepositorioUsuario;
import br.stalkersat.usuario.RepositorioUsuarioJDBC;
import br.stalkersat.usuario.Usuario;

public class Teste {
	public static void main (String[] args){
		
		Fachada f = Fachada.getInstance();
		
		Usuario u = new Usuario("cpf","mama rola","login","senha",f.procurarTipoUsuario(1),f.procurarEndereco(3));
		
		IRepositorioUsuario r = new RepositorioUsuarioJDBC();
		
		f.cadastrarUsuario(u);
		
		
		
		
		
		
		
		
		
	}
}
