package br.com.caelum.argentum.indicadores;

public class MediaMovelSimples implements Indicador {

	private Indicador outroIndicador;

	public MediaMovelSimples(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
	}
	
	@Override
	public double calcula(int dia, SerieTemporal serieTemporal) {
		double soma = 0; 
		for (int i = dia; i > dia - 3 ; i--) {
			soma += outroIndicador.calcula(i, serieTemporal);
		}
		return soma / 3;
	}
	
	@Override
	public String toString() {
		return "MMS - Fechamento";
	}
	
}
