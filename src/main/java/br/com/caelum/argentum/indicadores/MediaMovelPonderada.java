package br.com.caelum.argentum.indicadores;

public class MediaMovelPonderada implements Indicador {

	@Override
	public double calcula(int dia, SerieTemporal serieTemporal) {
		double soma = 0;
		int mult = 3;
		for (int i = dia; i > dia - 3; i--) {
			soma += serieTemporal.getCandle(i).getFechamento() * mult;
			mult--;
		}
		System.out.println(soma);
		return soma / 6;
	}

	@Override
	public String toString() {
		return "MMP - Fechamento";
	}
	
}
