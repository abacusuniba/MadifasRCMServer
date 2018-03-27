package b_tiers.a_presentation.a_frontcontroller;

import c_dto.Command;
import c_dto.a_abstract.DTOBase;
import c_dto.b_real.Utente;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import b_tiers.a_presentation.b_dispatcher.Dispatcher;
import b_tiers.b_business.a_businessDelegate.BusinessDelegate;
import b_tiers.b_business.a_businessDelegate.lookUpService.BusinessLookUp;
import b_tiers.b_business.a_businessDelegate.lookUpService.ServiceType;

public class FrontController {
	
	private static FrontController singleton=null;
	private Dispatcher dispatcher;
	private BusinessDelegate delegate;
	
    public static synchronized FrontController getInstance(){
    	if (singleton==null){
    		//se il frontcontroller non � stato "avvalorato", mi occupo di inizializzarlo
    		singleton = new FrontController();
    	}
    	return singleton;
    }

	private FrontController(){
		//inizializzo il business delegate
		delegate = new BusinessDelegate();
		
		//inizializzo il dispatcher
		dispatcher = new Dispatcher();
		
//		//inizializzo il business delegate
//		delegate = new BusinessDelegate();
	}
	
	public Object execute(Command cmd){
//	public void execute(Command cmd){
		Object resultObj=null;

		
		if (cmd.isLoginCommand()){
			//si tratta di un comando di login
			
			//esegue il comando (passa il controllo al delegate)
			resultObj=delegate.doTask(cmd);
//			cmd.setDto(resultObj);
			
//			//cerca il form appropriato
//			dispatcher.dispatch(cmd);
//			
//			delegate.reset((Utente) cmd.getDto());
//			
		}
		
		//server
		if (cmd.isFormCommand()){
			//si tratta di un comando per mostrare le interfacce
			
//			//devo iniettare l'oggetto?
//			delegate.doTask(cmd);
				
			//cerca il form appropriato
			dispatcher.dispatch(cmd);
		}
		if (cmd.isReadCommand() || cmd.isWriteCommand()){
			//si tratta di un comando per la lettura dei dati
				
			//esegue il comando (passa il controllo al delegate)
			resultObj=delegate.doTask(cmd);
		}
//		if (cmd.isReadCommand()){
//			//si tratta di un comando per la lettura dei dati
//				
//			//esegue il comando (passa il controllo al delegate)
//			resultObj=delegate.doTask(cmd);
//		}
//		if (cmd.isWriteCommand()){
//			//si tratta di un comando per la scrittura dei dati
//				
//			//esegue il comando (passa il controllo al delegate)
//			resultObj=delegate.doTask(cmd);
////			delegate.doTask(cmd);
//		}
		

		return resultObj;
		
	}
    
 }