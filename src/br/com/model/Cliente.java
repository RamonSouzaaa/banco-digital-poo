package br.com.model;

public class Cliente {

	private String nome;
	
	//Getters
	public String getNome() {
		return this.nome;
	}
	
	//Setters
	public void setNome(String nome) {
		if(!nome.isEmpty()) {
			this.nome = nome;
		}else{
			throw new RuntimeException("Nome n�o pode ser vazio!");
		}
	}
	
	//toString
	
	@Override
	public String toString() {
		return this.getNome();
	}
}
