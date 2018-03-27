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
import c_dto.b_real.Citta;
import c_dto.b_real.Provincia;
import c_dto.c_enum.Stato;


public class BOCitta extends NewBOBase<Citta>{
	
	
	public BOCitta() {
		startMemory();
		
//		String query = "select id, nome, stato from Citta";// where stato=1;";
//		ResultSet rs = DAO.executeQuery(query);
//		
//		try {
//			while(rs.next()){
//				Citta n = new Citta();
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
//		Citta n = (Citta) o;
//		n.setStato(Stato.Attivo);
//		DAO.create(n);
//		addElement(n);
//	}

//	@Override
//	public void read(DTOBase o) {
////		BOProvincia naz = new BOProvincia();
//		Citta m = (Citta) getMemory().get(o.getId());
//		Citta n=(Citta) o;
//		n.setProvincia(new Provincia());
//		
//		if (m.isEmpty()){
//			ResultSet rs =DAO.read(m);
//			try {
//				rs.next();
//				n.setNome(rs.getString("nome"));
//				n.setStato(Stato.fromValue(rs.getInt("stato")));
//				n.getProvincia().setId(rs.getInt("idprovincia"));
//				n.setStato(Stato.fromValue(rs.getInt("stato")));
////				naz.read(n.getProvincia());
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		else{
//			n.setNome(m.getNome());
//			n.setStato(m.getStato());
//			n.setProvincia(m.getProvincia());
//			n.setStato(m.getStato());
//		}
//	}

//	@Override
//	public ArrayList<? extends DTOBase> readAll() {
//		ArrayList<Citta> lista=new ArrayList<>();
//		
//		Iterator<Entry<Long, DTOBase>> it = getMemory().entrySet().iterator();
//		
//		while(it.hasNext()){
//			Citta n = (Citta) it.next().getValue();
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
//		Citta n=(Citta) o;
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
