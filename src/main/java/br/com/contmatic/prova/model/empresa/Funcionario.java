package br.com.contmatic.prova.model.empresa;

import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaCaracteresRepetidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaRegex;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.EmpresaConstantes.REGEX_EMAIL;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.MSG_EMAIL_INVALIDO;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.MSG_TELEFONE_INVALIDO;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.MSG_TELEFONE_VAZIO;
import static java.math.BigDecimal.valueOf;

import java.math.BigDecimal;
import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;
import br.com.contmatic.prova.model.endereco.Endereco;
import br.com.contmatic.prova.utils.CpfUtils;
import br.com.contmatic.prova.utils.constants.FuncionarioConstantes;

public class Funcionario extends Auditoria {

	private String nome;

	private BigDecimal salario;
	
	private String cpf;
	
	private Setor setor;
	
	private Endereco endereco;

	private String telefone;

	private String email;
	

	public Funcionario(String nome, String cpf) {
		this.setNome(nome);
		this.setCpf(cpf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificaNulo(nome, "O campo nome é obrigatorio");
		verificaValorVazio(nome, "O campo é de preenchimento obrigatório");
		verificaTamanhoMinimo(nome, 2, "O campo Nome deve ser no minimo 2 caracteres");
		verificaTamanhoMaximo(nome, 80, "O tamanho maximo do campo nome é 80 caracteres");
		this.nome = nome;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	
	public void setSalario(BigDecimal salario) {
		verificaNulo(salario, "O campo sálario é obrigatorio");
		verificaValorMinimo(salario, valueOf(0),"Valor do salario não pode ser zero");
		verificaValorMaximo(salario, valueOf(2000), "O valor não pode ser maior que 2.000,00");
		this.salario = salario;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		CpfUtils.validaCpf(cpf);
		this.cpf = cpf;
	}
	
	public Setor getSetor() {
		return setor;
	}
	
	public void setSetor(Setor setor) {
		verificaNulo(setor, "O campo é de preencimento obrigatorio");
		this.setor = setor;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		verificaNulo(endereco, "Endereço inválido"); // tem que ser o teste pela classe Endereço?
		this.endereco = endereco;
		
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		verificaNulo(telefone, MSG_TELEFONE_INVALIDO);
		verificaValorVazio(telefone, MSG_TELEFONE_VAZIO);
		verificaCaracteresRepetidos(telefone, MSG_TELEFONE_INVALIDO);
		verificaTamanhoMinimo(telefone, 8, "O numero do telefone deve conter no minimo 8 caracteres"); 
		verificaTamanhoMaximo(telefone, 10, "O campo telefone deve ter no máximo 10 caracteres");
		verificaRegex(telefone, "^[\\d]{8,10}$", "O Campo Telefone deve conter apenas números");
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		verificaNulo(email, "Email inválido");
		verificaValorVazio(email, FuncionarioConstantes.MSG_EMAIL_VAZIO);
		verificaCaracteresRepetidos(email, MSG_EMAIL_INVALIDO);
		verificaTamanhoMinimo(email, 3, "O numero do telefone deve conter no minimo 2 caracteres"); 
		verificaTamanhoMaximo(email, 80, "O campo email deve ter no máximo 80 caracteres");
		verificaRegex(email, REGEX_EMAIL, "O Campo Email deve conter arroba");
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
