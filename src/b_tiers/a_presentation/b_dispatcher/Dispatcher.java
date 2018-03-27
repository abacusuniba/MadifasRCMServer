package b_tiers.a_presentation.b_dispatcher;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Stack;

import b_tiers.a_presentation.b_dispatcher.forms.controller.CBase;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.scene.Node;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.sun.javafx.scene.control.skin.ListViewSkin;

import a_main.RCMException;
import c_dto.Command;
import c_dto.a_abstract.DTOBase;
import c_dto.b_real.Utente;
import b_tiers.b_business.a_businessDelegate.lookUpService.BusinessService;
import b_tiers.b_business.a_businessDelegate.lookUpService.ServiceType;

public class Dispatcher {
	
	
	private class CoupleValue{
		
		public CoupleValue(CoupleKey key) {
			stageController= key.stageController;
			subStages = new ArrayList<>();
//			object=null;
		}
		
//		public DTOBase object;
		public CBase stageController;
		public ArrayList<Stage> subStages;
		
		
//		@Override
//		public String toString() {
//			return "[" + stageController.toString() + " , " + subStages.toString() + "]";
//		}
		
	}
	private class CoupleKey	{
		
		public Stage stageForm;
		public CBase stageController;
		
	}
	
	
	private HashMap<String, String> mapForms;
	
	
//////	private Stack<Stage> stackForms;//rimuovere
////	private HashMap<Stage, Stack<Stage>> hashMapStage;
//	private HashMap<Stage, ArrayList<Stage>> hashMapStage;
	private HashMap<Stage, CoupleValue> newHashMapStage;
	
	
	
	public CBase getKey(Stage son){
		CBase fatherController=null;
		
		Iterator<Entry<Stage, CoupleValue>> it = newHashMapStage.entrySet().iterator();
		   boolean found = false;

		while (it.hasNext() && !found){
			Entry<Stage, CoupleValue> elem = it.next();
			if (elem.getValue().subStages.contains(son)){
				fatherController = elem.getValue().stageController;
				found=true;
			}
		}
		
		return fatherController;
	}
	
//	public Iterator<Entry<Stage, CoupleValue>> getStages() {
////	public Iterator<Entry<Stage, ArrayList<Stage>>> getStages() {
//		HashMap<Stage, ArrayList<Stage>> hashMapStage = new HashMap<>();
//		
//		Iterator<Entry<Stage, CoupleValue>> it = newHashMapStage.entrySet().iterator();
//		
//		while (it.hasNext())
//		{
//			Entry<Stage, CoupleValue> elem = it.next();
//			hashMapStage.put(elem.getKey(), elem.getValue().subStages);
//		}
//		
//////		newHashMapStage
////		return hashMapStage.entrySet().iterator();
//		return null;
//	}

	private static Stage keyStage;
	
	
	
	private SAXBuilder builder;
	private Document document;
	private File forms;
	private Element rootNode;
	private FXMLLoader loader;	
//	private CoupleKey stage;

	public Dispatcher(){
		try {
			//inizializzo gli oggetti per la lettura dei dati dall'XML
//////			forms = new File("src\\b_tiers\\a_presentation\\b_dispatcher\\forms.xml");
////			forms = new File("res\\forms.xml");
//			forms = new File("/src/b_tiers/a_presentation/b_dispatcher/forms.xml");
			InputStream inputStreamFile = this.getClass().getResourceAsStream("/forms.xml");
//			InputStream inputStreamFile = this.getClass().getResourceAsStream("//src/b_tiers/a_presentation/b_dispatcher/forms.xml");
//			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStreamFile));
			
//        	URL url = 	getClass().getResource("forms.xml");
//        	try {
//				forms = new File(url.toURI());
//			} catch (URISyntaxException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			builder= new SAXBuilder();
//			document= builder.build(forms);
			document= builder.build(inputStreamFile);
			rootNode=null;
			
			mapForms=null;
			
			
//			mapForms = new HashMap<>();
//			stackForms = new Stack<>();
			
			
		} catch (JDOMException | IOException e) {
			RCMException.showException(e);
		}
	}
   
