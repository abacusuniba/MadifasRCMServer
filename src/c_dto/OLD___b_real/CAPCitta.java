package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.google.gson.annotations.SerializedName;

import javax.persistence.JoinColumn;

import c_dto.OLD___a_abstract.DTOBase;

@Entity
@Table(name="capcitta")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class CAPCitta extends DTOBase{
	
	////@SerializedName("cap") 
	@ManyToOne
	@JoinColumn(name="idcap")
	private CAP cap;

	////@SerializedName("citta") 
	@ManyToOne
	@JoinColumn(name="idcitta")
	private Citta citta;

	public CAP getCap() {
		return cap;
	}

	public void setCap(CAP cap) {
		this.cap = cap;
	}

	public Citta getCitta() {
		return citta;
	}

	public void setCitta(Citta citta) {
		this.citta = citta;
	}
	
	@Override
	public String toString() {
//		return getCap().getNome() + " " + getCitta().getNome() + getCitta().getProvincia().toString();
		return getCap().getNome() + " " + getCitta().toString();

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
