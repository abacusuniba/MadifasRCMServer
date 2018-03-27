package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import c_dto.c_enum.Stato;
import d_utils.StringBuilderQuery;

public class Provincia extends Primary{

	public Provincia() {
//		setTable("provincia");
	}
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private String sigla;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	private Regione regione;

	public Regione getRegione() {
		return regione;
	}

	public void setRegione(Regione regione) {
		this.regione = regione;
	}

	@Override
	public String toString() {
////		return " (" + getNome() + ") - " + getRegione().getNazione().toString();
//		return " (" + getNome() + ") - " + getRegione().toString();
		return " (" + getNome() + ") - " + getSigla();

//		return " (" + getSigla()() + ") - " + getRegione().getNazione().toString();
	}


////	@ManyToOne
////    @JoinColumn(name="idtipo")
////	private TipoDocumento tipo;
//	public boolean contains(String s){
//		boolean contain=false;
//		
////		String stringForFilter = nome;
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
////		query.setTable(1, getTable());
//				
//		return query.toString();
//	}

	public boolean contains(Provincia elem) {
//		return (getNome().toLowerCase().indexOf(elem.getNome())+getSigla().toLowerCase().indexOf(elem.getSigla())>=0) ? true : false;
		return (getNome().toLowerCase().indexOf(elem.getNome().toLowerCase())>=0) ? true : false;
	}
	
	@Override
	public int compareTo(DTOBase o) {
		Provincia n = (Provincia) o;
		int res = getNome().compareTo(n.getNome());// + super.compareTo(o);
		
		return res;
	}

//	@Override
//	public String getDeleteQuery() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//@Override
//public int compareTo(Provincia o) {
//	
//	
//	//=0: le stringhe sono uguali
//	//>0: o < this
//	//<0: o > this
//	
//	int compare;
//	
//	compare=nome.toLowerCase().compareTo(o.getNome().toLowerCase());
//	
//	if (compare==0)
//	{
////		compare=this.getNome().toLowerCase().compareTo(o.getNome().toLowerCase());
////		if (compare==0)
////		{
//			compare=this.getId()-o.getId();
////		}
//	}
//	
//	
//	return compare;
//	
//}
//
//@Override
//public boolean isModified() {
//	// TODO Auto-generated method stub
//	return false;
//}
//
//@Override
//public boolean isEmpty() {
//	// TODO Auto-generated method stub
//	return false;
//}

}