package br.com.caelum.argentum.indicadores;

public class IndicadorAbertura implements Indicador {

	@Override
	public double calcula(int posicao, SerieTemporal serieTemporal) {
		return serieTemporal.getCandle(posicao).getAbertura();
	}
	
	@Override
	public String toString() {
		return "Abertura";
	}

}
