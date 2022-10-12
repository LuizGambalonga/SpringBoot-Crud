package com.lhgsistemas.exception;

public class EntidadeEmUso extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntidadeEmUso(String mensagem) {
		super(mensagem);
	}
	
}
