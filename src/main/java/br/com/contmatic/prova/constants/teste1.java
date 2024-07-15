package br.com.contmatic.prova.constants;

import br.com.contmatic.prova.model.empresa.Funcionario;

public class teste1 {
	
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario ("Teste","91555873057");
		Funcionario funcionario2 = new Funcionario ("Teste","19819667062");
		
	
		System.out.println(funcionario.hashCode());
		System.out.println(funcionario2.hashCode());
	}

}
