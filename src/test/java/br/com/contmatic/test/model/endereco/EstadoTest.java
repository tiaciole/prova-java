package br.com.contmatic.test.model.endereco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.model.endereco.Estado;
import br.com.contmatic.prova.utils.constants.EmpresaConstantes;

public class EstadoTest {

	private static final String MAIS_DE_80_CARACTERES = "444CudydddwTAYfxyeM3cGoEJXXqNBOZ8ndNKnqStqMYEGojYAvui6O7XNy5LnHQmMm7tLbYxR29eFIV7fgM8S";

	Estado estado;
	
	@BeforeEach
	void set_up() {
		estado = new Estado("SP");
	}
	
	
	@Test
	void deve_aceitar_nome_do_estado_valido() {
		Estado estado = new Estado("AM");
		estado.setNome("SÃO PAULO");
		assertEquals("SÃO PAULO", estado.getNome());
	}

	@Test
	void deve_aceitar_uf_valida() {
		Estado estado = new Estado("AM");
		estado.setUf("SP");
		assertEquals("SP", estado.getUf());
	}

	@Test
	void nao_deve_aceitar_nome_de_estado_nulo() {
		Estado estado = new Estado("AM");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> estado.setNome(null));
		assertEquals(EmpresaConstantes.O_CAMPO_NOME_DO_ESTADO_E_OBRIGATORIO, erro.getMessage());
	}

	@Test
	void naodeveaceitarnomedeestadovazio() {
		Estado estado = new Estado("AM");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> estado.setNome(""));
		assertEquals(EmpresaConstantes.O_CAMPO_NOME_DO_ESTADO_E_OBRIGATORIO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_de_estado_com_menos_de_2_caracteres() {
		Estado estado = new Estado("AM");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> estado.setNome("q"));
		assertEquals("O tamanho minimo é de 2 caracteres", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_de_estado_com_mais_de_80_caracteres() {
		Estado estado = new Estado("AM");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> estado.setNome(MAIS_DE_80_CARACTERES));
		assertEquals("O tamanho máximo é de 80 caracteres", erro.getMessage());
	}
	
	@Test
	void deve_retornar_mesmo_valor_hascode() {
		Estado estado2= new Estado("SP");
		assertEquals(estado.hashCode(), estado2.hashCode());
	}
	
	@Test
	void deve_retornar_verdadeiro_para_objetos_iguais() {
		Estado estado2= new Estado("SP");
		assertEquals(estado, estado2);
	}
	
	@Test
	void deve_retornar_falso_para_equals_comparado_com_nulo() {
		assertNotEquals(estado, null);
	}
	
	@Test
	void deve_retornar_falso_para_equals_com_diferentes_classes() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		assertNotEquals(estado, funcionario);
	}
	
	@Test
	void deve_retornar_verdadeiro_para_objetos_com_o_mesmo_UF() {
		Estado estado2 = new Estado("SP");
		assertEquals(estado, estado2);
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
