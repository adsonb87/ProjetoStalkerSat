package br.stalkersat.usuario;

import java.util.ArrayList;

import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.tipousuario.ControladorTipoUsuario;
import br.stalkersat.tipousuario.IRepositorioTipoUsuario;
import br.stalkersat.tipousuario.RepositorioTipoUsuarioJDBC;
import br.stalkersat.tipousuario.TipoUsuario;

public class ControladorUsuario {

	private IRepositorioUsuario repositorioUsuario;
		
	public ControladorUsuario() {
		repositorioUsuario = new RepositorioUsuarioJDBC();
	}
	
	public void cadastrarUsuario(Usuario usuario) throws ErrorException{
		if(usuario != null){
			repositorioUsuario.cadastrar(usuario);
		}else{
			throw new ErrorException("Usuario nulo");
		}
	}
	
	public void atualizarUsuario(Usuario usuario) throws ErrorException{
		if(usuario.getIdUsuario() != null){
			repositorioUsuario.atualizar(usuario);
		}else{
			throw new ErrorException("Usuario não identificado");
		}
	}
	
	public Usuario procurarUsuario (Integer id) throws ErrorException{
		if(id != null){
			return repositorioUsuario.procurar(id);
		}else{
			throw new ErrorException("Id não localizado");
		}
	}
	
	public boolean removerUsuario(Integer id) throws ErrorException{
		if(id != null){
			if(procurarUsuario(id) != null){
				return repositorioUsuario.remover(id);
			}else{
				return false;
			}
		}else{
			throw new ErrorException("Id não localizado");
		}
	}
	
	public ArrayList<Usuario> listarUsuario(){
		return repositorioUsuario.listar();
	}
}
