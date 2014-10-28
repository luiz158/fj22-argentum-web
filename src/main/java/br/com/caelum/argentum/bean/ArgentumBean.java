package br.com.caelum.argentum.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.MediaMovelPonderada;
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
	
	public ArgentumBean() {
		this.negociacoes = new ClienteWebService().getNegociacoes();
		List<Candle> candles = new CandleFactory().constroidCandles(negociacoes);
		SerieTemporal serieTemporal = new SerieTemporal(candles);
		
		GeradorModeloGrafico geradorModeloGrafico = new GeradorModeloGrafico(serieTemporal, 2, serieTemporal.getUltimaPosicao());
		geradorModeloGrafico.plotaIndicador(new MediaMovelPonderada());
		this.modeloGrafico = geradorModeloGrafico.getModeloGrafico();
	}
	
	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}
	
	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}
	
}
