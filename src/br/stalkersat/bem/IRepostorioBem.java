package br.stalkersat.bem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IRepostorioBem {
	
	public void cadastrar (Bem bem);
	public void atualizar (Bem bem);
	public Bem procurar (Integer id);
	public boolean remover (Integer id);
	public boolean existe (String chassi);
	public ArrayList<Bem> listar ();
}
