package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import c_dto.c_enum.Stato;
import d_utils.StringBuilderQuery;

public class Parametro extends Primary{
	
	
	
//	private String rootIPAddress;
	
	private String root;
	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	private String rootwin;
//	public String getRootIPAddress() {
//		return rootIPAddress;
//	}
//
//	public void setRootIPAddress(String rootIPAddress) {
//		this.rootIPAddress = rootIPAddress;
//	}

	private String rootUnix;
	private String rootSolaris;
	private String rootmac;
	
	public Parametro() {
//		setTable("nazione");
	}
	
//	private String nome;
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

//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
	
//	@Override
//	public String toString() {
//		return getNome();
//	}

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

//	public String getRoot() {
//		return root;
//	}
//
//	public void setRoot(String root) {
//		this.root = root;
//	}

	@Override
	public int compareTo(DTOBase o) {
//		=0: le stringhe sono uguali
//		>0: o < this
//		<0: o > this
	
//		Parametro n = (Parametro) o;
		int compare=0;
		
//		compare=getNome().toLowerCase().compareTo(n.getNome().toLowerCase());
//		if (compare==0){
//			compare=super.compareTo(o);
//		}
		
		return compare;
	}
 
	public String getRootWindows() {
//		return rootwin.replace("/", "\\");
		return rootwin;
	}

	public void setRootWindows(String rootWindows) {
//		this.rootwin = rootWindows.replace("\\", "/");
		this.rootwin = rootWindows;
	}

	public String getRootUnix() {
		return rootUnix;
	}

	public void setRootUnix(String rootUnix) {
		this.rootUnix = rootUnix;
	}

	public String getRootSolaris() {
		return rootSolaris;
	}

	public void setRootSolaris(String rootSolaris) {
		this.rootSolaris = rootSolaris;
	}

	public String getRootMac() {
		return rootmac;
	}

	public void setRootMac(String rootMac) {
		this.rootmac = rootMac;
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