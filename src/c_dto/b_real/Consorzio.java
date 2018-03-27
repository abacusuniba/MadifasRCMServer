package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import c_dto.c_enum.Stato;
import d_utils.StringBuilderQuery;

public class Consorzio extends Primary{
	
	public Consorzio() {
//		setTable("consorzio");
	}
	
	private String nome;
//	private Stato stato;
//	
//	
//	public Stato getStato() {
//		return stato;
//	}
//
//	public void setStato(Stato stato) {
//		this.stato = stato;
//	}
	
//	public Nazione() {
//		setTable("nazione");
//	}

	
//	private Stato stato;
//	
//	public Stato getStato() {
//		return stato;
//	}
//
//	public void setStato(Stato stato) {
//		this.stato = stato;
//	}

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

	@Override
	public int compareTo(DTOBase o) {
		Consorzio n = (Consorzio) o;
//		
		int res = getNome().compareTo(n.getNome());// + super.compareTo(o);
		
		return res;
	}
	public boolean contains(Consorzio elem) {
		
	String thisNome = getNome().replace(".", "").toLowerCase();
			
	
	String thatNome = elem.getNome().replace(".", "").toLowerCase();
//	return (getNome().toLowerCase().indexOf(elem.getNome())+getSigla().toLowerCase().indexOf(elem.getSigla())>=0) ? true : false;
	return (thisNome.indexOf(thatNome)>=0) ? true : false;
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