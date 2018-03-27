package b_tiers.a_presentation.b_dispatcher.forms.controller;

//package presentation.forms;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import c_dto.Command;
import c_dto.a_abstract.DTOBase;
import c_dto.b_real.Cliente;
import b_tiers.a_presentation.a_frontcontroller.FrontController;
import b_tiers.b_business.a_businessDelegate.lookUpService.ServiceType;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
//import business.delegate.ServiceType;
//import business.services.as.EmailException;
//import business.services.as.UsernameException;
//import dto.Competizione;
//import dto.DTOBase;
//import dto.Utente;
//import presentation.frontController.FrontController2;

/**
*
* 
* @author Rosario
*
*/
public abstract class CBase  implements Initializable, IController{
	
	
//	private static FrontController2 fc = FrontController2.getInstance();
	private static FrontController fc=FrontController.getInstance();
	
//	@FXML private AnchorPane anchorPane;
	
//	private Object obj=null;
//	protected Utente user;
	
//	protected void sortTable(TableView<Competizione> table, TableColumn<Competizione, String> col){
//		table.getSortOrder().add(col);
//	    SortType st = col.getSortType();
//	    col.setSortType(st);
//	    col.setSortable(true); // This performs a sort
//		
//	}
	
private void _________________________________0(){}

//private DTOBase rootElement;//elemento radice per tutte le classi controller (conterrà i dati dell'oggetto aperto)



//	protected Object execute(ServiceType command, DTOBase dto) throws UsernameException, EmailException{
//		return fc.execute(command, dto);
//	}
	
//    protected void closeForm(Object e){
//    	Stage st=null;
////    	Scene sc=null;
////    	
////    			ActionEvent ae = (ActionEvent) e;
////    			((Node)ae.getSource()).getScene();
////    	
////    	
//    	try{
//    		st=(Stage) ((Node)((Event)e).getTarget()).getScene().getWindow();   	
//    	}
//    	catch(ClassCastException ex){
//    		st=((Stage)e);
//    		
//    		
//    	}
//    	
//		Command cmd = new Command();
//		cmd.setService(ServiceType.chiudi);
//		cmd.setDto(st);
//		
//		execute(cmd);
//    }
    

//public DTOBase getRootElement() {
//	return rootElement;
//}
//
//
//public void setRootElement(DTOBase rootElement) {
//	this.rootElement = rootElement;
//}

//////private ArrayList<TableView<DTOBase>> tableList;//da usare per tutte le tabelle del singolo stage
////private HashMap<TableView<?>, Command> newTableMap = new HashMap<>();//da usare per tutte le tabelle del singolo stage
//private HashMap<TableView<?>, ObservableList<?>> tableMap = new HashMap<>();//da usare per tutte le tabelle del singolo stage
private HashMap<TableView<?>, Object> tableMap = new HashMap<>();//da usare per tutte le tabelle del singolo stage


    protected void unloadMe(Event e){
    	Stage st=(Stage) ((Node)e.getTarget()).getScene().getWindow();   	
		Command cmd = new Command();
		cmd.setService(ServiceType.nascondi);
		cmd.setDto(st);
		
		execute(cmd);
    }

