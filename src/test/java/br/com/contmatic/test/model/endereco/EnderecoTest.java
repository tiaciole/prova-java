package br.com.contmatic.test.model.endereco;

import static br.com.contmatic.prova.utils.constants.CidadeConstantes.O_CAMPO_NOME_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.NOME_COM_MAIS_DE_80_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_CAMPO_BAIRRO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_CAMPO_BAIRRO_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_CAMPO_ENDERECO_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_CAMPO_NUMERO_DEVE_TER_MINIMO_2_NUMEROS;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_CAMPO_NUMERO_E_DE_PREENCHIMENTO_OBRIGATORIO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_ENDERECO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_TAMANHO_MAXIMO_DO_CAMPO_NUMERO_E_DE_8_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_TAMANHO_MINIMO_E_DE_2_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.TAMANHO_MAXIMO_80_CARACTERES_LOGRADOURO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.model.endereco.Cidade;
import br.com.contmatic.prova.model.endereco.Endereco;
import br.com.contmatic.prova.model.endereco.Estado;
import br.com.contmatic.prova.utils.constants.EnderecoConstantes;

class EnderecoTest {

	Endereco endereco;

	@BeforeEach
	void set_up() {
		endereco = new Endereco(11, "03929110", "Casa1");
	}

	@Test
	void deva_ceitar_logradouro_valido() {
		endereco.setLogradouro("Rua Oliveira");
		assertEquals("Rua Oliveira", endereco.getLogradouro());
	}

	@Test
	void deve_aceitar_numero_do_logradouro() {
		assertEquals(11, endereco.getNumero());
	}

	@Test
	void nao_deve_aceitar_numero_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> endereco.setNumero(null));
		assertEquals(O_CAMPO_NUMERO_E_DE_PREENCHIMENTO_OBRIGATORIO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_menos_que_2_numero_no_campo_numero() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> endereco.setNumero(1));
		assertEquals(O_CAMPO_NUMERO_DEVE_TER_MINIMO_2_NUMEROS, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_mais_que_o_valor_99999999() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> endereco.setNumero(999999999));
		assertEquals(O_TAMANHO_MAXIMO_DO_CAMPO_NUMERO_E_DE_8_CARACTERES, erro.getMessage());
	}

	@Test
	void deve_aceitar_cep_logradouro() {
		assertEquals("03929110", endereco.getCep());
	}

	@Test
	void deve_aceitar_complemento_do_endereco() {
		assertEquals("Casa1", endereco.getComplemento());
	}

	@Test
	void nao_deve_aceitar_logradouro_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro(null));
		assertEquals(O_ENDERECO_NAO_PODE_SER_NULO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_campo_logradouro_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> endereco.setLogradouro(""));
		assertEquals(O_CAMPO_ENDERECO_NAO_PODE_SER_VAZIO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_campo_logradouro_com_menos_de_2_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> endereco.setLogradouro("1"));
		assertEquals(O_TAMANHO_MINIMO_E_DE_2_CARACTERES, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_logradouro_com_mais_de_80_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro(NOME_COM_MAIS_DE_80_CARACTERES));
		assertEquals(TAMANHO_MAXIMO_80_CARACTERES_LOGRADOURO, erro.getMessage());
	}

	@Test
	void deve_aceitar_campo_endereco_valido() {
		endereco.setBairro("Jd Tiete");
		assertEquals("Jd Tiete", endereco.getBairro());
	}

	@Test
	void nao_deve_aceitar_campo_bairro_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> endereco.setBairro(null));
		assertEquals(O_CAMPO_BAIRRO_NAO_PODE_SER_NULO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_bairro_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> endereco.setBairro(""));
		assertEquals(O_CAMPO_BAIRRO_NAO_PODE_SER_VAZIO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_bairro_com_menos_de_2_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> endereco.setBairro("k"));
		assertEquals(O_TAMANHO_MINIMO_E_DE_2_CARACTERES, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_bairro_com_mais_de_80_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> endereco.setBairro(NOME_COM_MAIS_DE_80_CARACTERES));
		assertEquals("O tamanho máximo do campo Logradouro é de 80 caracteres", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_campo_cidade_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> endereco.setCidade(null));
		assertEquals(O_CAMPO_NOME_NAO_PODE_SER_NULO, erro.getMessage());
	}

	@Test
	void deve_aceitar_campo_cidade_valida() {
		Estado estado = new Estado("MA");
		Cidade cidade = new Cidade("SP", estado);
		endereco.setCidade(cidade);
		assertEquals(endereco.getCidade(), cidade);
	}

	@Test
	void deve_retornar_mesmo_valor_hascode() {
		Endereco endereco2 = new Endereco(11, "03929110", "Casa1");
		assertEquals(endereco.hashCode(), endereco2.hashCode());
	}

	@Test
	void deve_retornar_verdadeiro_para_objetos_iguais() {
		assertEquals(endereco, endereco);
	}

	@Test
	void deve_retornar_falso_para_equals_comparado_com_nulo() {
		assertNotEquals(endereco, null);
	}

	@Test
	void deve_retornar_falso_para_equals_com_diferentes_classes() {
		Funcionario funcionario = new Funcionario("Tiago", "47044517048");
		assertNotEquals(endereco, funcionario);
	}

	@Test
	void deve_retornar_verdadeiro_para_objetos_com_o_mesmo_numero_cep_complemento() {
		Endereco endereco2 = new Endereco(11, "03929110", "Casa1");
		assertEquals(endereco, endereco2);
	}

	@Test
	void deve_retornar_falso_para_objetos_com_diferente_numero_cep_complemento() {
		Endereco endereco2 = new Endereco(12, "03929119", "Casa2");
		assertNotEquals(endereco, endereco2);
	}

	@Test
	void deve_retornar_verdadeiro_o_toString() {
		assertEquals("Endereco [logradouro=null, numero=11, bairro=null, cep=03929110, complemento=Casa1, cidade=null]",
				endereco.toString());
	}
}
