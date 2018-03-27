package c_dto.b_real;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import c_dto.a_abstract.Riga;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "id")
public class RigaTestoSub extends Riga/* / implements Comparable<RigaTesto>/**/{

	
	private DocumentoSub documento;
	
	private String text;
	private String colorhex;
	
	public String getColorHex() {
		return colorhex;
	}


	public void setColorHex(String colorHex) {
		this.colorhex = colorHex;
	}


	public DocumentoSub getDocumento() {
		return documento;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public void setDocumento(DocumentoSub documento) {
		this.documento = documento;
	}


//	public Prodotto getProdotto() {
//		return prodotto;
//	}
//
//
//	public void setProdotto(Prodotto prodotto) {
//		this.prodotto = prodotto;
//	}
//
//
//	public Iva getIva() {
//		return iva;
//	}
//
//
//	public void setIva(Iva iva) {
//		this.iva = iva;
//	}


	@Override
	public String toString() {
//		return getProgressivo() + ":  " + getProdotto().getNome();
		return getProgressivo() + ":  " + getText();
	}
	
	

	
}
