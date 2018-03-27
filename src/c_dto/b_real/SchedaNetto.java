package c_dto.b_real;
import java.beans.Transient;

import c_dto.a_abstract.Primary;

public class SchedaNetto extends Primary{
	
	private double prezzo;
	
	private String data;

	private Prodotto prodotto;
	
//	private Cliente azienda;

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

//	public Cliente getAzienda() {
//		return azienda;
//	}
//
//	@Transient
//	public void setAzienda(Cliente azienda) {
//		this.azienda = azienda;
//	}



	


}
