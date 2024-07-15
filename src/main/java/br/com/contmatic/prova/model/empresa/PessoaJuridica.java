package br.com.contmatic.prova.model.empresa;

public class PessoaJuridica {
	
	private String nome;
	private String CnpjPessoaJuridica;
	private String enderecoPessoaJuridica;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpjPessoaJuridica() {
		return CnpjPessoaJuridica;
	}
	public void setCnpjPessoaJuridica(String cnpjPessoaJuridica) {
		CnpjPessoaJuridica = cnpjPessoaJuridica;
	}
	public String getEnderecoPessoaJuridica() {
		return enderecoPessoaJuridica;
	}
	public void setEnderecoPessoaJuridica(String enderecoPessoaJuridica) {
		this.enderecoPessoaJuridica = enderecoPessoaJuridica;
	}
}


