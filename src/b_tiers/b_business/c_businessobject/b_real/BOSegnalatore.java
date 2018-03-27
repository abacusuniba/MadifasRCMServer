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
import c_dto.b_real.Segnalatore;
import c_dto.c_enum.Stato;
import c_dto.c_enum.TipoAzienda;
import d_utils.StringBuilderQuery;


public class BOSegnalatore extends NewBOBase<Segnalatore>{
	
	
	public BOSegnalatore() {
		startMemory();
//		
//		StringBuilderQuery q = new StringBuilderQuery("select id, nome from azienda where stato=1 and idtipo=?;");
//		q.setValue(1, TipoAzienda.fromName(TipoAzienda.Segnalatore));
//		
////		String query = "select id, nome from azienda where stato=1 and idtipo=?;";
//		ResultSet rs = DAO.executeQuery(q.toString());
//		
//		try {
//			while(rs.next()){
//				Segnalatore n = new Segnalatore();
//				n.setId(rs.getInt("id"));
//				n.setNome(rs.getString("nome"));
//				addElement(n);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
//	@Override
//	public void create(DTOBase o) {
//		Segnalatore n = (Segnalatore) o;
//		n.setStato(Stato.Attivo);
//		DAO.create(n);
//		addElement(n);
//	}

//	@Override
//	public void read(DTOBase o) {
////		BONazione naz = new BONazione();
////		Segnalatore m = (Segnalatore) getMemory().get(o.getId());
////		Segnalatore n=(Segnalatore) o;
////		n.setNazione(new Nazione());
////		
////		if (m.isEmpty()){
////			ResultSet rs =DAO.read(m);
////			try {
////				rs.next();
////				n.setNome(rs.getString("nome"));
////				n.setStato(Stato.fromValue(rs.getInt("stato")));
////				n.getNazione().setId(rs.getInt("idnazione"));
////				naz.read(n.getNazione());
////			} catch (SQLException e) {
////				e.printStackTrace();
////			}
////		}
////		else{
////			n.setNome(m.getNome());
////			n.setStato(m.getStato());
////			n.setNazione(m.getNazione());
////		}
//	}

//	@Override
//	public void update(DTOBase o) {
////		getMemory().put(o.getId(), o);
////		DAO.update(o);
//	}

//	@Override
//	public void delete(DTOBase o) {
////		Segnalatore n=(Segnalatore) o;
////		n.setStato(Stato.Archiviato);
////		removeElement(n);
////		
////		DAO.update(o);
//	}
}
