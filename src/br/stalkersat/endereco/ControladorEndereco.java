package br.stalkersat.endereco;

import java.util.ArrayList;

import org.hibernate.hql.internal.ast.ErrorReporter;

public class ControladorEndereco {
	
	private IRepositorioEndereco repositorioEndereco;
	
	private static ControladorEndereco controladorEndereco;
	
	public ControladorEndereco() {
		repositorioEndereco = new RepositorioEnderecoJDBC();
	}
	
	public void cadastrarEndereco (Endereco endereco){
		repositorioEndereco.cadastrar(endereco);
	}
	
	public void atualizarEndereco (Endereco endereco){
		repositorioEndereco.atualizar(endereco);
	}
	
	public boolean removerEndereco (Integer id){
		return repositorioEndereco.remover(id);
	}
	
	public Endereco procurarEndereco (Integer id){
		return repositorioEndereco.procurar(id);
	}
	
	public ArrayList<Endereco> listarEndereco(){
		return repositorioEndereco.listar();
	}
}