   @SuppressWarnings("unused")
   public void dispatch(Command cmd){
	   //seleziona la view pi� appropriata da mostrare grazie al file xml
	   String resourcePath="";
	   String key="";
	   
	   
	   try{
		   //determino quale chiave mi serve per recuperare il form
		   key =cmd.getService().toString().toLowerCase() + "_" + cmd.getDto().getClass().getSimpleName().toLowerCase();//decommentare
	   }
	   catch(NullPointerException e){
		   //eccezione: il dto � nullo
		   key =cmd.getService().toString().toLowerCase();
	   }
	   
	   
	   //una volta ottenuta la chiave (key)
	   //procedo con la lettura del form dall'hashmap dei path
	   
	   try{
////		   Stage st;
		   CoupleKey stage=null;
//		   stage=null;
		   
		   if (mapForms.size()>0){
			   //maggiore di zero? -> tutti i riferimenti ai form sono stati caricati
			   if (mapForms.containsKey(key)){
				   //la chiave � contenuta ed il form viene caricato
				   resourcePath=mapForms.get(key);
				   
//				   st=getForm(resourcePath);
				   stage=getForm(resourcePath);
				   
				   //inietto l'oggetto di mio interesse per inizializzare il form
				   stage.stageController.injectElement((DTOBase) cmd.getDto());
				   
//				   stackForms.push(st);
				   newHashMapStage.get(keyStage).subStages.add(stage.stageForm);//"accodo" questo form
				   
//			       hashMapStage.get(keyStage).add(stage.stageForm);//aggiungo l'elemento alla key selezionata
////			       hashMapStage.get(keyStage).add(st);//aggiungo l'elemento alla key selezionata
				   
				   newHashMapStage.put(stage.stageForm, new CoupleValue(stage));//e lo inserisco come chiave

				   
				   
			       stage.stageForm.setOnCloseRequest(new EventHandler<WindowEvent>() {
//				    st.setOnCloseRequest(new EventHandler<WindowEvent>() {
			          public void handle(WindowEvent we) {
			        	  
			        	  
			        	  Stage myStage = (Stage) we.getTarget();
			        	  
//			        	  stage.stageController.discard();
			        	  newHashMapStage.get(myStage).stageController.discard();
			        	  
			        	  removeStage(myStage);
			        	  
			        	  
			        	  
//			        	  Stage swap=null;
//			        	  Stack<Stage> swapStack= new Stack<>();
//			        	  
//			        	  Iterator<Entry<Stage, ArrayList<Stage>>> it = hashMapStage.entrySet().iterator();
//			        	  
//			        	  while (it.hasNext()){
//			        		  
//			        		  ArrayList<Stage> array= it.next().getValue();
//			        		  if (array.contains(myStage)){
//			        			  array.remove(myStage);
//			        		  }
//			        	  }
//			        	  
//			        	  
//			        	  
////			        	  int index=stackForms.size();
////			        	  
////			        	  while (index>0){
////			        		  swap=stackForms.pop();
////			        		  
////			        		  if(!myStage.equals(swap)){
////			        			  swapStack.push(swap);
////			        			  index--;
////			        		  }
////			        		  else{
////			        			  index=0;
////			        		  }
////			        	  }
////			        	  index=swapStack.size();
////			        	  while (index>0){
////			        		  stackForms.push(swapStack.pop());
////			        		  index--;
////			        	  }
			          }
			      });        
				   
				   
			        
//				   st.show();
				   stage.stageForm.show();
				   
				   
//				   inject(cmd.getDto());
				   
			   }
			   else{
				   //la chiave � mancante:
				   //si tratta di comandi puramente necessari al motore di gestione dei form
				   //potenzialmente: potrebbe essere un comando per la chiusura del form
				   
				   Stage newStage=(Stage) cmd.getDto();
				   if (cmd.isPushCommand()){
//					   Stage newStage=(Stage) cmd.getDto();
					   //inserisce il form nella hashmap
					   
////					   newHashMapStage
//					   if (!newHashMapStage.containsKey(newStage)){
//						   newHashMapStage.put(newStage, new CoupleValue(null));
////						   hashMapStage.put(newStage, new ArrayList<>());//inserisco il primo stage della lista
//					   }
////					   if (!hashMapStage.containsKey(newStage)){
////						   hashMapStage.put(newStage, new ArrayList<>());//inserisco il primo stage della lista
////					   }
					   keyStage=newStage;
				   }
				   else{
					   //chiude il form
//					   Object possiblyStage= cmd.getDto();
//					   if (possiblyStage instanceof Stage){
//						   ((Stage)possiblyStage).close();
//						   removeStage((Stage) possiblyStage);
//					   }
//					   Stage closingStage= (Stage) cmd.getDto();
//					   closingStage.close();
					   removeStage(newStage);
				   }
				   
			   }
		   }
		   else{
			   //non � maggiore di zero. Per questo motivo � necessario effettuare il
			   //caricamento di tutti i riferimenti ai form
			   
			   loadUserForms(cmd);
			   
//			   stackForms = new Stack<>();
//			   newHashMapStage
			   newHashMapStage = new HashMap<>();
//			   hashMapStage = new HashMap<>();
			   
			   resourcePath = getDefault(cmd.getDto());
			   
//			   st= getForm(resourcePath);
			   stage= getForm(resourcePath);
			   stage.stageController.injectElement((DTOBase) cmd.getDto());
			   
			   
			   stage.stageForm.setOnCloseRequest(new EventHandler<WindowEvent>() {
//			   st.setOnCloseRequest(new EventHandler<WindowEvent>() {
				   public void handle(WindowEvent we) {
//					   int scelta=JOptionPane.YES_OPTION;
					   
					   
						  ButtonType btnYes = new ButtonType("Si");
						  ButtonType btnNo = new ButtonType("No");
					   Stage myStage = (Stage) we.getTarget();
						  Optional<ButtonType> scelta= null;
		        	  
//						  newHashMapStage
					  if (/*(*/newHashMapStage.get(myStage).subStages.size()>0){// + hashMapStage.get(myStage).size())>1){//da sostituire allo stack
//					  if (/*(*/hashMapStage.get(myStage).size()>0){// + hashMapStage.get(myStage).size())>1){//da sostituire allo stack
////		        	  if (stackForms.size()>0){
		        		  //ci sono dei form ancora aperti
						  Alert alert= new Alert(AlertType.WARNING);
						  alert.setTitle("Attenzione!");
						  alert.setHeaderText("Ci sono delle finestre ancora aperte.");
						  alert.setContentText("Sei sicuro di voler chiudere il programma?\n\nI dati non salvati andranno persi.");
						  
						  
						  alert.getButtonTypes().setAll(btnYes, btnNo);
						  

						  scelta = alert.showAndWait();
						  
//		        		  scelta = JOptionPane.showConfirmDialog (null, "\nCi sono delle finestre ancora aperte.\n\nSei sicuro di voler chiudere il programma?\n\nI dati non salvati andranno persi.","Attenzione!",JOptionPane.YES_NO_OPTION);
//						  else{
//			        		  we.consume();
//						  }
		        	  }
//					  try{
			        	  if (scelta==null || scelta.get()==btnYes){
			        		  Platform.exit();
//			        		  System.out.println("asd");
			        	  }
			        	  else{
			        		  we.consume();
//			        		  throw new Exception();
			        	  }
//					  }
//					  catch(Exception e){
//		        		  we.consume();
//					  }
		          }
		      });
			   
//			   newHashMapStage
			   newHashMapStage.put(stage.stageForm, new CoupleValue(stage));//inserisco il primo stage della lista
//			   hashMapStage.put(stage.stageForm, new ArrayList<>());//inserisco il primo stage della lista
////			   hashMapStage.put(st, new ArrayList<>());//inserisco il primo stage della lista
			   
			   stage.stageForm.show();
//			   st.show();
			   
		   }
		   
	   }
	   catch(NullPointerException e){
			RCMException.showException(e);
		   //l'hashmap � nulla (quindi il sw � stato appena avviato e quindi bisogna
		   //effettuare il login).
		   //Si procede con la schermata di login
//		   getForm(getDefault(null)).show();//mostra il form di base dell'intero software
		   getForm(getDefault(null)).stageForm.show();//mostra il form di base dell'intero software
		   
		   
		   
		   //istanzio l'hashmap dei form (che, ovviamente, risulter� essere vuota)
		   mapForms=new HashMap<String, String>();
	   }
	   
	   
	   
	   
	   
//	   {
//		   //altrimenti � stato caricato qualcosa
//		   
//		   if (mapForms.size()>0){
//			   //maggiore di zero? -> vuol dire che i riferimenti sono stati caricati
//			   //e si deve capire quale form mostrare
//			   
//			   String key="";
//			   
//			   
//			   if (cmd.getDto()==null){
//				   key =cmd.getService().toString().toLowerCase();
//			   }
//			   else{
//				   key =cmd.getService().toString().toLowerCase() + "_" + cmd.getDto().getClass().getSimpleName().toLowerCase();//decommentare
//			   }
//			   
//			   if (!mapForms.containsKey(key)){
//				   if (!cmd.isWriteCommand())
//				   ((Stage)cmd.getDto()).close();
//			   }
//			   else{
//				   resourcePath=mapForms.get(key);
//				   
//				   Stage st= getForm(resourcePath);
////				   Stage st= getForm(cmd);
//				   
//				   
//				   String[] title= key.split("_");
//				   
////				   st.setTitle(title[0].substring(0,1).toUpperCase() + title[0].substring(1) + " " + title[1].substring(0,1).toUpperCase() + title[1].substring(1));
//				   
//				   
//				   stackForms.push(st);//decommentare
//				   
//				   
//			        st.setOnCloseRequest(new EventHandler<WindowEvent>() {
//			          public void handle(WindowEvent we) {
//			        	  
//			        	  Stage myStage = (Stage) we.getTarget();
//			        	  Stage swap=null;
//			        	  Stack<Stage> swapStack= new Stack<>();
//			        	  
//			        	  int index=stackForms.size();
//			        	  
//			        	  while (index>0){
//			        		  swap=stackForms.pop();
//			        		  
//			        		  if(!myStage.equals(swap)){
//			        			  swapStack.push(swap);
//			        			  index--;
//			        		  }
//			        		  else{
//			        			  index=0;
//			        		  }
//			        	  }
//			        	  index=swapStack.size();
//			        	  while (index>0){
//			        		  stackForms.push(swapStack.pop());
//			        		  index--;
//			        	  }
//			          }
//			      });        
//				   
//				   
//				   st.show();
//			   }
//			   
//		   }
//		   else{
//			   //i riferimenti devono essere ancora caricati
//			   mapForms.putAll(loadUserForms(cmd));
//			   
//			   stackForms = new Stack<>();//decommentare
//			   
//			   resourcePath=getDefault(cmd.getDto());
//
//			   Stage st= getForm(resourcePath);
////			   Stage st= getForm(cmd);
//			   
//		        st.setOnCloseRequest(new EventHandler<WindowEvent>() {
//		          public void handle(WindowEvent we) {
//		        	  
//		        	  int scelta=JOptionPane.YES_OPTION;
//		        	  
//		        	  if (stackForms.size()>0){
//		        		  //ci sono dei form ancora aperti
//		        		  scelta = JOptionPane.showConfirmDialog (null, "\nCi sono delle finestre ancora aperte.\n\nSei sicuro di voler chiudere il programma?\n\nI dati non salvati andranno persi.","Attenzione!",JOptionPane.YES_NO_OPTION);
//		        	  }
//		        	  if (scelta==JOptionPane.YES_OPTION){
//		        		  Platform.exit();
//		        	  }
//		        	  else{
//		        		  we.consume();
//		        	  }
//		          }
//		      });        
//        st.show();
//			   
//		   }
//	   }
//	   
////	   //inietto il dato di mio interesse
////	   inject(cmd.getDto());
//	   
	   
   }
   
   
   private void removeSubStage(Stage myStage){
//	   newHashMapStage
	   ArrayList<Stage> subArray = newHashMapStage.get(myStage).subStages;
//	   ArrayList<Stage> subArray = hashMapStage.get(myStage);
	   
	   try{
		   Iterator<Stage> subIt = subArray.iterator();
		   while (subIt.hasNext() ){
			   Stage subStage=subIt.next();
			   removeSubStage(subStage);
//			   subArray.remove(subStage);
			   subStage.close();
		   }
//		   newHashMapStage
		   newHashMapStage.remove(myStage);
//		   hashMapStage.remove(myStage);
	   }
	   catch(Exception e){
		   //non ci sono sottoarray con questo stage come chiave
	   }
	   
   }
   

