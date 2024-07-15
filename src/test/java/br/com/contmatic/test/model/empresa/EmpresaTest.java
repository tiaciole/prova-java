package br.com.contmatic.test.model.empresa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.model.empresa.Empresa;

class EmpresaTest {

	@Test
	void deve_aceitar_cnpj_valido() {
		Empresa empresa = new Empresa("Empresa Tiago", "67987198000110");
		Assertions.assertEquals(empresa.getCnpj(), "67987198000110");

	}

	@Test
	void deve_aceitar_inscricao_estadual_valido() {
		Empresa empresa = new Empresa("Empresa Tiago", "67987198000110");
		//empresa.setInscricaoEstadual();
		Assertions.assertEquals(empresa.getInscricaoEstadual(), "1234567890");
	}
}
