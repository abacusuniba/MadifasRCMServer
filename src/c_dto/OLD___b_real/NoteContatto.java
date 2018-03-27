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
@Table(name="elenconote")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
//@JsonIgnoreProperties({"riferimento"})
public class NoteContatto extends DTOBase{
	
	public Riferimento getRiferimento() {
		return riferimento;
	}

	@Transient
	public void setRiferimento(Riferimento riferimento) {
		this.riferimento = riferimento;
	}

	////@SerializedName("note") 
	@Column(name="note")//nome azienda
	private String note;
	
	
	///*@JsonBackReference*/("notecontatto")
	/////*@JsonManagedReference*/(value="notecontatto")
//	@Expose(serialize = false)
	////@SerializedName("riferimento") 
	@ManyToOne
    @JoinColumn(name="idcontatto")
	/*@JsonIgnore*/ private Riferimento riferimento;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	@Override
	public String toString() {

		return getNote();
	}
	
	@Override
	public boolean equals(Object obj) {
		NoteContatto c = (NoteContatto) obj;
		
//		return super.equals(obj) || c.getNote().equals(this.getNote());
		return c.getNote().equals(this.getNote());
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
