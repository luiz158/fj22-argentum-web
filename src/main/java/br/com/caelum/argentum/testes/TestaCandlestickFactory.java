package br.com.caelum.argentum.testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestickFactory {

	public static void main(String[] args) {
		Calendar dataDeHoje = Calendar.getInstance();
		
		List<Negociacao> negociacoes = new ArrayList<Negociacao>();
		negociacoes.add(new Negociacao(100, 2, dataDeHoje));
		negociacoes.add(new Negociacao(800, 3, dataDeHoje));
		negociacoes.add(new Negociacao(900, 5, dataDeHoje));
		negociacoes.add(new Negociacao(300, 3, dataDeHoje));
		
		Candle candlestick = new CandlestickFactory().constroiCandleParaData(dataDeHoje, negociacoes);
		
		System.out.println(candlestick.getMinimo());
		System.out.println(candlestick.getMaximo());
		System.out.println(candlestick.getAbertura());
		System.out.println(candlestick.getFechamento());
		System.out.println(candlestick.getVolume());
	}
}
