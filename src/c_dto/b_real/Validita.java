package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import c_dto.c_enum.Stato;
import d_utils.StringBuilderQuery;

public class Validita extends Primary{
	
	
	public Validita() {
//		setTable("validita");
		// TODO Auto-generated constructor stub
	}
	
	private String nome;
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
	public int compareTo(DTOBase o) {
		Validita n = (Validita) o;
//		
		int res = getNome().compareTo(n.getNome());// + super.compareTo(o);
		
		return res;
	}
	public boolean contains(Validita elem) {
		
	String thisNome = getNome().toLowerCase();
			
	
	String thatNome = elem.getNome().toLowerCase();
//	return (getNome().toLowerCase().indexOf(elem.getNome())+getSigla().toLowerCase().indexOf(elem.getSigla())>=0) ? true : false;
	return (thisNome.indexOf(thatNome)>=0) ? true : false;
}
}
