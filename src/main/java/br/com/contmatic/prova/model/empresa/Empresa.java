package br.com.contmatic.prova.model.empresa;

import static br.com.contmatic.prova.utils.CnpjUtils.isCnpj;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaCaracteresRepetidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaDataMaxima;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaDataMinima;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaListaVazia;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaRegex;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanoMaximoLista;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanoMinimoLista;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.A_INSCRICAO_ESTADUAL_NAO_PODE_SER_NULA;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.A_INSCRICAO_ESTADUAL_NAO_PODE_SER_VAZIA;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.A_SITUACAO_TRIBUTARIA_DEVE_TER_APENAS_NUMEROS;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.A_SITUACAO_TRIBUTARIA_DEVE_TER_NO_MAXIMO_10_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.A_SITUACAO_TRIBUTARIA_DEVE_TER_NO_MININO_5_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.A_SITUACAO_TRIBUTARIA_NAO_DEVE_SER_NULA;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.A_SITUACAO_TRIBUTARIA_NAO_DEVE_TER_APENAS_CARACTERES_REPETIDOS;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.A_SITUACAO_TRIBUTARIA_NAO_PODE_SER_VAZIA;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.INSCRICAO_ESTADUAL_DEVE_TER_APENAS_NUMERO;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.INSCRICAO_ESTADUAL_NAO_DEVE_TER_APENAS_CARACTERES_REPETIDOS;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.INSCRICAO_ESTUDAL_DEVE_TER_MAXIMO_10_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.INSCRICAO_ESTUDAL_DEVE_TER_MINIMO_5_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.O_CAMPO_DATA_CRIACAO_NAO_PODE_SER_ANTES_01_01_1446;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.O_CAMPO_DATA_CRIACAO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.O_CAMPO_DATA_CRIACAO_NAO_PODE_SER_POSTERIOR_AO_DIA_ATUAL;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.O_CAMPO_RAZAO_SOCIAL_DEVE_TER_MAXIMO_DE_30_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.O_CAMPO_RAZAO_SOCIAL_DEVE_TER_O_MINIMO_DE_3_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.O_CAMPO_RAZAO_SOCIAL_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.O_CAMPO_RAZAO_SOCIAL_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.O_STATUS_E_OBRIGATORIO;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.REGEX_INSCRICAO_ESTADUAL;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.TAMANHO_1;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.TAMANHO_10;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.TAMANHO_2;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.TAMANHO_3;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.TAMANHO_30;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.TAMANHO_4;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.TAMANHO_5;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_ENDERECO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.LISTA_FUNCIONARIO_VAZIA;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.NAO_DEVE_EXISTIR_MAIS_DE_10_FUNCIONARIOS_CADASTRADOS;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_CAMPO_NOME_FUNCIONARIO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.CAMPO_SETOR_NULO;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.DEVE_EXISTIR_AO_MENOS_2_SETORES;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.LIMITE_DA_LISTA_SETORES;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.O_CAMPO_SETOR_NAO_PODE_SER_VAZIO;
import static java.util.Objects.hash;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import br.com.contmatic.prova.model.auditoria.Auditoria;
import br.com.contmatic.prova.model.endereco.Endereco;

public class Empresa extends Auditoria {

	private String cnpj;

	private String razaoSocial;

	private Set<Endereco> enderecos;

	private LocalDate dataCriacao;

	private String situacaoTributaria;

	private Set<Setor> setores;

	private Set<Funcionario> funcionarios;

	private String inscricaoEstadual;
	
	private Boolean isAtivo;

	public Empresa(String razaoSocial, String cnpj) {
		this.setRazaoSocial(razaoSocial);
		this.setCnpj(cnpj);
	}
	
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		verificaNulo(inscricaoEstadual, A_INSCRICAO_ESTADUAL_NAO_PODE_SER_NULA);
		verificaValorVazio(inscricaoEstadual,A_INSCRICAO_ESTADUAL_NAO_PODE_SER_VAZIA);
		verificaTamanhoMinimo(inscricaoEstadual, TAMANHO_5, INSCRICAO_ESTUDAL_DEVE_TER_MINIMO_5_CARACTERES);
		verificaTamanhoMaximo(inscricaoEstadual, TAMANHO_10,INSCRICAO_ESTUDAL_DEVE_TER_MAXIMO_10_CARACTERES);
		verificaRegex(inscricaoEstadual, REGEX_INSCRICAO_ESTADUAL,INSCRICAO_ESTADUAL_DEVE_TER_APENAS_NUMERO);
		verificaCaracteresRepetidos(inscricaoEstadual, INSCRICAO_ESTADUAL_NAO_DEVE_TER_APENAS_CARACTERES_REPETIDOS);
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getSituacaoTributaria() {
		return situacaoTributaria;
	}

