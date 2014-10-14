package br.com.caelum.argentum.testes;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.infra.LeitorDeXml;
import br.com.caelum.argentum.modelo.Negociacao;

public class TesteLeitorDeXml {

	@Test
	public void deveriaRetornarUmaListaDeUmaNegociacaoEAtributosCorretos() throws Exception {
		String xmlDeTeste = " <list>" + "    "
							+ "	   <negociacao>"
							+ "        <preco>43.5</preco>"
							+ "        <quantidade>1000</quantidade>" 
							+ "			   <data>"
							+ "                <time>1322233344455</time>" 
							+ " 		   </data>"
							+ "    </negociacao>" 
							+ "</list>";
		
		LeitorDeXml leitorDeXml = new LeitorDeXml();
		List<Negociacao> negociacoes = leitorDeXml.fromXml(new ByteArrayInputStream(xmlDeTeste.getBytes()));
		
		assertEquals(1, negociacoes.size());
		assertEquals(43.5, negociacoes.get(0).getPreco(), 0);
		assertEquals(1000, negociacoes.get(0).getQuantidade());
		Calendar data = Calendar.getInstance();
		data.setTimeInMillis(1322233344455l);
		assertEquals(data, negociacoes.get(0).getData());
	}
	
	@Test
	public void deveriaRetornarUmaListaDeDuasNegociacoes() throws Exception {
		String xmlDeTeste = " <list>" + "    "
							+ "	   <negociacao>"
							+ "        <preco>43.5</preco>"
							+ "        <quantidade>1000</quantidade>" 
							+ "			   <data>"
							+ "                <time>1322233344455</time>" 
							+ " 		   </data>"
							+ "    </negociacao>" 
							+ "	   <negociacao>"
							+ "        <preco>43.5</preco>"
							+ "        <quantidade>1000</quantidade>" 
							+ "			   <data>"
							+ "                <time>1322233344455</time>" 
							+ " 		   </data>"
							+ "    </negociacao>" 
							+ "</list>";
		
		LeitorDeXml leitorDeXml = new LeitorDeXml();
		List<Negociacao> negociacoes = leitorDeXml.fromXml(new ByteArrayInputStream(xmlDeTeste.getBytes()));
		
		assertEquals(2, negociacoes.size());
	}
	
}
