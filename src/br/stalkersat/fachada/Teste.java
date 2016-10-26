package br.stalkersat.fachada;

import br.stalkersat.bem.Bem;
import br.stalkersat.bem.ControladorBem;
import br.stalkersat.bem.RepositorioBemJDBC;

public class Teste {
	public static void main (String[] args){
		
		ControladorBem controlador = new ControladorBem();
	
		Fachada fachada = Fachada.getInstance();
		
		RepositorioBemJDBC r = new RepositorioBemJDBC();
		
		Bem bem = new Bem();
		bem.setIdBem(0);
		bem.setChassi("c2221");
		bem.setPlaca("plc1080");
		bem.setUsuario(fachada.procurarUsuario(1));
		bem.setTipoBem(fachada.procurarTipoBem(1));
		
		fachada.atualizarBem(bem);
		
		
		
	}
}
	
