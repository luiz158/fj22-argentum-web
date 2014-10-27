package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.Candlestick;

public class MediaMovelSimples {

	public double calcula(int dia, SerieTemporal serieTemporal) {
		double soma = 0; 
		for (int i = dia; i > dia - 3 ; i--) {
			Candlestick candle = serieTemporal.getCandle(i);
			soma += candle.getFechamento();
		}
		return soma / 3;
	}
	
}
