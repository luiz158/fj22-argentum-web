package br.com.caelum.argentum.indicadores;

import java.lang.reflect.Constructor;

public class IndicadorFactory {

	private String nomeMedia;
	private String nomeIndicador;

	public IndicadorFactory(String nomeMedia, String nomeIndicador) {
		this.nomeMedia = nomeMedia;
		this.nomeIndicador = nomeIndicador;
	}

	public Indicador criaIndicador() {
		if (nomeMedia == null || nomeIndicador == null) {
			return new MediaMovelSimples(new IndicadorFechamento());
		}
		String pacote = "br.com.caelum.argentum.indicadores.";
		try {
			Class<?> indicadorBase = Class.forName(pacote + nomeIndicador);
			Indicador indicador = (Indicador) indicadorBase.newInstance();
			
			Class<?> indicadorMedia = Class.forName(pacote + nomeMedia);
			Constructor<?> construtor = indicadorMedia.getConstructor(Indicador.class);
			Indicador media = (Indicador) construtor.newInstance(indicador);
			return media;
		} catch (Exception e) {
			throw new RuntimeException("Erro ao tentar fazer a instanciacao do indicador", e);
		}
	}
	
	

}
