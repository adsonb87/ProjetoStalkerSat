package br.stalkersat.fachada;

import br.stalkersat.contato.Contato;
import br.stalkersat.usuario.IRepositorioUsuario;
import br.stalkersat.usuario.RepositorioUsuarioJDBC;
import br.stalkersat.usuario.Usuario;

public class Teste {
	public static void main (String[] args){
		
		Fachada f = Fachada.getInstance();
		
		Usuario u = new Usuario("cpf","hugo campos","login","senha",f.procurarTipoUsuario(1),f.procurarEndereco(3));
		u.setIdUsuario(2);
		
		f.atualizarUsuario(u);
		
		
		
		
		
		
		
		
	}
}
