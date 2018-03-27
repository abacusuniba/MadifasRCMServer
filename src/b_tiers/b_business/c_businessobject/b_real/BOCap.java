package b_tiers.b_business.c_businessobject.b_real;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import b_tiers.b_business.c_businessobject.a_abstract.NewBOBase;
import b_tiers.c_integration.a_dao.DAO;
import c_dto.a_abstract.DTOBase;
import c_dto.b_real.CAP;
import c_dto.c_enum.Stato;


public class BOCap extends NewBOBase<CAP>{
	
	
	public BOCap() {
		startMemory();
		
//////		String query = "select id, nome from cap";// where stato=1;";
////		String query = "select id, nome, stato from cap;";
//		String query = "select id, nome from cap;";
//		ResultSet rs = DAO.executeQuery(query);
//		
//		try {
//			while(rs.next()){
//				CAP n = new CAP();
//				n.setId(rs.getInt("id"));
//				n.setCap(rs.getString("nome"));
////				n.setStato(Stato.fromValue(rs.getInt("stato")));
//				addElement(n);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
//	@Override
//	public void create(DTOBase o) {
//		CAP n = (CAP) o;
//		n.setStato(Stato.Attivo);
//		DAO.create(n);
//		addElement(n);
//	}

//	@Override
//	public void read(DTOBase o) {
//		CAP m = (CAP) getMemory().get(o.getId());
//		CAP n=(CAP) o;
//		
//		if (m.isEmpty()){
//			ResultSet rs =DAO.read(m);
//			try {
//				rs.next();
//				n.setCap(rs.getString("nome"));
////				n.setStato(Stato.fromValue(rs.getInt("stato")));
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		else{
//			n.setCap(m.getCap());
////			n.setStato(m.getStato());
//		}
//	}
//	public /**/final/**/ ArrayList<DTOBase> readAll(){
//		ArrayList<DTOBase> lista=new ArrayList<>();
//		
//		Iterator<Entry<Long, DTOBase>> it = getMemory().entrySet().iterator();
//		
//		while(it.hasNext()){
//			DTOBase n = it.next().getValue();
////			if (n.getStato()==Stato.Attivo)
//			lista.add(n);
//		}
//		
//		Collections.sort(lista);
//		
//		return lista;
//	}

//	@Override
//	public ArrayList<? extends DTOBase> readAll() {
//		ArrayList<CAP> lista=new ArrayList<>();
//		
//		Iterator<Entry<Long, DTOBase>> it = getMemory().entrySet().iterator();
//		
//		while(it.hasNext()){
//			CAP n = (CAP) it.next().getValue();
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
//		System.out.println("Cancellazione disabilitata per i CAP");
//		
////		CAP n=(CAP) o;
////		n.setStato(Stato.Archiviato);
////		removeElement(n);
////		
////		DAO.update(o);
//	}
	
}
