package br.com.model;

import java.util.*;

import br.com.abstracts.Conta;

public class Banco {
	
	private String nome;
	private List<Conta> listaContas;
	
	//Constructor
	public Banco() {}
	
	public Banco(String nome) {
		this.setNome(nome);
	}
	
	//Getters
	public String getNome() {
		return this.nome;
	}
	
	public List<Conta> getListaContas() {
		return this.listaContas;
	}
	
	//Setters
	public void setNome(String nome) {
		if(!nome.isEmpty()) {
			this.nome = nome;
		}else {
			throw new RuntimeException("Nome não pode ser vazio!");
		}
	}
	
	//toString
	@Override
	public String toString() {
		return this.getNome();
	}
	
	public void setConta(Conta conta) {
		if(this.listaContas == null) {
			this.listaContas = new ArrayList<Conta>();
		}
		
		this.listaContas.add(conta);
	}
	
	public List<Conta> getListaContasByCliente(Cliente cliente) {
		List<Conta> contas = new ArrayList<Conta>();
		for(Conta conta: this.listaContas) {
			if (conta.getCliente() == cliente) {
				contas.add(conta);
			}
		}
		return contas;
	}
	
	public List<Conta> getListaContasCorrentes() {
		List<Conta> contas = new ArrayList<Conta>();
		for(Conta conta : this.listaContas) {
			if(conta instanceof ContaCorrente) {
				contas.add(conta);
			}
		}
		return contas;
	}
	
	public List<Conta> getListaContasPoupanca() {
		List<Conta> contas = new ArrayList<Conta>();
		for(Conta conta : this.listaContas) {
			if(conta instanceof ContaPoupanca) {
				contas.add(conta);
			}
		}
		return contas;
	}
}
