package br.com.model;

import br.com.abstracts.Conta;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente){
		super(cliente);
		super.setTipoConta("Conta Corrente");
	}
	
}
