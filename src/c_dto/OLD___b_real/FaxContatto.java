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
@Table(name="elencofax")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
//@JsonIgnoreProperties({"riferimento"})
public class FaxContatto extends DTOBase{
	
	public Riferimento getRiferimento() {
		return riferimento;
	}


	@Transient
	public void setRiferimento(Riferimento riferimento) {
		this.riferimento = riferimento;
	}

	////@SerializedName("fax") 
	@Column(name="fax")//nome azienda
	private String fax;
	
	
	///*@JsonBackReference*/("faxcontatto")
	/////*@JsonManagedReference*/(value="faxcontatto")
//	@Expose(serialize = false)
	////@SerializedName("riferimento") 
	@ManyToOne
    @JoinColumn(name="idcontatto")
	/*@JsonIgnore*/ private Riferimento riferimento;

	
	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	@Override
	public String toString() {

		return getFax();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		FaxContatto c = (FaxContatto) obj;
		
//		return super.equals(obj) || c.getFax().equals(this.getFax());
		return c.getFax().equals(this.getFax());
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
