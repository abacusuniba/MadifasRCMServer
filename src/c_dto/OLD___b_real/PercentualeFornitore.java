package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.google.gson.annotations.SerializedName;

import javax.persistence.JoinColumn;

import c_dto.OLD___a_abstract.Azienda;
import c_dto.OLD___a_abstract.DTOBase;

@Entity
@Table(name="percentualef")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class PercentualeFornitore extends DTOBase implements Comparable<PercentualeFornitore>{
	
	////@SerializedName("nome") 
	@Column(name="percentuale")//nome azienda
	private int nome;

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

//	public String getNome() {
//		return nome + " %";
//	}
//	public void setNome(String nome) {
//		this.nome = nome;
//	}

	@Override
	public String toString() {
		return getNome() + " %";
	}

	public int getNome() {
		return nome;
	}

	public void setNome(int nome) {
		this.nome = nome;
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
	public int compareTo(PercentualeFornitore o) {
		
		
		//=0: le stringhe sono uguali
		//>0: o < this
		//<0: o > this
		
		int compare;
		
		compare=nome-o.getNome();
		
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
