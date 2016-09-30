package br.stalkersat.tipocontato;

import java.util.ArrayList;

public interface IRepositorioTipoContato {
	
	public void cadastrar(TipoContato tipoContato);
	public void atualizar (TipoContato tipoContato);
	public TipoContato procurar(Integer id);
	public boolean remover (Integer id);
	public boolean existe (String tipo);
	public ArrayList<TipoContato> listar();
	
}
