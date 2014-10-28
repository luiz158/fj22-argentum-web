package br.com.caelum.argentum.indicadores;

public class IndicadorAbertura implements Indicador {

	@Override
	public double calcula(int dia, SerieTemporal serieTemporal) {
		return serieTemporal.getCandle(dia).getAbertura();
	}
	
	@Override
	public String toString() {
		return "Abertura";
	}

}
