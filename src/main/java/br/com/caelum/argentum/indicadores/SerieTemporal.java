package br.com.caelum.argentum.indicadores;

import java.util.List;

import br.com.caelum.argentum.modelo.Candle;

public class SerieTemporal {

	private List<Candle> candles;

	public SerieTemporal(List<Candle> candles) {
		this.candles = candles;
	}

	public Candle getCandle(int posicao) {
		return this.candles.get(posicao);
	}

	public int getUltimaPosicao() {
		return this.candles.size() - 1;
	}

}
