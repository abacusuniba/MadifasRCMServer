package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

 //////import com.fasterxml.jackson.annotation.JsonBackReference;
////////import com.fasterxml.jackson.annotation.JsonManagedReference;
////import com.fasterxml.jackson.annotation.JsonIgnoreProperties;//import com.fasterxml.jackson.annotation.JsonIgnore;
////////import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OrderBy;

////import com.fasterxml.jackson.annotation.JsonBackReference;

//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;

import c_dto.OLD___a_abstract.Azienda;
import c_dto.OLD___a_abstract.DTOBase;
import c_dto.OLD___a_abstract.Riga;

/**
 * si tratta della classe base che modella un generico utente
 * 
 * @author Rosario
 *
 */
@Entity
@Table(name="docrighe")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class RigaTesto extends Riga/* / implements Comparable<RigaTesto>/**/{

	
//	////@SerializedName("prezzo") 
//	@Column(name="prezzo")//nome azienda
//	private double prezzo;

//	////@SerializedName("quantita") 
//	@Column(name="quantita")//nome azienda
//	private int quantita;

	///*@JsonBackReference*/("prodotti")
//	///*@JsonManagedReference*/(value="rigaprodotto")
//	@Expose(serialize = false)
	////@SerializedName("documento") 
	@ManyToOne
    @JoinColumn(name="iddocumento")
	/*@JsonBackReference*/ private Documento documento;
	
	////@SerializedName("prodotto") 
//	@ManyToOne
	@Column(name="text")//nome azienda
	private String text;
	
//	////@SerializedName("iva") 
//	@ManyToOne
//    @JoinColumn(name="idiva")
//	private Iva iva;
	


//	public double getPrezzo() {
//		return prezzo;
//	}
//
//
//	public void setPrezzo(double prezzo) {
//		this.prezzo = prezzo;
//	}
//
//
//	public int getQuantita() {
//		return quantita;
//	}
//
//
//	public void setQuantita(int quantita) {
//		this.quantita = quantita;
//	}


	public Documento getDocumento() {
		return documento;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public void setDocumento(Documento documento) {
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
	
	
//@Override
//	public int compareTo(RigaTesto o) {
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

	@Override
	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	
//	@ManyToOne
//	@JoinColumn(name = "idtitolo")
//	private Titolo titolo;
	
//	@ManyToOne
//	@JoinColumn(name = "idruolo")
//	private Ruolo ruolo;
	
	
	
	
}
