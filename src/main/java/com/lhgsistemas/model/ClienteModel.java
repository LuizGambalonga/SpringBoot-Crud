package com.lhgsistemas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.lhgsistemas.abstracts.Pessoa;

@Entity
@Table(name = "CLIENTE", schema = "lhg_owner")
public class ClienteModel extends Pessoa{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long i_clientes;
	
	@Column
	private Long i_databases;
	@Column
	private Long i_usuario;
	
	public ClienteModel() {
		
	}

	public ClienteModel(Long i_clientes, Long i_databases, Long i_usuario) {
		super();
		this.i_clientes = i_clientes;
		this.i_databases = i_databases;
		this.i_usuario = i_usuario;
	}

	



	public Long getI_clientes() {
		return i_clientes;
	}

	public void setI_clientes(Long i_clientes) {
		this.i_clientes = i_clientes;
	}

	public Long getI_databases() {
		return i_databases;
	}

	public void setI_databases(Long i_databases) {
		this.i_databases = i_databases;
	}

	public Long getI_usuario() {
		return i_usuario;
	}

	public void setI_usuario(Long i_usuario) {
		this.i_usuario = i_usuario;
	}

	@Override
	public String toString() {
		return "ClienteModel [i_clientes=" + i_clientes + ", i_databases=" + i_databases + ", i_usuario=" + i_usuario
				+ "]";
	}
	


	
}
