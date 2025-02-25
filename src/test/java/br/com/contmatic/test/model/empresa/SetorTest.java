package br.com.contmatic.test.model.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.model.empresa.Setor;

public class SetorTest {

	Setor setor;

	@BeforeEach
	void set_up() {
		Funcionario funcionario = new Funcionario("Tiago", "56799896034");
		setor = new Setor("ADM", funcionario);
	}

	@Test
	void deve_aceitar_lista_de_funcionario_valida() {
		Funcionario funcionario = new Funcionario("Tiago", "56799896034");
		Setor setor = new Setor("ADM", funcionario);
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		listaFuncionario.add(funcionario);
		setor.setFuncionarios(listaFuncionario);
		assertEquals(listaFuncionario, setor.getFuncionarios());
	}

	@Test
	void nao_deve_aceitar_lista_de_funcionario_nulo() {
		Funcionario funcionario = new Funcionario("Tiago", "56799896034");
		Setor setor = new Setor("ADM", funcionario);
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> setor.setFuncionarios(null));
		assertEquals(erro.getMessage(), "O campo Funcionário do Setor é obrigatório");
	}

	@Test
	void nao_deve_aceitar_lista_funcionario_vazia() {
		Funcionario funcionario = new Funcionario("Tiago", "56799896034");
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		Setor setor = new Setor("ADM", funcionario);
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> setor.setFuncionarios(listaFuncionario));
		assertEquals("É obrigatório o cadastro de no mínimo 1 funcionário", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_lista_com_mais_de_10_funcionarios_cadastrados() {
		Funcionario funcionario = new Funcionario("Tiago", "56799896034");
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		for (int i = 0; i < 11; i++) {
			Funcionario funcionario2 = new Funcionario("Tiago", "56799896034");
			listaFuncionario.add(funcionario2);
		}
		Setor setor = new Setor("adm", funcionario);
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> setor.setFuncionarios(listaFuncionario));
		assertEquals("Nao é permitido uma lista com mais de 10 funcionarios", erro.getMessage());
	}

	@Test
	void deve_aceitar_nome_do_setor() {
		Funcionario funcionario = new Funcionario("Tiago", "56799896034");
		Setor setor = new Setor("ADM", funcionario);
		assertEquals(setor.getNome(), "ADM");
	}

	@Test
	void deve_aceitar_chefe_do_setor() {
		Funcionario funcionario = new Funcionario("Tiago", "56799896034");
		Setor setor = new Setor("ADM", funcionario);
		assertEquals(setor.getChefe(), funcionario);
	}

	@Test
	void deve_retornar_mesmo_valor_hascode() {
		Funcionario funcionario = new Funcionario("Tiago", "56799896034");
		Setor setor1 = new Setor("ADM", funcionario);
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
		assertNotEquals(setor, new Funcionario("Tiago", "56799896034"));
	}
	
	@Test
	void deve_retornar_verdadeiro_para_objetos_com_o_mesmo_cpf() {
		Funcionario funcionario = new Funcionario("Tiago", "56799896034");
		Setor setor1 = new Setor("ADM", funcionario);
		assertEquals(setor, setor1);
	}
	
	@Test
	void deve_retornar_falso_para_objetos_com_cpf_diferentes() {
		Funcionario funcionario = new Funcionario("Tiago", "40465371086");
		Setor setor1 = new Setor("ADM", funcionario);
		assertNotEquals(setor, setor1);
	}
	
	@Test
	void deve_retornar_verdadeiro_o_toString() {
		assertEquals("Setor [nome=ADM, chefe=Funcionario [nome=Tiago, endereco=null, salario=null, cpf=56799896034, telefone=null, email=null], funcionarios=null]", setor.toString());
	}
}
