package c_dto.b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import c_dto.a_abstract.DTOBase;

import java.beans.Transient;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Secondary;

public class Titolo extends Secondary{
	
	private String titolo;
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	@Override
	public String toString() {
		return getTitolo();

	}

	public boolean contains(Titolo elem) {
		return (getTitolo().toLowerCase().indexOf(elem.getTitolo().toLowerCase())>=0) ? true : false;
	}
	
	@Override
	public int compareTo(DTOBase o) {
//		=0: le stringhe sono uguali
//		>0: o < this
//		<0: o > this
	
		Titolo n = (Titolo) o;
		int compare=0;
		
		compare=getTitolo().toLowerCase().compareTo(n.getTitolo().toLowerCase());
		if (compare==0){
			compare=super.compareTo(o);
		}
		
		return compare;
	}
}