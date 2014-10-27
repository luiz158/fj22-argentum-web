package br.com.caelum.argentum.indicadores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candle;

public class GeradorDeSeries {

	public static SerieTemporal gera(double... valores) {
		List<Candle> candles = new ArrayList<Candle>();
		for (double valor: valores) {
			candles.add(new Candle(valor, valor, valor, valor, 1, Calendar.getInstance()));
		}
		return new SerieTemporal(candles);
	}

}
