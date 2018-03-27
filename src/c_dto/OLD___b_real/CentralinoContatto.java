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
@Table(name="elencoufficio")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
//@JsonIgnoreProperties({"riferimento"})
public class CentralinoContatto extends DTOBase{
	
	////@SerializedName("ufficio") 
	@Column(name="ufficio")//nome azienda
	private String ufficio;
	
	
	///*@JsonBackReference*/("centralinocontatto")
	/////*@JsonManagedReference*/(value="centralinocontatto")
//	@Expose(serialize = false)
	////@SerializedName("riferimento") 
	@ManyToOne
    @JoinColumn(name="idcontatto")
	/*@JsonIgnore*/ private Riferimento riferimento;

	
	public String getUfficio() {
		return ufficio;
	}


	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}


	public Riferimento getRiferimento() {
		return riferimento;
	}


	@Transient
	public void setRiferimento(Riferimento riferimento) {
		this.riferimento = riferimento;
	}


	@Override
	public String toString() {

		return getUfficio();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		CentralinoContatto c = (CentralinoContatto) obj;
		
//		super.equals(obj);
		
//		return super.equals(obj) || c.getUfficio().equals(this.getUfficio());
		return c.getUfficio().equals(this.getUfficio());
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
