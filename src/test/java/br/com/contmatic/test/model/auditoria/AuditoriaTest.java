package br.com.contmatic.test.model.auditoria;

import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.CAMPO_DATA_ALTERACAO_INVALIDA;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.CAMPO_DATA_ALTERACAO_PREENCHIMENTO_OBRIGATORIO;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.CAMPO_DATA_CRIACAO_INVALIDA;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_CRIADOR_COM_MUITOS_CARACTERES_REPETIDOS;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_CRIADOR_DEVE_TER_MAXIMO_10_CARACTERES;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_CRIADOR_DEVE_TER_MINIMO_5_CARACTERES;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_CRIADOR_OBRIGATORIO;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_CRIADOR_SEM_ESPAÇO_BRANCO;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_EDITOR_COM_MUITOS_CARACTERES_REPETIDOS;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_EDITOR_DEVE_TER_MAXIMO_10_CARACTERES;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_EDITOR_DEVE_TER_MINIMO_5_CARACTERES;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_EDITOR_NAO_PODE_ESPACO_BRANCO;
import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

import br.com.contmatic.prova.model.auditoria.Auditoria;
import br.com.contmatic.prova.utils.constants.AuditoriaConstantes;

@TestMethodOrder(MethodOrderer.MethodName.class)
class AuditoriaTest {

	static int numero;

	Auditoria auditoria;;

	@BeforeAll
	static void mensagem_inicio() {
		System.out.println("Inicio do teste da Auditoria");
	}

	@AfterAll
	static void mensagem_final() {
		System.out.println("Final do teste");
	}

	@AfterEach
	void mensagem_cada_teste() {
		System.out.println("Teste efetuado" + numero);
		numero++;
	}
	
	@BeforeEach
	void set_up() {
		auditoria = new Auditoria();
	}

	@Test
	@Disabled
	void test12_deve_ser_ignorado() {
		auditoria.setNomeCriador("Tiago");
		assertEquals("Tiago", auditoria.getNomeCriador());
		System.out.println("Nao aconteceu");
	}

	@Test
	void test22_deve_aceitar_campo_nome_criador_valido() {
		auditoria.setNomeCriador("Tiago");
		assertEquals("Tiago", auditoria.getNomeCriador());
	}

	@Test
	void test02_nao_deve_aceitar_campo_nome_criador_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> auditoria.setNomeCriador(null));
		assertEquals(NOME_CRIADOR_OBRIGATORIO, erro.getMessage());
	}

	@Test
	void test03_nao_deve_aceitar_campo_nome_criador_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> auditoria.setNomeCriador(""));
		assertEquals(NOME_CRIADOR_SEM_ESPAÇO_BRANCO, erro.getMessage());
	}

	@Test
	void test04_nao_deve_aceitar_campo_nome_criador_menor_que_5_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> auditoria.setNomeCriador("Tiag"));
		assertEquals(NOME_CRIADOR_DEVE_TER_MINIMO_5_CARACTERES, erro.getMessage());
	}

	@Test
	void test06_nao_deve_aceitar_campo_nome_criador_mais_que_10_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> auditoria.setNomeCriador("Tiago Aciole de Oliveira"));
		assertEquals(NOME_CRIADOR_DEVE_TER_MAXIMO_10_CARACTERES, erro.getMessage());
	}

	@Test
	void test05_nao_deve_aceitar_caracteres_repetidos_no_campo_nome_do_criador() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> auditoria.setNomeCriador("ttttt"));
		assertEquals(NOME_CRIADOR_COM_MUITOS_CARACTERES_REPETIDOS, erro.getMessage());
	}

	@Test
	void test07_deve_aceitar_campo_nome_do_editor_valido() {
		auditoria.setNomeEditor("Tiago");
		assertThat("Tiago", equalTo(auditoria.getNomeEditor()));
	}

	@Test
	void test08_nao_deve_aceitar_nome_editor_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> auditoria.setNomeEditor(null));
		assertEquals(AuditoriaConstantes.NOME_EDITOR_NULO, erro.getMessage());
	}

	@Test
	void test09_nao_deve_aceitar_nome_editor_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> auditoria.setNomeEditor(""));
		assertEquals(NOME_EDITOR_NAO_PODE_ESPACO_BRANCO, erro.getMessage());
	}

	@Test
	void test10_nao_deve_aceitar_nome_editor_menor_que_5_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> auditoria.setNomeEditor("Tiag"));
		assertThat(NOME_EDITOR_DEVE_TER_MINIMO_5_CARACTERES, equalTo(erro.getMessage()));
	}

	@Test
	void test11_nao_deve_aceitar_nome_editor_mais_que_10_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> auditoria.setNomeEditor("Tiago Aciole de Oliveira"));
		assertEquals(NOME_EDITOR_DEVE_TER_MAXIMO_10_CARACTERES, erro.getMessage());
	}

	@Test
	void test01_nao_deve_aceitar_caracteres_repetidos_no_campo_nome_do_editor() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> auditoria.setNomeEditor("ttttt"));
		assertEquals(NOME_EDITOR_COM_MUITOS_CARACTERES_REPETIDOS, erro.getMessage());
	}

	@Test
	void test13_deve_aceitar_data_hora_criacao_valida() {
		ZonedDateTime dataHoraEsperada = ZonedDateTime.now();
		auditoria.setDataHoraCriacao(dataHoraEsperada);
		assertEquals(auditoria.getDataHoraCriacao(), dataHoraEsperada);
	}

	@Test
	void test14_nao_deve_aceitar_data_hora_criacao_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> auditoria.setDataHoraCriacao(null));
		assertEquals(AuditoriaConstantes.CAMPO_DATA_CRIACAO_INVALIDA, erro.getMessage());
	}

	@Test
	void test15_nao_deve_aceitar_data_hora_criacao_diferente_do_horario_atual() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> auditoria.setDataHoraCriacao(ZonedDateTime.now().plusHours(1)));
		assertEquals(CAMPO_DATA_CRIACAO_INVALIDA, erro.getMessage());
	}

	@Test
	void test16_deve_aceitar_data_hora_alteracao_valida() {
		ZonedDateTime dataHoraAlteracao = ZonedDateTime.now();
		auditoria.setDataHoraAlteracao(dataHoraAlteracao);
		assertEquals(auditoria.getDataHoraAlteracao(), dataHoraAlteracao);
	}

	@Test
	void test17_nao_deve_aceitar_data_hora_alteracao_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> auditoria.setDataHoraAlteracao(null));
		assertEquals(CAMPO_DATA_ALTERACAO_PREENCHIMENTO_OBRIGATORIO, erro.getMessage());
	}

	@Test
	void test18_nao_deve_aceitar_data_hora_maior_alteracao_diferente() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> auditoria.setDataHoraAlteracao(ZonedDateTime.now().plusHours(1)));
		assertEquals(CAMPO_DATA_ALTERACAO_INVALIDA, erro.getMessage());
	}

	@Test
	void test19_nao_deve_aceitar_data_hora_menor_alteracao_diferente() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> auditoria.setDataHoraAlteracao(ZonedDateTime.now().minusHours(1)));
		assertEquals(CAMPO_DATA_ALTERACAO_INVALIDA, erro.getMessage());
	}

	@Test
	void test20_deve_retornar_verdadeiro_para_o_toString() {
		System.out.println(auditoria);
		assertEquals("Auditoria [nomeCriador=null, nomeEditor=null, dataHoraCriacao=null, dataHoraAlteracao=null]",
				auditoria.toString());
	}

	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS) 
		void test21_teste_com_timeout_passando() throws InterruptedException {
		sleep(95); 
		assertTrue(true); 
	}
}
