package br.stalkersat.tipobem;

public class TipoBem {
	
	private Integer idTipoBem;
	private String tipo;
	
	public TipoBem(String tipo) {
		this.tipo = tipo;
	}
	
	public TipoBem(Integer id, String tipo) {
		this.idTipoBem = id;
		this.tipo = tipo;
	}
	
	public TipoBem() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTipoBem() {
		return idTipoBem;
	}

	public void setIdTipoBem(Integer idTipoBem) {
		this.idTipoBem = idTipoBem;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "TipoBem [idTipoBem=" + idTipoBem + ", tipo=" + tipo + "]";
	}
	
}
