package br.com.contmatic.prova.model.telefone;

import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaRegex;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.CAMPO_DDI_DEVE_SER_APENAS_NUERO;

import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;

public class Telefone extends Auditoria{
	
	private String ddi;
	
	private String ddd;
	
	private String numero;
	
	private String tipo;
	
	public Telefone(String ddd, String dd1, String numero) {
		this.setDdd(ddd);
		this.setDdi(dd1);
		this.setNumero(numero);
	}
	
	public String getDdi() {
		return ddi;
	}
	public void setDdi(String ddi) {	
		verificaNulo(ddi, "Número de DDI inválido");
		verificaValorVazio(ddi, "Número de DDI inválido");
		verificaTamanhoMinimo(ddi, 3, "O campo DDI deve ser no minimo 3 caracteres");
		verificaTamanhoMaximo(ddi, 3, "O tamanho maximo do campo DDI é 3 caracteres");
		verificaRegex(ddi, "^[\\d]{3}$", CAMPO_DDI_DEVE_SER_APENAS_NUERO);
		this.ddi = ddi;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		verificaNulo(ddd, "Número de DDD nulo");
		verificaValorVazio(ddd, "Número de DDD inválido");
		verificaTamanhoMinimo(ddd, 2, "O campo DDD deve ser no minimo 2 caracteres");
		verificaTamanhoMaximo(ddd, 2, "O tamanho maximo do campo DDD é 2 caracteres");
		verificaRegex(ddd, "^[\\d]{2}$", "O campo DDD aceita apenas número");
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		verificaNulo(numero, "Número do telefone nulo");
		verificaValorVazio(numero, "Número do telefone inválido");
		verificaTamanhoMinimo(numero, 8, "Numero do telefone dever o minimo de 8 caracteres");
		verificaTamanhoMaximo(numero, 9, "Número do telefone deve conter o maxio de 9 caraceteres");
		verificaRegex(numero, "^[\\d]{8,9}$", "O campo telefone aceita apenas número");
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		verificaNulo(numero, "Tipo do telefone nulo");
		verificaValorVazio(numero, "Número do telefone inválido");
		verificaRegex(tipo, "^[a-zA-Z]+$", "O Campo tipo aceita apenas texto");
		this.tipo = tipo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ddd, ddi, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(ddd, other.ddd) && Objects.equals(ddi, other.ddi) && Objects.equals(numero, other.numero)
				&& Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Telefone [ddi=");
		builder.append(ddi);
		builder.append(", ddd=");
		builder.append(ddd);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
