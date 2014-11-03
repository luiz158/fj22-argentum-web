package br.com.caelum.argentum.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.indicadores.IndicadorAbertura;
import br.com.caelum.argentum.indicadores.IndicadorFactory;
import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.MediaMovelPonderada;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.indicadores.SerieTemporal;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@RequestScoped
public class ArgentumBean {

	private List<Negociacao> negociacoes;
	
	private ChartModel modeloGrafico;
	
	private String nomeMedia;
	
	private String nomeIndicador;
	
	public ArgentumBean() {
		this.negociacoes = new ClienteWebService().getNegociacoes();
	}

	private Indicador defineIndicador() {
		IndicadorFactory factory = new IndicadorFactory(nomeMedia, nomeIndicador);
		return factory.criaIndicador();
//		return new MediaMovelPonderada(new IndicadorFechamento());
	}
	
	public void gerarGrafico() {
		List<Candle> candles = new CandleFactory().constroidCandles(negociacoes);
		SerieTemporal serieTemporal = new SerieTemporal(candles);
		
		GeradorModeloGrafico geradorModeloGrafico = new GeradorModeloGrafico(serieTemporal, 2, serieTemporal.getUltimaPosicao());
		geradorModeloGrafico.plotaIndicador(defineIndicador());
		this.modeloGrafico = geradorModeloGrafico.getModeloGrafico();		
//		return geraGraficoDaFormaAntiga();
	}

	@SuppressWarnings("unused")
	private Indicador geraGraficoDaFormaAntiga() {
		if (this.nomeMedia.equals("MediaMovelSimples")) {
			if (this.nomeIndicador.equals("IndicadorAbertura")) {
				return new MediaMovelSimples(new IndicadorAbertura());
			} 
			if (this.nomeIndicador.equals("IndicadorFechamento")) {
				return new MediaMovelSimples(new IndicadorFechamento());
			} 
		} else if (this.nomeMedia.equals("MediaMovelPonderada")) {
			if (this.nomeIndicador.equals("IndicadorAbertura")) {
				return new MediaMovelPonderada(new IndicadorAbertura());
			}
			if (this.nomeIndicador.equals("IndicadorFechamento")) {
				return new MediaMovelPonderada(new IndicadorFechamento());
			}
		}
		return new MediaMovelSimples(new IndicadorFechamento());
	}
	
	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}
	
	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}

	public String getNomeMedia() {
		return nomeMedia;
	}

	public void setNomeMedia(String nomeMedia) {
		this.nomeMedia = nomeMedia;
	}

	public String getNomeIndicador() {
		return nomeIndicador;
	}

	public void setNomeIndicador(String nomeIndicador) {
		this.nomeIndicador = nomeIndicador;
	}
	
}
