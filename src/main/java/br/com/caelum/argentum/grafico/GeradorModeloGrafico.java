package br.com.caelum.argentum.grafico;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.indicadores.SerieTemporal;

public class GeradorModeloGrafico {

	private SerieTemporal serieTemporal;
	private int inicio;
	private int fim;
	private CartesianChartModel modeloGrafico = new CartesianChartModel();

	public GeradorModeloGrafico(SerieTemporal serieTemporal, int inicio, int fim) {
		this.serieTemporal = serieTemporal;
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public void plotaMediaMovelSimples() {
		MediaMovelSimples mms = new MediaMovelSimples();
		ChartSeries chartSeries = new LineChartSeries("MMS - Fechamento");
		for (int i = inicio; i <= fim; i++) {
			chartSeries.set(i, mms.calcula(i, serieTemporal));
		}
		this.modeloGrafico.addSeries(chartSeries);
	}
	
	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}
	
}
