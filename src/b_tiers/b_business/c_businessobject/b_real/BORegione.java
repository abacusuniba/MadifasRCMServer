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
import c_dto.b_real.Nazione;
import c_dto.b_real.Regione;
import c_dto.c_enum.Stato;


public class BORegione extends NewBOBase<Regione>{
	
	
	public BORegione() {
		startMemory();
		
//		String query = "select id, nome, stato from regione";// where stato=1;";
//		ResultSet rs = DAO.executeQuery(query);
//		
//		try {
//			while(rs.next()){
//				Regione n = new Regione();
//				n.setId(rs.getInt("id"));
//				n.setNome(rs.getString("nome"));
//				n.setStato(Stato.fromValue(rs.getInt("stato")));
//				addElement(n);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
//	@Override
//	public void create(DTOBase o) {
//		Regione n = (Regione) o;
//		n.setStato(Stato.Attivo);
//		DAO.create(n);
//		addElement(n);
//	}

//	@Override
//	public void read(DTOBase o) {
////		BONazione naz = new BONazione();
//		Regione m = (Regione) getMemory().get(o.getId());
//		Regione n=(Regione) o;
//		n.setNazione(new Nazione());
//		
//		if (m.isEmpty()){
//			ResultSet rs =DAO.read(m);
//			try {
//				rs.next();
//				n.setNome(rs.getString("nome"));
//				n.setStato(Stato.fromValue(rs.getInt("stato")));
//				n.getNazione().setId(rs.getInt("idnazione"));
////				naz.read(n.getNazione());
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		else{
//			n.setNome(m.getNome());
//			n.setStato(m.getStato());
//			n.setNazione(m.getNazione());
//		}
//	}

//	@Override
//	public ArrayList<? extends DTOBase> readAll() {
//		ArrayList<Regione> lista=new ArrayList<>();
//		
//		Iterator<Entry<Long, DTOBase>> it = getMemory().entrySet().iterator();
//		
//		while(it.hasNext()){
//			Regione n = (Regione) it.next().getValue();
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
//		Regione n=(Regione) o;
//		n.setStato(Stato.Archiviato);
////		removeElement(n);
//		
//		DAO.delete(o);
//	}
	
//	
////	@Override
////	public void create(DTOBase o) {
////		DAO.create(o);
////	}
//	
//	public BONazione() {
//		newPreLoadMemory();
//	}
//	
//	
//	@Override
//	public void read(DTOBase o) {
//		ResultSet rs=null;// = DAO.read(o);
//		Nazione n=(Nazione) o;
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
////		Nazione n= new Nazione();
////		HashMap<Long, DTOBase> list = DAO.getMemory(n.getClass());
////		if (list==null){
////			ResultSet rs = DAO.readAll(n);
//////			ArrayList<Nazione> lista = new ArrayList<>();
////			
////
////			try {
////				while(rs.next()){
////					n = new Nazione();
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
//////		ArrayList<Nazione> lista = new ArrayList<>();
////		Nazione n;
////
////		try {
////			while(rs.next()){
////				n = new Nazione();
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
//		Nazione n=null;
//		
//		try {
//			while(rs.next()){
//				n = new Nazione();
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
////		Nazione n = (Nazione) o;
////		n.setStato(Stato.Archiviato);
////		DAO.update(o);
////	}
//	
}
