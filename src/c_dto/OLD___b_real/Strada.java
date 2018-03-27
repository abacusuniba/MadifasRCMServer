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
@Table(name="indirizzo")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Strada extends DTOBase{
	
	////@SerializedName("nome") 
	@Column(name="indirizzo")//nome azienda
	private String nome;
	
//	@ManyToOne
//	@JoinColumn(name="idcivico")
//	private Civico civico;

//	public Civico getCivico() {
//		return civico;
//	}
//
//	public void setCivico(Civico civico) {
//		this.civico = civico;
//	}
	

	////@SerializedName("capcitta") 
	@ManyToOne
	@JoinColumn(name="idcap")
	private CAPCitta capcitta;


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public CAPCitta getCapcitta() {
		return capcitta;
	}


	public void setCapcitta(CAPCitta capcitta) {
		this.capcitta = capcitta;
	}
	
	
	@Override
	public String toString() {
//		//via pisa, 7 - 76125 Trani (BT) - Italia
//		
		String s=/* /", " + getCivico().toString() + /**/" - " + getCapcitta().toString();
		return s;
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
