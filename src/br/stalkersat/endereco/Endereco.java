package br.stalkersat.endereco;

public class Endereco {
	
	private Integer idEndereco;
	private int numero;
	private String complemento;
	private String rua;
	private String cep;
	
	public Endereco(int numero, String complemento, String rua, String cep) {
		this.numero = numero;
		this.complemento = complemento;
		this.rua = rua;
		this.setCep(cep);
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep.replaceAll("\\.|\\,|\\-|\\ ", ""); 
	}
	
	public String formatarCep(){
		return cep.substring(0, 2) + "." + cep.substring(2, 5) + "-" +cep.substring(5, 8);
	}

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", numero=" + numero + ", complemento=" + complemento + ", rua="
				+ rua + ", cep=" + formatarCep() + "]";
	}
	
	
}
