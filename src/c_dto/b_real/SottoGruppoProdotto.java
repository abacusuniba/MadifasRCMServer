package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;

public class SottoGruppoProdotto extends Primary{
	
	private String nome;
	private GruppoProdotto gruppo;

	public GruppoProdotto getGruppo() {
		return gruppo;
	}

	public void setGruppo(GruppoProdotto gruppo) {
		this.gruppo = gruppo;
	}

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

	public boolean contains(SottoGruppoProdotto elem) {
		return (getNome().toLowerCase().indexOf(elem.getNome().toLowerCase())>=0) ? true : false;
	}
	
	@Override
	public int compareTo(DTOBase o) {
//		=0: le stringhe sono uguali
//		>0: o < this
//		<0: o > this
	
		SottoGruppoProdotto n = (SottoGruppoProdotto) o;
		int compare=0;
		
		compare=getNome().toLowerCase().compareTo(n.getNome().toLowerCase());
		if (compare==0){
			compare=super.compareTo(o);
		}
		
		return compare;
	}
}
