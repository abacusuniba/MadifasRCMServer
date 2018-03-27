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
import c_dto.b_real.CAPCitta;
import c_dto.b_real.Citta;
//import c_dto.b_real.CAP;
//import c_dto.b_real.CAPCitta;
//import c_dto.b_real.Citta;
import c_dto.b_real.Indirizzo_old;
import c_dto.b_real.Strada;
import c_dto.c_enum.Stato;
import d_utils.StringBuilderQuery;

public class BOIndirizzo extends NewBOBase<Indirizzo_old>{
	
	
	public BOIndirizzo() {
		startMemory();
		
//		String query = "select * from indcivico;";
//		ResultSet rs = DAO.executeQuery(query);
//		
//		try {
//			while(rs.next()){
//				Indirizzo n = new Indirizzo();
////				n.setStato(Stato.fromValue(rs.getInt("stato")));
//				
//				Civico civico = new Civico();
//				civico.setId(rs.getLong("idcivico"));
////				BOCivico busCivico = new BOCivico();
////				busCivico.read(civico);
//				
//				Strada strada = new Strada();
//				strada.setId(rs.getLong("idindirizzo"));
////				BOStrada busStrada = new BOStrada();
////				busStrada.read(strada);
//				n.setCivico(civico);
//				n.setStrada(strada);
//				
//				
//				n.setId(rs.getInt("id"));
//				
//				
//				StringBuilderQuery q = new StringBuilderQuery("select * from civico where id=?;");
//				q.setValue(1, civico.getId());
//				ResultSet rs2 = DAO.executeQuery(q.toString());
//				rs2.next();
//					civico.setNumero(rs2.getString("civico"));
//				rs2.close();
//				
//				
//				q = new StringBuilderQuery("select * from indirizzo where id=?;");
//				q.setValue(1, strada.getId());
//				rs2 = DAO.executeQuery(q.toString());
//				rs2.next();{
//					strada.setNome(rs2.getString("indirizzo"));
//					
//					CAPCitta capCitta = new CAPCitta();
//					capCitta.setId(rs2.getLong("idcap"));
//					strada.setCap(capCitta);
//					
//					q = new StringBuilderQuery("select cap.id as idcap, cap.nome as cap, citta.id as idcitta, idprovincia, citta.nome as citta, stato from cap, citta, capcitta where capcitta.id=? and cap.id=capcitta.idcap and capcitta.idcitta=citta.id;");
//					q.setValue(1, capCitta.getId());
//					ResultSet rs3 = DAO.executeQuery(q.toString());
//					rs3.next();{
//						capCitta.setCap(new CAP());
//						capCitta.getCap().setId(rs3.getLong("idcap"));;
//						capCitta.getCap().setCap(rs3.getString("cap"));
//						
//						capCitta.setCitta(new Citta());
//						capCitta.getCitta().setId(rs3.getLong("idcitta"));
//						capCitta.getCitta().setNome(rs3.getString("citta"));
//					}
//					rs3.close();
//				}
//				rs2.close();
//				
//				
//				
////					strada.setNome(rs2.getString("indirizzo"));
////					strada.setCap(new CAPCitta());
////					strada.getCap().setId(rs2.getLong("idcap"));
////					
////					q = new StringBuilderQuery("select * from capcitta where id=?;");
////					q.setValue(1, strada.getCap().getId());
////					ResultSet rs3 = DAO.executeQuery(q.toString());
////					rs3.next();
////						q = new StringBuilderQuery("select nome from cap where id=?;");
////						q.setValue(1, rs3.getLong("idcap"));
////						ResultSet rs4 = DAO.executeQuery(q.toString());
////						rs4.next();
////							strada.getCap().getCap().setCap(rs4.getString("nome"));
////						rs4.close();
////						
////						q = new StringBuilderQuery("select * from citta where id=?;");
////						q.setValue(1, rs3.getLong("idcitta"));
////						rs4 = DAO.executeQuery(q.toString());
////						rs4.next();
////							strada.getCap().getCitta().setNome(rs.getString("nome"));
////							strada.getCap().getCitta().setId(id);
////							
////						rs4.close();
////					rs3.close();
////				rs2.close();
//				
//				
//				
//				addElement(n);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		startMemory();
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
//		Indirizzo n = (Indirizzo) o;
////		n.setStato(Stato.Attivo);
//		DAO.create(n);
//		addElement(n);
//	}

//	@Override
//	public void read(DTOBase o) {
//		Indirizzo m = (Indirizzo) getMemory().get(o.getId());
//		Indirizzo n=(Indirizzo) o;
//		
//		if (m.isEmpty()){
//			ResultSet rs =DAO.read(m);
//			try {
//				rs.next();
//				Civico civico = new Civico();
//				civico.setId(rs.getLong("idcivico"));
//				BOCivico busCivico = new BOCivico();
//				busCivico.read(civico);
//				
//				Strada strada = new Strada();
//				strada.setId(rs.getLong("idcitta"));
//				BOStrada busStrada = new BOStrada();
//				busStrada.read(strada);
//
//				n.setId(rs.getInt("id"));
//				n.setCivico(civico);
//				n.setStrada(strada);
////				n.setStato(Stato.fromValue(rs.getInt("stato")));
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		else{
//			n.setCivico(m.getCivico());
//			n.setStrada(m.getStrada());
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
//		System.out.println("Cancellazione disabilitata");
//		
////		CAP n=(CAP) o;
////		n.setStato(Stato.Archiviato);
////		removeElement(n);
////		
////		DAO.update(o);
//	}
	
}
