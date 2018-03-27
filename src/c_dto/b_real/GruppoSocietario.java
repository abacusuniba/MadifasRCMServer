package c_dto.b_real;

import c_dto.a_abstract.Primary;

public class GruppoSocietario extends Primary{
	
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

}
