package c_dto.b_real;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import d_utils.StringBuilderQuery;

public class CAP extends Primary{
	
	
	public CAP() {
//		setTable("cap");
	}
	
	private String cap;

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}
	
	@Override
	public String toString() {
		return getCap();
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

	@Override
	public int compareTo(DTOBase o) {
		CAP n = (CAP) o;
		int res = getCap().compareTo(n.getCap());// + super.compareTo(o);
		
		return res;
	}
	public boolean contains(CAP elem) {
//		return (getNome().toLowerCase().indexOf(elem.getNome())+getSigla().toLowerCase().indexOf(elem.getSigla())>=0) ? true : false;
		return (getCap().toLowerCase().indexOf(elem.getCap().toLowerCase())>=0) ? true : false;
	}

//	@Override
//	public String getDeleteQuery() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}