   private void removeStage(Stage myStage) {
//	   removeSubStage(myStage);
	   
//	   newHashMapStage
	   Iterator<Entry<Stage, CoupleValue>> it = newHashMapStage.entrySet().iterator();
//	   Iterator<Entry<Stage, ArrayList<Stage>>> it = hashMapStage.entrySet().iterator();
	   
  	  boolean found = false;

	  
	   try{
		   
		   while (it.hasNext() && !found){
		  		  
//	  	   ArrayList<Stage> array= it.next().getValue();
		   ArrayList<Stage> array= it.next().getValue().subStages;
	  		if (array.contains(myStage)){
	  			removeSubStage(myStage);
	  			  array.remove(myStage);
	  			  found=true;
	  		  }
	  	  }
//		  myStage.close();
	   }
	   catch(Exception e){
		   //non ci sono sottoarray con questo stage come chiave
	   }
		  myStage.close();
	   
	  
   }

	private void loadUserForms(Command cmd){
//		HashMap<String, String> userForms=new HashMap<>();
		String packg="";
		String ext="";
		String subFolder=cmd.getDto().getClass().getSimpleName().toLowerCase();
		
		rootNode = document.getRootElement();
		
		//seleziona il percorso relativo ai form e sostituisco i punti con il carattere del percorso
		packg=rootNode.getAttributeValue("package").replace(".","/");
		
		//seleziona l'estensione dei form da caricare
		ext=rootNode.getAttributeValue("extension");
		
		//ricavo il gruppo di servizi relativi all'utente
		rootNode=rootNode.getChild(subFolder);
		

		subFolder+="/";
		
		
		//li carico nella lista
		Iterator<Element> iterator=rootNode.getChildren().iterator();
		
		while (iterator.hasNext()){
			Element e = iterator.next();
			
			String command;
			
			if (e.getAttributeValue("class") !=null){
				command = e.getAttributeValue("name") + "_" + e.getAttributeValue("class");
			}
			else{
				command = e.getAttributeValue("name");
			}
			
			String path=packg + subFolder + e.getAttributeValue("resource") + ext;
			
			mapForms.put(command, path);
			
		}
		
//		return userForms;
	}
	
	
	private String getDefault(Object dto) {
		String packg="";
		String ext="";
		String path="";
		
		rootNode = document.getRootElement();
		
		//seleziona il percorso relativo ai form e sostituisco i punti con il carattere del percorso
		packg=rootNode.getAttributeValue("package").replace(".","/");
		
		//seleziona l'estensione dei form da caricare
		ext=rootNode.getAttributeValue("extension");
		
		
		try{
			String subPath=dto.getClass().getSimpleName().toLowerCase();
			rootNode= rootNode.getChild(subPath);
			subPath += "/";
			path= packg + subPath + rootNode.getAttributeValue("resource") + ext;
		}
		catch (NullPointerException e){
			path= packg + rootNode.getAttributeValue("default") + ext;
		}
		
		
		
//		if (dto==null){
//			path= packg + rootNode.getAttributeValue("default") + ext;
//		}
//		else{
//			String subPath=dto.getClass().getSimpleName().toLowerCase();
//			rootNode= rootNode.getChild(subPath);
//			subPath += "/";
//			path= packg + subPath + rootNode.getAttributeValue("resource") + ext;
//		}
		
		return path;
	}

//	private HashMap<String, String> getFormPath(Command cmd){
//		HashMap<String, String> formPath=null;
//		String packg="";
//		String ext="";
//		String command=cmd.getService().toString().toLowerCase();
//		
//		rootNode = document.getRootElement();
//		
//		//seleziona il percorso relativo ai form e sostituisco i punti con il carattere del percorso
//		packg=rootNode.getAttributeValue("package").replace(".","/");
//		
//		//seleziona l'estensione dei form da caricare
//		ext=rootNode.getAttributeValue("extension");
//		
//		
//		
//		
//		List<Element> lista=rootNode.getChildren(command);
//		
//		if (lista.size()>0){
//			//elenco dei comandi
//			
//		}
////		else{
////			//form di default
////			formPath.put(command, packg + rootNode.getAttributeValue("default") + ext);
////		}
//		
//		
//		
////		if (lista.size()==1){
////			//il comando � solo uno
////////			formPath=packg + lista.get(0).getAttributeValue("resource") + ext;
//////			formPath.put(command, packg + lista.get(0).getAttributeValue("resource") + ext);
////				Element e=lista.get(0);
////				formPath.put(command, packg + e.getAttributeValue("resource") + ext);
//////				mapForms.put(command, null);
////		}
////		else{
////			if (!(cmd.getDto() instanceof DTOBase)){
////				formPath=null;
////			}
////			else{
////				//esiste pi� di un comando, perci�:
////				//1) pesco l'iteratore della lista
////				Iterator<Element> it = lista.iterator();
////					
////				//2) scansiono tutti gli elementi e li carico nel "path"
////				while (it.hasNext()){
////					Element e=it.next();
////	//				formPath+= e.getAttributeValue("class") + ":" + packg + e.getAttributeValue("resource") + ext + ";";
////					formPath.put(e.getAttributeValue("class"), packg + e.getAttributeValue("class") + "/" + e.getAttributeValue("resource") + ext);
//////					mapForms.put(e.getAttributeValue("class"), null);
////				}
////			}
////			
////		}
//		
//		return formPath;
//	}   
   
