package br.com.contmatic.test.model.endereco;

import static br.com.contmatic.prova.utils.constants.EstadoConstantes.NOME_COM_MAIS_DE_80_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.NOME_DO_ESTADO_O_MINIMO_E_2_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.O_CAMPO_ESTADO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.O_CAMPO_ESTADO_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.O_TAMANHO_MAXIMO_NO_CAMPO_NOME_ESTADO_E_80_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.SAO_PAULO;
import static br.com.contmatic.prova.utils.constants.EstadoConstantes.SP;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.model.endereco.Estado;

 class EstadoTest {

	Estado estado;
	
	@BeforeEach
	void set_up() {
		estado = new Estado("SP");
	}
	
	@Test
	void deve_aceitar_nome_do_estado_valido() {
		estado.setNome(SAO_PAULO);
		assertEquals(SAO_PAULO, estado.getNome());
	}

	@Test
	void deve_aceitar_uf_valida() {
		estado.setUf(SP);
		assertEquals(SP, estado.getUf());
	}

	@Test
	void nao_deve_aceitar_nome_de_estado_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> estado.setNome(null));
		assertEquals(O_CAMPO_ESTADO_NAO_PODE_SER_NULO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_de_estado_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> estado.setNome(""));
		assertEquals(O_CAMPO_ESTADO_NAO_PODE_SER_VAZIO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_de_estado_com_menos_de_2_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> estado.setNome("q"));
		assertEquals(NOME_DO_ESTADO_O_MINIMO_E_2_CARACTERES, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_de_estado_com_mais_de_80_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> estado.setNome(NOME_COM_MAIS_DE_80_CARACTERES));
		assertEquals(O_TAMANHO_MAXIMO_NO_CAMPO_NOME_ESTADO_E_80_CARACTERES, erro.getMessage());
	}
	
	@Test
	void deve_retornar_mesmo_valor_hascode() {
		Estado estado2= new Estado(SP);
		assertEquals(estado.hashCode(), estado2.hashCode());
	}
	
	@Test
	void deve_retornar_verdadeiro_para_objetos_iguais() {
		Estado estado2= new Estado(SP);
		assertEquals(estado, estado2);
	}
	
	@Test
	void deve_retornar_falso_para_equals_comparado_com_nulo() {
		Estado estado2= new Estado(SP);
		assertFalse(estado2.equals(null));
	}
	
	@Test
	void deve_retornar_falso_para_equals_com_diferentes_classes() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		assertNotEquals(estado, funcionario);
	}
		
	@Test
	void deve_retornar_falso_para_objetos_com_diferente_UF() {
		Estado estado2 = new Estado("AM");
		assertNotEquals(estado, estado2);
	}
	
	
	@Test
	void deve_retornar_verdadeiro_o_toString() {
		assertEquals("Estado [nome=null, uf=SP]", estado.toString());
	}
}
