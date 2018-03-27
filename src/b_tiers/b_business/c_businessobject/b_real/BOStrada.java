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
import c_dto.a_abstract.Primary;
import c_dto.b_real.Strada;

public class BOStrada extends NewBOBase<Strada>{
	
	
	public BOStrada() {
		startMemory();
//		
////		String query = "select id, nome from cap";// where stato=1;";
//		String query = "select id, indirizzo from indirizzo;";
//		ResultSet rs = DAO.executeQuery(query);
//		
//		try {
//			while(rs.next()){
//				Strada n = new Strada();
//				n.setId(rs.getInt("id"));
//				n.setNome(rs.getString("indirizzo"));
//				addElement(n);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
//	@Override
//	public void create(DTOBase o) {
//		Strada n = (Strada) o;
////		n.setStato(Stato.Attivo);
//		DAO.create(n);
//		addElement(n);
//	}

//	@Override
//	public void read(DTOBase o) {
//		Strada m = (Strada) getMemory().get(o.getId());
//		Strada n=(Strada) o;
//		
//		if (m.isEmpty()){
//			ResultSet rs =DAO.read(m);
//			try {
//				rs.next();
//				n.setNome(rs.getString("indirizzo"));
////				n.setStato(Stato.fromValue(rs.getInt("stato")));
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		else{
//			n.setNome(m.getNome());
////			n.setStato(m.getStato());
//		}
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
