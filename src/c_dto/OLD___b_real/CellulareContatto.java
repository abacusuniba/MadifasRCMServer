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
@Table(name="elencocellulare")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
//@JsonIgnoreProperties({"riferimento"})
public class CellulareContatto extends DTOBase{
	
	////@SerializedName("cellulare") 
	@Column(name="cellulare")//nome azienda
	private String cellulare;
	
	
	///*@JsonBackReference*/("cellularecontatto")
	/////*@JsonManagedReference*/(value="cellularecontatto")
//	@Expose(serialize = false)
	////@SerializedName("riferimento") 
	@ManyToOne
    @JoinColumn(name="idcontatto")
	/*@JsonIgnore*/ private Riferimento riferimento;

	public Riferimento getRiferimento() {
		return riferimento;
	}

	@Transient
	public void setRiferimento(Riferimento riferimento) {
		this.riferimento = riferimento;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
	
	@Override
	public String toString() {

		return getCellulare();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		CellulareContatto c = (CellulareContatto) obj;
		
//		return super.equals(obj) || c.getCellulare().equals(this.getCellulare());
		return c.getCellulare().equals(this.getCellulare());
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
