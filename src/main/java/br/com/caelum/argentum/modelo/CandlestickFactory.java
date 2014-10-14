package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {
		double minimo = negociacoes.isEmpty() ? 0: negociacoes.get(0).getPreco();
		double maximo = negociacoes.isEmpty() ? 0: negociacoes.get(0).getPreco();
		
		double volume = 0;
		for (Negociacao negociacao: negociacoes) {
			volume += negociacao.getVolume();
			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			} 
			if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
		}
		double abertura = negociacoes.isEmpty() ? 0: negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0: negociacoes.get(negociacoes.size() - 1).getPreco();
		
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}

	public List<Candlestick> constroidCandles(List<Negociacao> negociacoes) {
		List<Candlestick> candles = new ArrayList<Candlestick>();

		Calendar data = negociacoes.get(0).getData();
		List<Negociacao> negociacoesMesmoDia = new ArrayList<Negociacao>();
		for (Negociacao negociacao: negociacoes) {
			if (!negociacao.isMesmoDia(data)) {
				candles.add(this.constroiCandleParaData(data, negociacoesMesmoDia));
				data = negociacao.getData();
				negociacoesMesmoDia = new ArrayList<Negociacao>();
			}
			negociacoesMesmoDia.add(negociacao);
		}
		candles.add(this.constroiCandleParaData(data, negociacoesMesmoDia));
		return candles;
	}
}
