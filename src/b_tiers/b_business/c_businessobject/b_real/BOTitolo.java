package b_tiers.b_business.c_businessobject.b_real;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import b_tiers.b_business.c_businessobject.a_abstract.NewBOBase;
import b_tiers.c_integration.a_dao.DAO;
import c_dto.a_abstract.DTOBase;
import c_dto.b_real.Titolo;
import c_dto.c_enum.Stato;


public class BOTitolo extends NewBOBase<Titolo>{
	
	
	public BOTitolo() {
		startMemory();
//		
////		String query = "select id, Titolo from Titolo";// where stato=1;";
//		String query = "select id, Titolo from Titolo;";
//		ResultSet rs = DAO.executeQuery(query);
//		
//		try {
//			while(rs.next()){
//				Titolo n = new Titolo();
//				n.setId(rs.getInt("id"));
//				n.setTitolo(rs.getString("Titolo"));
//				addElement(n);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
//	@Override
//	public void create(DTOBase o) {
//		Titolo n = (Titolo) o;
//		n.setStato(Stato.Attivo);
//		DAO.create(n);
//		addElement(n);
//	}

//	@Override
//	public void read(DTOBase o) {
//		Titolo m = (Titolo) getMemory().get(o.getId());
//		Titolo n=(Titolo) o;
//		
////		if (m.isEmpty()){
////			ResultSet rs =DAO.read(m);
////			try {
////				rs.next();
////				n.setNome(rs.getString("nome"));
////				n.setStato(Stato.fromValue(rs.getInt("stato")));
////			} catch (SQLException e) {
////				e.printStackTrace();
////			}
////		}
////		else{
//			n.setTitolo(m.getTitolo());
////			n.setStato(m.getStato());
////		}
//	}

//	@Override
//	public ArrayList<? extends DTOBase> readAll() {
//		ArrayList<Titolo> lista=new ArrayList<>();
//		
//		Iterator<Entry<Long, DTOBase>> it = getMemory().entrySet().iterator();
//		
//		while(it.hasNext()){
//			Titolo n = (Titolo) it.next().getValue();
//			lista.add(n);
//		}
//		
//		return lista;
//	}

//	@Override
//	public void update(DTOBase o) {
//		getMemory().put(o.getId(), o);
//		DAO.update(o);
//		
//		
////		DAO.create(n);
////		addElement(n);
//	}

//	@Override
//	public void delete(DTOBase o) {
//		Titolo n=(Titolo) o;
//		n.setStato(Stato.Archiviato);
////		removeElement(n);
//		
//		DAO.update(o);
//	}
	
//	
////	@Override
////	public void create(DTOBase o) {
////		DAO.create(o);
////	}
//	
//	public BOTitolo() {
//		newPreLoadMemory();
//	}
//	
//	
//	@Override
//	public void read(DTOBase o) {
//		ResultSet rs=null;// = DAO.read(o);
//		Titolo n=(Titolo) o;
//		
//		try {
//			rs.next();
//			n.setId(rs.getInt("id"));
//			n.setNome(rs.getString("nome"));
//			n.setStato(Stato.fromValue(rs.getInt("stato")));
////			putInMemory(n);
//		}
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public HashMap<Long, DTOBase> readAll() {
////		Titolo n= new Titolo();
////		HashMap<Long, DTOBase> list = DAO.getMemory(n.getClass());
////		if (list==null){
////			ResultSet rs = DAO.readAll(n);
//////			ArrayList<Titolo> lista = new ArrayList<>();
////			
////
////			try {
////				while(rs.next()){
////					n = new Titolo();
////					n.setId(rs.getInt("id"));
////					n.setNome(rs.getString("nome"));
////					n.setStato(Stato.fromValue(rs.getInt("stato")));
////					
//////					lista.add(n);
////					putInMemory(n);
////				}
////				list = DAO.getMemory(n.getClass());
////			} catch (SQLException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
////		
////		return list;
//		return null;
//	}
//
////	@Deprecated
////	@Override
////	protected HashMap<Long, DTOBase> preLoadMemory() {
////		ResultSet rs = DAO.readAll(getActualClass());
//////		ArrayList<Titolo> lista = new ArrayList<>();
////		Titolo n;
////
////		try {
////			while(rs.next()){
////				n = new Titolo();
////				n.setId(rs.getInt("id"));
////				n.setNome(rs.getString("nome"));
////				addElement(n);
//////				putInMemory(n);
////			}
//////			list = DAO.getMemory(n.getClass());
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		return getSwapMemory();
////	}
//
//	@Override
//	protected void newPreLoadMemory() {
//		ResultSet rs=null;// = DAO.loadDefault(getActualClass());
//		Titolo n=null;
//		
//		try {
//			while(rs.next()){
//				n = new Titolo();
//				n.setId(rs.getInt("id"));
//				n.setNome(rs.getString("nome"));
//				addItem(n);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//////		ResultSet rs = DAO.readAll(getActualClass());
////		
////		//ricavare l'elenco dei campi sulla base della classe
////		
////		
////		ResultSet rs = DAO.loadDefault(getActualClass());
//	}
//
////	@Override
////	public void update(DTOBase o) {
////		DAO.update(o);
////	}
////
////	@Override
////	public void delete(DTOBase o) {
////		Titolo n = (Titolo) o;
////		n.setStato(Stato.Archiviato);
////		DAO.update(o);
////	}
//	
}
