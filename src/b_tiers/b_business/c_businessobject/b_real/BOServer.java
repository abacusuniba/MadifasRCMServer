package b_tiers.b_business.c_businessobject.b_real;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.jgroups.stack.IpAddress;

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
import c_dto.b_real.Server;
import c_dto.b_real.Altro;
import c_dto.c_enum.Stato;
import c_dto.c_enum.TipoAzienda;
import d_utils.StringBuilderQuery;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;


public class BOServer extends Thread{
	
	
	private class IPSniffer extends Thread{
		
		String ipAddr;
		
		public IPSniffer(String ipAddress) {
			ipAddr=ipAddress;
			
			
			
			
			start();
		}
		
		@Override
		public void run() {
//			try {
				
			SmbFile[] directories=null;
				String serverName="smb:" + File.separator + File.separator;
				try {
					directories = new SmbFile(serverName).listFiles();
				} catch (SmbException | MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for (SmbFile host: directories) {
//					System.out.println(host);
					
					
					
//					String[] subs = host.list();
//					System.out.println(subs);
					
					SmbFile[] subDirs;
					try {
						subDirs = host.listFiles();
						System.out.println(host);

						for (SmbFile sub: subDirs) {
							System.out.println(sub);
							
							
						}
					} catch (SmbException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
					}
				}
				
				
				
				
//			
//				
//				
////				for (int i=1;i<255;i++) {
//						InetAddress addrWiFi = InetAddress.getByName(ipAddr);
//						if (addrWiFi.isReachable(2000)) {
//							Server srv = new Server();
//							srv.setServerIP(addrWiFi.getHostAddress());
//							srv.setServerName(addrWiFi.getHostName());
//							ipServers.add(srv);
////							System.out.println(addrWiFi.getHostAddress() + ": " + addrWiFi.getHostName());
//						}
////						System.out.print(addrWiFi.getHostAddress() + ":" + addrWiFi.isReachable(150));
////				}
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
		}
		
	}
	
	
	
	private static final ArrayList<DTOBase> ipServers = new ArrayList<>();
	
	
	
	@Override
	public void run() {
		
		NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, "gestionale", "gestionale");
		
////		try {
//		for (int i=1;i<255;i++) {
//			
//			new IPSniffer("192.168.1." + i);
//			
//			
////				InetAddress addrWiFi = InetAddress.getByName("192.168.1." + i);
////				if (addrWiFi.isReachable(500)) {
////					Server srv = new Server();
////					srv.setServerIP(addrWiFi.getHostAddress());
////					srv.setServerName(addrWiFi.getHostName());
////					ipServers.add(srv);
//////					System.out.println(addrWiFi.getHostAddress() + ": " + addrWiFi.getHostName());
////				}
////				System.out.print(addrWiFi.getHostAddress() + ":" + addrWiFi.isReachable(150));
//		}
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
		
