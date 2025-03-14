package br.com.contmatic.prova.model.email;

import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaRegex;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.EMAIL_DEVE_TER_MAXIMO_DE_50_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.EMAIL_DEVE_TER_MINIMO_DE_3_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.MSG_EMAIL_INVALIDO;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.MSG_EMAIL_VAZIO;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.REGEX_EMAIL;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.TAMANHO_3;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.TAMANHO_50;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.TIPO_EMAIL_NULO;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.TIPO_EMAIL_VAZIO;

import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;

public class Email extends Auditoria{

	String dominioEmail;
	
	String tipo;
	
	public Email(String email) {
		this.setEmail(email);
	}

	public String getEmail() {
		return dominioEmail;
	}

	public void setEmail(String email) {
		verificaNulo(email, TIPO_EMAIL_NULO);
		verificaValorVazio(email, MSG_EMAIL_VAZIO);
		verificaTamanhoMinimo(email, TAMANHO_3, EMAIL_DEVE_TER_MINIMO_DE_3_CARACTERES);
		verificaTamanhoMaximo(email, TAMANHO_50, EMAIL_DEVE_TER_MAXIMO_DE_50_CARACTERES);
		verificaRegex(email, REGEX_EMAIL, MSG_EMAIL_INVALIDO);
		this.dominioEmail = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		verificaNulo(tipo, TIPO_EMAIL_NULO);
		verificaValorVazio(tipo, TIPO_EMAIL_VAZIO);
		this.tipo = tipo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dominioEmail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		return Objects.equals(dominioEmail, other.dominioEmail) && Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Email [email=");
		builder.append(dominioEmail);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append("]");
		return builder.toString();
	}
	
	
}
