package br.stalkersat.contato;

import java.util.ArrayList;

import br.stalkersat.exceptions.ErrorException;

public class ControladorContato {

	private IRepositorioContato repositorioContato;
	
	private static ControladorContato controladorContato;
	
	public ControladorContato() {
		repositorioContato = new RepositorioContatoJDBC();
	}
	
	public void cadastrarContato(Contato contato)throws ErrorException{
		if(contato != null){
			repositorioContato.cadastrar(contato);
		}else{
			throw new ErrorException("Contato nulo");
		}
	}
	
	public void atualizarContato(Contato contato) throws ErrorException{
		if(contato.getIdContato() != null){
			repositorioContato.atualizar(contato);
		}else{
			throw new ErrorException("Contato nulo");
		}
	}
	
	public Contato procurarContato (Integer id)throws ErrorException{
		if(id != null ){
			return repositorioContato.procurar(id);
		}else{
			throw new ErrorException("Id não encontrado");
		}
	}
	
	
	public boolean removerContato (Integer id) throws ErrorException{
		if(id != null){
			if(procurarContato(id) != null){
				return repositorioContato.remover(id);
			}else{
				return false;
			}
		}else{
			throw new ErrorException("Id não localizado");
		}
	}
	
	public ArrayList<Contato> listarContato(){
		return repositorioContato.listar();
	}
	
	public ArrayList<Contato> listarContatoPorUsuario(Integer id)throws ErrorException{
		if(id !=null){
			return repositorioContato.listarPorUsuario(id);			
		}else{
			throw new ErrorException("Id não localizado");
		}
	}
}
