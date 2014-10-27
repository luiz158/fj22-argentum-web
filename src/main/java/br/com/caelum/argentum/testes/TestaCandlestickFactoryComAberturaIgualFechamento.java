package br.com.caelum.argentum.testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestickFactoryComAberturaIgualFechamento {

	public static void main(String[] args) {
		Calendar dataDeHoje = Calendar.getInstance();
		
		List<Negociacao> negociacoes = new ArrayList<Negociacao>();
		negociacoes.add(new Negociacao(100, 2, dataDeHoje));
		negociacoes.add(new Negociacao(100, 3, dataDeHoje));
		
		Candle candlestick = new CandleFactory().constroiCandleParaData(dataDeHoje, negociacoes);
		
		System.out.println(candlestick);
	}
}
