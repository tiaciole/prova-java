package br.com.contmatic.prova.model.endereco;

public class Endereco {
	
	private String logradouro;
	
	private Integer numero;
	
	private String bairro;
	
	private String cep;
	
	private String complemento;
	
	private Cidade cidade;

	public Endereco(String logradouro, Integer numero, String cep, String complemento) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.complemento = complemento;
	}
	
	
	
}
