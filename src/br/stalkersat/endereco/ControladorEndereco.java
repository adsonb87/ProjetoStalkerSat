package br.stalkersat.endereco;

import java.util.ArrayList;

import org.hibernate.hql.internal.ast.ErrorReporter;

import br.stalkersat.exceptions.ErrorException;

public class ControladorEndereco {
	
	private IRepositorioEndereco repositorioEndereco;
	
	private static ControladorEndereco controladorEndereco;
	
	public ControladorEndereco() {
		repositorioEndereco = new RepositorioEnderecoJDBC();
	}
	
	public void cadastrarEndereco (Endereco endereco)  throws ErrorException{
		if(endereco !=null){
			repositorioEndereco.cadastrar(endereco);
		}else{
			throw new ErrorException("Endereço nulo");
		}
	}
	
	public void atualizarEndereco (Endereco endereco) throws ErrorException{
		if(endereco.getIdEndereco() != null){
			repositorioEndereco.atualizar(endereco);
		}else{
			throw new ErrorException("Id não localizado");
		}
	}
	
	public boolean removerEndereco (Integer id) throws ErrorException{
		if(id != null){
			if(procurarEndereco(id) != null){
				return repositorioEndereco.remover(id);		
			}else{
				return false;
			}
		}else{
			throw new ErrorException("Id não localizado");
		}
	}
	
	public Endereco procurarEndereco (Integer id) throws ErrorException{
		if(id != null){
			return repositorioEndereco.procurar(id);
		}else{
			throw new ErrorException("Id não localizado");
		}
	}
	
	public ArrayList<Endereco> listarEndereco(){
		return repositorioEndereco.listar();
	}
}
