package br.stalkersat.contato;

import java.util.ArrayList;

public class ControladorContato {

	private IRepositorioContato repositorioContato;
	
	private static ControladorContato controladorContato;
	
	public static ControladorContato getInstance(){
		if(controladorContato == null){
			controladorContato = new ControladorContato();
		}
		return controladorContato;
	}
	
	private ControladorContato() {
		repositorioContato = new RepositorioContatoJDBC();
	}
	
	public void cadastrarContato(Contato contato){
		repositorioContato.cadastrar(contato);
	}
	
	public void atualizarContato(Contato contato){
		repositorioContato.atualizar(contato);
	}
	
	public Contato procurarContato (Integer id){
		return repositorioContato.procurar(id);
	}
	
	
	public boolean removerContato (Integer id){
		return repositorioContato.remover(id);
	}
	
	public ArrayList<Contato> listarContato(){
		return repositorioContato.listar();
	}
}
