package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;//import com.fasterxml.jackson.annotation.JsonIgnore;

////import com.fasterxml.jackson.annotation.JsonBackReference;

//////import com.fasterxml.jackson.annotation.JsonBackReference;
//////import com.fasterxml.jackson.annotation.JsonManagedReference;

////////import com.fasterxml.jackson.annotation.JsonManagedReference;

////import com.google.gson.annotations.Expose;

////import com.fasterxml.jackson.annotation.JsonIgnoreProperties;//import com.fasterxml.jackson.annotation.JsonIgnore;
////////import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.google.gson.annotations.SerializedName;

import javax.persistence.JoinColumn;

import c_dto.OLD___a_abstract.Azienda;
import c_dto.OLD___a_abstract.DTOBase;

@Entity
@Table(name="faxazienda")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
//@JsonIgnoreProperties({"azienda"})
public class FaxAzienda extends DTOBase{
	
	////@SerializedName("numero") 
	@Column(name="numero")//nome azienda
	private String numero;
	
	
	///*@JsonBackReference*/("fax")
//	///*@JsonManagedReference*/(value="faxazienda")
//	@Expose(serialize = false)
	////@SerializedName("azienda") 
	@ManyToOne
    @JoinColumn(name="idazienda")
	/*@JsonIgnore*/ private Azienda azienda;

//	public void setAzienda(Azienda azienda) {
//		this.azienda = azienda;
//	}

	public Azienda getAzienda() {
		return azienda;
	}

	@Transient
	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

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
		
		FaxAzienda c = (FaxAzienda) obj;
		
		return c.getNumero().equals(this.getNumero());
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

}
