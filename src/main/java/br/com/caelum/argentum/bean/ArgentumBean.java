package br.com.caelum.argentum.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@RequestScoped
public class ArgentumBean {

	private List<Negociacao> negociacoes;
	
	public ArgentumBean() {
		this.negociacoes = new ClienteWebService().getNegociacoes();
	}
	
	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}
}
