package c_dto.b_real;

import java.io.File;
import java.util.ArrayList;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
//import jcifs.smb.SmbFile;

public class Server extends Primary{
	
//	SmbFile root;
	
	
	public Server(String string) {
		// TODO Auto-generated constructor stub
		setServerName(string); 
		
		String[] pieces =string.split("/"); 
		macServer="/Volumes/";
//		winServer="\\\\";
		winServer="";
		
		if (pieces.length>3) {
			for (int i=3; i<pieces.length;i++) {
				macServer+=pieces[i] + "/";
			}
			for (int i=3; i<pieces.length;i++) {
//				winServer+=pieces[i] + "\\";
				winServer+=pieces[i] + "/";
			}
		}
		
		
		
	}
	public String getWinServer() {
		return winServer;
	}
	public void setWinServer(String winServer) {
		this.winServer = winServer;
	}
	public Server() {
		serverName=null;
		macServer=null;
		winServer=null;
		
	}
public String getMacServer() {
		return macServer;
	}
	public void setMacServer(String macServer) {
		this.macServer = macServer;
	}
	//	public Server(SmbFile sub) {
//		// TODO Auto-generated constructor stub
//		root=sub;
//	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String[] name = getServerName().split("/");
		
		
		return name[name.length-1];
		
		
		
	}
	private String serverName;
	private String macServer;
	private String winServer;
//	private String serverShortName;
//	private String serverIP;
	
	ArrayList<Server> subFolders = new ArrayList<>();
//	ArrayList<SmbFile> subFolders2 = new ArrayList<>();
	
	public void addFolder(Server folder) {
		subFolders.add(folder);
	}
	public void removeFolder(Server folder) {
		subFolders.remove(folder);
	}
	
	
	public ArrayList<Server> getSubFolders() {
		return subFolders;
	}
	public String getServerName() {
		return serverName;
	}
//	public String getServerShortName() {
//		return serverShortName;
//	}
//	public void setServerShortName(String serverShortName) {
//		this.serverShortName = serverShortName;
//	}
	public void setServerName(String serverName) {
//		if (serverName!=null) {
//			System.out.print("");
//		}
		this.serverName = serverName;
//		if (serverName.indexOf('.')>-1)
//		this.serverShortName=serverName.split("\\.")[0]; 
//		else
//			this.serverShortName="_"; 
			
	}
//	public String getServerIP() {
//		return serverIP;
//	}
//	public void setServerIP(String serverIP) {
//		this.serverIP = serverIP;
//	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		boolean res = true;
		if (obj!=null) {
			Server ob = (Server) obj;
			
//			res =getServerName().equals(ob.getServerName()) && getServerIP().equals(ob.getServerIP());
			res =getServerName().equals(ob.getServerName());
		}
		
		return res;

	}

	
	
	@Override
	public int compareTo(DTOBase o) {
		Server n = (Server) o;
		int res = getServerName().compareTo(n.getServerName());// + super.compareTo(o);
		
		return res;
	}
////	public void addFolder(String string) {
////		// TODO Auto-generated method stub
////		
////	}
//	public void addFolder(SmbFile folder) {
//		// TODO Auto-generated method stub
//		subFolders2.add(folder);		
//	}
//	public void removeFolder(SmbFile folder) {
//		subFolders2.remove(folder);
//	}
	
}
