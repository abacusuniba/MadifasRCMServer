package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;

public class Iva extends Primary{
	
	private String nome;
	private float percentuale;

	public String getNome() {
		return nome;
	}

	public float getPercentuale() {
		return percentuale;
	}

	public void setPercentuale(float percentuale) {
		this.percentuale = percentuale;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return getNome();
	}

	public boolean contains(Iva elem) {
		return (getNome().toLowerCase().indexOf(elem.getNome().toLowerCase())>=0) ? true : false;
	}
	
	@Override
	public int compareTo(DTOBase o) {
//		=0: le stringhe sono uguali
//		>0: o < this
//		<0: o > this
	
		Iva n = (Iva) o;
		int compare=0;
		
		compare=getNome().toLowerCase().compareTo(n.getNome().toLowerCase());
		if (compare==0){
			compare=super.compareTo(o);
		}
		
		return compare;
	}
}
