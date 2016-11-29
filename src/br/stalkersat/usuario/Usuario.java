package br.stalkersat.usuario;

import java.util.ArrayList;

import br.stalkersat.bem.Bem;
import br.stalkersat.contato.Contato;
import br.stalkersat.endereco.Endereco;
import br.stalkersat.tipousuario.TipoUsuario;

public class Usuario {
	
	private Integer idUsuario;
	private Endereco endereco;
	private String cpf;
	private String nome;
	private String login;
	private String senha;
	private TipoUsuario tipoUsuario;
	private ArrayList<Contato> listaContatos;
	private ArrayList<Bem> listaBens;
	
	public Usuario(String cpf, String nome, String login, String senha, TipoUsuario tipoUsuario, Endereco endereco) {
		this.setCpf(cpf);
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.endereco = endereco;
	}
	
	public Usuario(String cpf, String nome, String login, String senha, TipoUsuario tipoUsuario) {
		this.setCpf(cpf);
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}
	
	public Usuario(Integer id, String cpf, String nome, String login, String senha, TipoUsuario tipoUsuario, Endereco endereco) {
		this.idUsuario = id;
		this.setCpf(cpf);
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.endereco = endereco;
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public void addContato (Contato contato){
		this.listaContatos.add(contato);
	}
	
	public ArrayList<Contato> listarContatos (){
		return listaContatos;
	}
	
	public void addBem(Bem bem){
		this.listaBens.add(bem);
	}
	
	public ArrayList<Bem> listarBens(){
		return listaBens;
	}
	
	public boolean getPermissaoDeAcesso(){
		return true;
	}

	@Override
	public String toString() {
		return "\nId Usuario: " + idUsuario + "\nCpf: " + cpf + "\nNome: " + nome + "\nLogin: " + login + "\nSenha: "
				+ senha + "\nTipo Usuario: " + tipoUsuario.getTipo() + 
				"\nEndereco: " + endereco.getRua() + ",Nº " + endereco.getNumero() + ", " + endereco.getComplemento() + ",Cep: " + endereco.getCep() + "\n";
	}
	
}
