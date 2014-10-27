package br.com.caelum.argentum.indicadores;

public class MediaMovelSimples {

	public double calcula(int dia, SerieTemporal serieTemporal) {
		double soma = 0; 
		for (int i = dia; i > dia - 3 ; i--) {
			soma += serieTemporal.getCandle(i).getFechamento();
		}
		return soma / 3;
	}
	
}
