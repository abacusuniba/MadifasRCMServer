package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

//////import com.fasterxml.jackson.annotation.JsonBackReference;
//////import com.fasterxml.jackson.annotation.JsonManagedReference;
////////import com.fasterxml.jackson.annotation.JsonManagedReference;
//// //////import com.fasterxml.jackson.annotation.JsonBackReference;
////////import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;//import com.fasterxml.jackson.annotation.JsonIgnore;

////import com.fasterxml.jackson.annotation.JsonBackReference;

////import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import c_dto.OLD___a_abstract.DTOBase;

@Entity
@Table(name="settore")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
//@JsonIgnoreProperties({"azienda"})
public class Settore extends DTOBase implements Comparable<Settore>{
	
	////@SerializedName("nome") 
	@Column(name="nome")//nome azienda
	private String nome;
	
	////@SerializedName("stato") 
	@ManyToOne
	@JoinColumn(name = "stato", nullable=false)
	private Stato stato;

//	///*@JsonBackReference*/
//	////@SerializedName("aziende") 
//		@ManyToMany(mappedBy="settori")
//	//	private List<Azienda> aziende = new ArrayList<>();
//		private List<Cliente> aziende = new ArrayList<>();
	
	
	
//	///*@JsonBackReference*/("settori")
////	///*@JsonManagedReference*/(value="settore")
////	@Expose(serialize = false)
//	////@SerializedName("azienda") 
//	@ManyToOne
//    @JoinColumn(name="idazienda", nullable=true)
//	/*@JsonIgnore*/ private Cliente azienda;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "settori")
	private List<Cliente> clienti = new ArrayList<>();
	
	public void addAzienda(Cliente a){
		if (!clienti.contains(a))
			clienti.add(a);
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

//	//	public List<Azienda> getAziende() {
////		return aziende;
////	}
//	public List<Cliente> getAziende() {
//		return aziende;
//	}
//
////	public void setAziende(List<Azienda> aziende) {
////		this.aziende = aziende;
////	}
//	public void setAziende(List<Cliente> aziende) {
//		this.aziende = aziende;
//	}
//	public Cliente getAzienda() {
//		return azienda;
//	}
//
//	@Transient
//	public void setAzienda(Cliente azienda) {
//		this.azienda = azienda;
//	}
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return getNome();
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

	public boolean contains(String s) {
		boolean contain=false;
		
		String stringForFilter = nome;
		
		
		
		stringForFilter=stringForFilter.toLowerCase();
		
		if (stringForFilter.indexOf(s.toLowerCase())>-1)
			contain=true;
		
		
		return contain;
	}

	@Override
	public int compareTo(Settore o) {
		
		//=0: le stringhe sono uguali
		//>0: o < this
		//<0: o > this
		
		int compare;
		
		compare=getNome().toLowerCase().compareTo(o.getNome().toLowerCase());
		
		if (compare==0)
		{
//			compare=this.getNome().toLowerCase().compareTo(o.getNome().toLowerCase());
//			if (compare==0)
//			{
				compare=this.getId()-o.getId();
//			}
		}
		
		
		return compare;
		
	}



	


}

//package c_dto.b_real;
//////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//////import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//
//import java.beans.Transient;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
// //////import com.fasterxml.jackson.annotation.JsonBackReference;
////////import com.fasterxml.jackson.annotation.JsonManagedReference;
//////////import com.fasterxml.jackson.annotation.JsonManagedReference;
////// //////import com.fasterxml.jackson.annotation.JsonBackReference;
//////////import com.fasterxml.jackson.annotation.JsonManagedReference;
//import org.hibernate.annotations.LazyCollection;
//import org.hibernate.annotations.LazyCollectionOption;
//
////import com.fasterxml.jackson.annotation.JsonIgnoreProperties;//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//////import com.fasterxml.jackson.annotation.JsonBackReference;
//
//////import com.google.gson.annotations.Expose;
////import com.google.gson.annotations.SerializedName;
//
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
//
//import c_dto.OLD___a_abstract.DTOBase;
//
//@Entity
//@Table(name="settore")
////@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
////@JsonIgnoreProperties({"azienda"})
//public class Settore extends DTOBase implements Comparable<Settore>{
//	
//	////@SerializedName("nome") 
//	@Column(name="nome")//nome azienda
//	private String nome;
//	
//	////@SerializedName("stato") 
//	@ManyToOne
//	@JoinColumn(name = "stato", nullable=false)
//	private Stato stato;
//
////	///*@JsonBackReference*/
////	////@SerializedName("aziende") 
////		@ManyToMany(mappedBy="settori")
////	//	private List<Azienda> aziende = new ArrayList<>();
////		private List<Cliente> aziende = new ArrayList<>();
//	
//	
//	
//	///*@JsonBackReference*/("settori")
////	///*@JsonManagedReference*/(value="settore")
////	@Expose(serialize = false)
//	////@SerializedName("azienda") 
//	@ManyToOne
//    @JoinColumn(name="idazienda")
//	/*@JsonIgnore*/ private Cliente azienda;
//	
//
//	public Stato getStato() {
//		return stato;
//	}
//
//	public void setStato(Stato stato) {
//		this.stato = stato;
//	}
//
////	//	public List<Azienda> getAziende() {
//////		return aziende;
//////	}
////	public List<Cliente> getAziende() {
////		return aziende;
////	}
////
//////	public void setAziende(List<Azienda> aziende) {
//////		this.aziende = aziende;
//////	}
////	public void setAziende(List<Cliente> aziende) {
////		this.aziende = aziende;
////	}
//	public Cliente getAzienda() {
//		return azienda;
//	}
//
//	@Transient
//	public void setAzienda(Cliente azienda) {
//		this.azienda = azienda;
//	}
//	
//	
//	
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	@Override
//	public String toString() {
//		return getNome();
//	}
//
//	@Override
//	public boolean isModified() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isEmpty() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public boolean contains(String s) {
//		boolean contain=false;
//		
//		String stringForFilter = nome;
//		
//		
//		
//		stringForFilter=stringForFilter.toLowerCase();
//		
//		if (stringForFilter.indexOf(s.toLowerCase())>-1)
//			contain=true;
//		
//		
//		return contain;
//	}
//
//	@Override
//	public int compareTo(Settore o) {
//		
//		//=0: le stringhe sono uguali
//		//>0: o < this
//		//<0: o > this
//		
//		int compare;
//		
//		compare=getNome().toLowerCase().compareTo(o.getNome().toLowerCase());
//		
//		if (compare==0)
//		{
////			compare=this.getNome().toLowerCase().compareTo(o.getNome().toLowerCase());
////			if (compare==0)
////			{
//				compare=this.getId()-o.getId();
////			}
//		}
//		
//		
//		return compare;
//		
//	}
//
//
//
//	
//
//
//}
