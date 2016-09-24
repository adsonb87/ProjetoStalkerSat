package br.stalkersat.tipobem;

import java.util.ArrayList;

public class ControladorTipoBem {
	
	private IRepositorioTIpoBem repositorioTipoBem;
	
	private static ControladorTipoBem controladorTipoBem;
	
	public static ControladorTipoBem getInstance(){
		if(controladorTipoBem == null){
			controladorTipoBem = new ControladorTipoBem();
		}
		return controladorTipoBem;
	}
	
	private ControladorTipoBem() {
		repositorioTipoBem = new RepositorioTipoBemJDBC();
	}
	
	public void cadastrarTipoBem(TipoBem tipoBem){
		repositorioTipoBem.cadastrar(tipoBem);
	}
	
	public void atualizarTipoBem(TipoBem tipoBem){
		repositorioTipoBem.atualizar(tipoBem);
	}
	
	public boolean removerTipoBem(Integer id){
		return repositorioTipoBem.remover(id);
	}
	
	public ArrayList<TipoBem> listarTipoBem(){
		return repositorioTipoBem.listar();
	}
}
