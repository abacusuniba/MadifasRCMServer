package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;

public class PercentualeCollaboratore extends Primary{
	
	private int nome;

	@Override
	public int compareTo(DTOBase o) {
		PercentualeCollaboratore n = (PercentualeCollaboratore) o;
//		
//		
//		
//		int res = String.valueOf(getNome()).compareTo(String.valueOf(n.getNome()));// + super.compareTo(o);
		
		return getNome()-n.getNome();
	}

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

	public boolean contains(PercentualeCollaboratore elem) {
		
	String thisNome = getNome()+"";
			
	
	String thatNome = elem.getNome() + "";
//	return (getNome().toLowerCase().indexOf(elem.getNome())+getSigla().toLowerCase().indexOf(elem.getSigla())>=0) ? true : false;
	return (thisNome.indexOf(thatNome)>=0) ? true : false;
}
	
	
}
