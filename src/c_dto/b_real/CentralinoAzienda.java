package c_dto.b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.beans.Transient;

import c_dto.a_abstract.Azienda;
import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Secondary;

public class CentralinoAzienda extends Secondary{
	
	private String numero;
//	private Azienda azienda;
//	
//	public void setAzienda(Azienda azienda) {
//		this.azienda = azienda;
//	}

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

	
	
	
//	@Override
//	public int compareTo(DTOBase o) {
////		long x = this.getId();
////		long y = o.getId();
////		return (x < y) ? -1 : ((x == y) ? 0 : 1); 
//		int cmp = super.compareTo(o) + getNumero().compareTo(((CentralinoAzienda)o).getNumero());
//		
//		return cmp;
//	}
	
	@Override
	public boolean equals(Object obj) {
		
		CentralinoAzienda c = (CentralinoAzienda) obj;
		
		return c.getNumero().equals(this.getNumero());
	}

}