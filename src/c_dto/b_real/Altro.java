package c_dto.b_real;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import c_dto.a_abstract.Azienda;
import c_dto.a_abstract.DTOBase;
import c_dto.c_enum.Stato;
import c_dto.c_enum.TipoAzienda;
import d_utils.StringBuilderQuery;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "id")
public final class Altro extends Azienda {
	
	public Altro() {
//		setTable("azienda");
	}
	
//	public boolean contains(Altro elem) {
//		String thisNome = getNome().replace(".", "").toLowerCase();
//		String thatNome = elem.getNome().replace(".", "").toLowerCase();
////		return (getNome().toLowerCase().indexOf(elem.getNome())+getSigla().toLowerCase().indexOf(elem.getSigla())>=0) ? true : false;
//		return (thisNome.indexOf(thatNome)>=0) ? true : false;
//	}
	
}
