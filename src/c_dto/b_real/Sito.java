package c_dto.b_real;

import java.beans.Transient;

import c_dto.a_abstract.Secondary;


public class Sito extends Secondary{
	
	private String nome;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return getNome();
	}

	@Override
	public boolean equals(Object obj) {
		
		Sito c = (Sito) obj;
		
		return c.getNome().equals(this.getNome());
	}

}