package br.com.caelum.argentum.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.caelum.argentum.infra.LeitorDeXml;
import br.com.caelum.argentum.modelo.Negociacao;

public class ClienteWebService {

	private static final String URL_WEB_SERVICE = "http://argentumws.caelum.com.br/negociacoes";
	
	public List<Negociacao> getNegociacoes() {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(URL_WEB_SERVICE);
			connection = (HttpURLConnection) url.openConnection();
			InputStream xmlFromWebService = connection.getInputStream();
			List<Negociacao> negociacoes = new LeitorDeXml().fromXml(xmlFromWebService);
			return negociacoes;
		} catch (MalformedURLException e) {
			throw new RuntimeException("Ocorreu um erro no caminho do WebService", e);
		} catch (IOException e) {
			throw new RuntimeException("Ocorreu um erro na chamada do WebService", e);
		} finally {
			connection.disconnect();
		}
	}
	
	public static void main(String[] args) {
		List<Negociacao> negociacoes = new ClienteWebService().getNegociacoes();
		System.out.println(negociacoes);
	}
	
}