		System.setProperty("jcifs.smb.client.responseTimeout", "330000");
//		System.setProperty("jcifs.util.loglevel", "10");
				
				
		SmbFile[] directories=null;
		String serverName="cifs:" + File.separator + File.separator;
//		String serverName="smb:\\\\";
		try {
			directories = new SmbFile(serverName,auth).listFiles();
//			directories = new SmbFile(serverName).listFiles();
		} catch (SmbException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (SmbFile host: directories) {
//			System.out.println(host);
			
			
			
//			String[] subs = host.list();
//			System.out.println(subs);
			
			SmbFile[] subDirs;
			try {
				subDirs = host.listFiles();
//				System.out.println(host);

				for (SmbFile sub: subDirs) {
//					Server srv = new Server(sub);
					Server srv = new Server(sub.toString());
					
					for (SmbFile folder : sub.listFiles()) {
						try {
							folder.listFiles();
							
							if (folder.isDirectory()) {
////								srv.addFolder(folder.toString());
//								srv.addFolder(folder);
								srv.addFolder(new Server(folder.toString()));
								
							}
							
						} catch(SmbException subEX) {
//							System.out.print("");
							
						}
						
						
						
					}
					ipServers.add(srv);
					
//					sub.listFiles();
//					System.out.println(" -- " + sub);
					
					
				}
			} catch (SmbException e) {
//				e.printStackTrace();
//////				// TODO Auto-generated catch block
////////				e.printStackTrace();
//////				SmbFile[] directories2=null;
//////				String serverName2=File.separator + File.separator;
//////				try {
//////					directories2 = new SmbFile(serverName2).listFiles();
//////				} catch (SmbException | MalformedURLException e2) {
//////					// TODO Auto-generated catch block
////					e.printStackTrace();
//////				}
//				
//				System.out.println("----------");
//				SmbFile[] directories2=null;
//				String serverName2="cifs:" + File.separator + File.separator;
////				String serverName="smb:\\\\";
//				try {
//					directories2 = new SmbFile(serverName2).listFiles();
//				} catch (SmbException | MalformedURLException e2) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				
//				for (SmbFile host2: directories2) {
////					System.out.println(host);
//					
//					
//					
////					String[] subs = host.list();
////					System.out.println(subs);
//					
//					SmbFile[] subDirs2;
//					try {
//						subDirs2 = host2.listFiles();
//						System.out.println(host2);
//
//						for (SmbFile subx: subDirs2) {
//							System.out.println(" -- " + subx);
//							
//							
//						}
//					} catch (SmbException e3) {
////////						// TODO Auto-generated catch block
//////////						e.printStackTrace();
////////						SmbFile[] directories2=null;
////////						String serverName2=File.separator + File.separator;
////////						try {
////////							directories2 = new SmbFile(serverName2).listFiles();
////////						} catch (SmbException | MalformedURLException e2) {
////////							// TODO Auto-generated catch block
////							e.printStackTrace();
////////						}
//						
//				}
//				
//			}
				
				
			}
		}
		
		

	}
	
	
	
	
	public BOServer() {
		start();
//		System.out.print("");
//		startMemory();
////		
//////		StringBuilderQuery q = new StringBuilderQuery("select id, nome from azienda where stato=1 and idtipo=?;");
////		StringBuilderQuery q = new StringBuilderQuery("select id, nome, secondonome, piva, codfisc, stato from azienda where idtipo=?;");
////		q.setValue(1, TipoAzienda.fromName(TipoAzienda.Altro));
////		
//////		String query = "select id, nome from azienda where stato=1 and idtipo=?;";
////		ResultSet rs = DAO.executeQuery(q.toString());
////		
////		try {
////			while(rs.next()){
////				Altro n = new Altro();
////				n.setId(rs.getInt("id"));
////				n.setNome(rs.getString("nome"));
////				n.setSecondoNome(rs.getString("secondonome"));
////				n.setPartitaIva(rs.getString("piva"));
////				n.setCodiceFiscale(rs.getString("codfisc"));
////				n.setStato(Stato.fromValue(rs.getInt("stato")));
////				
////				
////				StringBuilderQuery subQuery = new StringBuilderQuery("select id, note from noteazienda where idazienda=?;");
////				subQuery.setValue(1, n.getId());
////				ResultSet rs2 = DAO.executeQuery(subQuery.toString());
//////				n.setNote(new ArrayList<>());
////				while(rs2.next()){
////					NoteAzienda nota = new NoteAzienda();
////					nota.setId(rs2.getInt("id"));
////					nota.setNote(rs2.getString("note"));
////					n.getNote().add(nota);
////				}
////				rs2.close();
////				
////				
//////				subQuery= new StringBuilderQuery("select contatto.id as id, nome, cognome, ruolo.id as id_ruolo, ruolo from contatto, ruolo where idazienda=? and ruolo.id=idruolo;");
////				subQuery= new StringBuilderQuery("select id, nome, cognome from contatto where idazienda=?;");
////				subQuery.setValue(1, n.getId());
////				rs2 = DAO.executeQuery(subQuery.toString());
//////				n.setRiferimenti(new ArrayList<>());
////				while(rs2.next()){
////					Riferimento rif = new Riferimento();
////					rif.setId(rs2.getInt("id"));
////					rif.setNome(rs2.getString("nome"));
////					rif.setCognome(rs2.getString("cognome"));
////					
////					subQuery = new StringBuilderQuery("select id, note from elenconote where idcontatto=?;");
////					subQuery.setValue(1, rif.getId());
////					ResultSet rs3 = DAO.executeQuery(subQuery.toString());
//////					rif.setNote(new ArrayList<>());
////					while(rs3.next()){
////						NoteContatto notac = new NoteContatto();
////						notac.setId(rs3.getInt("id"));
////						notac.setNote(rs3.getString("note"));
////						rif.getNote().add(notac);
////					}
////					rs3.close();
////					
////					
////					
////					
////					n.getRiferimenti().add(rif);
////				}
////				
////				
////				
////				
////				addElement(n);
////			}
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
	}




