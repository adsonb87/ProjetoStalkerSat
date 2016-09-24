package br.stalkersat.bem;

import java.util.ArrayList;

public class ControladorBem {
	
	private IRepostorioBem repositorioBem;
	
	private static ControladorBem controladorBem;
	
	public static ControladorBem getInstance(){
		if(controladorBem == null){
			controladorBem = new ControladorBem();
		}
		return controladorBem;
	}
	
	private ControladorBem() {
		repositorioBem = new RepositorioBemJDBC();
	}
	
	public void cadastrarBem (Bem bem){
		repositorioBem.cadastrar(bem);
	}
	
	public void atualizarBem (Bem bem){
		repositorioBem.atualizar(bem);
	}
	
	public boolean removerBem(Integer id){
		return repositorioBem.remover(id);
	}
	
	public ArrayList<Bem> listarBens (){
		return repositorioBem.listar();
	}
}
