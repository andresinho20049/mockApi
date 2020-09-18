package com.andre.mockapi.models;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUser;
	private String nome;

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
