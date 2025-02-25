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
	
	private static final int TAMANHO_MAXIMO_10 = 10;

	private static final int TAMANHO_MINIMO_MINIMO_5 = 5;

	public Empresa(String razaoSocial, String cnpj) {
		this.setRazaoSocial(razaoSocial);
		this.setCnpj(cnpj);
	}
	
	

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		verificaNulo(inscricaoEstadual, "A Inscrição Estadual é de preenhimento obrigatorio");
		verificaValorVazio(inscricaoEstadual, "O campo Inscrição Estadual é obrigatório");
		verificaTamanhoMinimo(inscricaoEstadual, TAMANHO_MINIMO_MINIMO_5, "O Campo Inscrição Estadual deve conter o minimo de 5 caracteres");
		verificaTamanhoMaximo(inscricaoEstadual, TAMANHO_MAXIMO_10,"O campo Inscrição Estadual deve ter o tamanho máximo de 10 caracteres");
		verificaRegex(inscricaoEstadual, "^[\\d]{5,10}$", "O campo Inscrição Estadual deve ser apenas números");
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
		verificaRegex(situacaoTributaria, "^[\\d]{5,10}$", "O campo Situação Tributaria deve ser apenas números");
		verificaCaracteresRepetidos(situacaoTributaria, "Situação Tributaria inválida");
		this.situacaoTributaria = situacaoTributaria;
	}

	public Set<Setor> getSetores() {
		return setores;
	}

	public void setSetores(Set<Setor> setores) {
		verificaNulo(setores, "O setor é de preenhimento obrigatorio");
		verificaListaVazia(setores, "Não existem setores cadastrados");
		verificaTamanoMinimoLista(setores, 2, "Deve existir ao menos 2 setor cadastrado"); 
		verificaTamanoMaximoLista(setores, 4, "Não é possivel cadastrar mais que 4 setores");
		this.setores = setores;
	}

	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		verificaNulo(funcionarios, "Os campos do cadastro de Funcionario é de preenchimento obrigatorio");
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
