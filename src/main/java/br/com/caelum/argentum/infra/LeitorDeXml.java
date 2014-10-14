package br.com.caelum.argentum.infra;

import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.caelum.argentum.modelo.Negociacao;

public class LeitorDeXml {

	@SuppressWarnings("unchecked")
	public List<Negociacao> fromXml(InputStream xml) {
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("negociacao", Negociacao.class);
		List<Negociacao> negociacoes = (List<Negociacao>) xStream.fromXML(xml);
		return negociacoes;
	}

}
