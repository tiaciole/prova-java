package br.com.contmatic.prova.utils.constants;

import br.com.contmatic.prova.model.empresa.Empresa;
import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.model.endereco.Cidade;
import br.com.contmatic.prova.model.endereco.Endereco;
import br.com.contmatic.prova.model.endereco.Estado;

public class teste1 {
	
	public static void main(String[] args) {
		//Funcionario funcionario = new Funcionario ("Teste","91555873057");
		Empresa empresa = new Empresa("Teste1", "67987198000110");
//		empresa.setNomeCriador("Tiago");
//		empresa.setDataHoraCriacao(ZonedDateTime.now());
//		Set<Funcionario> listaFuncionarios = new HashSet<>();
//		listaFuncionarios.add(funcionario);
//		empresa.setFuncionarios(listaFuncionarios);
//	
		System.out.println(empresa.toString());
		
		Funcionario funcionario = new Funcionario("Tiago", "32594649805");
		Estado estado = new Estado("sp");
		estado.setNome("tocantins");
		Cidade cidade = new Cidade("Nome cidade", estado);
		
		Endereco endereco = new Endereco(26, "03929110", "Casa1");
		endereco.setLogradouro("Teste endereço");
		endereco.setBairro("Bairro");
		endereco.setCidade(cidade);
		funcionario.setEndereco(endereco);
	
		System.out.println(funcionario);
	}

}
