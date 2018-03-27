package b_tiers.b_business.c_businessobject.b_real;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import b_tiers.b_business.c_businessobject.a_abstract.BaseNewBOBase;
import b_tiers.b_business.c_businessobject.a_abstract.NewBOBase;
import b_tiers.c_integration.a_dao.DAO;
import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import c_dto.b_real.Nazione;
import c_dto.b_real.NoteAzienda;
import c_dto.b_real.NoteContatto;
import c_dto.b_real.Parametro;
import c_dto.b_real.Riferimento;
import c_dto.b_real.Altro;
import c_dto.c_enum.Stato;
import c_dto.c_enum.TipoAzienda;
import d_utils.StringBuilderQuery;


public class BOParametro extends NewBOBase<Parametro>{
	
	
	public BOParametro() {
		startMemory();
//		
////		StringBuilderQuery q = new StringBuilderQuery("select id, nome from azienda where stato=1 and idtipo=?;");
//		StringBuilderQuery q = new StringBuilderQuery("select id, nome, secondonome, piva, codfisc, stato from azienda where idtipo=?;");
//		q.setValue(1, TipoAzienda.fromName(TipoAzienda.Altro));
//		
////		String query = "select id, nome from azienda where stato=1 and idtipo=?;";
//		ResultSet rs = DAO.executeQuery(q.toString());
//		
//		try {
//			while(rs.next()){
//				Altro n = new Altro();
//				n.setId(rs.getInt("id"));
//				n.setNome(rs.getString("nome"));
//				n.setSecondoNome(rs.getString("secondonome"));
//				n.setPartitaIva(rs.getString("piva"));
//				n.setCodiceFiscale(rs.getString("codfisc"));
//				n.setStato(Stato.fromValue(rs.getInt("stato")));
//				
//				
//				StringBuilderQuery subQuery = new StringBuilderQuery("select id, note from noteazienda where idazienda=?;");
//				subQuery.setValue(1, n.getId());
//				ResultSet rs2 = DAO.executeQuery(subQuery.toString());
////				n.setNote(new ArrayList<>());
//				while(rs2.next()){
//					NoteAzienda nota = new NoteAzienda();
//					nota.setId(rs2.getInt("id"));
//					nota.setNote(rs2.getString("note"));
//					n.getNote().add(nota);
//				}
//				rs2.close();
//				
//				
////				subQuery= new StringBuilderQuery("select contatto.id as id, nome, cognome, ruolo.id as id_ruolo, ruolo from contatto, ruolo where idazienda=? and ruolo.id=idruolo;");
//				subQuery= new StringBuilderQuery("select id, nome, cognome from contatto where idazienda=?;");
//				subQuery.setValue(1, n.getId());
//				rs2 = DAO.executeQuery(subQuery.toString());
////				n.setRiferimenti(new ArrayList<>());
//				while(rs2.next()){
//					Riferimento rif = new Riferimento();
//					rif.setId(rs2.getInt("id"));
//					rif.setNome(rs2.getString("nome"));
//					rif.setCognome(rs2.getString("cognome"));
//					
//					subQuery = new StringBuilderQuery("select id, note from elenconote where idcontatto=?;");
//					subQuery.setValue(1, rif.getId());
//					ResultSet rs3 = DAO.executeQuery(subQuery.toString());
////					rif.setNote(new ArrayList<>());
//					while(rs3.next()){
//						NoteContatto notac = new NoteContatto();
//						notac.setId(rs3.getInt("id"));
//						notac.setNote(rs3.getString("note"));
//						rif.getNote().add(notac);
//					}
//					rs3.close();
//					
//					
//					
//					
//					n.getRiferimenti().add(rif);
//				}
//				
//				
//				
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
//		Altro n = (Altro) o;
//		n.setStato(Stato.Attivo);
//		DAO.create(n);
//		
//		addElement(n);
//	}

//	@Override
//	public void read(DTOBase o) {
////		BONazione naz = new BONazione();
////		Altro m = (Altro) getMemory().get(o.getId());
////		Altro n=(Altro) o;
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
//		DAO.update(o);
//		
//		addElement(o);
//		
//	}

//	@Override
//	public void delete(DTOBase o) {
////		Altro n=(Altro) o;
////		n.setStato(Stato.Archiviato);
////		removeElement(n);
////		
////		DAO.update(o);
//	}
}
