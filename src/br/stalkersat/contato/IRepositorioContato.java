package br.stalkersat.contato;

import java.util.ArrayList;

public interface IRepositorioContato {
	
	public void cadastrar (Contato contato);
	public void atualizar (Contato contato);
	public Contato procurar (Integer id);
	public boolean remover (Integer id);
	public boolean existe (Integer id);
	public ArrayList<Contato> listar ();
	
}
