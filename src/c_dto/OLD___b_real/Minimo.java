package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.text.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.google.gson.annotations.SerializedName;

import javax.persistence.JoinColumn;

import c_dto.OLD___a_abstract.Azienda;
import c_dto.OLD___a_abstract.DTOBase;

@Entity
@Table(name="minimo")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Minimo extends DTOBase implements Comparable<Minimo>{
	
	////@SerializedName("nome") 
	@Column(name="minimo")//nome azienda
	private int nome;
//	@Column(name="prezzo")
//	private double prezzo;
	
	
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

	public int getNome() {
		return nome;
	}

	public void setNome(int nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return NumberFormat.getCurrencyInstance().format(getNome());
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
		
		String stringForFilter = String.valueOf(nome);
		
		
		
		stringForFilter=stringForFilter.toLowerCase();
		
		if (stringForFilter.indexOf(s.toLowerCase())>-1)
			contain=true;
		
		
		return contain;
	}

	@Override
	public int compareTo(Minimo o) {
		String myMinimo=String.valueOf(nome);
		String paramMinimo = String.valueOf(o.getNome());
		//=0: le stringhe sono uguali
		//>0: o < this
		//<0: o > this
		
		int compare;
		
		compare=myMinimo.compareTo(paramMinimo);
		
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
