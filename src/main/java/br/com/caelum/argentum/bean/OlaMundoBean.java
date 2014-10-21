package br.com.caelum.argentum.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {

	private String mensagem = "Ola Mundo!";
	
	private String nome;
	
	public String getMensagem() {
		return mensagem;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void mudaNome() {
		System.out.println("Muda Nome");
	}
	
}
