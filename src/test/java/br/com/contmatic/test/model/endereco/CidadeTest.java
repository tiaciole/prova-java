package br.com.contmatic.test.model.endereco;

import static br.com.contmatic.prova.utils.constants.CidadeConstantes.O_CAMPO_NOME_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.CidadeConstantes.O_CAMPO_NOME_NAO_PODE_SER_VAZIO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.model.endereco.Cidade;
import br.com.contmatic.prova.model.endereco.Estado;

public class CidadeTest {

	@Test
	void deve_aceitar_campo_cidade_prenchido() {
		Estado estado = new Estado("SP");
		Cidade cidade = new Cidade("Santo André", estado);
		assertEquals("Santo André", cidade.getNome());
	}

	@Test
	void nao_deve_aceitar_campo_cidade_nulo() {
		Estado estado = new Estado("SP");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> new Cidade(null, estado));
		assertEquals(O_CAMPO_NOME_NAO_PODE_SER_NULO, erro.getMessage());
	}

	@Test
	void deveaceitarestadovalido() {
		Estado estado = new Estado("AM");
		Cidade cidade = new Cidade("SP", estado);
		cidade.setEstado(estado);
		assertEquals(cidade.getEstado(), estado);
	}

	@Test
	void nao_deve_aceitar_campo_cidade_vazio() {
		Estado estado = new Estado("SP");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> new Cidade("", estado));
		assertEquals(O_CAMPO_NOME_NAO_PODE_SER_VAZIO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_campo_cidade_com_menos_de_2_caracteres() {
		Estado estado = new Estado("SP");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> new Cidade("d", estado));
		assertEquals("O tamanho minimo é de 2 caracteres", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_campo_cidade_com_mais_de_80_caracteres() {
		Estado estado = new Estado("SP");
		String nomeComMai80Caracteres = "VAiVcwIxyyqElx@NJNgPuKxEbBBmPuSbrMYxdEyrFGwCeZgfqumvwFprpSUgQfpmxLrgodfdfvLWWHkçw";
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Cidade(nomeComMai80Caracteres, estado));
		assertEquals("O tamanho máximo é de 80 caracteres", erro.getMessage());//teste
	}

	@Test
	void deve_retornar_mesmo_valor_hascode() {
		Estado estado = new Estado("SP");
		Cidade cidade1 = new Cidade("SAO PAULO", estado);
		Cidade cidade2 = new Cidade("SAO PAULO", estado);
		assertEquals(cidade1.hashCode(), cidade2.hashCode());
	}

	@Test
	void deve_retornar_verdadeiro_para_objetos_iguais() {
		Estado estado = new Estado("SP");
		Cidade cidade1 = new Cidade("SAO PAULO", estado);
		assertEquals(cidade1, cidade1);
	}

	@Test
	void deve_retornar_falso_para_equals_comparado_com_nulo() {
		Estado estado = new Estado("SP");
		Cidade cidade1 = new Cidade("SAO PAULO", estado);
		assertNotEquals(cidade1, null);
	}

	@Test
	void deve_retornar_falso_para_equals_com_diferentes_classes() {
		Estado estado = new Estado("SP");
		Cidade cidade1 = new Cidade("SAO PAULO", estado);
		assertNotEquals(cidade1, estado);
	}

	@Test
	void deve_retornar_verdadeiro_para_objetos_com_o_mesmo_Estado() {
		Estado estado = new Estado("SP");
		Cidade cidade1 = new Cidade("SAO PAULO", estado);
		Cidade cidade2 = new Cidade("SAO PAULO", estado);
		assertEquals(cidade1, cidade2);
	}
	
	@Test
	void deve_retornar_falso_para_objetos_com_estado_diferente() {
		Estado estado = new Estado("AM");
		Cidade cidade1 = new Cidade("Minas", estado);
		Cidade cidade2 = new Cidade("SAO PAULO", estado);
		assertNotEquals(cidade1, cidade2);
	}

	@Test
	void deve_retornar_verdadeiro_o_toString() {
		Estado estado = new Estado("SP");
		Cidade cidade1 = new Cidade("SAO PAULO", estado);
		assertEquals("Cidade [nome=SAO PAULO, estado=Estado [nome=null, uf=SP]]",cidade1.toString());
	}
}
