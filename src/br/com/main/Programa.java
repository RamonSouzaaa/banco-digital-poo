package br.com.main;

import java.util.*;

import br.com.abstracts.*;
import br.com.model.*;

public class Programa {

	public static void main(String[] args) {
		Banco b = new Banco("Nubank");
				
		Cliente c1 = new Cliente();
		c1.setNome("João");
		
		Cliente c2 = new Cliente();
		c2.setNome("Maria");
		
		Cliente c3 = new Cliente();
		c3.setNome("Pedro");
		
		Cliente c4 = new Cliente();
		c4.setNome("Joana");
		
		ContaCorrente cc1 = new ContaCorrente(c1);
		ContaCorrente cc2 = new ContaCorrente(c3);
		ContaPoupanca cp1 = new ContaPoupanca(c2);
		ContaPoupanca cp2 = new ContaPoupanca(c4);
		
		b.setConta(cp1);
		b.setConta(cc1);
		b.setConta(cp2);
		b.setConta(cc2);
		
		cc1.depositar(100);
		cp1.depositar(28.44);
		cp2.depositar(75.5);
		cc2.depositar(150.25);
		
		cc1.transferir(cp2, 15.78);
		cc2.transferir(cp1, 25.50);
		
		System.out.println("Lista de contas banco");
		for(Conta c : b.getListaContasCorrentes()) {
			c.extrato();
		}
	}
}
