package br.com.contmatic.prova.model.empresa;

import static br.com.contmatic.prova.utils.CnpjUtil.validaCnpj;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaCaracteresRepetidos;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaDataMaxima;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaDataMinima;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaListaVazia;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaRegex;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaTamanoMaximoLista;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaTamanoMinimoLista;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaValorVazio;
import static java.util.Objects.hash;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import br.com.contmatic.prova.model.endereco.Endereco;
import br.com.contmatic.prova.utils.ValidacaoUtil;

public class Empresa {

	private String razaoSocial;

	private String cnpj;

	private Endereco endereco;

	private LocalDate dataCriacao;

	private String situacaoTributaria;

	private Set<Setor> setores = new HashSet<>();

	private Set<Funcionario> funcionarios;

	private String inscricaoEstadual;

	public Empresa(String razaoSocial, String cnpj) {
		this.setRazaoSocial(razaoSocial);
		this.setCnpj(cnpj);
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		verificaNulo(inscricaoEstadual, "A Inscrição Estadual é de preenhimento obrigatorio");
		verificaValorVazio(inscricaoEstadual, "O campo Inscrição Estadual não pode contes espaços em branco");
		verificaTamanhoMinimo(inscricaoEstadual, 5, "O Campo Inscrição Estadual deve conter o minimo de 5 caracteres");
		verificaTamanhoMaximo(inscricaoEstadual, 10,
				"O campo Inscrição Estadual deve ter o tamanho máximo de 10 caracteres");
		verificaRegex(inscricaoEstadual, "([0-9])+", "O campo Inscrição Estadual deve ser apenas números");
		verificaCaracteresRepetidos(inscricaoEstadual, "Inscrição Estadual inválida");
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getSituacaoTributaria() {
		return situacaoTributaria;
	}

	public void setSituacaoTributaria(String situacaoTributaria) {
		verificaNulo(situacaoTributaria, "A Situação Tributaria é de preenhimento obrigatorio");
		verificaValorVazio(situacaoTributaria, "O campo Situação Tributaria não pode contes espaços em branco");
		verificaTamanhoMinimo(situacaoTributaria, 5,"O Campo Situação Tributaria deve conter o minimo de 5 caracteres");
		verificaTamanhoMaximo(situacaoTributaria, 10,"O campo Situação Tributaria deve ter o tamanho máximo de 10 caracteres");
		verificaRegex(situacaoTributaria, "([A-z])+", "O campo Situação Tributaria deve ser apenas números");
		verificaCaracteresRepetidos(situacaoTributaria, "Situação Tributaria inválida");
		this.situacaoTributaria = situacaoTributaria;
	}

	public Set<Setor> getSetores() {
		return setores;
	}

	public void setSetores(Set<Setor> setores) {
		verificaNulo(setores, "O setor é de preenhimento obrigatorio");
		verificaListaVazia(setores, "Não existem setores cadastrados");
		verificaTamanoMinimoLista(setores, 1, "Deve existir ao menos um setor cadastrado"); 
		verificaTamanoMaximoLista(setores, 10, "Não é possivel cadastrar mais que 15 setores");
		this.setores = setores;
	}

	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		verificaNulo(funcionarios, "Os campos do cadastro de Funcionario é de preenchimento obrigatorio");
		verificaListaVazia(funcionarios, "Não existem setores cadastrados");
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
		ValidacaoUtil.verificaNulo(razaoSocial, "O campo Razão Social é de preenchimento obrigatorio");
		ValidacaoUtil.verificaTamanhoMinimo(razaoSocial, 3, "O campo Razão Social deve conter ao menos 3 caracteres");
		ValidacaoUtil.verificaTamanhoMinimo(razaoSocial, 10,"O tamanho máximo do campo Razão Social é de 100 caracteres");
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		validaCnpj(cnpj);
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		ValidacaoUtil.verificaNulo(endereco, "O endereço é obrigatorio");
		this.endereco = endereco;
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
		builder.append(endereco);
		builder.append("]");
		return builder.toString();
	}
}
