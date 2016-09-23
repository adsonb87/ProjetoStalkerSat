package br.stalkersat.tipobem;

import java.util.ArrayList;

public interface IRepositorioTIpoBem {
	
	public void cadastrar (TipoBem tipoBem);
	public void atualizar (TipoBem tipoBem);
	public TipoBem procurar (Integer id);
	public boolean remover (Integer id);
	public boolean existe (Integer id);
	public ArrayList<TipoBem> listar();
}
