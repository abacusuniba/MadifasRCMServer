package c_dto.b_real;

import c_dto.a_abstract.Azienda;
import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import d_utils.StringBuilderQuery;

public class CAPCitta extends Primary{
	
	
	public CAPCitta() {
//		setTable("capcitta");
	}
	
	
	private CAP cap;
	private Citta citta;
	
	

	public CAP getCap() {
		return cap;
	}

	public void setCap(CAP cap) {
		this.cap = cap;
	}

	public Citta getCitta() {
		return citta;
	}

	public void setCitta(Citta citta) {
		this.citta = citta;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cap.getCap() + " - " + citta.getNome();
	}
	
	public boolean contains(CAPCitta elem) {
//		String txt = cap.toString().toLowerCase() + citta.toString().toLowerCase();
		String txt = toString().toLowerCase();
		
		
		return (txt.indexOf(elem.getCap().getCap().toLowerCase())>=0) ? true : false;
	}
	
	
	
	@Override
	public int compareTo(DTOBase o) {
//		=0: le stringhe sono uguali
//		>0: o < this
//		<0: o > this
	
		CAPCitta n = (CAPCitta) o;
		int compare=0;
		
//		try{
			compare=getCap().getCap().toLowerCase().compareTo(n.getCap().getCap().toLowerCase());
//			compare+=getCodice().toLowerCase().compareTo(n.getCodice().toLowerCase());
			if (compare==0){
				compare=getCitta().getNome().toLowerCase().compareTo(n.getCitta().getNome().toLowerCase());
			}
//		}
//		catch(Exception e){
//			System.out.print("");
//		}
		
		return compare;
	}

//	@Override
//	public String getReadQuery() {
//		StringBuilderQuery query = new StringBuilderQuery("select * from " + getTable() + " where id=?");
//		query.setValue(1, getId());
//				
//		return query.toString();
//	}
//
//	@Override
//	public String getReadAllQuery() {
//		StringBuilderQuery query = new StringBuilderQuery("select * from " + getTable() + "");
//		
//		return query.toString();
//	}


//	@Override
//	public String getDeleteQuery() {
//		return null;
//	}
	
}