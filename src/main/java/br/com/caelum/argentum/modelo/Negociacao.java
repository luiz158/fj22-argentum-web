package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public class Negociacao {

	private final double preco;
	
	private final int quantidade;
	
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {
		if (data == null) {
			throw new IllegalArgumentException("Data nao pode ser nula");
		}
		this.data = data;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public double getVolume() {
		return this.quantidade * this.preco;
	}
	
	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
//		Fazer isso na mao com o pessoal
//		Calendar data = Calendar.getInstance();
//		data.setTime(this.data.getTime());
		return (Calendar) this.data.clone();
	}

	public boolean isMesmoDia(Calendar dataComparada) {
		return (this.data.get(Calendar.DAY_OF_MONTH) == dataComparada.get(Calendar.DAY_OF_MONTH) &&
				this.data.get(Calendar.MONTH) == dataComparada.get(Calendar.MONTH)) &&
				this.data.get(Calendar.YEAR) == dataComparada.get(Calendar.YEAR);
	}

	@Override
	public String toString() {
		return "Negociacao [preco=" + preco + ", quantidade=" + quantidade
				+ "]";
	}

}
