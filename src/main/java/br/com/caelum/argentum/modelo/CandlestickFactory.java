package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {

	public Candle constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {
		double minimo = negociacoes.isEmpty() ? 0: negociacoes.get(0).getPreco();
		double maximo = negociacoes.isEmpty() ? 0: negociacoes.get(0).getPreco();
		
		double volume = 0;
		for (Negociacao negociacao: negociacoes) {
			volume += negociacao.getVolume();
			double preco = negociacao.getPreco();
			if (preco > maximo) {
				maximo = preco;
			} 
			if (preco < minimo) {
				minimo = preco;
			}
		}
		double abertura = negociacoes.isEmpty() ? 0: negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0: negociacoes.get(negociacoes.size() - 1).getPreco();
		
		return new Candle(abertura, fechamento, minimo, maximo, volume, data);
	}

	public List<Candle> constroidCandles(List<Negociacao> negociacoes) {
		List<Candle> candles = new ArrayList<Candle>();

		Calendar data = negociacoes.get(0).getData();
		List<Negociacao> negociacoesMesmoDia = new ArrayList<Negociacao>();
		for (Negociacao negociacao: negociacoes) {
			if (!negociacao.isMesmoDia(data)) {
				criaEGuardaCandle(candles, data, negociacoesMesmoDia);
				data = negociacao.getData();
				negociacoesMesmoDia = new ArrayList<Negociacao>();
			}
			negociacoesMesmoDia.add(negociacao);
		}
		criaEGuardaCandle(candles, data, negociacoesMesmoDia);
		return candles;
	}

	private void criaEGuardaCandle(List<Candle> candles, Calendar data,
			List<Negociacao> negociacoesMesmoDia) {
		candles.add(this.constroiCandleParaData(data, negociacoesMesmoDia));
	}
}
