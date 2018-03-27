package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 //////import com.fasterxml.jackson.annotation.JsonBackReference;
//////import com.fasterxml.jackson.annotation.JsonManagedReference;
////////import com.fasterxml.jackson.annotation.JsonManagedReference;
////import com.fasterxml.jackson.annotation.JsonIgnoreProperties;//import com.fasterxml.jackson.annotation.JsonIgnore;
////////import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OrderBy;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;//import com.fasterxml.jackson.annotation.JsonIgnore;

////import com.fasterxml.jackson.annotation.JsonBackReference;

////import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;

import javax.persistence.JoinColumn;

import c_dto.OLD___a_abstract.Azienda;
import c_dto.OLD___a_abstract.DTOBase;

@Entity
@Table(name="scheda")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
//@JsonIgnoreProperties({"azienda"})
public class SchedaNetto extends DTOBase implements Comparable<SchedaNetto>{
	
	////@SerializedName("prezzo") 
	@Column(name="prezzo")
	private double prezzo;
	
	////@SerializedName("data") 
	@Column(name="data")
	private String data;

	////@SerializedName("prodotto") 
	@ManyToOne
    @JoinColumn(name="idprodotto")
	private Prodotto prodotto;
	
	///*@JsonBackReference*/("scheda")
//	///*@JsonManagedReference*/(value="schedanetto")
//	@Expose(serialize = false)
	////@SerializedName("azienda") 
	@ManyToOne
    @JoinColumn(name="idazienda")
	/*@JsonIgnore*/  private Cliente azienda;

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

	public Cliente getAzienda() {
		return azienda;
	}

	@Transient
	public void setAzienda(Cliente azienda) {
		this.azienda = azienda;
	}

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

	@Override
	public int compareTo(SchedaNetto o) {
		
		//=0: le stringhe sono uguali
		//>0: o < this
		//<0: o > this
		
		int compare;
		
//		compare=this.getCognome().toLowerCase().compareTo(o.getCognome().toLowerCase());
		compare=this.getProdotto().getNome().toLowerCase().compareTo(o.getProdotto().getNome().toLowerCase());
		
		if (compare==0)
		{
//			compare=this.getNome().toLowerCase().compareTo(o.getNome().toLowerCase());
//			if (compare==0)
//			{
				compare=this.getId()-o.getId();
//			}
		}
		
		
		return compare;
		
	}


	


}
