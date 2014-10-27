package br.com.caelum.argentum.indicadores;

import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;

public class SerieTemporal {

	private List<Candlestick> candles;

	public SerieTemporal(List<Candlestick> candles) {
		this.candles = candles;
	}

	public Candlestick getCandle(int posicao) {
		return this.candles.get(posicao);
	}

}
