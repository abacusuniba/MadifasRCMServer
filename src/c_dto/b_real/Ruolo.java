package c_dto.b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import c_dto.a_abstract.DTOBase;

import java.beans.Transient;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Secondary;

public class Ruolo extends Secondary{
	
	private String ruolo;
	
	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}



	@Override
	public String toString() {
		return getRuolo();

	}

	public boolean contains(Ruolo elem) {
		return (getRuolo().toLowerCase().indexOf(elem.getRuolo().toLowerCase())>=0) ? true : false;
	}
	
	@Override
	public int compareTo(DTOBase o) {
//		=0: le stringhe sono uguali
//		>0: o < this
//		<0: o > this
	
		Ruolo n = (Ruolo) o;
		int compare=0;
		
		compare=getRuolo().toLowerCase().compareTo(n.getRuolo().toLowerCase());
		if (compare==0){
			compare=super.compareTo(o);
		}
		
		return compare;
	}
}