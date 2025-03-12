package br.com.contmatic.prova.model.empresa;

import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanoMaximoLista;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanoMinimoLista;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.LISTA_FUNCIONARIO_VAZIA;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_CAMPO_FUNCIONARIO_DO_SETOR_E_OBRIGATORIO;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.TAMANHO_1;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.TAMANHO_10;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.CAMPO_SETOR_DEVE_TER_MAXIMO_80_CARACTERES;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.CAMPO_SETOR_MINIMO_3_CARACTERES;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.CAMPO_SETOR_NULO;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.CAMPO_SETOR_VAZIO;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.LISTA_SETOR_COM_MAIS_DE_10_FUNCIONARIOS;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.O_CAMPO_CHEFE_DO_SETOR_E_OBRIGATORIO;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.TAMANHO_3;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.TAMANHO_80;

import java.util.List;
import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;

public class Setor extends Auditoria {

	private String nome;

	private Funcionario chefe;

	private List<Funcionario> funcionarios;

	public Setor(String nome, Funcionario chefe) {
		setNome(nome);
		setChefe(chefe);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificaNulo(nome, CAMPO_SETOR_NULO);
		verificaValorVazio(nome, CAMPO_SETOR_VAZIO);
		verificaTamanhoMinimo(nome, TAMANHO_3, CAMPO_SETOR_MINIMO_3_CARACTERES);
		verificaTamanhoMaximo(nome, TAMANHO_80, CAMPO_SETOR_DEVE_TER_MAXIMO_80_CARACTERES  );
		this.nome = nome;
	}

	public Funcionario getChefe() {
		return chefe;
	}

	public void setChefe(Funcionario chefe) {
		verificaNulo(chefe, O_CAMPO_CHEFE_DO_SETOR_E_OBRIGATORIO);
		this.chefe = chefe;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		verificaNulo(funcionarios,O_CAMPO_FUNCIONARIO_DO_SETOR_E_OBRIGATORIO);
		verificaTamanoMinimoLista(funcionarios, TAMANHO_1,LISTA_FUNCIONARIO_VAZIA);
		verificaTamanoMaximoLista(funcionarios, TAMANHO_10, LISTA_SETOR_COM_MAIS_DE_10_FUNCIONARIOS);
		this.funcionarios = funcionarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chefe, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setor other = (Setor) obj;
		return Objects.equals(chefe, other.chefe) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Setor [nome=");
		builder.append(nome);
		builder.append(", chefe=");
		builder.append(chefe);
		builder.append(", funcionarios=");
		builder.append(funcionarios);
		builder.append("]");
		return builder.toString();
	}
}
