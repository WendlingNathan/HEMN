package br.com.hemn.model;

public class Endereco {
	private String complemento_end;
	private String logradouro_end;
	private int numero_end;
	private String cidade_end;
	private String bairro_end;
	private String ponto_ref_end;
	
	public Endereco() {
		super();
	}

	public Endereco(String complemento_end, String logradouro_end, int numero_end, String cidade_end, String bairro_end,
			String ponto_ref_end) {
		super();
		this.complemento_end = complemento_end;
		this.logradouro_end = logradouro_end;
		this.numero_end = numero_end;
		this.cidade_end = cidade_end;
		this.bairro_end = bairro_end;
		this.ponto_ref_end = ponto_ref_end;
	}

	public String getComplemento_end() {
		return complemento_end;
	}

	public void setComplemento_end(String complemento_end) {
		this.complemento_end = complemento_end;
	}

	public String getLogradouro_end() {
		return logradouro_end;
	}

	public void setLogradouro_end(String logradouro_end) {
		this.logradouro_end = logradouro_end;
	}

	public int getNumero_end() {
		return numero_end;
	}

	public void setNumero_end(int numero_end) {
		this.numero_end = numero_end;
	}

	public String getCidade_end() {
		return cidade_end;
	}

	public void setCidade_end(String cidade_end) {
		this.cidade_end = cidade_end;
	}

	public String getBairro_end() {
		return bairro_end;
	}

	public void setBairro_end(String bairro_end) {
		this.bairro_end = bairro_end;
	}

	public String getPonto_ref_end() {
		return ponto_ref_end;
	}

	public void setPonto_ref_end(String ponto_ref_end) {
		this.ponto_ref_end = ponto_ref_end;
	}

	@Override
	public String toString() {
		return "Endereco [complemento_end=" + complemento_end + ", logradouro_end=" + logradouro_end + ", numero_end="
				+ numero_end + ", cidade_end=" + cidade_end + ", bairro_end=" + bairro_end + ", ponto_ref_end="
				+ ponto_ref_end + "]";
	}
}