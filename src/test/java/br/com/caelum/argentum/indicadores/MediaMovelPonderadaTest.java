package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.*;

import org.junit.Test;

public class MediaMovelPonderadaTest {

	@Test
	public void deveriaCalcularAMediaMovelPonderada() throws Exception {
		SerieTemporal serieTemporal = GeradorDeSeries.gera(1, 6, 3, 4, 7, 5, 3);
		MediaMovelPonderada mmp = new MediaMovelPonderada();

		assertEquals(4, mmp.calcula(3, serieTemporal), 0.00001);
		assertEquals(32.0/6, mmp.calcula(4, serieTemporal), 0.00001);
		assertEquals(22.0/6, mmp.calcula(2, serieTemporal), 0.00001);
	}
	
}
