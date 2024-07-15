package br.com.contmatic.prova.model.empresa;

import java.util.List;
import java.util.Objects;

public class Setor {

	private String nome;

	private Funcionario chefe;

	private List<Funcionario> funcionarios;

	public Setor(String nome, Funcionario chefe) {
		this.nome = nome;
		this.chefe = chefe;
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
