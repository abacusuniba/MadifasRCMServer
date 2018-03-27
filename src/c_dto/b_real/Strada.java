package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import d_utils.StringBuilderQuery;

public class Strada extends Primary{
	
	public Strada() {
//		setTable("indirizzo");
	}
	
	private String nome;
	private String civico;
	
	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	private CAPCitta cap;
	



	public CAPCitta getCap() {
		return cap;
	}

	public void setCap(CAPCitta cap) {
		this.cap = cap;
	}

	@Override
	public String toString() {
////		//via pisa, 7 - 76125 Trani (BT) - Italia
////		
//		String s=/* /", " + getCivico().toString() + /**/" - " + getCapcitta().toString();
//		return s;
		return getNome() + ", " + getCivico() + "  -  " + getCap().toString();
	}

	public boolean contains(Strada elem) {
		String txt = cap.toString().toLowerCase() + getNome().toLowerCase();
		
		
		return (txt.indexOf(elem.getNome().toLowerCase())>=0) ? true : false;
	}
	
	
	
	@Override
	public int compareTo(DTOBase o) {
//		=0: le stringhe sono uguali
//		>0: o < this
//		<0: o > this
	
		Strada n = (Strada) o;
		int compare=0;
		
//		try{
			compare=getNome().toLowerCase().compareTo(n.getNome().toLowerCase());
//			compare+=getCodice().toLowerCase().compareTo(n.getCodice().toLowerCase());
			if (compare==0 && getCap()!=null){
				compare=getCap().compareTo(n.getCap());
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
//		// TODO Auto-generated method stub
//		return null;
//	}
}