		private CoupleKey getForm(String resource){
			CoupleKey coupleKey= new CoupleKey();
			
			
//		private Stage getForm(String resource){
////		private Stage getForm(Command cmd){
			
//			String[] params=resource.split("\'");
			
					Stage newStage = new Stage();
					newStage.setResizable(false);
					newStage.initModality(Modality.WINDOW_MODAL);
					newStage.sizeToScene();
		
					AnchorPane newPane=null;
					Scene myScene=null;
					try {
		//				newPane = (AnchorPane)FXMLLoader.load(Forms.class.getResource(resource));
						////////////////////////////////////////////////////////////////////
//						FXMLLoader loader=new FXMLLoader(getClass().getResource(resource));
						loader=new FXMLLoader(getClass().getResource(resource));
						newPane = (AnchorPane) loader.load();
//						loader.<CBase>getController().setObj(null);
						////////////////////////////////////////////////////////////////////
						myScene = new Scene(newPane);
						newStage.setScene(myScene);

						
//						int index=forms.size()-1;
//						forms.get(index).close();
//

						
//						//verifica allineamento orizzontale
//						String horizontal=params[1];
//						
//						
						newStage.centerOnScreen();
						
						
						//imposto lo Stage
						coupleKey.stageForm=newStage;
						
						coupleKey.stageController= loader.getController();
						
						
//						switch(horizontal){
//						case "left":
//							newStage.setX(1);
//						break;
//						case "right":
//							newStage.setX((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-10)-(newPane.getPrefWidth()));
//						break;
////						default:
////							newStage.setX(((Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2))-(newPane.getPrefWidth()/2));
////						break;
//						}
						
						
//						//verifica allineamento verticale
//						String vertical=params[2];
//						switch(vertical){
//						case "top":
//							newStage.setY(3);
//						break;
//						case "bottom":
//							newStage.setY((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-10)-(newPane.getPrefHeight()));
//						break;
////						default:
////							newStage.setY((Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-10-(newPane.getPrefHeight()/2));
////						break;
//						}
						
//						Iterator<Entry<String, Stage>> it = mapForms.entrySet().iterator();
//						
//						boolean found=false;
//						while (it.hasNext() && !found){
//							Entry<String, Stage> elem= it.next();
//							
//							if (elem.getValue()==null){
//								elem.setValue(newStage);
//								found=true;
//							}
//						}
						
						
//						newStage.show();
					} catch (IOException e) {
						RCMException.showException(e);
						coupleKey=null;
						//newStage = null;
					}
					
					
					
					
					return coupleKey;
//					return newStage;
		 
					
				}

//		public void inject(Object resultObj) {
//			if (resultObj!=null && !(resultObj instanceof Stage))
//				loader.<CBase>getController().setObj(resultObj);
//		}
   
		
		
		
		
}