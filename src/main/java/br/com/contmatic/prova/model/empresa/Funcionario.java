package br.com.contmatic.prova.model.empresa;

import static br.com.contmatic.prova.constants.EmpresaConstantes.REGEX_EMAIL;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.MSG_TELEFONE_INVALIDO;
import static br.com.contmatic.prova.constants.FuncionarioConstantes.MSG_TELEFONE_VAZIO;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaCaracteresRepetidos;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaRegex;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaValorMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaValorMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtil.verificaValorVazio;
import static java.math.BigDecimal.valueOf;

import java.math.BigDecimal;
import java.util.Objects;

import br.com.contmatic.prova.utils.CpfUtil;
import br.com.contmatic.prova.utils.ValidacaoUtil;

public class Funcionario {

	private String nome;

	private String endereco;

	private BigDecimal salario;

	private String cpf;

	private String telefone;

	private String email;
	
	private Setor setor;

	public Funcionario(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificaNulo(nome, "O campo nome é obrigatorio");
		verificaTamanhoMinimo(nome, 2, "O campo Nome deve ser no minimo 2 caracteres");
		verificaTamanhoMaximo(nome, 80, "O tamanho maximo do campo nome é 80 caracteres");
		
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		ValidacaoUtil.verificaNulo(endereco, "Endereço inválido");
		ValidacaoUtil.verificaTamanhoMaximo(endereco, 80, "O campo Endereço deve ter o máximo de 80 caracteres");
		this.endereco = endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		verificaValorMinimo(salario, valueOf(0),"Valor do salario não pode ser zero");
		verificaValorMaximo(salario, valueOf(2000), "O valor não pode ser maior que 2.000,00");
		verificaNulo(salario, "O campo sálario é obrigatorio");
		this.salario = salario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		CpfUtil.validaCpf(cpf);
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		verificaNulo(telefone, MSG_TELEFONE_INVALIDO);
		verificaValorVazio(telefone, MSG_TELEFONE_VAZIO);
		verificaCaracteresRepetidos(telefone, MSG_TELEFONE_INVALIDO);
		verificaTamanhoMinimo(telefone, 10, "O numero do telefone deve conter no minimo 10 caracteres"); 
		verificaTamanhoMaximo(telefone, 11, "O campo telefone deve ter no máximo 11 caracteres");
		verificaRegex(telefone, "[0-9]", "O Campo Telefone deve conter apensa números");
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		verificaNulo(email, "Email inválido");
		verificaValorVazio(email, MSG_TELEFONE_VAZIO);
		verificaCaracteresRepetidos(email, MSG_TELEFONE_INVALIDO);
		verificaTamanhoMinimo(email, 10, "O numero do telefone deve conter no minimo 10 caracteres"); 
		verificaTamanhoMaximo(email, 11, "O campo telefone deve ter no máximo 11 caracteres");
		verificaRegex(email, REGEX_EMAIL, "O Campo Telefone deve conter apensa números");
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [nome=");
		builder.append(nome);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", salario=");
		builder.append(salario);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", telefone=");
		builder.append(telefone);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
}
