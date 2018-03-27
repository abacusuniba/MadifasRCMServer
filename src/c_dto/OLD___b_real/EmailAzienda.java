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
@Table(name="emailazienda")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
//@JsonIgnoreProperties({"azienda"})
public class EmailAzienda extends DTOBase{
	
	public Azienda getAzienda() {
		return azienda;
	}


	@Transient
	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}


	////@SerializedName("email") 
	@Column(name="email")//nome azienda
	private String email;
	
	
	///*@JsonBackReference*/("email")
//	///*@JsonManagedReference*/(value="emailazienda")
//	@Expose(serialize = false)
	////@SerializedName("azienda") 
	@ManyToOne
    @JoinColumn(name="idazienda")
	/*@JsonIgnore*/ private Azienda azienda;


//	public void setAzienda(Azienda azienda) {
//		this.azienda = azienda;
//	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return getEmail();
	}

	@Override
	public boolean equals(Object obj) {
		
		EmailAzienda c = (EmailAzienda) obj;
		
		return c.getEmail().equals(this.getEmail());
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
