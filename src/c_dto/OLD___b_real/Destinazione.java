package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.google.gson.annotations.SerializedName;

import javax.persistence.JoinColumn;

import c_dto.OLD___a_abstract.Azienda;
import c_dto.OLD___a_abstract.DTOBase;

@Entity
@Table(name="destinazione")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Destinazione extends DTOBase{
	
	////@SerializedName("azienda") 
	@Column(name="idazienda")//nome azienda
	private int azienda;
	
	////@SerializedName("indirizzo") 
	@Column(name="idindirizzo")//nome azienda
	private int indirizzo;

	public int getAzienda() {
		return azienda;
	}

	public void setAzienda(int azienda) {
		this.azienda = azienda;
	}

	public int getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(int indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	@Override
	public String toString() {
		return getAzienda() + " || " + getIndirizzo();
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
	
	
//	@ManyToOne
//    @JoinColumn(name="idazienda")
//	private Azienda azienda;


}
