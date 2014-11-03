package br.com.caelum.argentum.ws;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class ClienteWebServiceHttpClientTest {

	@Test
	public void deveriaAcessarOWebService() throws Exception {
		ClienteWebServiceHttpClient ws = new ClienteWebServiceHttpClient();
		
		List<Negociacao> negociacoes = ws.getNegociacoes();
		
		assertTrue(negociacoes.size() > 0);
	}
}
