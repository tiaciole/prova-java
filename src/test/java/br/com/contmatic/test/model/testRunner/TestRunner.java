package br.com.contmatic.test.model.testRunner;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({ "br.com.contmatic.test.model.auditoria", "br.com.contmatic.test.model.email",
		"br.com.contmatic.test.model.empresa", "br.com.contmatic.test.model.endereco",
		"br.com.contmatic.test.model.telefone" })
class TestRunner {
}
