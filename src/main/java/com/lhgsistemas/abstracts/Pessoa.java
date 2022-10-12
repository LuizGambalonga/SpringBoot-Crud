package com.lhgsistemas.abstracts;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import com.lhgsistemas.enums.FlagAtivo;

@MappedSuperclass
public abstract class Pessoa {
	@Column(name = "nome")
	private String nome;
	@Column(name = "email")
	private String email;
	@Column(name = "contato")
	private String contato;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "cnpj")
	private String cnpj;
	@Column(name = "aud_dh_criacao")
	private LocalDateTime aud_dh_criacao;
	@Column(name = "aud_dh_alterado_por")
	private LocalDateTime aud_dh_alterado_por;
	@Column(name = "aud_dh_alteracao")
	private LocalDateTime aud_dh_alteracao;
	@Column(name = "ativo")
	private String ativo;
	
	public Pessoa() {
		
	}
	public Pessoa(String nome, String email, String contato, String cpf, String cnpj, LocalDateTime aud_dh_criacao,
			LocalDateTime aud_dh_alterado_por, LocalDateTime aud_dh_alteracao, FlagAtivo ativo) {
		super();
		this.nome = nome;
		this.email = email;
		this.contato = contato;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.aud_dh_criacao = aud_dh_criacao;
		this.aud_dh_alterado_por = aud_dh_alterado_por;
		this.aud_dh_alteracao = aud_dh_alteracao;
		setAtivo(ativo);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public LocalDateTime getAud_dh_criacao() {
		return aud_dh_criacao;
	}
	public void setAud_dh_criacao(LocalDateTime aud_dh_criacao) {
		this.aud_dh_criacao = aud_dh_criacao;
	}
	public LocalDateTime getAud_dh_alterado() {
		return aud_dh_alterado_por;
	}
	public void setAud_dh_alterado(LocalDateTime aud_dh_alterado_por) {
		this.aud_dh_alterado_por = aud_dh_alterado_por;
	}
	public LocalDateTime getAud_dh_alteracao() {
		return aud_dh_alteracao;
	}
	public void setAud_dh_alteracao(LocalDateTime aud_dh_alteracao) {
		this.aud_dh_alteracao = aud_dh_alteracao;
	}
	
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(FlagAtivo ativo) {
		if (ativo !=null){
			this.ativo = ativo.getValor();
		}
	}
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", email=" + email + ", contato=" + contato + ", cpf=" + cpf + ", cnpj=" + cnpj
				+ ", aud_dh_criacao=" + aud_dh_criacao + ", aud_dh_alterado_por=" + aud_dh_alterado_por + ", aud_dh_alteracao="
				+ aud_dh_alteracao + ", ativo=" + ativo + "]";
	}
	
	
	
}
