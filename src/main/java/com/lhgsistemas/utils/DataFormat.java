package com.lhgsistemas.utils;
import java.time.LocalDateTime;


public class DataFormat {
	
	public static String FormatarDataBrasileira(LocalDateTime data) {
		data = LocalDateTime.now();
		String dataString = data.toString();
		String[] result = dataString.split("-");
		String valorFinal = result[2].substring(0,2) +"-"+ result[1] +"-"+ result[0];
		
		return valorFinal;

	}
	

}

