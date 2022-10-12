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
	@Column
	private String usuario;
	@Column
	private String senha;
	
	public UsuarioModel() {
		
	}
	
	public UsuarioModel(Long i_usuario, Integer i_databases, String usuario, String senha) {
		super();
		this.i_usuario = i_usuario;
		this.i_databases = i_databases;
		this.usuario = usuario;
		this.senha = senha;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioModel [i_usuario=" + i_usuario + ", i_databases=" + i_databases + ", usuario=" + usuario
				+ ", senha=" + senha + "]";
	}
	
}
