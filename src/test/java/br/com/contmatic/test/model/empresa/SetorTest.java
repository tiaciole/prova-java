package br.com.contmatic.test.model.empresa;

import static br.com.contmatic.prova.utils.constants.SetorConstantes.CAMPO_FUNCIONARIO_OBRIGATORIO;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.CAMPO_SETOR_MINIMO_3_CARACTERES;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.CAMPO_SETOR_VAZIO;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.LISTA_FUNCIONARIO_VAZIA;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.LISTA_SETOR_COM_MAIS_DE_10_FUNCIONARIOS;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.NOME_SETOR_ADM;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.NOME_TIAGO;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.NUMERO_CPF_TIAGO;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.ONZE_CARACRETES;
import static br.com.contmatic.prova.utils.constants.SetorConstantes.TOSTRING_SETOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.model.empresa.Setor;
import br.com.contmatic.prova.utils.constants.SetorConstantes;

class SetorTest {

	Setor setor;

	@BeforeEach
	void set_up() {
		Funcionario funcionario = new Funcionario(NOME_TIAGO, NUMERO_CPF_TIAGO);
		setor = new Setor(NOME_SETOR_ADM, funcionario);
	}

	@Test
	void deve_aceitar_lista_de_funcionario_valida() {
		Funcionario funcionario = new Funcionario(NOME_TIAGO, NUMERO_CPF_TIAGO);
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		listaFuncionario.add(funcionario);
		setor.setFuncionarios(listaFuncionario);
		assertEquals(listaFuncionario, setor.getFuncionarios());
	}

	@Test
	void nao_deve_aceitar_lista_de_funcionario_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> setor.setFuncionarios(null));
		assertEquals(CAMPO_FUNCIONARIO_OBRIGATORIO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_lista_funcionario_vazia() {
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> setor.setFuncionarios(listaFuncionario));
		assertEquals(LISTA_FUNCIONARIO_VAZIA, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_lista_com_mais_de_10_funcionarios_cadastrados() {
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		for (int i = 0; i < 11; i++) {
			Funcionario funcionario2 = new Funcionario(NOME_TIAGO, NUMERO_CPF_TIAGO);
			listaFuncionario.add(funcionario2);
		}
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> setor.setFuncionarios(listaFuncionario));
		assertEquals(LISTA_SETOR_COM_MAIS_DE_10_FUNCIONARIOS , erro.getMessage());
	}

	@Test
	void deve_aceitar_nome_do_setor() {
		assertEquals(NOME_SETOR_ADM, setor.getNome());
	}
	
	@Test
	void nao_deve_aceitar_campo_nome_do_setor_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> setor.setNome(null));
		assertEquals(SetorConstantes.CAMPO_SETOR_NULO, erro.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_nome_do_setor_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> setor.setNome(""));
		assertEquals(CAMPO_SETOR_VAZIO, erro.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_nome_do_setor_menos_que_3_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> setor.setNome("AD"));
		assertEquals(CAMPO_SETOR_MINIMO_3_CARACTERES, erro.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_nome_do_setor_mais_que_10_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> setor.setNome("AD46587khf"));
		assertEquals(ONZE_CARACRETES, erro.getMessage());
	}

	@Test
	void deve_aceitar_chefe_do_setor() {
		Funcionario funcionario = new Funcionario(NOME_TIAGO, NUMERO_CPF_TIAGO);
		assertEquals(setor.getChefe(), funcionario);
	}

	@Test
	void deve_retornar_mesmo_valor_hascode() {
		Funcionario funcionario = new Funcionario(NOME_TIAGO, NUMERO_CPF_TIAGO);
		Setor setor1 = new Setor(NOME_SETOR_ADM, funcionario);
		assertEquals(setor.hashCode(), setor1.hashCode());
	}

	@Test
	void deve_retornar_verdadeiro_para_objetos_iguais(){
	assertEquals(setor, setor);
	}
	
	@Test
	void deve_retornar_falso_para_equals_comparado_com_nulo() {
		assertNotEquals(setor, null);
	}
	
	@Test
	void deve_retornar_falso_para_equals_com_diferentes_classes() {
		assertNotEquals(setor, new Funcionario(NOME_TIAGO, NUMERO_CPF_TIAGO));
	}
	
	@Test
	void deve_retornar_verdadeiro_para_objetos_com_o_mesmo_cpf() {
		Funcionario funcionario = new Funcionario(NOME_TIAGO, NUMERO_CPF_TIAGO);
		Setor setor1 = new Setor("ADM", funcionario);
		assertEquals(setor, setor1);
	}
	
	@Test
	void deve_retornar_falso_para_objetos_com_cpf_diferentes() {
		Funcionario funcionario = new Funcionario(NOME_TIAGO, "40465371086");
		Setor setor1 = new Setor(NOME_SETOR_ADM, funcionario);
		assertNotEquals(setor, setor1);
	}
	
	@Test
	void deve_retornar_verdadeiro_o_toString() {
		assertEquals(TOSTRING_SETOR, setor.toString());
	}
}
