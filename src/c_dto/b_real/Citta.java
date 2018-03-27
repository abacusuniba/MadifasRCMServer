package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import c_dto.c_enum.Stato;
import d_utils.StringBuilderQuery;

public class Citta extends Primary{
	
	public Citta() {
//		setTable("citta");
	}
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private Provincia provincia;

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		
//		return getNome() + " " + getProvincia().toString();
		return getNome();

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

	public boolean contains(Citta elem) {
//		return (getNome().toLowerCase().indexOf(elem.getNome())+getSigla().toLowerCase().indexOf(elem.getSigla())>=0) ? true : false;
		return (getNome().toLowerCase().indexOf(elem.getNome().toLowerCase())>=0) ? true : false;
	}
	
	@Override
	public int compareTo(DTOBase o) {
		Citta n = (Citta) o;
		int res = getNome().compareTo(n.getNome());// + super.compareTo(o);
		
		return res;
	}
//	@Override
//	public String getDeleteQuery() {
//		// TODO Auto-generated method stub
//		return null;
//	}


}