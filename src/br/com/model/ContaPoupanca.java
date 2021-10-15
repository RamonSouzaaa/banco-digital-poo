package br.com.model;

import br.com.abstracts.Conta;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca(Cliente cliente){
		super(cliente);
		super.setTipoConta("Conta Poupança");
	}
}
