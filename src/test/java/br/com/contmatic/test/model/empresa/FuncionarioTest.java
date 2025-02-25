package br.com.contmatic.test.model.empresa;

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

public class FuncionarioTest {
	
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
		assertEquals("O campo nome é obrigatorio", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("", "87806981071"));
		assertEquals("O campo é de preenchimento obrigatório", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_menor_que_2_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("T", "87806981071"));
		assertEquals("O campo Nome deve ser no minimo 2 caracteres", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_maior_que_80_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario(
						"(Hl%y7r4Wa+l9+$cdFap5MlkdO3O4vcRHyLFd9^L#hZJSG_t7LH^rp0O4qKJUsP68IZpI24*8n*y0DG44",
						"87806981071"));
		assertEquals("O tamanho maximo do campo nome é 80 caracteres", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_ate_que_80_caracteres() {
		Funcionario funcionario = new Funcionario(
				"(Hl%y7r4Wa+l9$cdFap5MlkdO3O4vcRHyLFd9^L#hZJSG_t7LH^rp0O4qKJUsP68IZpI24*8n*y0DG44", "87806981071");
		assertEquals("(Hl%y7r4Wa+l9$cdFap5MlkdO3O4vcRHyLFd9^L#hZJSG_t7LH^rp0O4qKJUsP68IZpI24*8n*y0DG44",
				funcionario.getNome());
	}

	@Test
	void nao_deve_aceitar_endereco_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEndereco(null));
		assertEquals("Endereço inválido", erro.getMessage());
	}

	@Test
	void deve_aceitar_o_endereco_valido() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		Endereco endereco = new Endereco(3, "03929110", "teste");
		funcionario.setEndereco(endereco);
		assertEquals(endereco, funcionario.getEndereco()); // Victor Ajudou
	}

	@Test
	void nao_deve_aceitar_valor_salario_zero() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSalario(valueOf(-1)));
		assertEquals("Valor do salario não pode ser zero", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_salario_maior_que_2000() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSalario(valueOf(2000.1)));
		assertEquals("O valor não pode ser maior que 2.000,00", erro.getMessage());
	}

	@Test
	void deve_aceitar_salario_maior_igual_que_2000() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		funcionario.setSalario(valueOf(2000));
		assertEquals(funcionario.getSalario(), valueOf(2000));
	}

	@Test
	void nao_deve_aceitar_salario_nulo() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSalario(null));
		assertEquals("O campo sálario é obrigatorio", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_cpf_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("Tiago", null));
		assertEquals("O campo Cpf é obrigatório", erro.getMessage()); // está dando erro o teste ver gui
	}

	@Test
	void nao_deve_aceitar_cpf_menos_que_11_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("Tiago", "8780698107"));
		assertEquals("O CPF deve ter 11 caracteres", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_cpf_maior_que_11_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("Tiago", "878069810710"));
		assertEquals("O CPF deve ter 11 caracteres", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_cpf_com_numeros_repetidos() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("Tiago", "11111111111"));
		assertEquals("O CPF não deve conter uma sequencia de número repetidos", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_cpf_com_letras() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("Tiago", "87806981k71"));
		assertEquals("CPF Inválido", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_cpf_com_digito_incorreto() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("Tiago", "87806981075"));
		assertEquals("CPF Inválido", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_campo_setor_nulo() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> funcionario.setSetor(null));
		assertEquals("O campo é de preencimento obrigatorio", erro.getMessage());
	}

	@Test
	void deve_aceitar_campo_setor() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		Setor setor = new Setor("Administrativo", funcionario);
		funcionario.setSetor(setor);
		assertEquals(setor, funcionario.getSetor());
	}

	@Test
	void nao_deve_aceitar_endereço_invalido() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEndereco(null));
		assertEquals("Endereço inválido", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_telefone_nulo() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setTelefone(null));
		assertEquals("Número de telefone inválido", erro.getLocalizedMessage());
	}

	@Test
	void nao_deve_aceitar_campo_telefone_vazio() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> funcionario.setTelefone(""));
		assertEquals("O Campo Número de telefone é obrigatorio", erro.getMessage());
	}

	@Test
	void deve_aceitar_campo_telefone_preenchido() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		funcionario.setTelefone("1125457896");
		assertEquals("1125457896", funcionario.getTelefone());
	}

	@Test
	void nao_deve_aceitar_telefone_com_numeros_repetidos() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setTelefone("4444444444"));
		assertEquals("Número de telefone inválido", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_telefone_com_menos_que_10_caracteres() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setTelefone("4525896"));
		assertEquals("O numero do telefone deve conter no minimo 8 caracteres", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_telefone_com_mais_que_11_caracteres() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setTelefone("99541452589"));
		assertEquals("O campo telefone deve ter no máximo 10 caracteres", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_numero_de_telefone_com_letra() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setTelefone("585454698k"));
		assertEquals("O Campo Telefone deve conter apenas números", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_campo_do_email_nulo() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> funcionario.setEmail(null));
		assertEquals("Email inválido", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_campo_do_email_vazio() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> funcionario.setEmail(""));
		assertEquals("Campo Email é de preenchimento obrigatorio", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_com_caracteres_repetidos() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail("kkkkkkk"));
		assertEquals("O Email está inválido", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_com_menos_de_3_caracteres() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> funcionario.setEmail("2@"));
		assertEquals("O numero do telefone deve conter no minimo 2 caracteres", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_com_mais_de_80_caracteres() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail("VAiVcwIxyyqElx@NJNgPuKxEbBBmPuSbrMYxdEyrFGwCeZgfqumvwFprpSUgQfpmxLrgodfdfvLWWHkçw"));
		assertEquals("O campo email deve ter no máximo 80 caracteres", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_sem_arroba() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> funcionario.setEmail("tiagogmail.com"));
		assertEquals("O Campo Email deve conter arroba", erro.getMessage());
	}

	@Test
	void deve_aceitar_email_preenchido() {
		Funcionario funcionario = new Funcionario("Tiago", "87806981071");
		funcionario.setEmail("tiago@gmail.com");
		assertEquals("tiago@gmail.com", funcionario.getEmail());
	}
	
	@Test
	void deve_retornar_mesmo_valor_hascode() {
		Funcionario funcionario2 = new Funcionario("Tiago Aciole","87806981071");
		assertEquals(funcionario.hashCode(), funcionario2.hashCode());
	}
	
	@Test
	void deve_retornar_verdadeiro_para_objetos_iguais() {
		assertEquals(funcionario,funcionario);		
	}
	
	@Test
	void deve_retornar_falso_para_equals_comparado_com_nulo() {
		assertNotEquals(funcionario, null);
	}
	
	@Test
	void deve_retornar_falso_para_equals_com_diferentes_classes() {
		Empresa empresa = new Empresa("Tiago Aciol2e","67987198000110");
		assertNotEquals(new Funcionario("Tiago Aciole","87806981071"),empresa);
	}
	
	@Test
	void deve_retornar_verdadeiro_para_objetos_com_o_mesmo_cpf(){
		Funcionario funcionario2 = new Funcionario("Tiago", "87806981071");
		assertEquals(funcionario, funcionario2);
	}
	
	@Test
	void deve_retornar_verdadeiro_o_toString() {
		System.out.println(funcionario.toString()); 
		assertEquals("Funcionario [nome=Tiago, endereco=null, salario=null, cpf=87806981071, telefone=null, email=null]", funcionario.toString());
	}
	
}
