package br.com.contmatic.prova.model.auditoria;

import java.time.LocalDateTime;

public class Auditoria {
	
	private String nomeCriador;
	private String nomeEditor;
	private LocalDateTime dataHoraCriacao;
	private LocalDateTime dataHoraAlteracao;
	
	public String getNomeCriador() {
		return nomeCriador;
	}
	public void setNomeCriador(String nomeCriador) {
		this.nomeCriador = nomeCriador;
	}
	public String getNomeEditor() {
		return nomeEditor;
	}
	public void setNomeEditor(String nomeEditor) {
		this.nomeEditor = nomeEditor;
	}
	public LocalDateTime getDataHoraCriacao() {
		return dataHoraCriacao;
	}
	public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}
	public LocalDateTime getDataHoraAlteracao() {
		return dataHoraAlteracao;
	}
	public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
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
