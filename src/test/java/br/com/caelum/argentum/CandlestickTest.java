package br.com.caelum.argentum;

import java.util.Calendar;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Candle;

public class CandlestickTest {

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveriaCriarUmCandlestickComPrecoMaximoMenorQueOMinimo() throws Exception {
		new Candle(100, 200, 400, 250, 2000, Calendar.getInstance());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveriaCriarUmCandlestickComADataNula() throws Exception {
		new Candle(100, 200, 100, 250, 2000, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveriaCriarUmCandlestickComPrecoDeAberturaNegativo() throws Exception {
		new Candle(-100, 200, 100, 250, 2000, null);
	}
	
}
