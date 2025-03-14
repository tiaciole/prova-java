package br.com.contmatic.test.model.empresa;

import static br.com.contmatic.prova.utils.constants.CpfConstantesUtils.CPF_INVALIDO;
import static br.com.contmatic.prova.utils.constants.CpfConstantesUtils.O_CPF_DEVE_TER_11_CARACTERES;
import static br.com.contmatic.prova.utils.constants.CpfConstantesUtils.O_CPF_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.EMAIL_COM_MAIS_DE_80_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.EMAIL_DEVE_TER_MINIMO_DE_3_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.EMAIL_DEVE_TER_NO_MAXIMO_80_CARACTERES;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.FORMATO_EMAIL_INVALIDO;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.MSG_EMAIL_INVALIDO;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.MSG_EMAIL_VAZIO;
import static br.com.contmatic.prova.utils.constants.EmailConstantes.TIPO_EMAIL_NULO;
import static br.com.contmatic.prova.utils.constants.EnderecoConstantes.O_ENDERECO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.NOME_FUNCIONARIO_ATE_80_CARACTERES;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.NOME_FUNCIONARIO_MAIOR_QUE_80_CARACTERES;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_CAMPO_DO_FUNCIONARIO_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_CAMPO_NOME_DEVE_TER_MINIMO_2_CARACTERES;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_CAMPO_NOME_FUNCIONARIO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_CAMPO_SALARIO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_CAMPO_SALARIO_NAO_PODE_SER_ZERO;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_TAMANHO_MAXIMO_DO_CAMPO_NOME_80_CARACTERES;
import static br.com.contmatic.prova.utils.constants.FuncionarioConstantes.O_VALOR_DO_SALARIO_NAO_PODE_SER_MAIOR_QUE_DOIS_MIL;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.MSG_TELEFONE_INVALIDO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_CAMPO_TELEFONE_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_CAMPO_TELEFONE_NAO_PODE_SER_VAZIO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_NUMERO_DE_TELEFONE_DEVE_CONTER_APENAS_NUMERO;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_NUMERO_TELEFONE_DEVE_TER_O_MAXIMO_DE_9_CARACTERES;
import static br.com.contmatic.prova.utils.constants.TelefoneConstantes.O_NUMERO_TELEFONE_DEVE_TER_O_MINIMO_DE_8_CARACTERES;
import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.model.empresa.Empresa;
import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.model.empresa.Setor;
import br.com.contmatic.prova.model.endereco.Endereco;
import br.com.contmatic.prova.utils.constants.SetorConstantes;

class FuncionarioTest {

	private Funcionario funcionario;

	@BeforeEach
	void set_up2() {
		funcionario = new Funcionario("Tiago", "87806981071");
	}

	@Test
	void deve_aceitar_funcionario_válido() {
		Assertions.assertEquals("Tiago", funcionario.getNome());
		Assertions.assertEquals("87806981071", funcionario.getCpf());
	}

