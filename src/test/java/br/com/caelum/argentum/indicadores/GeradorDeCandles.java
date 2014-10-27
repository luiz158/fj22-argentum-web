package br.com.caelum.argentum.indicadores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;

public class GeradorDeCandles {

	public static SerieTemporal gera(double... valores) {
		List<Candlestick> candles = new ArrayList<Candlestick>();
		for (double valor: valores) {
			candles.add(new Candlestick(valor, valor, valor, valor, 1, Calendar.getInstance()));
		}
		return new SerieTemporal(candles);
	}

}