    private void pushMe(Event e){
    	
    	MenuItem menuItem=null;
    	Stage st=null;
    	boolean foundScene=false;
    	
    	try{
    		st=(Stage) ((Node)e.getTarget()).getScene().getWindow();   	
    	}
    	catch (Exception exc){
        	try{
        		menuItem=((MenuItem) e.getTarget());
        		st=(Stage) menuItem.getParentPopup().getOwnerNode().getScene().getWindow();
//        		foundScene=true;
        	}
        	catch(Exception exc2){
        		
            	Menu menu=menuItem.getParentMenu();
            	while (!foundScene){
                	try{
                		st=(Stage) menu.getParentPopup().getOwnerNode().getScene().getWindow();
//                		menu=menuItem.getParentMenu();
//                		st=(Stage) menu.getParentPopup().getOwnerNode().getScene().getWindow();
                		foundScene=true;
                	}
                	catch(Exception exc3){
                		menu=menu.getParentMenu();
                	}
            	}
        	}
    	}
    	
    	
    	
//    	try{
//    		st=(Stage) ((MenuItem) e.getTarget()).getParentMenu().getParentPopup().getOwnerNode().getScene().getWindow();
//    	}
//    	catch (Exception exc){
////    		exc.printStackTrace();
//        	try{
//            	st=(Stage) ((Node)e.getTarget()).getScene().getWindow();   	
//        	}
//        	catch (Exception exc2){
//        		st=(Stage) ((MenuItem) e.getTarget()).getParentPopup().getOwnerNode().getScene().getWindow();
//        	}
//    	}
    	
		Command cmd = new Command();
		cmd.setService(ServiceType.push);
		cmd.setDto(st);
		
		execute(cmd);
    }

//	protected Object execute(ServiceType command, DTOBase dto) throws UsernameException, EmailException{
	//		return fc.execute(command, dto);
	//	}
		
	//    protected void closeForm(Object e){
	//    	Stage st=null;
	////    	Scene sc=null;
	////    	
	////    			ActionEvent ae = (ActionEvent) e;
	////    			((Node)ae.getSource()).getScene();
	////    	
	////    	
	//    	try{
	//    		st=(Stage) ((Node)((Event)e).getTarget()).getScene().getWindow();   	
	//    	}
	//    	catch(ClassCastException ex){
	//    		st=((Stage)e);
	//    		
	//    		
	//    	}
	//    	
	//		Command cmd = new Command();
	//		cmd.setService(ServiceType.chiudi);
	//		cmd.setDto(st);
	//		
	//		execute(cmd);
	//    }
	    
	    protected Object execute(Command cmd)/* throws UsernameException, EmailException*/{
	//      protected void execute(Command cmd)/* throws UsernameException, EmailException*/{
	  		return fc.execute(cmd);
	//  		fc.execute(cmd);
	  	}

	protected Object execute(Command cmd, Event e)/* throws UsernameException, EmailException*/{
		pushMe(e);
		
		return fc.execute(cmd);
	}

	
	protected void updateFather(Event e){
		
		//leggi il padre (Stage father)
		Command cmd=new Command();
		cmd.setService(ServiceType.father);
		
		Stage st=(Stage) ((Node)e.getTarget()).getScene().getWindow();   	
		
		cmd.setDto(st);
		
		CBase fatherController= (CBase) execute(cmd);
		
		fatherController.reloadTables();
		
		
		//refresh del form
//		father.ref
		
	}
	
//	private void reloadTables(){
//		
//		Iterator<Entry<TableView<?>, Object>> it = tableMap.entrySet().iterator();
//		TableView<DTOBase> tblTable;
//		Object tblData;
//		
//		
//		while (it.hasNext()){
////			Entry<TableView<?>, ObservableList<?>> element = it.next();
//			Entry<TableView<?>, Object> element = it.next();
//			
//			
//			tblTable=(TableView<DTOBase>) element.getKey();
//			tblData= element.getValue();
//			
//			
//			if (tblData instanceof Command){
//				//esegue il comando e aggiorna il tutto
//				ObservableList<DTOBase> actualTblData = tblTable.getItems();
//				tblTable.setItems(null);
//				tblTable.layout();
//				
//				try{
//					actualTblData.clear();
//					actualTblData.addAll((ArrayList<Cliente>)execute((Command) tblData));
////				actualTblData = (ObservableList<DTOBase>) execute((Command) tblData);
//				}
//				catch (Exception e){
//					e.printStackTrace();
//				}
//				tblTable.setItems(actualTblData);
//			}
//			else{
//				//altrimenti: aggiorna solamente la tabella
//				tblTable.setItems(null);
//				tblTable.layout();
////				datiRiferimenti.setAll(cliente.getRiferimenti());
//				tblTable.setItems((ObservableList<DTOBase>) tblData);
//			}
//		}
//	}
	
//	protected void addKey(TableView<?> key){
//		tableMap.put(key, key.getItems());
//	}
	
//	protected void addElement(TableView<?> key, Command cmd){
//		tableMap.put(key, cmd);
//	}
	
	
	
