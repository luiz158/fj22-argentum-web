package br.com.caelum.argentum.indicadores;

public class IndicadorFechamento implements Indicador {

	@Override
	public double calcula(int dia, SerieTemporal serieTemporal) {
		return serieTemporal.getCandle(dia).getFechamento();
	}
	
	@Override
	public String toString() {
		return "Fechamento";
	}

}
