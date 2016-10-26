package br.stalkersat.bem;

import java.util.ArrayList;

import br.stalkersat.endereco.Endereco;

public class ControladorBem {
	
	private IRepostorioBem repositorioBem;
		
	public ControladorBem() {
		repositorioBem = new RepositorioBemJDBC();
	}
	
	public void cadastrarBem (Bem bem){
		repositorioBem.cadastrar(bem);
	}
	
	public void atualizarBem (Bem bem){
		repositorioBem.atualizar(bem);
	}
	
	public Bem procurarBem (Integer id){
		return repositorioBem.procurar(id);
	}
	
	public boolean removerBem(Integer id){
		if(procurarBem(id) != null){
			return repositorioBem.remover(id);
		}else{
			return false;
		}
	}
	
	public ArrayList<Bem> listarBens (){
		return repositorioBem.listar();
	}
}