	private void _________________________________1(){}
	
	
	
    public static String stringToMD5 (String str) throws NoSuchAlgorithmException{
    	 
        String securePassword = null;
        // Create MessageDigest instance for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        //Add password bytes to digest
        md.update(str.getBytes());
        //Get the hash's bytes
        byte[] bytes = md.digest();
        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        //Get complete hashed password in hex format
        securePassword = sb.toString();

        return securePassword;

}
	
//	protected Object execute(ServiceType command, DTOBase dto) throws UsernameException, EmailException{
//		return fc.execute(command, dto);
//	}
	
//    protected void closeForm(Object e){
//    	Stage st=null;
////    	Scene sc=null;
////    	
////    			ActionEvent ae = (ActionEvent) e;
////    			((Node)ae.getSource()).getScene();
////    	
////    	
//    	try{
//    		st=(Stage) ((Node)((Event)e).getTarget()).getScene().getWindow();   	
//    	}
//    	catch(ClassCastException ex){
//    		st=((Stage)e);
//    		
//    		
//    	}
//    	
//		Command cmd = new Command();
//		cmd.setService(ServiceType.chiudi);
//		cmd.setDto(st);
//		
//		execute(cmd);
//    }
    
    
  	
	
//	protected void startFC(){
//////		fc=new FrontController();
////		fc=new FrontController2();
//		fc=FrontController2.getInstance();
//	}
	
//	protected ArrayList<DTOBase> getList(){
//		return fc.getList();
//	}


//	public void setObj(Object obj) {
//	}


//	protected Object getObj() {
//		return obj;
//	}
	
	protected void validate (TextField textField){
		
		
		if (textField.getText().isEmpty()){
			textField.setStyle(" -fx-border-color: red ;  -fx-border-width: 3px ;  ");
		}
		else{
			textField.setStyle(" -fx-border-color: red ;  -fx-border-width: 0px ;  ");
		}
		
	}
	
//	protected boolean isValid (TextArea textField){
//		
//	}

	protected void validate (ComboBox<?> combo){
		if (combo.getSelectionModel().getSelectedIndex()==-1){
			combo.setStyle(" -fx-border-color: red ;  -fx-border-width: 3px ;  ");
		}
		else{
			combo.setStyle(null);
		}
		
		
	}
	protected void validate (Label label){
		
		if (label.getText().isEmpty()){
			label.setStyle(" -fx-border-color: red ;  -fx-border-width: 2px ; -fx-text-fill:red ; ");
			label.setText("Inserisci il certificato SRC");
		}
		else{
			label.setStyle(null);
		}
	}
	
	
	protected void disable (TextField text){
//		text.setDisable(true);
		text.setEditable(false);
	}
	
	protected void enable (TextField text){
//		text.setDisable(false);
		text.setEditable(true);
	}
	
	protected void disable (TextArea text){
//		text.setDisable(true);
		text.setEditable(false);
	}
	
	protected void enable (TextArea text){
//		text.setDisable(false);
		text.setEditable(true);
	}
	protected void disable (Button button){
		button.setDisable(true);
	}
	
	protected void enable (Button button){
		button.setDisable(false);
	}
	
	protected void enable(ListView<?> list) {
//		list.setDisable(false);
		list.setEditable(true);
	}
	protected void disable(ListView<?> list) {
//		list.setDisable(true);
		list.setEditable(false);
	}
	
	
}
