package br.com.abstracts;

import br.com.interfaces.IConta;
import br.com.model.Cliente;

public abstract class Conta implements IConta{
	
	private int agencia;
	private int numero;
	private double saldo;
	private String tipoConta;
	private Cliente cliente;
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
		
	//Constructor
		public Conta(Cliente cliente) {
			this.setAgencia(this.AGENCIA_PADRAO);
			this.setNumero(this.SEQUENCIAL++);
			this.setCliente(cliente);
		}
		
	//Getters
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public String getTipoConta() {
		return this.tipoConta;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	//Setters
	
	public void setAgencia(int agencia) {
		if(agencia > 0) {
			this.agencia = agencia;
		}else{
			throw new RuntimeException("Agência deve ser maior que 0");
		}
	}
	
	public void setNumero(int numero) {
		if(numero > 0) {
			this.numero = numero;
		}else{
			throw new RuntimeException("Número deve ser maior que 0");
		}
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void setTipoConta(String tipoConta) {
		if(!tipoConta.isEmpty()) {
			this.tipoConta = tipoConta;
		}else{
			throw new RuntimeException("Tipo conta não pode ser vázio");
		}
	}
	
	public void setCliente(Cliente cliente) {
		if(cliente != null) {
			this.cliente = cliente;
		}else {
			throw new RuntimeException("Cliente não pode ser nulo!");
		}
	}
	
	//toString
	@Override
	public String toString() {
		return "tipo: " + this.tipoConta + "\n"+
			   "Titular: " + this.getCliente();
	}
	
	@Override
	public void sacar(double valor) {
		this.setSaldo(this.getSaldo() - valor);
		
	}

	@Override
	public void depositar(double valor) {
		this.setSaldo(this.getSaldo() + valor);
		
	}

	@Override
	public void transferir(Conta contaDestino, double valor) {
		if(valor <= this.getSaldo()) {
			this.sacar(valor);
			contaDestino.depositar(valor);
		}
	}
	
	@Override
	public void extrato() {
		System.out.println("===== EXTRATO =====");
		System.out.println(String.format("Agência: %d", this.getAgencia()));
		System.out.println(String.format("Número: %d", this.getNumero()));
		System.out.println(String.format("Tipo: %s", this.getTipoConta()));
		System.out.println(String.format("Saldo: %.2f", this.getSaldo()));
		System.out.println(String.format("Cliente: %s", this.getCliente()));
		System.out.println("===================");
	}
}	

