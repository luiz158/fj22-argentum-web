package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public final class Candlestick {

	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;
	
	public Candlestick(double abertura, double fechamento, double minimo,
			double maximo, double volume, Calendar data) {
		if (minimo > maximo) {
			throw new IllegalArgumentException("O valor minimo nao pode ser maior que o valor maximo");
		}
		if (data == null) {
			throw new IllegalArgumentException("A data nao pode ser nula");
		}
		if (abertura < 0 || fechamento < 0 || minimo < 0 || maximo < 0 || volume < 0) {
			throw new IllegalArgumentException("Nenhum preco pode ser negativo");
		}
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public double getVolume() {
		return volume;
	}
	
	public boolean isAlta() {
		return this.fechamento > this.abertura;
	}
	
	public boolean isBaixa() {
		return this.fechamento < this.abertura;
	}
	
	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public Calendar getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Candlestick [abertura=" + abertura + ", fechamento="
				+ fechamento + ", minimo=" + minimo + ", maximo=" + maximo
				+ ", volume=" + volume + ", data=" + data.getTime() + "]";
	}

	
}
