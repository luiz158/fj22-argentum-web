package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MediaMovelSimplesTest {

	@Test
	public void deveriaCalcularAMediaMovelSimples() throws Exception {
		SerieTemporal serieTemporal = GeradorDeSeries.gera(1, 2, 3, 4, 3, 5, 5, 1);
		MediaMovelSimples mms = new MediaMovelSimples();
		
		assertEquals(2, mms.calcula(2, serieTemporal), 0000.1);
		assertEquals(3, mms.calcula(3, serieTemporal), 0000.1);
		assertEquals(10.0/3, mms.calcula(4, serieTemporal), 0000.1);
		assertEquals(4, mms.calcula(5, serieTemporal), 0000.1);
	}
	
}
