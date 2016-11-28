package br.stalkersat.bem;

import java.util.ArrayList;

import br.stalkersat.endereco.Endereco;
import br.stalkersat.exceptions.ErrorException;

public class ControladorBem {
	
	private IRepostorioBem repositorioBem;
	
	public ControladorBem() {
		repositorioBem = new RepositorioBemJDBC();
	}
	
	public void cadastrarBem (Bem bem) throws ErrorException{
		if(bem != null){
			repositorioBem.cadastrar(bem);
		}else{
			throw new ErrorException("Bem Nulo");
		}
	}
	
	public void atualizarBem (Bem bem)throws ErrorException{
		if(bem.getIdBem() != null){
			repositorioBem.atualizar(bem);			
		}else{
			throw new ErrorException("Bem nulo");
		}
	}
	
	public Bem procurarBem (Integer id) throws ErrorException{
		if(id!=null){
			return repositorioBem.procurar(id);
		}else{
			throw new ErrorException("Id não localizado");
		}
	}
	
	public boolean removerBem(Integer id) throws ErrorException{
		if(id != null){
			if(procurarBem(id) != null){
				return repositorioBem.remover(id);
			}else{
				return false;
			}
		}else{
			throw new ErrorException("Id não localizado");
		}
	}
	
	public ArrayList<Bem> listarBens (){
		return repositorioBem.listar();
	}
	
	public ArrayList<Bem> listarBemPorUsuario(Integer id) throws ErrorException{
		if(id != null){
			return repositorioBem.listarPorUsuario(id);
		}else{
			throw new ErrorException("Id não localizado");
		}
	}
}
