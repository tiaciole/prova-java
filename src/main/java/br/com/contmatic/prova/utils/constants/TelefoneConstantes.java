package br.com.contmatic.prova.utils.constants;

public final class TelefoneConstantes {

	private TelefoneConstantes() {
	}

	public static final String MSG_TELEFONE_INVALIDO = "Número de telefone inválido";

	public static final String NUMERO_DDI_NAO_PODE_SER_NULO = "O número do DDI não pode ser nulo";

	public static final String NUMERO_DDI_NAO_PODE_SER_VAZIO = "O número do DDI nao pode ser vazio";

	public static final String NUMERO_DDD_NAO_PODE_SER_NULO = "O número do DDD não pode ser nulo";

	public static final String NUMERO_DDD_NAO_PODE_SER_VAZIO = "O número do DDD nao pode ser vazio";

	public static final String CAMPO_DDD_DEVE_SER_2_CARACTERES = "O campo DDD deve ser 2 caracteres";

	public static final String CAMPO_DDD_DEVE_SER_APENAS_NUMERO = "O campo DDD aceita apenas número";

	public static final String CAMPO_DDI_DEVE_SER_APENAS_NUMERO = "O campo DDI aceita apenas número";

	public static final String CAMPO_DDI_DEVE_SER_3_CARACTERES = "O campo DDI deve ser 3 caracteres";

	public static final String O_CAMPO_TELEFONE_NAO_PODE_SER_NULO = "O campo telefone não pode ser nulo";

	public static final String O_CAMPO_TELEFONE_NAO_PODE_SER_VAZIO = "O campo telefone não pode ser vazio";

	public static final String O_NUMERO_TELEFONE_DEVE_TER_O_MINIMO_DE_8_CARACTERES = "O numero do telefone deve conter no minimo 8 caracteres";

	public static final String O_NUMERO_TELEFONE_DEVE_TER_O_MAXIMO_DE_9_CARACTERES = "O campo telefone deve ter no máximo 9 caracteres";

	public static final String O_NUMERO_DE_TELEFONE_DEVE_CONTER_APENAS_NUMERO = "O Campo Telefone deve conter apenas números";

	public static final String O_TIPO_DE_TELEFONE_NAO_PODE_SER_NULO = "O número do telefone não poder ser nulo";
	
	public static final String O_CAMPO_TIPO_DE_TELEFONE_ACEITA_APENAS_TEXTO = "O Campo tipo aceita apenas texto";

	public static final String O_TIPO_DE_TELEFONE_NAO_PODE_SER_VAZIO = "O número do telefone não pode ser vazio";
	
	public static final String TIPO_TELEFONE_COMERCIAL = "Comercial";

	public static final String REGEX_TELEFONE2 = "^[\\d]{8,10}$";

	public static final String REGEX_TELEFONE = "^[\\d]{8,9}$";

	public static final String REGEX_DDI = "^[\\d]{3}$";

	public static final String REGEX_DDD = "^[\\d]{2}$";
	
	public static final String REGEX_TIPO_TELEFONE_APENAS_LETRA = "^[a-zA-Z]+$";

	public static final Integer TAMANHO_2 = 2;

	public static final Integer TAMANHO_3 = 3;

	public static final Integer TAMANHO_8 = 8;

	public static final Integer TAMANHO_9 = 9;

	public static final Integer TAMANHO_10 = 10;

	public static final Integer TAMANHO_50 = 50;

	public static final Integer TAMANHO_80 = 80;
}
