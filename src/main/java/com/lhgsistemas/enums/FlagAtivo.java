package com.lhgsistemas.enums;

import com.fasterxml.jackson.annotation.JsonValue;


public enum FlagAtivo {
	
	ATIVO("S"), 
	DESATIVO("N");
	@JsonValue
	private final String valor;

	
	private FlagAtivo(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
	
	public static FlagAtivo valueof(String valor) {
		for(FlagAtivo value : FlagAtivo.values()) {
			if(value.getValor() == valor) {
				return value;
			}
		}
		throw new IllegalArgumentException("Este valor não é o esperado para o campo 'ATIVO'");
	}

}
