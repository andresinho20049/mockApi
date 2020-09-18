package com.andre.mockapi.models;

import java.io.Serializable;

public class Transacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String descricao;
	private Long data;
	private Integer valor;
	private Boolean duplicated;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getData() {
		return data;
	}

	public void setData(Long data) {
		this.data = data;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Boolean getDuplicated() {
		return duplicated;
	}

	public void setDuplicated(Boolean duplicated) {
		this.duplicated = duplicated;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transacao [descricao=");
		builder.append(descricao);
		builder.append(", data=");
		builder.append(data);
		builder.append(", valor=");
		builder.append(valor);
		builder.append(", duplicated=");
		builder.append(duplicated);
		builder.append("]");
		return builder.toString();
	}

}
