package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

import java.util.ArrayList;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import c_dto.c_enum.Stato;
import d_utils.StringBuilderQuery;

public class Layout extends Primary{
	
	
//	private String root;
//	ArrayList<Rettangolo> lista = new ArrayList<>();
	
	private int pxlwidth;
	private int pxlheight ;
	private String nome ;

	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPxlWidth() {
		return pxlwidth;
	}

	public void setPxlWidth(int pxlWidth) {
		this.pxlwidth = pxlWidth;
	}

	public int getPxlHeight() {
		return pxlheight;
	}

	public void setPxlHeight(int pxlHeight) {
		this.pxlheight = pxlHeight;
	}

	ArrayList<RettangoloPDF> listarect = new ArrayList<>();
	ArrayList<RettangoloPDFText> listatesto = new ArrayList<>();
	
//	double x;
//	double y;
//	double width;
//	double height;
//	String titolo;
	
	
	
	
	
//	public double getX() {
//		return x;
//	}
//
//	public void setX(double x) {
//		this.x = x;
//	}
//
//	public double getY() {
//		return y;
//	}
//
//	public void setY(double y) {
//		this.y = y;
//	}
//
//	public double getWidth() {
//		return width;
//	}
//
//	public void setWidth(double width) {
//		this.width = width;
//	}
//
//	public double getHeight() {
//		return height;
//	}
//
//	public void setHeight(double height) {
//		this.height = height;
//	}
//
//	public String getTitolo() {
//		return titolo;
//	}
//
//	public void setTitolo(String titolo) {
//		this.titolo = titolo;
//	}

	public Layout() {
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

//	public ArrayList<RettangoloPDF> getLista() {
//		return lista;
//	}
//
//	public void setLista(ArrayList<RettangoloPDF> lista) {
//		this.lista = lista;
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

	public ArrayList<RettangoloPDF> getListaRect() {
		return listarect;
	}

	public void setListaRect(ArrayList<RettangoloPDF> listaRect) {
		this.listarect = listaRect;
	}

	public ArrayList<RettangoloPDFText> getListaTesto() {
		return listatesto;
	}

	public void setListaTesto(ArrayList<RettangoloPDFText> listaTesto) {
		this.listatesto = listaTesto;
	}

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

	public boolean contains(Layout elem) {
		return (getNome().toLowerCase().indexOf(elem.getNome().toLowerCase())>=0) ? true : false;
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
	
	@Override
		public String toString() {
		return getNome();

		}


}