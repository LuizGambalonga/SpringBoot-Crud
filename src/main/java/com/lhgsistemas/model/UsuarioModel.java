package com.lhgsistemas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.lhgsistemas.abstracts.Pessoa;

@Entity
@Table(name = "USUARIO", schema = "lhg_owner")
public class UsuarioModel extends Pessoa{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long i_usuario;
	
	@Column
	private Integer i_databases;
	
	public UsuarioModel() {
		
	}
	
	public UsuarioModel(Long i_usuario, Integer i_databases) {
		super();
		this.i_usuario = i_usuario;
		this.i_databases = i_databases;
	}

	public Long getI_usuario() {
		return i_usuario;
	}

	public void setI_usuario(Long i_usuario) {
		this.i_usuario = i_usuario;
	}
	
	public Integer getI_databases() {
		return i_databases;
	}

	public void setI_databases(Integer i_databases) {
		this.i_databases = i_databases;
	}

	@Override
	public String toString() {
		return "UsuarioModel [i_usuario=" + i_usuario + ", i_databases=" + i_databases + "]";
	}

	
}
