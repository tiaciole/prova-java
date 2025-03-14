package br.com.contmatic.prova.model.endereco;

import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.CidadeConstantes.O_CAMPO_NOME_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_CAMPO_BAIRRO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_CAMPO_BAIRRO_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_CAMPO_CEP_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_CAMPO_CEP_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_CAMPO_COMPLEMENTO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_CAMPO_COMPLEMENTO_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_CAMPO_ENDERECO_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_CAMPO_NUMERO_DEVE_TER_MINIMO_2_NUMEROS;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_CAMPO_NUMERO_E_DE_PREENCHIMENTO_OBRIGATORIO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_ENDERECO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_TAMANHO_MAXIMO_DO_CAMPO_NUMERO_E_DE_8_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_TAMANHO_MAXIMO_E_DE_8_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_TAMANHO_MINIMO_E_DE_2_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_TAMANHO_MINIMO_E_DE_8_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_TAMANHO_MININO_COMPLEMENTO_E_DE_UM_CARACTERE;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.TAMANHO_1;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.TAMANHO_2;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.TAMANHO_8;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.TAMANHO_80;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.TAMANHO_MAXIMO_80_CARACTERES_LOGRADOURO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.tamanho_99999999;

import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;

   public class Endereco extends Auditoria{

	private String logradouro;
	
	private Integer numero;
	
	private String bairro;
	
	private String cep;
	
	private String complemento;
	
	private Cidade cidade;

	public Endereco(Integer numero, String cep, String complemento) {
		setNumero(numero);
		setCep(cep);
		setComplemento(complemento);
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		verificaNulo(logradouro, O_ENDERECO_NAO_PODE_SER_NULO);
		verificaValorVazio(logradouro,O_CAMPO_ENDERECO_NAO_PODE_SER_VAZIO);
		verificaTamanhoMinimo(logradouro, TAMANHO_2,O_TAMANHO_MINIMO_E_DE_2_CARACTERES);
		verificaTamanhoMaximo(logradouro, TAMANHO_80, TAMANHO_MAXIMO_80_CARACTERES_LOGRADOURO);
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		verificaNulo(numero, O_CAMPO_NUMERO_E_DE_PREENCHIMENTO_OBRIGATORIO);
		verificaValorMinimo(numero, TAMANHO_2, O_CAMPO_NUMERO_DEVE_TER_MINIMO_2_NUMEROS);
		verificaValorMaximo(numero,tamanho_99999999, O_TAMANHO_MAXIMO_DO_CAMPO_NUMERO_E_DE_8_CARACTERES);
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		verificaNulo(bairro,O_CAMPO_BAIRRO_NAO_PODE_SER_NULO);
		verificaValorVazio(bairro, O_CAMPO_BAIRRO_NAO_PODE_SER_VAZIO);
		verificaTamanhoMinimo(bairro, TAMANHO_2, O_TAMANHO_MINIMO_E_DE_2_CARACTERES);
		verificaTamanhoMaximo(bairro, TAMANHO_80, TAMANHO_MAXIMO_80_CARACTERES_LOGRADOURO);
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		verificaNulo(cep, O_CAMPO_CEP_NAO_PODE_SER_NULO);
		verificaValorVazio(cep, O_CAMPO_CEP_NAO_PODE_SER_VAZIO);
		verificaTamanhoMinimo(cep, TAMANHO_8, O_TAMANHO_MINIMO_E_DE_8_CARACTERES);
		verificaTamanhoMaximo(cep, TAMANHO_8, O_TAMANHO_MAXIMO_E_DE_8_CARACTERES);
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		verificaNulo(complemento, O_CAMPO_COMPLEMENTO_NAO_PODE_SER_NULO);
		verificaValorVazio(complemento, O_CAMPO_COMPLEMENTO_NAO_PODE_SER_VAZIO);
		verificaTamanhoMinimo(complemento, TAMANHO_1, O_TAMANHO_MININO_COMPLEMENTO_E_DE_UM_CARACTERE );
		verificaTamanhoMaximo(complemento, TAMANHO_80, TAMANHO_MAXIMO_80_CARACTERES_LOGRADOURO);
		this.complemento = complemento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		verificaNulo(cidade, O_CAMPO_NOME_NAO_PODE_SER_NULO);
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, complemento, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Endereco [logradouro=");
		builder.append(logradouro);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", bairro=");
		builder.append(bairro);
		builder.append(", cep=");
		builder.append(cep);
		builder.append(", complemento=");
		builder.append(complemento);
		builder.append(", cidade=");
		builder.append(cidade);
		builder.append("]");
		return builder.toString();
	}
}
