package br.com.caelum.argentum.ws;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

import br.com.caelum.argentum.infra.LeitorDeXml;
import br.com.caelum.argentum.modelo.Negociacao;

public class ClienteWebServiceHttpClient {

	private static final String WS_ADDRESS = "http://argentumws.caelum.com.br/negociacoes";
	
	public List<Negociacao> getNegociacoes() throws ClientProtocolException, IOException {
		Content content = Request.Get(WS_ADDRESS).execute().returnContent();
		InputStream inputStream = content.asStream();
		
		return new LeitorDeXml().fromXml(inputStream);
	}

}
