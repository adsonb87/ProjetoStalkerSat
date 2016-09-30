package br.stalkersat.tipousuario;

import java.util.ArrayList;

public interface IRepositorioTipoUsuario {
	
	public void cadastrar(TipoUsuario tipoUsuario);
	public TipoUsuario procurar(Integer id);
	public void atualizar (TipoUsuario tipoUsuario);
	public boolean remover (Integer id);
	public boolean existe (String tipo);
	public ArrayList<TipoUsuario> listar();
}