	public ArrayList<DTOBase> readAll() {
		// TODO Auto-generated method stub
		return ipServers;
	}




	public ArrayList<DTOBase> readAll(Server n) {
		
		ArrayList<DTOBase> ipServersSub = new ArrayList<>();
		NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, "gestionale", "gestionale");
		
////	try {
//	for (int i=1;i<255;i++) {
//		
//		new IPSniffer("192.168.1." + i);
//		
//		
////			InetAddress addrWiFi = InetAddress.getByName("192.168.1." + i);
////			if (addrWiFi.isReachable(500)) {
////				Server srv = new Server();
////				srv.setServerIP(addrWiFi.getHostAddress());
////				srv.setServerName(addrWiFi.getHostName());
////				ipServers.add(srv);
//////				System.out.println(addrWiFi.getHostAddress() + ": " + addrWiFi.getHostName());
////			}
////			System.out.print(addrWiFi.getHostAddress() + ":" + addrWiFi.isReachable(150));
//	}
////	} catch (IOException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	}
	
//	System.setProperty("jcifs.smb.client.responseTimeout", "330000");
//	System.setProperty("jcifs.util.loglevel", "10");
			
			
	SmbFile[] directories=null;
//	String serverName="cifs:" + File.separator + File.separator;
	String serverName=n.getServerName();
	try {
		directories = new SmbFile(serverName,auth).listFiles();
//		directories = new SmbFile(serverName).listFiles();
	} catch (SmbException | MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	for (SmbFile host: directories) {
//		System.out.println(host);
		
		
		
//		String[] subs = host.list();
//		System.out.println(subs);
		
		SmbFile[] subDirs;
		try {
			subDirs = host.listFiles();
//			System.out.println(host);
			Server host2 = new Server(host.toString());

			ipServersSub.add(host2);

//			for (SmbFile sub: subDirs) {
////				Server srv = new Server(sub);
//				Server srv = null;
//				System.out.print("");
//				if (sub.isDirectory())
//				srv = new Server(sub.toString());
//				
////				for (SmbFile folder : sub.listFiles()) {
////					try {
////						folder.listFiles();
////						
////						if (folder.isDirectory()) {
////////							srv.addFolder(folder.toString());
//////							srv.addFolder(folder);
////							srv.addFolder(new Server(folder.toString()));
////							
////						}
////						
////					} catch(SmbException subEX) {
//////						System.out.print("");
////						
////					}
////					
////					
////					
////				}
//				ipServersSub.add(srv);
//				
////				sub.listFiles();
////				System.out.println(" -- " + sub);
//				
//				
//			}
		} catch (SmbException e) {
			
			
		}
	}
	
	
	return ipServersSub;
	
	
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
