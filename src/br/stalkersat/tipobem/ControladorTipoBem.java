package br.stalkersat.tipobem;

import java.util.ArrayList;

public class ControladorTipoBem {
	
	private IRepositorioTIpoBem repositorioTipoBem;
	
	private static ControladorTipoBem controladorTipoBem;
	
	public ControladorTipoBem() {
		repositorioTipoBem = new RepositorioTipoBemJDBC();
	}
	
	public void cadastrarTipoBem(TipoBem tipoBem){
		repositorioTipoBem.cadastrar(tipoBem);
	}
	
	public void atualizarTipoBem(TipoBem tipoBem){
		repositorioTipoBem.atualizar(tipoBem);
	}
	
	public TipoBem procurarTipoBem (Integer id){
		return repositorioTipoBem.procurar(id);
	}
	
	public boolean removerTipoBem(Integer id){
		return repositorioTipoBem.remover(id);
	}
	
	public ArrayList<TipoBem> listarTipoBem(){
		return repositorioTipoBem.listar();
	}
}
