package br.com.caelum.argentum;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class NegociacaoTest {

	@Test
	public void deveriaRetornarDataDaNegociacaoImutavel() throws Exception {
		Calendar data =  Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, 15);
		
		Negociacao negociacao = new Negociacao(100, 10, data);
		negociacao.getData().set(Calendar.DAY_OF_MONTH, 18);
		
		Assert.assertEquals(15, negociacao.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula()  throws Exception {
		Negociacao negociacao = new Negociacao(100, 2, null);
		
		Assert.assertNotNull(negociacao.getData());
	}

	@Test
	public void mesmoMilissegundoEhDoMesmoDia() throws Exception {
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();
		
		Negociacao negociacao = new Negociacao(100, 50, agora);
		
		Assert.assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}
	
	@Test
	public void comHorariosDiferentesEhNoMesmoDia() throws Exception {
		Calendar primeiraData = new GregorianCalendar(2014, 9, 30, 21, 30);
		Calendar segundaData = new GregorianCalendar(2014, 9, 30, 22, 30);
		
		Negociacao negociacao = new Negociacao(100, 50, primeiraData);
		
		Assert.assertTrue(negociacao.isMesmoDia(segundaData));
	}
	
	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia() throws Exception {
		Calendar primeiraData = new GregorianCalendar(2014, 9, 30);
		Calendar segundaData = new GregorianCalendar(2014, 10, 30);
		
		Negociacao negociacao = new Negociacao(100, 50, primeiraData);
		
		Assert.assertFalse(negociacao.isMesmoDia(segundaData));
	}
	
	@Test
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia() throws Exception {
		Calendar primeiraData = new GregorianCalendar(2014, 9, 30);
		Calendar segundaData = new GregorianCalendar(2013, 9, 30);
		
		Negociacao negociacao = new Negociacao(100, 10, primeiraData);
		
		Assert.assertFalse(negociacao.isMesmoDia(segundaData));
	}
}
