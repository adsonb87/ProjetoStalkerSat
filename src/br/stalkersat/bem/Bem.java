package br.stalkersat.bem;

import br.stalkersat.localizacao.Localizacao;
import br.stalkersat.tipobem.TipoBem;
import br.stalkersat.usuario.Usuario;

public class Bem {
	
	private Integer idBem;
	private Usuario usuario;
	private String chassi;
	private String placa;
	private TipoBem tipoBem;
	private Localizacao localizacao;
	
	public Bem(String chassi, String placa, TipoBem tipoBem, Usuario usuario) {
		this.chassi = chassi;
		this.placa = placa;
		this.tipoBem = tipoBem;
		this.usuario = usuario;
	}
		
	public Bem(Integer id, String chassi, String placa, TipoBem tipoBem, Usuario usuario) {
		this.idBem = id;
		this.chassi = chassi;
		this.placa = placa;
		this.tipoBem = tipoBem;
		this.usuario = usuario;
	}
	
	public Bem() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdBem() {
		return idBem;
	}

	public void setIdBem(Integer idBem) {
		this.idBem = idBem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TipoBem getTipoBem() {
		return tipoBem;
	}

	public void setTipoBem(TipoBem tipoBem) {
		this.tipoBem = tipoBem;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	
	@Override
	public String toString() {
		return "Bem [idBem=" + idBem + ", usuario=" + usuario.getNome() + ", chassi=" + chassi + ", placa=" + placa + ", tipoBem="
				+ tipoBem.getTipo() + "]\n";
	}
	
	
}
