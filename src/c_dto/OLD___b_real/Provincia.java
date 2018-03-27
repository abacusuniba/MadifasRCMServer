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
@Table(name="provincia")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Provincia extends DTOBase implements Comparable<Provincia>{
	
	////@SerializedName("nome") 
	@Column(name="nome")//nome azienda
	private String nome;

	////@SerializedName("sigla") 
	@Column(name="sigla")//nome azienda
	private String sigla;

	////@SerializedName("stato") 
	@ManyToOne
	@JoinColumn(name = "stato", nullable=false)
	private Stato stato;

	////@SerializedName("regione") 
	@ManyToOne
	@JoinColumn(name="idregione")
	private Regione regione;

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Regione getRegione() {
		return regione;
	}

	public void setRegione(Regione regione) {
		this.regione = regione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
////		return " (" + getNome() + ") - " + getRegione().getNazione().toString();
//		return " (" + getNome() + ") - " + getRegione().toString();
		return " (" + getNome() + ") - ";

//		return " (" + getSigla()() + ") - " + getRegione().getNazione().toString();
	}


//	@ManyToOne
//    @JoinColumn(name="idtipo")
//	private TipoDocumento tipo;
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
public int compareTo(Provincia o) {
	
	
	//=0: le stringhe sono uguali
	//>0: o < this
	//<0: o > this
	
	int compare;
	
	compare=nome.toLowerCase().compareTo(o.getNome().toLowerCase());
	
	if (compare==0)
	{
//		compare=this.getNome().toLowerCase().compareTo(o.getNome().toLowerCase());
//		if (compare==0)
//		{
			compare=this.getId()-o.getId();
//		}
	}
	
	
	return compare;
	
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
