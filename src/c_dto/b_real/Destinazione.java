package c_dto.b_real;

import c_dto.a_abstract.Primary;

public class Destinazione extends Primary{
	
	private int azienda;
	
	private int indirizzo;

	public int getAzienda() {
		return azienda;
	}

	public void setAzienda(int azienda) {
		this.azienda = azienda;
	}

	public int getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(int indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	@Override
	public String toString() {
		return getAzienda() + " || " + getIndirizzo();
	}


}
