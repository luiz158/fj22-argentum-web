package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.Candlestick;

public class MediaMovelPonderada {

	public double calcula(int dia, SerieTemporal serieTemporal) {
		double soma = 0;
		int mult = 3;
		for (int i = dia; i > dia - 3; i--) {
			Candlestick candle = serieTemporal.getCandle(i);
			soma += candle.getFechamento() * mult;
			mult--;
		}
		System.out.println(soma);
		return soma / 6;
	}

}
