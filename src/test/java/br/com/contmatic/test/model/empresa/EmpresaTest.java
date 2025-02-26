package br.com.contmatic.test.model.empresa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.model.empresa.Empresa;
import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.model.empresa.Setor;
import br.com.contmatic.prova.model.endereco.Endereco;

class EmpresaTest {

	private Empresa empresa;

	@BeforeAll
	static void rodarTudo() {
		System.out.println("iniciando classe empresa teste");
	}

	@BeforeEach
	void set_up() {
		empresa = new Empresa("Tiago Aciole", "67987198000110");
	}

	@Test
	void deve_aceitar_cnpj_valido() {
		assertEquals("67987198000110", empresa.getCnpj());
	}

	@Test
	void deve_aceitar_razao_social_valida() {
		assertEquals("Tiago Aciole", empresa.getRazaoSocial());//teste
	}

	@Test
	void nao_deve_aceitar_cnpj_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("Tiago Aciole", null));
		assertEquals("O campo cnpj é obrigatório", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_cnpj_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("Tiago Aciole", ""));
		assertEquals("O campo CNPJ não deve ser vazio", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_cnpj_menor_que_14() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("Tiago Aciole", "6798719800011"));
		assertEquals("Cnpj Inválido", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_cnpj_maior_que_14() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("Tiago Aciole", "679871980001100"));
		assertEquals("Cnpj Inválido", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_CNPJ_caracteres_repetidos() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("Tiago Aciole", "44444444444444"));
		assertEquals("Cnpj inválido", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_cnpj_com_digito_invalido() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("Tiago Aciole", "67987198000111"));
		assertEquals(erro.getMessage(), ("Cnpj Inválido"));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_letra() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("Tiago Aciole", "6798719800011e"));
		assertEquals("Cnpj Inválido", erro.getMessage());
	}

	@Test
	void deve_aceitar_inscricao_estadual_valido() {
		empresa.setInscricaoEstadual("1234567890");
		assertEquals("1234567890", empresa.getInscricaoEstadual());
	}

	@Test
	void nao_deve_aceitar_inscricao_estadual_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setInscricaoEstadual(null));
		assertEquals("A Inscrição Estadual é de preenhimento obrigatorio", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_inscricao_estadual_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setInscricaoEstadual(""));
		assertEquals("O campo Inscrição Estadual é obrigatório", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_inscricao_estadual_menor_que_5_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setInscricaoEstadual("1234"));
		assertEquals("O Campo Inscrição Estadual deve conter o minimo de 5 caracteres", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_inscricao_estadual_maior_que_10_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setInscricaoEstadual("123445678901"));
		assertEquals("O campo Inscrição Estadual deve ter o tamanho máximo de 10 caracteres", erro.getMessage());
	}

	@Test
	void nao_deve_conter_letra_no_campo_inscricao_estadual() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setInscricaoEstadual("123445678k"));
		assertEquals("O campo Inscrição Estadual deve ser apenas números", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_inscricao_estadual_com_caracteres_repetidos() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setInscricaoEstadual("55555555"));
		assertEquals("Inscrição Estadual inválida", erro.getMessage());
	}

	@Test
	void deve_aceitar_situacao_tributaria_valida() {
		empresa.setSituacaoTributaria("1234567890");
		assertEquals(empresa.getSituacaoTributaria(), "1234567890");
	}

	@Test
	void nao_deve_aceitar_situacao_tributaria_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setSituacaoTributaria(null));
		assertEquals("A Situação Tributaria é de preenhimento obrigatorio", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_situacao_tributaria_vazio() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setSituacaoTributaria(""));
		assertEquals("O campo Situação Tributaria não pode contes espaços em branco", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_situacao_tributaria_menor_que_5_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setSituacaoTributaria("1234"));
		assertEquals("O Campo Situação Tributaria deve conter o minimo de 5 caracteres", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_situacao_tributaria_maior_que_10_caracteres() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setSituacaoTributaria("12345678901"));
		assertEquals("O campo Situação Tributaria deve ter o tamanho máximo de 10 caracteres", erro.getMessage());
		;
	}

	@Test
	void deve_aceitar_situacao_tributaria_apenas_com_numero() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setSituacaoTributaria("123456789k"));
		assertEquals("O campo Situação Tributaria deve ser apenas números", erro.getMessage());
		;
	}

	@Test
	void nao_deve_aceitar_situacao_tributaria_com_caracteres_repetidos() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setSituacaoTributaria("5555555555"));
		assertEquals("Situação Tributaria inválida", erro.getMessage());
		;
	}

	@Test
	void deve_aceitar_campo_setor_valido() {
		Funcionario funcionario = new Funcionario("Tiago", "97973956000");
		Set<Setor> listaSetores = new HashSet<Setor>();// pode colcoar dentro dos dois diamantes o tipo, tem que ser o
														// mesmo
		for (int i = 0; i <= 2; i++) {
			Setor setor = new Setor("Recursos Humanos" + i, funcionario);
			listaSetores.add(setor);
		}
		empresa.setSetores(listaSetores);
		assertEquals(empresa.getSetores(), listaSetores);
	}

	@Test
	void nao_deve_aceitar_campo_setor_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> empresa.setSetores(null));
		assertEquals(erro.getMessage(), "O setor é de preenhimento obrigatorio");
	}

	@Test
	void nao_deve_aceitar_campo_setor_vazio() {
		Set<Setor> listaSetores = new HashSet<>();
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setSetores(listaSetores));
		assertEquals(erro.getMessage(), "Não existem setores cadastrados");
	}

	@Test
	void nao_deve_aceitar_campo_setor_com_apenas_1_setor_cadastrado() {
		Funcionario funcionario = new Funcionario("Tiago", "97973956000");
		Setor setor = new Setor("Recursos Humanos", funcionario);
		Set<Setor> listaSetores = new HashSet<>();
		listaSetores.add(setor);
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setSetores(listaSetores));
		assertEquals(erro.getMessage(), "Deve existir ao menos 2 setor cadastrado");
	}

	@Test
	void nao_deve_aceitar_mais_de_4_setores_cadastrados() {
		Funcionario funcionario = new Funcionario("Tiago", "97973956000");
		Set<Setor> listaSetores = new HashSet<>();
		IntStream.range(0, 5).forEach(indice
				-> listaSetores.add(new Setor("Recursos Humanos" + indice, funcionario)));//TODO entender esse
//		for (int i = 0; i <= 5; i++) {
//			Setor setor = new Setor("Recursos Humanos" + i, funcionario);
//			listaSetores.add(setor);
//		}
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setSetores(listaSetores));
		assertEquals(erro.getMessage(), "Não é possivel cadastrar mais que 4 setores");
	}

	@Test
	void deve_aceitar_campo_funcionario_valido() {
		Funcionario funcionario = new Funcionario("Tiago", "97973956000");
		Set<Funcionario> funcionarioLista = new HashSet<>();
		funcionarioLista.add(funcionario);
		empresa.setFuncionarios(funcionarioLista);
		assertEquals(empresa.getFuncionarios(), funcionarioLista);
	}

	@Test
	void não_deve_aceitar_campo_funcionario_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setFuncionarios(null));
		assertEquals("Os campos do cadastro de Funcionario é de preenchimento obrigatorio", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_campo_funcionario_vazio() {
		Set<Funcionario> funcionarioLista = new HashSet<>();
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setFuncionarios(funcionarioLista));
		assertEquals("Não existem funcionarios cadastrados", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_mais_que_10_funcionarios_cadastrados() {
		Set<Funcionario> funcionarioLista = new HashSet<>();
		Empresa empresa = new Empresa("Tiago Aciole", "67987198000110");
		Funcionario funcionario0 = new Funcionario("Tiago1", "97973956000");
		Funcionario funcionario1 = new Funcionario("Tiago2", "90976981033");
		Funcionario funcionario2 = new Funcionario("Tiago3", "85078717048");
		Funcionario funcionario3 = new Funcionario("Tiago4", "72160400076");
		Funcionario funcionario4 = new Funcionario("Tiago5", "38793444001");
		Funcionario funcionario5 = new Funcionario("Tiago6", "85288297070");
		Funcionario funcionario6 = new Funcionario("Tiago7", "23821883081");
		Funcionario funcionario7 = new Funcionario("Tiago8", "50978700007");
		Funcionario funcionario8 = new Funcionario("Tiago9", "22065272007");
		Funcionario funcionario9 = new Funcionario("Tiago10", "09979477059");
		Funcionario funcionario10 = new Funcionario("Tiago11", "12121812040");
		funcionarioLista.add(funcionario0);
		funcionarioLista.add(funcionario1);
		funcionarioLista.add(funcionario2);
		funcionarioLista.add(funcionario3);
		funcionarioLista.add(funcionario4);
		funcionarioLista.add(funcionario5);
		funcionarioLista.add(funcionario6);
		funcionarioLista.add(funcionario7);
		funcionarioLista.add(funcionario8);
		funcionarioLista.add(funcionario9);
		funcionarioLista.add(funcionario10);
		System.out.println(funcionarioLista);
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setFuncionarios(funcionarioLista));
		assertEquals(erro.getMessage(), "Não podem existir mais de 10 funcionarios cadastrados");

	}

	@Test
	void nao_deve_aceitar_data_criacao_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setDataCriacao(null));
		assertEquals("O campo Data de criação da empresa é obrigatorio", erro.getMessage());
	}

	@Test
	void deve_aceitar_data_valida_no_campo_data_criacao() {
		Empresa empresa = new Empresa("Tiago", "67987198000110");
		empresa.setDataCriacao(LocalDate.now());
		assertEquals(empresa.getDataCriacao(), LocalDate.now());

	}

	@Test
	void nao_deve_aceitar_data_criacao_menor_que_data_minima() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setDataCriacao(LocalDate.of(1445, 01, 01)));
		assertEquals("A data não pode ser anterior a 01/01/1446", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_criacao_posterior_que_data_atual() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
				() -> empresa.setDataCriacao(LocalDate.now().plusDays(1)));
		assertEquals("A Data de criação não pode ser posterior ao dia atual.", erro.getMessage());
	}

	@Test
	void nao_deve_aceitar_endereco_nulo() {
		IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> empresa.setEndereco(null));
		assertEquals("O endereço é obrigatorio", erro.getMessage());
	}

	@Test
	void deve_aceitar_endereco_valido() {
		Endereco endereco = new Endereco(11, "03929110", "Casa1");
		Set<Endereco> listaEndereco = new HashSet<>();
		listaEndereco.add(endereco);
		empresa.setEndereco(listaEndereco);
		assertEquals(empresa.getEndereco(), listaEndereco);

	}

	@Test
	void deve_retornar_mesmo_valor_hascode() {
		Empresa empresa2 = new Empresa("Tiago Aciol2e", "67987198000110");
		assertEquals(empresa.hashCode(), empresa2.hashCode());
	}

	@Test
	void deve_retornar_verdadeiro_para_objetos_iguais() {
		assertEquals(empresa, empresa);

	}

	@Test
	void deve_retornar_falso_para_equals_comparado_com_nulo() {
		assertNotEquals(empresa,null);

	}

	@Test
	void deve_retornar_falso_para_equals_com_diferentes_classes() {
		assertNotEquals(empresa, new Endereco(11, "03929110", "Casa1"));
	}

	@Test
	void deve_retornar_verdadeiro_para_objetos_com_o_mesmo_cnpj() {
		Empresa empresa3 = new Empresa("Tiago Aciol2e", "67987198000110");
		assertEquals(empresa, empresa3);
	}

	@Test
	void deve_retornar_razao_social_no_tostring() {
		MatcherAssert.assertThat(empresa.toString(), CoreMatchers.containsString("Tiago Aciole"));
	}

	@Test
	void deve_retornar_endereco_no_toString() {
		Set<Endereco> listaEndereco = new HashSet<>();
		Endereco endereco = new Endereco(11, "03929110", "Casa1");
		listaEndereco.add(endereco);
		empresa.setEndereco(listaEndereco);
		MatcherAssert.assertThat(empresa.toString(), containsString("03929110"));
	}

	@Test
	void deve_retornar_data_criacao_no_toString() {
		empresa.setDataCriacao(LocalDate.of(2025, 02, 07));
		MatcherAssert.assertThat(empresa.toString(), containsString("2025-02-07"));
																					
	}

	@Test
	void deve_retornar_situacao_tributaria_no_tostring() {
		empresa.setSituacaoTributaria("1234567");
		MatcherAssert.assertThat(empresa.toString(), containsString("1234567"));
	}

	@Test
	void deve_retornar_setor_no_tostring() { // teste toString completo
		Set<Setor> listaSetores = new HashSet<>();
		Funcionario funcionario = new Funcionario("Tiago", "97973956000");
		Funcionario funcionario2 = new Funcionario("Tiago", "97801038053");
		Setor setor = new Setor("ADM1", funcionario);
		Setor setor2 = new Setor("PETECA", funcionario2);
		listaSetores.add(setor);
		listaSetores.add(setor2);
		listaSetores.add(setor);
		listaSetores.add(setor2);
		empresa.setSetores(listaSetores);
		System.out.println(empresa.toString());
		assertEquals("Empresa [razaoSocial=Tiago Aciole, cnpj=67987198000110, endereco=null, dataCriacao=null, situacaoTributaria=null, setores=[Setor [nome=ADM1, chefe=Funcionario [nome=Tiago, endereco=null, salario=null, cpf=97973956000, telefone=null, email=null], funcionarios=null], Setor [nome=PETECA, chefe=Funcionario [nome=Tiago, endereco=null, salario=null, cpf=97801038053, telefone=null, email=null], funcionarios=null]], funcionarios=null, inscricaoEstadual=nullAuditoria [nomeCriador=null, nomeEditor=null, dataHoraCriacao=null, dataHoraAlteracao=null]]", empresa.toString());
	}

	@Test
	void deve_retornar_funcionarios_no_tostring() {
		Funcionario funcionario = new Funcionario("Tiago", "97973956000");
		Set<Funcionario> listaFuncionario = new HashSet<>();
		listaFuncionario.add(funcionario);
		empresa.setFuncionarios(listaFuncionario);
		MatcherAssert.assertThat(empresa.toString(), containsString("Tiago"));
	}

	@Test
	void deve_retornar_inscricao_estadual_no_toString() {
		empresa.setInscricaoEstadual("1234567");
		MatcherAssert.assertThat(empresa.toString(), containsString("1234567"));
	}
}
