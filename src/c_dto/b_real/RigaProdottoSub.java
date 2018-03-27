package c_dto.b_real;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import c_dto.a_abstract.Riga;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "id")

public class RigaProdottoSub extends Riga/* / implements Comparable<RigaProdotto>/**/{

	


	private double prezzo;

	private int quantita;

	private DocumentoSub documento;
	
	private Prodotto prodotto;
	
	private TempoConsegna tempo;
	
	private String consegnar;
	private String consegnap;
	
	public String getConsegnaR() {
		return consegnar;
	}


	public void setConsegnaR(String consegnaR) {
		consegnar = consegnaR;
	}


	public String getConsegnaP() {
		return consegnap;
	}


	public void setConsegnaP(String consegnaP) {
		consegnap = consegnaP;
	}


	public TempoConsegna getTempo() {
		return tempo;
	}


	public void setTempo(TempoConsegna tempo) {
		this.tempo = tempo;
	}


	private Iva iva;
	
	public double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}


	public int getQuantita() {
		return quantita;
	}


	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}


	public DocumentoSub getDocumento() {
		return documento;
	}


	public void setDocumento(DocumentoSub documento) {
		this.documento = documento;
	}


	public Prodotto getProdotto() {
		return prodotto;
	}


	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}


	public Iva getIva() {
		return iva;
	}


	public void setIva(Iva iva) {
		this.iva = iva;
	}


	@Override
	public String toString() {
		return getProgressivo() + ":  " + getProdotto().getNome();
	}
	
	
//@Override
//	public int compareTo(RigaProdotto o) {
//		
//		//=0: le stringhe sono uguali
//		//>0: o < this
//		//<0: o > this
//		
//		int compare;
//		
//		compare=this.getProgressivo()-o.getProgressivo();
//		
//		if (compare==0)
//		{
//				compare=this.getId()-o.getId();
//		}
//		
//		
//		return compare;
//		
//	}

}
