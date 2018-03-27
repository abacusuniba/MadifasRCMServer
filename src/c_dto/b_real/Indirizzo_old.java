package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

import java.util.ArrayList;
import java.util.List;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import d_utils.StringBuilderQuery;

public class Indirizzo_old extends Primary{
	public Indirizzo_old() {
//		setTable("indcivico");
	}
	
	private Civico_old civico;

	public Civico_old getCivico() {
		return civico;
	}

	public void setCivico(Civico_old civico) {
		this.civico = civico;
	}

	private Strada strada;
	
	
	
	public Strada getStrada() {
		return strada;
	}

	public void setStrada(Strada strada) {
		this.strada = strada;
	}
	
	@Override
	public String toString() {
//		return strada.getId() + "_" + civico.getId();
		String toString="";
		if (strada.getCap()!=null){
			toString= strada.getNome() + ", " + civico.getNumero() + " - "  + strada.getCap().getCap().getCap() + " " + strada.getCap().getCitta().getNome();
		}
		else{
			toString= strada.getNome() + ", " + civico.getNumero();
		}
		
		return toString;
	}
	
	
	@Override
	public int compareTo(DTOBase o) {
		Indirizzo_old n = (Indirizzo_old) o;
		
		int compare = getStrada().compareTo(n.getStrada());
		if (compare==0) {
			compare=getCivico().compareTo(n.getCivico());
		}
//		int res = strada.getNome().toLowerCase().compareTo(n.getStrada().getNome().toLowerCase());// + super.compareTo(o);
		
		return compare;
	}
	public boolean contains(Indirizzo_old elem) {
		
//		String thisNome = strada.getNome() + ", " + civico.getNumero() + " - "  + strada.getCap().getCap().getCap() + " " + strada.getCap().getCitta().getNome();
		String thisNome = toString();
		
		
		thisNome= thisNome.toLowerCase();

		return (thisNome.indexOf(elem.getStrada().getNome())>=0) ? true : false;
	}

}