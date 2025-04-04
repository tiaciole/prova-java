package br.com.contmatic.test.model.email;

import static br.com.contmatic.prova.utils.constants.EmailConstantes.EMAIL_COM_MAIS_DE_80_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.EMAIL_DEVE_TER_MAXIMO_DE_50_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.EMAIL_DEVE_TER_MINIMO_DE_3_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.MSG_EMAIL_INVALIDO;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.MSG_EMAIL_VAZIO;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.NOME_TIAGO;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.ROBERTO_GMAIL_COM;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.TIAGO_GMAIL_COM;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.TIPO_EMAIL_NULO;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.TIPO_EMAIL_VAZIO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.model.email.Email;
import br.com.contmatic.prova.model.empresa.Funcionario;

 class EmailTest {

	Email email;

	@BeforeEach
	void set_up() {
		email = new Email(TIAGO_GMAIL_COM);
	}

	@Test
	void deve_aceitar_email_valido() {
		assertEquals(TIAGO_GMAIL_COM, email.getEmail());
	}

	@Test
	void nao_deve_aceitar_campo_email_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> email.setEmail(null));
		assertEquals(TIPO_EMAIL_NULO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_campo_email_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> email.setEmail(""));
		assertEquals(MSG_EMAIL_VAZIO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_campo_email_com_menos_de_3_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> email.setEmail("fs"));
		assertEquals(EMAIL_DEVE_TER_MINIMO_DE_3_CARACTERES, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_campo_email_com_mais_de_50_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> email.setEmail(EMAIL_COM_MAIS_DE_80_CARACTERES));
		assertEquals(EMAIL_DEVE_TER_MAXIMO_DE_50_CARACTERES, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_ivalido() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> email.setEmail("rgrgk@"));
		assertEquals(MSG_EMAIL_INVALIDO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_tipo_de_email_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> email.setTipo(null));
		assertEquals(TIPO_EMAIL_NULO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_tipo_de_email_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> email.setTipo(""));
		assertEquals(TIPO_EMAIL_VAZIO, erro.getMessage());
	}

	@Test
	void deve_retornar_mesmo_valor_hascode() {
		Email email1 = new Email(TIAGO_GMAIL_COM);
		assertEquals(email.hashCode(), email1.hashCode());
	}

	@Test
	void deve_retornar_verdadeiro_para_objetos_iguais() {
		assertEquals(email, email);
	}

	@Test
	void deve_retornar_falso_para_equals_comparado_com_nulo() {
		assertNotEquals(email, null);
	}

	@Test
	void deve_retornar_falso_para_equals_com_diferentes_classes() {
		assertNotEquals(email, new Funcionario(NOME_TIAGO, "87806981071"));
	}

	@Test
	void deve_retornar_verdadeiro_para_objetos_com_o_mesmo_email_e_mesmo_tipo() {
		Email email1 = new Email(TIAGO_GMAIL_COM);
		email1.setTipo("comercial");
		email.setTipo("comercial");
		assertEquals(email, email1);
		assertEquals(email.getTipo(), email1.getTipo());
	}
	
	@Test
	void deve_retornar_falsoo_para_objetos_com_email_e_tipo_diferente() {
		Email email1 = new Email(ROBERTO_GMAIL_COM);
		email1.setTipo("comercial");
		email.setTipo("residencial");
		assertNotEquals(email, email1);
		assertNotEquals(email.getTipo(), email1.getTipo());
	}

	@Test
	void deve_retornar_verdadeiro_para_o_toString() {
		assertEquals("Email [email=Tiago@gmail.com, tipo=null]", email.toString());
	}
}
