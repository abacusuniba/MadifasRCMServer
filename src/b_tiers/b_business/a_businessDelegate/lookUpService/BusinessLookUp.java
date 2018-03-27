package b_tiers.b_business.a_businessDelegate.lookUpService;

//import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.util.HashMap;
import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import a_main.RCMException;
import c_dto.b_real.Utente;

public class BusinessLookUp {
//	private HashMap<ServiceType, String> serviceMap;
	private SAXBuilder builder;
	private Document document;
	private File services;
	private Element rootNode;
	
	public BusinessLookUp(){
		try {
			
			//inizializzo gli oggetti per la lettura dei dati dall'XML
//////			services = new File("src\\b_tiers\\b_business\\a_businessDelegate\\lookUpService\\services.xml");
////			services = new File("res\\services.xml");
//			services = new File("/src/b_tiers/b_business/a_businessDelegate/lookUpService/services.xml");
			
			InputStream inputStreamFile = this.getClass().getResourceAsStream("/services.xml");
//			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStreamFile));
//        	URL url = 	getClass().getResource("services.xml");
//        	try {
//				services = new File(url.toURI());
//			} catch (URISyntaxException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			builder= new SAXBuilder();
//			document= builder.build(services);
			document= builder.build(inputStreamFile);
			rootNode=null;
		}
		catch (JDOMException | IOException e) {
			RCMException.showException(e);
		}
	}
	
	public BusinessService findService(Utente user){
		BusinessService serv=null;
		String className="";
		String servicePath="";
		
		rootNode = document.getRootElement();
		
		servicePath+=rootNode.getAttributeValue("package") + rootNode.getAttributeValue("prefix");		
		
		
		try{
			boolean find=false;
			
			className=user.getClass().getSimpleName();
			
			//seleziona l'application service pi� appropriato da utilizzare
			Iterator<Element> it = rootNode.getChildren().iterator();
			
			while (it.hasNext() && find==false){
				Element elem = it.next();
				if (className.toLowerCase().equals(elem.getAttributeValue("class"))){
					find=true;
					servicePath+=className;
				}
			}
		}
		catch(NullPointerException e){
			servicePath+=rootNode.getAttributeValue("default");		
		}

		//effettua il caricamento dell'application service trovato
		try {
			serv = (BusinessService) Class.forName(servicePath).newInstance();
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			RCMException.showException(e);
		}
		
		return serv;
	}
	
}