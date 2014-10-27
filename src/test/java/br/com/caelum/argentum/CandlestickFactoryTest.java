package br.com.caelum.argentum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class CandlestickFactoryTest {

	@Test
	public void sequenciaSimplesDeNegociacoes() throws Exception {
		Calendar hoje = Calendar.getInstance();
		
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
				negociacao3, negociacao4);
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candle candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(42.3, candle.getFechamento(), 0.00001);
		Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);
	}
	
	@Test
	public void semNegociacoesGeraCandleComZeros() throws Exception {
		Calendar hoje = Calendar.getInstance();
		
		List<Negociacao> negociacoes = new ArrayList<Negociacao>();
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candle candlestick = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		Assert.assertEquals(0.0, candlestick.getVolume(), 0);
		Assert.assertEquals(0.0, candlestick.getAbertura(), 0);
		Assert.assertEquals(0.0, candlestick.getFechamento(), 0);
		Assert.assertEquals(0.0, candlestick.getMaximo(), 0);
		Assert.assertEquals(0.0, candlestick.getMinimo(), 0);
	}

	@Test
	public void apenasUmaNegociacaoGeraCandleComValoresIguais() {
		Calendar hoje = Calendar.getInstance();
		
		List<Negociacao> negociacoes = new ArrayList<Negociacao>();
		negociacoes.add(new Negociacao(100, 2, hoje));
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candle candlestick = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		Assert.assertEquals(100.0, candlestick.getAbertura(), 0);
		Assert.assertEquals(100.0, candlestick.getFechamento(), 0);
		Assert.assertEquals(100.0, candlestick.getMinimo(), 0);
		Assert.assertEquals(100.0, candlestick.getMaximo(), 0);
		Assert.assertEquals(200.0, candlestick.getVolume(), 0);
	}
	
	@Test
	public void paraNegociacoesDeTresDiasDistintosGeraTresCandles() throws Exception {
		Calendar ontem = new GregorianCalendar(2014, 10, 7);
		Calendar hoje = new GregorianCalendar(2014, 10, 8);
		Calendar amanha = new GregorianCalendar(2014, 10, 9);
		
		List<Negociacao> negociacoes = Arrays.asList(new Negociacao(100, 1, ontem), new Negociacao(120, 2, hoje), new Negociacao(150, 2, amanha));
		
		CandlestickFactory factory = new CandlestickFactory();
		List<Candle> candles = factory.constroidCandles(negociacoes);
		
		Assert.assertEquals(3, candles.size());
		Assert.assertEquals(100, candles.get(0).getAbertura(), 0);
		Assert.assertEquals(120, candles.get(1).getAbertura(), 0);
		Assert.assertEquals(150, candles.get(2).getAbertura(), 0);
	}
	
	@Test
	public void paraQuatroNegociacoesDeDoisDiasDistintosGeraDoisCandles() throws Exception {
		Calendar ontem = new GregorianCalendar(2014, 9, 7); 
		Calendar hoje = new GregorianCalendar(2014, 9, 8);
		
		List<Negociacao> negociacoes = new ArrayList<Negociacao>();
		negociacoes.add(new Negociacao(100, 1, ontem));
		negociacoes.add(new Negociacao(200, 1, ontem));
		negociacoes.add(new Negociacao(300, 1, hoje));
		negociacoes.add(new Negociacao(400, 1, hoje));
		
		CandlestickFactory factory = new CandlestickFactory();
		List<Candle> candles = factory.constroidCandles(negociacoes);
		
		Assert.assertEquals(2, candles.size());
		Assert.assertEquals(100, candles.get(0).getAbertura(), 0);
		Assert.assertEquals(200, candles.get(0).getFechamento(), 0);
		Assert.assertEquals(300, candles.get(1).getAbertura(), 0);
		Assert.assertEquals(400, candles.get(1).getFechamento(), 0);
	}
	
}
