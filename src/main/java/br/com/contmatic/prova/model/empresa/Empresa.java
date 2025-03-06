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
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.CAMPOS_CADASTRO_FUNCIONARIOS_OBRIGATORIO;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.DEVE_EXISTIR_AO_MENOS_2_SETORES;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.INSCRICAO_ESTADUAL_DEVE_TER_APENAS_NUMERO;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.INSCRICAO_ESTADUAL_NAO_DEVE_TER_APENAS_CARACTERES_REPETIDOS;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.INSCRICAO_ESTUDAL_DEVE_TER_MAXIMO_10_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.INSCRICAO_ESTUDAL_DEVE_TER_MINIMO_5_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.LIMITE_DA_LISTA_SETORES;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.O_CAMPO_SETOR_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.O_CAMPO_SETOR_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.TAMANHO_MAXIMO_10;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.TAMANHO_MINIMO_MINIMO_5;
import static java.util.Objects.hash;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import br.com.contmatic.prova.model.auditoria.Auditoria;
import br.com.contmatic.prova.model.endereco.Endereco;
import br.com.contmatic.prova.utils.constants.EmpresaConstantes;

public class Empresa extends Auditoria {

	private static final String REGEX_INSCRICAO_ESTADUAL = "^[\\d]{5,10}$";

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
		verificaTamanhoMinimo(inscricaoEstadual, TAMANHO_MINIMO_MINIMO_5, INSCRICAO_ESTUDAL_DEVE_TER_MINIMO_5_CARACTERES);
		verificaTamanhoMaximo(inscricaoEstadual, TAMANHO_MAXIMO_10,INSCRICAO_ESTUDAL_DEVE_TER_MAXIMO_10_CARACTERES);
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
		verificaTamanhoMinimo(situacaoTributaria, TAMANHO_MINIMO_MINIMO_5,A_SITUACAO_TRIBUTARIA_DEVE_TER_NO_MININO_5_CARACTERES);
		verificaTamanhoMaximo(situacaoTributaria, TAMANHO_MAXIMO_10, A_SITUACAO_TRIBUTARIA_DEVE_TER_NO_MAXIMO_10_CARACTERES);
		verificaRegex(situacaoTributaria, REGEX_INSCRICAO_ESTADUAL, A_SITUACAO_TRIBUTARIA_DEVE_TER_APENAS_NUMEROS);
		verificaCaracteresRepetidos(situacaoTributaria, A_SITUACAO_TRIBUTARIA_NAO_DEVE_TER_APENAS_CARACTERES_REPETIDOS);
		this.situacaoTributaria = situacaoTributaria;
	}

	public Set<Setor> getSetores() {
		return setores;
	}

	public void setSetores(Set<Setor> setores) {
		verificaNulo(setores, O_CAMPO_SETOR_NAO_PODE_SER_NULO);
		verificaListaVazia(setores, O_CAMPO_SETOR_NAO_PODE_SER_VAZIO);
		verificaTamanoMinimoLista(setores, 2, DEVE_EXISTIR_AO_MENOS_2_SETORES); 
		verificaTamanoMaximoLista(setores, 4, LIMITE_DA_LISTA_SETORES);
		this.setores = setores;
	}

	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		verificaNulo(funcionarios, CAMPOS_CADASTRO_FUNCIONARIOS_OBRIGATORIO);
		verificaListaVazia(funcionarios, "Não existem funcionarios cadastrados");
		verificaTamanoMinimoLista(funcionarios, 1, "Deve existir ao menos um setor cadastrado"); 
		verificaTamanoMaximoLista(funcionarios, 10, "Não podem existir mais de 10 funcionarios cadastrados");
		this.funcionarios = funcionarios;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		verificaNulo(dataCriacao, "O campo Data de criação da empresa é obrigatorio");
		verificaDataMinima(dataCriacao, "A data não pode ser anterior a 01/01/1446");
		verificaDataMaxima(dataCriacao, "A Data de criação não pode ser posterior ao dia atual.");
		this.dataCriacao = dataCriacao;
	}

	public void setRazaoSocial(String razaoSocial) {
		verificaNulo(razaoSocial, "O campo Razão Social é de preenchimento obrigatorio");
		verificaValorVazio(razaoSocial, "O campo é de preenchimento obrigatorio");
		verificaTamanhoMinimo(razaoSocial, 3, "O campo Razão Social deve conter ao menos 3 caracteres");
		verificaTamanhoMaximo(razaoSocial, 30,"O tamanho máximo do campo Razão Social é de 30 caracteres");
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
		verificaNulo(enderecos, "O endereço é obrigatorio");
		this.enderecos = enderecos;
	}
	
	public Boolean getisAtivo() {
		return isAtivo;
	}

	public void setisAtivo(Boolean status) {
		verificaNulo(status, "O status e´obrigatorio");
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
