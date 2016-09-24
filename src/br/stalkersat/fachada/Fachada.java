package br.stalkersat.fachada;

import java.util.ArrayList;

import br.stalkersat.bem.Bem;
import br.stalkersat.bem.ControladorBem;
import br.stalkersat.bem.RepositorioBemJDBC;

public class Fachada {
	
	private ControladorBem controladorBem;
	
	private static Fachada fachada;
	
	public static Fachada getInstance(){
		if(fachada == null){
			fachada = new Fachada();
		}
		return fachada;
	}
	
	private Fachada() {
		controladorBem.getInstance();
	}
	
	//Bem 
	
	public void cadastrarBem (Bem bem){
		controladorBem.cadastrarBem(bem);
	}
	
	public void atualizarBem (Bem bem){
		controladorBem.atualizarBem(bem);
	}
	
	public boolean removerBem(Integer id){
		return controladorBem.removerBem(id);
	}
	
	public ArrayList<Bem> listarBens (){
		return controladorBem.listarBens();
	}
}
