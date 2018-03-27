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
@Table(name="citta")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Citta extends DTOBase implements Comparable<Citta>{
	
	////@SerializedName("nome") 
	@Column(name="nome")//nome azienda
	private String nome;

	////@SerializedName("stato") 
	@ManyToOne
	@JoinColumn(name = "stato", nullable=false)
	private Stato stato;
	
	
	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	////@SerializedName("provincia") 
	@ManyToOne
	@JoinColumn(name="idprovincia")
	private Provincia provincia;

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		
//		return getNome() + " " + getProvincia().toString();
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
	public boolean contains(String s){
		boolean contain=false;
		
//		String stringForFilter = nome;
		String stringForFilter = toString();
		
		
		
		stringForFilter=stringForFilter.toLowerCase();
		
		if (stringForFilter.indexOf(s.toLowerCase())>-1)
			contain=true;
		
		
		return contain;
}

	@Override
	public int compareTo(Citta o) {
		
		
		//=0: le stringhe sono uguali
		//>0: o < this
		//<0: o > this
		
		int compare;
		
		compare=nome.toLowerCase().compareTo(o.getNome().toLowerCase());
		
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