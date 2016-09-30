package br.stalkersat.tipocontato;

import java.util.ArrayList;

import br.stalkersat.tipobem.TipoBem;

public class ControladorTipoContato {
	
	private IRepositorioTipoContato repositorioTipoContato;
	
	private static ControladorTipoContato controladorTipoContato;
	
	public static ControladorTipoContato getInstance(){
		if(controladorTipoContato == null){
			controladorTipoContato = new ControladorTipoContato();
		}
		return controladorTipoContato;
	}
	
	private ControladorTipoContato() {
		repositorioTipoContato = new RepositorioTipoContatoJDBC();
	}
	
	public void cadastrarTipoContato(TipoContato tipoContato){
		repositorioTipoContato.cadastrar(tipoContato);
	}
	
	public void atualizarTipoContato(TipoContato tipoContato){
		repositorioTipoContato.atualizar(tipoContato);
	}
	
	public TipoContato procurarTipoContato (Integer id){
		return repositorioTipoContato.procurar(id);
	}
	
	public boolean removerTipoContato(Integer id){
		return repositorioTipoContato.remover(id);
	}
	
	public ArrayList<TipoContato> listarTipoContato(){
		return repositorioTipoContato.listar();
	}
}
