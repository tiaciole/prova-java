package br.com.contmatic.prova.model.telefone;

import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaRegex;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.CAMPO_DDD_DEVE_SER_2_CARACTERES;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.CAMPO_DDD_DEVE_SER_APENAS_NUMERO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.CAMPO_DDI_DEVE_SER_3_CARACTERES;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.CAMPO_DDI_DEVE_SER_APENAS_NUMERO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.NUMERO_DDD_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.NUMERO_DDD_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.NUMERO_DDI_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.NUMERO_DDI_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_CAMPO_TELEFONE_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_CAMPO_TELEFONE_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_CAMPO_TIPO_DE_TELEFONE_ACEITA_APENAS_TEXTO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_NUMERO_DE_TELEFONE_DEVE_CONTER_APENAS_NUMERO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_NUMERO_TELEFONE_DEVE_TER_O_MAXIMO_DE_9_CARACTERES;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_NUMERO_TELEFONE_DEVE_TER_O_MINIMO_DE_8_CARACTERES;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_TIPO_DE_TELEFONE_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_TIPO_DE_TELEFONE_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.REGEX_DDD;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.REGEX_DDI;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.REGEX_TELEFONE;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.REGEX_TIPO_TELEFONE_APENAS_LETRA;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.TAMANHO_2;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.TAMANHO_3;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.TAMANHO_8;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.TAMANHO_9;

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
		verificaNulo(ddi, NUMERO_DDI_NAO_PODE_SER_NULO);
		verificaValorVazio(ddi, NUMERO_DDI_NAO_PODE_SER_VAZIO);
		verificaTamanhoMinimo(ddi, TAMANHO_3, CAMPO_DDI_DEVE_SER_3_CARACTERES);
		verificaTamanhoMaximo(ddi, TAMANHO_3, CAMPO_DDI_DEVE_SER_3_CARACTERES);
		verificaRegex(ddi, REGEX_DDI, CAMPO_DDI_DEVE_SER_APENAS_NUMERO);
		this.ddi = ddi;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		verificaNulo(ddd, NUMERO_DDD_NAO_PODE_SER_NULO);
		verificaValorVazio(ddd, NUMERO_DDD_NAO_PODE_SER_VAZIO);
		verificaTamanhoMinimo(ddd, TAMANHO_2, CAMPO_DDD_DEVE_SER_2_CARACTERES);
		verificaTamanhoMaximo(ddd, TAMANHO_2, CAMPO_DDD_DEVE_SER_2_CARACTERES);
		verificaRegex(ddd, REGEX_DDD, CAMPO_DDD_DEVE_SER_APENAS_NUMERO);
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		verificaNulo(numero, O_CAMPO_TELEFONE_NAO_PODE_SER_NULO);
		verificaValorVazio(numero, O_CAMPO_TELEFONE_NAO_PODE_SER_VAZIO);
		verificaTamanhoMinimo(numero, TAMANHO_8, O_NUMERO_TELEFONE_DEVE_TER_O_MINIMO_DE_8_CARACTERES);
		verificaTamanhoMaximo(numero, TAMANHO_9, O_NUMERO_TELEFONE_DEVE_TER_O_MAXIMO_DE_9_CARACTERES);
		verificaRegex(numero, REGEX_TELEFONE, O_NUMERO_DE_TELEFONE_DEVE_CONTER_APENAS_NUMERO);
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		verificaNulo(numero, O_TIPO_DE_TELEFONE_NAO_PODE_SER_NULO);
		verificaValorVazio(numero, O_TIPO_DE_TELEFONE_NAO_PODE_SER_VAZIO);
		verificaRegex(tipo, REGEX_TIPO_TELEFONE_APENAS_LETRA, O_CAMPO_TIPO_DE_TELEFONE_ACEITA_APENAS_TEXTO);
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
