package br.com.contmatic.prova.utils.constants;

public final class EmpresaConstantes {
	
	private EmpresaConstantes (){
		
	}
	
	public static final String REGEX_EMAIL = "^[A-z0-9.!#$%&'+/=?^_`{|}~-]+@[A-z0-9](?:[A-z0-9-]{0,61}[A-z0-9])?(?:\\.[A-z0-9](?:[A-z0-9-]{0,61}[A-z0-9])?)$";
	
	public static final String O_CAMPO_NOME_DO_ESTADO_E_OBRIGATORIO = "O campo Nome é obrigatório";
	
	public static final String A_INSCRICAO_ESTADUAL_NAO_PODE_SER_NULA = "A inscrição estadual nao pode ser nula";
	
	public static final String A_INSCRICAO_ESTADUAL_NAO_PODE_SER_VAZIA = "A inscrição estadual nao pode ser vazia";
	
	public static final String INSCRICAO_ESTUDAL_DEVE_TER_MINIMO_5_CARACTERES = "O Campo Inscrição Estadual deve conter o minimo de 5 caracteres";
	
	public static final String INSCRICAO_ESTUDAL_DEVE_TER_MAXIMO_10_CARACTERES = "campo Inscrição Estadual deve ter o tamanho máximo de 10 caracteres";
	
	public static final String INSCRICAO_ESTADUAL_DEVE_TER_APENAS_NUMERO = "O campo Inscrição Estadual deve ser apenas números";
	
	public static final String INSCRICAO_ESTADUAL_NAO_DEVE_TER_APENAS_CARACTERES_REPETIDOS = "Iscrição estadual nao deve ter apenas caracteres repetidos";
	
	public static final String A_SITUACAO_TRIBUTARIA_NAO_DEVE_SER_NULA =  "A Situação Tributaria não deve ser nula";
	
	public static final String A_SITUACAO_TRIBUTARIA_NAO_PODE_SER_VAZIA = "O campo Situação Tributaria não pode contes espaços em branco";
	
	public static final String A_SITUACAO_TRIBUTARIA_DEVE_TER_NO_MININO_5_CARACTERES = "O Campo Situação Tributaria deve conter o minimo de 5 caracteres";
	
	public static final String A_SITUACAO_TRIBUTARIA_DEVE_TER_NO_MAXIMO_10_CARACTERES =  "O campo Situação Tributaria deve ter o tamanho máximo de 10 caracteres";
	
	public static final String A_SITUACAO_TRIBUTARIA_DEVE_TER_APENAS_NUMEROS = "O campo Situação Tributaria deve ser apenas números";
	
	public static final String A_SITUACAO_TRIBUTARIA_NAO_DEVE_TER_APENAS_CARACTERES_REPETIDOS = "A situação tributaria nao deve ter apenas caraceteres repetidos";
	
	public static final String O_CAMPO_SETOR_NAO_PODE_SER_NULO = "O setor é de preenhimento obrigatorio";
	
	public static final String O_CAMPO_SETOR_NAO_PODE_SER_VAZIO = "Não existem setores cadastrados";
	
	public static final String DEVE_EXISTIR_AO_MENOS_2_SETORES = "Deve existir pelo menos 2 setores cadastrados";
	
	public static final String LIMITE_DA_LISTA_SETORES = "Não é possivel cadastrar mais que 4 setores";
	
	public static final String CAMPOS_CADASTRO_FUNCIONARIOS_OBRIGATORIO = "Os campos do cadastro de Funcionario é de preenchimento obrigatorio";
	
	public static final String LISTA_FUNCIONARIO_VAZIA = "Não existem funcionarios cadastrados";
	
	public static final Integer  TAMANHO_MAXIMO_10 = 10;

	public static final Integer TAMANHO_MINIMO_MINIMO_5 = 5;
	
}
