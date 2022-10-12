package com.lhgsistemas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lhgsistemas.abstracts.Pessoa;


@Entity
@Table(name = "DATABASES",schema = "lhg_owner")
public class DatabaseModel extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long i_databases;
	
	public DatabaseModel() {
		
	}
	public DatabaseModel(Long i_databases) {
		super();
		this.i_databases = i_databases;
	}

	public Long getI_databases() {
		return i_databases;
	}

	public void setI_databases(Long i_databases) {
		this.i_databases = i_databases;
	}
	
	@Override
	public String toString() {
		return "DatabaseModel [i_databases=" + i_databases + "]";
	}


	
}
