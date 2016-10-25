package br.stalkersat.usuario;

import java.util.ArrayList;

import br.stalkersat.tipousuario.ControladorTipoUsuario;
import br.stalkersat.tipousuario.IRepositorioTipoUsuario;
import br.stalkersat.tipousuario.RepositorioTipoUsuarioJDBC;
import br.stalkersat.tipousuario.TipoUsuario;

public class ControladorUsuario {

	private IRepositorioUsuario repositorioUsuario;
	
	private static ControladorUsuario controladorUsuario;
	
	public ControladorUsuario() {
		repositorioUsuario = new RepositorioUsuarioJDBC();
	}
	
	public void cadastrarUsuario(Usuario usuario){
		repositorioUsuario.cadastrar(usuario);
	}
	
	public void atualizarUsuario(Usuario usuario){
		repositorioUsuario.atualizar(usuario);
	}
	
	public Usuario procurarUsuario (Integer id){
		return repositorioUsuario.procurar(id);
	}
	
	public boolean removerUsuario(Integer id){
		return repositorioUsuario.remover(id);
	}
	
	public ArrayList<Usuario> listarUsuario(){
		return repositorioUsuario.listar();
	}
}
