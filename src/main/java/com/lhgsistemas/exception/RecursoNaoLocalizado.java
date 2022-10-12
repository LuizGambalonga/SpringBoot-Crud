package com.lhgsistemas.exception;

public class RecursoNaoLocalizado extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RecursoNaoLocalizado(String mensagem) {
		super(mensagem);
	}
	
}
