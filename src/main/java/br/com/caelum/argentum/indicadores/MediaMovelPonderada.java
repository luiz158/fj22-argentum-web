package br.com.caelum.argentum.indicadores;

public class MediaMovelPonderada implements Indicador {

	private Indicador outroIndicador;

	public MediaMovelPonderada(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
	}
	
	@Override
	public double calcula(int dia, SerieTemporal serieTemporal) {
		double soma = 0;
		int mult = 3;
		for (int i = dia; i > dia - 3; i--) {
			soma += outroIndicador.calcula(i, serieTemporal) * mult;
			mult--;
		}
		return soma / 6;
	}

	@Override
	public String toString() {
		return "MMP - Fechamento";
	}
	
}
