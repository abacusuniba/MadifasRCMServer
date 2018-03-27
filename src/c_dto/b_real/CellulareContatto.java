package c_dto.b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.beans.Transient;

import c_dto.a_abstract.Secondary;

public class CellulareContatto extends Secondary{
	
	private String numero;
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}



	@Override
	public String toString() {
		return getNumero();

	}

	@Override
	public boolean equals(Object obj) {
		
		CellulareContatto c = (CellulareContatto) obj;
		
		return c.getNumero().equals(this.getNumero());
	}

}