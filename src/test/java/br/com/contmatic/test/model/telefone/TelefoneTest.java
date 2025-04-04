package br.com.contmatic.test.model.telefone;

import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.CAMPO_DDI_DEVE_SER_3_CARACTERES;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.CAMPO_DDI_DEVE_SER_APENAS_NUMERO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.NUMERO_DDI_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.NUMERO_DDI_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.TIPO_TELEFONE_COMERCIAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.model.endereco.Estado;
import br.com.contmatic.prova.model.telefone.Telefone;

 class TelefoneTest {
	
	private Telefone telefone;
	
	@BeforeEach
	void set_up() {
		telefone = new Telefone("11","031","201682455");
	}
	
	@Test
	void deve_aceitar_DDI_valido_no_campo_DDD() {
		assertEquals("031", telefone.getDdi());
	}
	
	@Test
	void nao_deve_aceitar_campo_DDI_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi(null));
		assertEquals(NUMERO_DDI_NAO_PODE_SER_NULO, erro.getMessage());		
	}
	
	@Test
	void nao_deve_aceitar_campo_DDI_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi(""));
		assertEquals(NUMERO_DDI_NAO_PODE_SER_VAZIO, erro.getMessage());		
	}
	
	@Test
	void nao_deve_aceitar_campo_DDI_com_menos_de_3_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi("21"));
		assertEquals(CAMPO_DDI_DEVE_SER_3_CARACTERES, erro.getMessage());		
	}
	
	@Test
	void nao_deve_aceitar_campo_DDI_com_mais_de_3_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi("0021"));
		assertEquals(CAMPO_DDI_DEVE_SER_3_CARACTERES, erro.getMessage());		
	}
	
	@Test
	void campo_DDI_deve_aceitar_apenas_numeros() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi("03k"));
		assertEquals(CAMPO_DDI_DEVE_SER_APENAS_NUMERO , erro.getMessage());		
	}
	
	@Test
	void deve_aceitar_numero_telefone_valido_no_campo_telefone() {
		assertEquals("201682455", telefone.getNumero());
	}
	
	@Test
	void deve_aceitar_DDD_valido_no_campo_DDD() {
		assertEquals("11", telefone.getDdd());
	}
	
	
	@Test
	void deve_aceitar_tipo_de_telefone_valido() {
		telefone.setTipo(TIPO_TELEFONE_COMERCIAL);
		assertEquals(TIPO_TELEFONE_COMERCIAL, telefone.getTipo());
	}
	
	@Test
	void deve_retornar_mesmo_valor_hascode() {
		Telefone telefone2 = new Telefone("11","031","201682455");
		assertEquals(telefone.hashCode(), telefone2.hashCode());
	}
	
	@Test
	void deve_retornar_verdadeiro_para_objetos_iguais() {
		assertEquals(telefone, telefone);
	}
	
	@Test
	void deve_retornar_falso_para_equals_comparado_com_nulo() {
		assertNotEquals(telefone,null);
	}
	
	@Test
	void deve_retornar_falso_para_equals_com_diferentes_classes() {
		Estado estado = new Estado("SP");
		assertNotEquals(telefone, estado);
	}
	
	@Test
	void deve_retornar_verdadeiro_para_objetos_com_o_mesmo_DDD_DDi_Numero(){
		Telefone telefone1 = new Telefone("11","031","201682455");
		assertEquals(telefone, telefone1);
	}
	
	@Test
	void deve_retornar_falso_para_objetos_com_DDD_DDi_Numero_diferentes(){
		Telefone telefone1 = new Telefone("12","032","201682454");
		assertNotEquals(telefone, telefone1);
	}
	
	@Test
	void deve_retornar_verdadeiro_para_o_toString() {
		assertEquals("Telefone [ddi=031, ddd=11, numero=201682455, tipo=null]", telefone.toString());
	}

}
