package br.com.contmatic.prova.model.auditoria;

import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaCaracteresRepetidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaDataAuditoria;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaNulo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaTamanhoMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificaValorVazio;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.CAMPO_DATA_ALTERACAO_INVALIDA;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.CAMPO_DATA_ALTERACAO_OBRIGATORIO;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.CAMPO_DATA_CRIACAO_INVALIDA;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_CRIADOR_COM_MUITOS_CARACTERES_REPETIDOS;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_CRIADOR_DEVE_TER_MAXIMO_10_CARACTERES;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_CRIADOR_DEVE_TER_MINIMO_5_CARACTERES;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_CRIADOR_OBRIGATORIO;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_CRIADOR_SEM_ESPACO_BRANCO;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_EDITOR_COM_MUITOS_CARACTERES_REPETIDOS;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_EDITOR_DEVE_TER_MAXIMO_10_CARACTERES;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_EDITOR_DEVE_TER_MINIMO_5_CARACTERES;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_EDITOR_NAO_PODE_ESPACO_BRANCO;
import static br.com.contmatic.prova.utils.constants.AuditoriaConstantes.NOME_EDITOR_NULO;

import java.time.ZonedDateTime;

import br.com.contmatic.prova.utils.constants.AuditoriaConstantes;

public class Auditoria {
	
	private static final int TAMANHO_MAXIMO_10 = 10;

	private static final int TAMANHO_MINIMO_MINIMO_5 = 5;

	private String nomeCriador;
	
	private String nomeEditor;
	
	private ZonedDateTime dataHoraCriacao;
	
	private ZonedDateTime dataHoraAlteracao;
	
	public Auditoria() {
	}
	
	public String getNomeCriador() {
		return nomeCriador;
	}
	
	public void setNomeCriador(String nomeCriador) {
		verificaNulo(nomeCriador, NOME_CRIADOR_OBRIGATORIO);
		verificaValorVazio(nomeCriador,NOME_CRIADOR_SEM_ESPACO_BRANCO);
		verificaTamanhoMinimo(nomeCriador, TAMANHO_MINIMO_MINIMO_5, NOME_CRIADOR_DEVE_TER_MINIMO_5_CARACTERES);
		verificaTamanhoMaximo(nomeCriador, TAMANHO_MAXIMO_10, NOME_CRIADOR_DEVE_TER_MAXIMO_10_CARACTERES);
		verificaCaracteresRepetidos(nomeCriador, NOME_CRIADOR_COM_MUITOS_CARACTERES_REPETIDOS);
		this.nomeCriador = nomeCriador;
	}
	
	public String getNomeEditor() {
		return nomeEditor;
	}
	
	public void setNomeEditor(String nomeEditor) {
		verificaNulo(nomeEditor, NOME_EDITOR_NULO);
		verificaValorVazio(nomeEditor, NOME_EDITOR_NAO_PODE_ESPACO_BRANCO);
		verificaTamanhoMinimo(nomeEditor, TAMANHO_MINIMO_MINIMO_5,NOME_EDITOR_DEVE_TER_MINIMO_5_CARACTERES);
		verificaTamanhoMaximo(nomeEditor, TAMANHO_MAXIMO_10,NOME_EDITOR_DEVE_TER_MAXIMO_10_CARACTERES );
		verificaCaracteresRepetidos(nomeEditor, NOME_EDITOR_COM_MUITOS_CARACTERES_REPETIDOS);
		this.nomeEditor = nomeEditor;
	}
	
	public ZonedDateTime getDataHoraCriacao() {
		return dataHoraCriacao;
	}
	
	public void setDataHoraCriacao(ZonedDateTime dataHoraCriacao) {
		verificaNulo(dataHoraCriacao, CAMPO_DATA_CRIACAO_INVALIDA);
		verificaDataAuditoria(dataHoraCriacao, AuditoriaConstantes.CAMPO_DATA_CRIACAO_INVALIDA);
		this.dataHoraCriacao = dataHoraCriacao;
	}
	
	public ZonedDateTime getDataHoraAlteracao() {
		return dataHoraAlteracao;
	}
	
	public void setDataHoraAlteracao(ZonedDateTime dataHoraAlteracao) {
		verificaNulo(dataHoraAlteracao, CAMPO_DATA_ALTERACAO_OBRIGATORIO);
		verificaDataAuditoria(dataHoraAlteracao, CAMPO_DATA_ALTERACAO_INVALIDA);
		this.dataHoraAlteracao = dataHoraAlteracao;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Auditoria [nomeCriador=");
		builder.append(nomeCriador);
		builder.append(", nomeEditor=");
		builder.append(nomeEditor);
		builder.append(", dataHoraCriacao=");
		builder.append(dataHoraCriacao);
		builder.append(", dataHoraAlteracao=");
		builder.append(dataHoraAlteracao);
		builder.append("]");
		return builder.toString();
	}
}