	@Test
	void nao_deve_aceitar_nome_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario(null, "87806981071"));
		assertEquals(O_CAMPO_NOME_FUNCIONARIO_NAO_PODE_SER_NULO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("", "87806981071"));
		assertEquals(O_CAMPO_DO_FUNCIONARIO_NAO_PODE_SER_VAZIO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_menor_que_2_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("T", "87806981071"));
		assertEquals(O_CAMPO_NOME_DEVE_TER_MINIMO_2_CARACTERES, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_maior_que_80_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario(
						NOME_FUNCIONARIO_MAIOR_QUE_80_CARACTERES,
						"87806981071"));
		assertEquals(O_TAMANHO_MAXIMO_DO_CAMPO_NOME_80_CARACTERES, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_ate_80_caracteres() {
		Funcionario funcionario2 = new Funcionario(NOME_FUNCIONARIO_ATE_80_CARACTERES, "87806981071");
		assertEquals(NOME_FUNCIONARIO_ATE_80_CARACTERES, funcionario2.getNome());
	}

	@Test
	void nao_deve_aceitar_endereco_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEndereco(null));
		assertEquals(O_ENDERECO_NAO_PODE_SER_NULO, erro.getMessage());
	}

	@Test
	void deve_aceitar_o_endereco_valido() {
		Endereco endereco = new Endereco(11, "03929110", "Casa1");
		funcionario.setEndereco(endereco);
		assertEquals(endereco, funcionario.getEndereco()); // Victor Ajudou
	}

	@Test
	void nao_deve_aceitar_valor_salario_zero() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSalario(valueOf(-1)));
		assertEquals(O_CAMPO_SALARIO_NAO_PODE_SER_ZERO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_salario_maior_que_2000() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSalario(valueOf(2000.1)));
		assertEquals(O_VALOR_DO_SALARIO_NAO_PODE_SER_MAIOR_QUE_DOIS_MIL, erro.getMessage());
	}

	@Test
	void deve_aceitar_salario_maior_igual_que_2000() {
		funcionario.setSalario(valueOf(2000));
		assertEquals(funcionario.getSalario(), valueOf(2000));
	}

	@Test
	void nao_deve_aceitar_salario_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSalario(null));
		assertEquals(O_CAMPO_SALARIO_NAO_PODE_SER_NULO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_cpf_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("Tiago", null));
		assertEquals(O_CPF_NAO_PODE_SER_NULO, erro.getMessage()); // está dando erro o teste ver gui
	}

	@Test
	void nao_deve_aceitar_cpf_menos_que_11_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("Tiago", "8780698107"));
		assertEquals(O_CPF_DEVE_TER_11_CARACTERES, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_cpf_maior_que_11_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("Tiago", "878069810710"));
		assertEquals(O_CPF_DEVE_TER_11_CARACTERES, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_cpf_com_numeros_repetidos() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("Tiago", "11111111111"));
		assertEquals(CPF_INVALIDO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_cpf_com_letras() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("Tiago", "87806981k71"));
		assertEquals(CPF_INVALIDO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_cpf_com_digito_incorreto() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("Tiago", "87806981075"));
		assertEquals(CPF_INVALIDO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_campo_setor_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> funcionario.setSetor(null));
		assertEquals(SetorConstantes.CAMPO_SETOR_NULO, erro.getMessage());
	}

	@Test
	void deve_aceitar_campo_setor() {
		Setor setor = new Setor("Administrativo", funcionario);
		funcionario.setSetor(setor);
		assertEquals(setor, funcionario.getSetor());
	}

	@Test
	void nao_deve_aceitar_endereço_invalido_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEndereco(null));
		assertEquals(O_ENDERECO_NAO_PODE_SER_NULO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_telefone_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setTelefone(null));
		assertEquals(O_CAMPO_TELEFONE_NAO_PODE_SER_NULO, erro.getLocalizedMessage());
	}

	@Test
	void nao_deve_aceitar_campo_telefone_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> funcionario.setTelefone(""));
		assertEquals(O_CAMPO_TELEFONE_NAO_PODE_SER_VAZIO, erro.getMessage());
	}

	@Test
	void deve_aceitar_campo_telefone_preenchido() {
		funcionario.setTelefone("925457896");
		assertEquals("925457896", funcionario.getTelefone());
	}

	@Test
	void nao_deve_aceitar_telefone_com_numeros_repetidos() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setTelefone("4444444444"));
		assertEquals(MSG_TELEFONE_INVALIDO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_telefone_com_menos_que_8_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setTelefone("4525896"));
		assertEquals(O_NUMERO_TELEFONE_DEVE_TER_O_MINIMO_DE_8_CARACTERES, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_telefone_com_mais_que_9_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setTelefone("9201586453"));
		assertEquals(O_NUMERO_TELEFONE_DEVE_TER_O_MAXIMO_DE_9_CARACTERES, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_numero_de_telefone_com_letra() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setTelefone("12548798k"));
		assertEquals(O_NUMERO_DE_TELEFONE_DEVE_CONTER_APENAS_NUMERO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_campo_do_email_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> funcionario.setEmail(null));
		assertEquals(TIPO_EMAIL_NULO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_campo_do_email_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> funcionario.setEmail(""));
		assertEquals(MSG_EMAIL_VAZIO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_com_caracteres_repetidos() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail("kkkkkkk"));
		assertEquals(MSG_EMAIL_INVALIDO, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_com_menos_de_3_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> funcionario.setEmail("2@"));
		assertEquals(EMAIL_DEVE_TER_MINIMO_DE_3_CARACTERES, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_com_mais_de_80_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail(EMAIL_COM_MAIS_DE_80_CARACTERES));
		assertEquals(EMAIL_DEVE_TER_NO_MAXIMO_80_CARACTERES, erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_sem_arroba() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail("tiagogmail.com"));
		assertEquals(FORMATO_EMAIL_INVALIDO, erro.getMessage());
	}

	@Test
	void deve_aceitar_email_preenchido() {
		funcionario.setEmail("tiago@gmail.com");
		assertEquals("tiago@gmail.com", funcionario.getEmail());
	}

	@Test
	void deve_retornar_mesmo_valor_hascode() {
		Funcionario funcionario2 = new Funcionario("Tiago Aciole", "87806981071");
		assertEquals(funcionario.hashCode(), funcionario2.hashCode());
	}

	@Test
	void deve_retornar_verdadeiro_para_objetos_iguais() {
		assertEquals(funcionario, funcionario);
	}

	@Test
	void deve_retornar_falso_para_equals_comparado_com_nulo() {
		assertNotEquals(funcionario, null);
	}

	@Test
	void deve_retornar_falso_para_equals_com_diferentes_classes() {
		Empresa empresa = new Empresa("Tiago Aciol2e", "67987198000110");
		assertNotEquals(new Funcionario("Tiago Aciole", "87806981071"), empresa);
	}

	@Test
	void deve_retornar_verdadeiro_para_objetos_com_o_mesmo_cpf() {
		Funcionario funcionario2 = new Funcionario("Tiago", "87806981071");
		assertEquals(funcionario, funcionario2);
	}

	@Test
	void deve_retornar_verdadeiro_o_toString() {
		System.out.println(funcionario.toString());
		assertEquals(
				"Funcionario [nome=Tiago, endereco=null, salario=null, cpf=87806981071, telefone=null, email=null]",
				funcionario.toString());
	}

}
