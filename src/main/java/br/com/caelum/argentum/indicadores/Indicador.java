package br.com.caelum.argentum.indicadores;

public interface Indicador {

	public abstract double calcula(int dia, SerieTemporal serieTemporal);

}