package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import c_dto.c_enum.Stato;
import d_utils.StringBuilderQuery;

public class DescrizioneTrasporto extends Primary{
	
	
	private Lingua lingua;
	private String descrizione;

	
	
	public Lingua getLingua() {
		return lingua;
	}

	public void setLingua(Lingua lingua) {
		this.lingua = lingua;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione=descrizione;
	}

//	private Nazione nazione;
	
//	public Nazione getNazione() {
//		return nazione;
//	}
//
//	public void setNazione(Nazione nazione) {
//		this.nazione = nazione;
//	}

	@Override
	public String toString() {
		return getLingua() + "\n" + getDescrizione();
	}

//	public boolean contains(String s){
//		boolean contain=false;
//		
//		String stringForFilter = toString();
//		
//		
//		
//		stringForFilter=stringForFilter.toLowerCase();
//		
//		if (stringForFilter.indexOf(s.toLowerCase())>-1)
//			contain=true;
//		
//		
//		return contain;
//}

//	@Override
//	public int compareTo(Primary o) {
//		Nazione n = (Nazione) o;
//		
//		
//		//=0: le stringhe sono uguali
//		//>0: o < this
//		//<0: o > this
//		
//		int compare;
//		
//		compare=nome.toLowerCase().compareTo(n.getNome().toLowerCase());
//		
//		if (compare==0)
//		{
////			compare=this.getNome().toLowerCase().compareTo(o.getNome().toLowerCase());
////			if (compare==0)
////			{
//				compare=(int) (this.getId()-o.getId());
////			}
//		}
//		
//		
//		return compare;
//		
//	}

	

//	@Override
//	public String getReadQuery() {
//		
//		StringBuilderQuery query = new StringBuilderQuery("select * from " + getTable() + " where id=?");
//		query.setValue(1, getId());
//				
//		return query.toString();
//	}
//
//	@Override
//	public String getReadAllQuery() {
//		StringBuilderQuery query = new StringBuilderQuery("select * from " + getTable() + "");
////		query.setTable(1, getTable());
//				
//		return query.toString();
//	}

	public boolean contains(DescrizioneTrasporto elem) {
		return (getDescrizione().toLowerCase().indexOf(elem.getDescrizione().toLowerCase())>=0) ? true : false;
	}
	
	@Override
	public int compareTo(DTOBase o) {
//		=0: le stringhe sono uguali
//		>0: o < this
//		<0: o > this
	
		DescrizioneTrasporto n = (DescrizioneTrasporto) o;
		int compare=0;
		
		compare=getDescrizione().toLowerCase().compareTo(n.getDescrizione().toLowerCase());
		if (compare==0){
			compare=super.compareTo(o);
		}
		
		return compare;
	}

//	@Override
//	public String getDeleteQuery() {
//		
////		StringBuilderQuery query = new StringBuilderQuery("update ? set stato=? where id=?");
////		query.setTable(1, getTable());
//////		query.append(getTable());
////		
////		query.setValue(2, 2);
////		//1: attivo
////		//2: annullato
////		
////		query.setValue(3, getId());
//////		query.append(getId());
////				
////		return query.toString();
//		return null;
//	}


}