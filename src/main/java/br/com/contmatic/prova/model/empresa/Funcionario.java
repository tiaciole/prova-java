package br.com.contmatic.prova.model.empresa;

import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaCaracteresRepetidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaRegex;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.EMAIL_DEVE_TER_MINIMO_DE_3_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.EMAIL_DEVE_TER_NO_MAXIMO_80_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.FORMATO_EMAIL_INVALIDO;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.MSG_EMAIL_INVALIDO;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.MSG_EMAIL_VAZIO;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.REGEX_EMAIL;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.TAMANHO_3;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.TAMANHO_80;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.TIPO_EMAIL_NULO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_ENDERECO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_CAMPO_DO_FUNCIONARIO_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_CAMPO_NOME_DEVE_TER_MINIMO_2_CARACTERES;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_CAMPO_NOME_FUNCIONARIO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_CAMPO_SALARIO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_CAMPO_SALARIO_NAO_PODE_SER_ZERO;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_TAMANHO_MAXIMO_DO_CAMPO_NOME_80_CARACTERES;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_VALOR_DO_SALARIO_NAO_PODE_SER_MAIOR_QUE_DOIS_MIL;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.TAMANHO_2;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.CAMPO_SETOR_NULO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.MSG_TELEFONE_INVALIDO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_CAMPO_TELEFONE_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_CAMPO_TELEFONE_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_NUMERO_DE_TELEFONE_DEVE_CONTER_APENAS_NUMERO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_NUMERO_TELEFONE_DEVE_TER_O_MAXIMO_DE_9_CARACTERES;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_NUMERO_TELEFONE_DEVE_TER_O_MINIMO_DE_8_CARACTERES;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.REGEX_TELEFONE;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.TAMANHO_8;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.TAMANHO_9;
import static java.math.BigDecimal.valueOf;

import java.math.BigDecimal;
import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;
import br.com.contmatic.prova.model.endereco.Endereco;
import br.com.contmatic.prova.utils.CpfUtils;

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
		verificaNulo(nome, O_CAMPO_NOME_FUNCIONARIO_NAO_PODE_SER_NULO);
		verificaValorVazio(nome, O_CAMPO_DO_FUNCIONARIO_NAO_PODE_SER_VAZIO);
		verificaTamanhoMinimo(nome, TAMANHO_2, O_CAMPO_NOME_DEVE_TER_MINIMO_2_CARACTERES);
		verificaTamanhoMaximo(nome, 80, O_TAMANHO_MAXIMO_DO_CAMPO_NOME_80_CARACTERES);
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		verificaNulo(salario, O_CAMPO_SALARIO_NAO_PODE_SER_NULO);
		verificaValorMinimo(salario, valueOf(0), O_CAMPO_SALARIO_NAO_PODE_SER_ZERO);
		verificaValorMaximo(salario, valueOf(2000), O_VALOR_DO_SALARIO_NAO_PODE_SER_MAIOR_QUE_DOIS_MIL);
		this.salario = salario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		CpfUtils.isCPF(cpf);
		this.cpf = cpf;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		verificaNulo(setor, CAMPO_SETOR_NULO);
		this.setor = setor;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		verificaNulo(endereco, O_ENDERECO_NAO_PODE_SER_NULO);
		this.endereco = endereco;

	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		verificaNulo(telefone, O_CAMPO_TELEFONE_NAO_PODE_SER_NULO);
		verificaValorVazio(telefone, O_CAMPO_TELEFONE_NAO_PODE_SER_VAZIO);
		verificaCaracteresRepetidos(telefone, MSG_TELEFONE_INVALIDO);
		verificaTamanhoMinimo(telefone, TAMANHO_8, O_NUMERO_TELEFONE_DEVE_TER_O_MINIMO_DE_8_CARACTERES);
		verificaTamanhoMaximo(telefone, TAMANHO_9, O_NUMERO_TELEFONE_DEVE_TER_O_MAXIMO_DE_9_CARACTERES);
		verificaRegex(telefone, REGEX_TELEFONE, O_NUMERO_DE_TELEFONE_DEVE_CONTER_APENAS_NUMERO);
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		verificaNulo(email, TIPO_EMAIL_NULO);
		verificaValorVazio(email, MSG_EMAIL_VAZIO);
		verificaCaracteresRepetidos(email, MSG_EMAIL_INVALIDO);
		verificaTamanhoMinimo(email, TAMANHO_3, EMAIL_DEVE_TER_MINIMO_DE_3_CARACTERES);
		verificaTamanhoMaximo(email, TAMANHO_80, EMAIL_DEVE_TER_NO_MAXIMO_80_CARACTERES);
		verificaRegex(email, REGEX_EMAIL, FORMATO_EMAIL_INVALIDO);
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
