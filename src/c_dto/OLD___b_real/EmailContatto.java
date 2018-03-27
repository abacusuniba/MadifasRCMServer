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
@Table(name="elencoemail")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
//@JsonIgnoreProperties({"riferimento"})
public class EmailContatto extends DTOBase{
	
	public Riferimento getRiferimento() {
		return riferimento;
	}


	@Transient
	public void setRiferimento(Riferimento riferimento) {
		this.riferimento = riferimento;
	}

	////@SerializedName("email") 
	@Column(name="email")//nome azienda
	private String email;
	
	
	///*@JsonBackReference*/("emailcontatto")
	/////*@JsonManagedReference*/(value="emailcontatto")
//	@Expose(serialize = false)
	////@SerializedName("riferimento") 
	@ManyToOne
    @JoinColumn(name="idcontatto")
	/*@JsonIgnore*/ private Riferimento riferimento;

	
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
		
		EmailContatto c = (EmailContatto) obj;
		
//		return super.equals(obj) || c.getEmail().equals(this.getEmail());
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
