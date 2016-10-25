package br.stalkersat.localizacao;

import java.util.ArrayList;

public class ControladorLocalizacao {
	
	private IRepositorioLocalizacao repositorioLocalizacao;
	
	private static ControladorLocalizacao controladorLocalizacao;
	
	public ControladorLocalizacao() {
		repositorioLocalizacao = new RepositorioLocalizacaoJDBC();
	}
	
	public void cadastrarLocalizacao(Localizacao localizacao){
		repositorioLocalizacao.cadastrar(localizacao);
	}
	
	public void atualizarLocalizacao(Localizacao localizacao){
		repositorioLocalizacao.atualizar(localizacao);
	}
	
	public Localizacao procurarLocalizacao (Integer id){
		return repositorioLocalizacao.procurar(id);
	}
	
	public boolean removerLocalizacao(Integer id){
		return repositorioLocalizacao.remover(id);
	}
	
	public ArrayList<Localizacao> listarLocalizacao(){
		return repositorioLocalizacao.listar();
	}
}
