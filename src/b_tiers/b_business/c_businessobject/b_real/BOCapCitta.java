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
import c_dto.b_real.CAP;
import c_dto.b_real.CAPCitta;
import c_dto.b_real.Citta;
import c_dto.c_enum.Stato;

public class BOCapCitta extends NewBOBase<CAPCitta>{
	
	
	public BOCapCitta() {
		startMemory();
//		
//		String query = "select * from capcitta;";
//		ResultSet rs = DAO.executeQuery(query);
//		
//		try {
//			while(rs.next()){
//				CAPCitta n = new CAPCitta();
//				CAP cap = new CAP();
//				cap.setId(rs.getLong("idcap"));
////				BOCap busCap = new BOCap();
////				busCap.read(cap);
//				
//				Citta citta = new Citta();
//				citta.setId(rs.getLong("idcitta"));
////				BOCitta busCitta = new BOCitta();
////				busCitta.read(citta);
//				
//				
//				n.setId(rs.getInt("id"));
//				n.setCap(cap);
//				n.setCitta(citta);
//				
//				addElement(n);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
//	@Override
//	public void create(DTOBase o) {
//		CAPCitta n = (CAPCitta) o;
//		n.setStato(Stato.Attivo);
//		DAO.create(n);
//		addElement(n);
//	}

//	@Override
//	public void read(DTOBase o) {
//		CAPCitta m = (CAPCitta) getMemory().get(o.getId());
//		CAPCitta n=(CAPCitta) o;
//		
//		if (m.isEmpty()){
//			ResultSet rs =DAO.read(m);
//			try {
//				rs.next();
//				CAP cap = new CAP();
//				cap.setId(rs.getLong("idcap"));
//				BOCap busCap = new BOCap();
//				busCap.read(cap);
//				
//				Citta citta = new Citta();
//				citta.setId(rs.getLong("idcitta"));
//				BOCitta busCitta = new BOCitta();
//				busCitta.read(citta);
//				
//				
//				n.setId(rs.getInt("id"));
//				n.setCap(cap);
//				n.setCitta(citta);
////				n.setStato(Stato.fromValue(rs.getInt("stato")));
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		else{
//			n.setCap(m.getCap());
//			n.setCitta(m.getCitta());
////			n.setStato(m.getStato());
//		}
//	}

//	@Override
//	public ArrayList<? extends DTOBase> readAll() {
//		ArrayList<CAPCitta> lista=new ArrayList<>();
//		
//		Iterator<Entry<Long, DTOBase>> it = getMemory().entrySet().iterator();
//		
//		while(it.hasNext()){
//			CAPCitta n = (CAPCitta) it.next().getValue();
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
