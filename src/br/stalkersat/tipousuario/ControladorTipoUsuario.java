package br.stalkersat.tipousuario;

import java.util.ArrayList;

import br.stalkersat.tipobem.RepositorioTipoBemJDBC;
import br.stalkersat.tipobem.TipoBem;
import br.stalkersat.tipocontato.ControladorTipoContato;

public class ControladorTipoUsuario {

	private IRepositorioTipoUsuario repositorioTipoUsuario;
	
	private static ControladorTipoUsuario controladorTipoUsuario;
	
	public static ControladorTipoUsuario getInstance(){
		if(controladorTipoUsuario == null){
			controladorTipoUsuario = new ControladorTipoUsuario();
		}
		return controladorTipoUsuario;
	}
	
	private ControladorTipoUsuario() {
		repositorioTipoUsuario = new RepositorioTipoUsuarioJDBC();
	}
	
	public void cadastrarTipoUsuario(TipoUsuario tipoUsuario){
		repositorioTipoUsuario.cadastrar(tipoUsuario);
	}
	
	public void atualizarTipoUsuario (TipoUsuario tipoUsuario){
		repositorioTipoUsuario.atualizar(tipoUsuario);
	}
	
	public TipoUsuario procurarTipoUsuario (Integer id){
		return repositorioTipoUsuario.procurar(id);
	}
	
	public boolean removerTipoUsuario(Integer id){
		return repositorioTipoUsuario.remover(id);
	}
	
	public ArrayList<TipoUsuario> listarTipoUsuario(){
		return repositorioTipoUsuario.listar();
	}
}