	public void setSituacaoTributaria(String situacaoTributaria) {
		verificaNulo(situacaoTributaria, A_SITUACAO_TRIBUTARIA_NAO_DEVE_SER_NULA);
		verificaValorVazio(situacaoTributaria, A_SITUACAO_TRIBUTARIA_NAO_PODE_SER_VAZIA);
		verificaTamanhoMinimo(situacaoTributaria,TAMANHO_5,A_SITUACAO_TRIBUTARIA_DEVE_TER_NO_MININO_5_CARACTERES);
		verificaTamanhoMaximo(situacaoTributaria, TAMANHO_10, A_SITUACAO_TRIBUTARIA_DEVE_TER_NO_MAXIMO_10_CARACTERES);
		verificaRegex(situacaoTributaria, REGEX_INSCRICAO_ESTADUAL, A_SITUACAO_TRIBUTARIA_DEVE_TER_APENAS_NUMEROS);
		verificaCaracteresRepetidos(situacaoTributaria, A_SITUACAO_TRIBUTARIA_NAO_DEVE_TER_APENAS_CARACTERES_REPETIDOS);
		this.situacaoTributaria = situacaoTributaria;
	}

	public Set<Setor> getSetores() {
		return setores;
	}

	public void setSetores(Set<Setor> setores) {
		verificaNulo(setores, CAMPO_SETOR_NULO);
		verificaListaVazia(setores, O_CAMPO_SETOR_NAO_PODE_SER_VAZIO);
		verificaTamanoMinimoLista(setores, TAMANHO_2, DEVE_EXISTIR_AO_MENOS_2_SETORES); 
		verificaTamanoMaximoLista(setores, TAMANHO_4, LIMITE_DA_LISTA_SETORES);
		this.setores = setores;
	}

	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		verificaNulo(funcionarios, O_CAMPO_NOME_FUNCIONARIO_NAO_PODE_SER_NULO);
		verificaListaVazia(funcionarios, LISTA_FUNCIONARIO_VAZIA);
		verificaTamanoMinimoLista(funcionarios,  TAMANHO_1, LISTA_FUNCIONARIO_VAZIA); 
		verificaTamanoMaximoLista(funcionarios, TAMANHO_10, NAO_DEVE_EXISTIR_MAIS_DE_10_FUNCIONARIOS_CADASTRADOS);
		this.funcionarios = funcionarios;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		verificaNulo(dataCriacao, O_CAMPO_DATA_CRIACAO_NAO_PODE_SER_NULO);
		verificaDataMinima(dataCriacao, O_CAMPO_DATA_CRIACAO_NAO_PODE_SER_ANTES_01_01_1446);
		verificaDataMaxima(dataCriacao, O_CAMPO_DATA_CRIACAO_NAO_PODE_SER_POSTERIOR_AO_DIA_ATUAL);
		this.dataCriacao = dataCriacao;
	}

	public void setRazaoSocial(String razaoSocial) {
		verificaNulo(razaoSocial, O_CAMPO_RAZAO_SOCIAL_NAO_PODE_SER_NULO);
		verificaValorVazio(razaoSocial, O_CAMPO_RAZAO_SOCIAL_NAO_PODE_SER_VAZIO);
		verificaTamanhoMinimo(razaoSocial, TAMANHO_3, O_CAMPO_RAZAO_SOCIAL_DEVE_TER_O_MINIMO_DE_3_CARACTERES);
		verificaTamanhoMaximo(razaoSocial, TAMANHO_30, O_CAMPO_RAZAO_SOCIAL_DEVE_TER_MAXIMO_DE_30_CARACTERES);
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		isCnpj(cnpj);
		this.cnpj = cnpj;
	}

	public Set<Endereco> getEndereco() {
		return enderecos;
	}

	public void setEndereco(Set<Endereco> enderecos) {
		verificaNulo(enderecos, O_ENDERECO_NAO_PODE_SER_NULO);
		this.enderecos = enderecos;
	}
	
	public Boolean getisAtivo() {
		return isAtivo;
	}

	public void setisAtivo(Boolean status) {
		verificaNulo(status, O_STATUS_E_OBRIGATORIO);
		this.isAtivo = status;
	}

	@Override
	public int hashCode() {
		return hash(cnpj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;	
		}
		if (obj == null) {
			return false;	
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj);
	}
		
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Empresa [razaoSocial=");
		builder.append(razaoSocial);
		builder.append(", cnpj=");
		builder.append(cnpj);
		builder.append(", endereco=");
		builder.append(enderecos);
		builder.append(", dataCriacao=");
		builder.append(dataCriacao);
		builder.append(", situacaoTributaria=");
		builder.append(situacaoTributaria);
		builder.append(", setores=");
		builder.append(setores);
		builder.append(", funcionarios=");
		builder.append(funcionarios);
		builder.append(", inscricaoEstadual=");
		builder.append(inscricaoEstadual);
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
