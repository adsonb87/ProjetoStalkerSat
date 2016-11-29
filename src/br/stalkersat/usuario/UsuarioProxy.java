package br.stalkersat.usuario;

public class UsuarioProxy extends Usuario{
	
	private String login;
	private String senha;
	
	public UsuarioProxy(String login, String senha){
		this.login = login;
		this.senha = senha;
	}
	
	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public boolean getPermissao(String loginUsuario, String senhaUsuario){
		if(obterPermissao(loginUsuario, senhaUsuario)){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean obterPermissao(String loginUsuario, String senhaUsuario){
		return login.equalsIgnoreCase(loginUsuario) && senha.equalsIgnoreCase(senhaUsuario);
	}
	
	
}
