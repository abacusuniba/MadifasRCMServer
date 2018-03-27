package b_tiers.b_business.c_businessobject.b_real;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import b_tiers.b_business.c_businessobject.a_abstract.NewBOBase;
import b_tiers.c_integration.a_dao.DAO;
import b_tiers.c_integration.b_filesystem.FS;
import c_dto.a_abstract.DTOBase;
import c_dto.b_real.Documento;
import c_dto.b_real.DocumentoSub;
import c_dto.b_real.Parametro;
import c_dto.c_enum.Stato;


public class BODocumento extends NewBOBase<Documento>{
	
	
	public BODocumento(Parametro rootFolder) {
		startMemory();
//		FS.setRootFolder(rootFolder.getRoot());
		
//		String query = "select id, numero, data from Documento";// where stato=1;";
//		ResultSet rs = DAO.executeQuery(query);
//		
//		try {
//			while(rs.next()){
//				Documento n = new Documento();
//				n.setId(rs.getInt("id"));
//				n.setNumero(rs.getString("numero"));
//				n.setData(rs.getString("data"));
//				addElement(n);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void creaPDF(Documento n) {
		FS.createPDF(n);

	}
	public void cancellaPDF(Documento n) {
		FS.deletePDF(n);

	}

	public void creaPDF(DocumentoSub n) {
		// TODO Auto-generated method stub
		FS.createPDF(n);
	}

	public void creaXLS(Documento n) {
		// TODO Auto-generated method stub
		FS.createXLS(n);
	}

	public void setRootDocument(DTOBase dtoBase) {
		// TODO Auto-generated method stub
		if (FS.getRootFolder()==null)
		FS.setRootFolder((Parametro)dtoBase);
		
	}
	
	
//	@Override
//	public void create(DTOBase o) {
//		Documento n = (Documento) o;
//		n.setStato(Stato.Attivo);
//		DAO.create(n);
//		addElement(n);
//	}

//	@Override
//	public void read(DTOBase o) {
//		Documento m = (Documento) getMemory().get(o.getId());
//		Documento n=(Documento) o;
//		
//////		if (m.isEmpty()){
//////			ResultSet rs =DAO.read(m);
//////			try {
//////				rs.next();
//////				n.setNome(rs.getString("nome"));
//////				n.setStato(Stato.fromValue(rs.getInt("stato")));
//////			} catch (SQLException e) {
//////				e.printStackTrace();
//////			}
//////		}
//////		else{
////			n.setNome(m.getNome());
//////			n.setStato(m.getStato());
//////		}
//	}

//	@Override
//	public ArrayList<? extends DTOBase> readAll() {
//		ArrayList<Documento> lista=new ArrayList<>();
//		
//		Iterator<Entry<Long, DTOBase>> it = getMemory().entrySet().iterator();
//		
//		while(it.hasNext()){
//			Documento n = (Documento) it.next().getValue();
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
//		Documento n=(Documento) o;
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
//	public BODocumento() {
//		newPreLoadMemory();
//	}
//	
//	
//	@Override
//	public void read(DTOBase o) {
//		ResultSet rs=null;// = DAO.read(o);
//		Documento n=(Documento) o;
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
////		Documento n= new Documento();
////		HashMap<Long, DTOBase> list = DAO.getMemory(n.getClass());
////		if (list==null){
////			ResultSet rs = DAO.readAll(n);
//////			ArrayList<Documento> lista = new ArrayList<>();
////			
////
////			try {
////				while(rs.next()){
////					n = new Documento();
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
//////		ArrayList<Documento> lista = new ArrayList<>();
////		Documento n;
////
////		try {
////			while(rs.next()){
////				n = new Documento();
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
//		Documento n=null;
//		
//		try {
//			while(rs.next()){
//				n = new Documento();
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
////		Documento n = (Documento) o;
////		n.setStato(Stato.Archiviato);
////		DAO.update(o);
////	}
//	
}
