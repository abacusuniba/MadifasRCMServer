package b_tiers.b_business.a_businessDelegate;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import a_main.RCMException;

//import org.apache.avro.SchemaBuilder.EnumBuilder;
//import org.apache.lucene.index.SegmentInfos.FindSegmentsFile;

import c_dto.Command;
import c_dto.a_abstract.DTOBase;
import c_dto.b_real.Administrator;
import c_dto.b_real.Utente;
import b_tiers.b_business.a_businessDelegate.lookUpService.BusinessLookUp;
import b_tiers.b_business.a_businessDelegate.lookUpService.BusinessService;
import b_tiers.b_business.a_businessDelegate.lookUpService.ServiceType;


public class BusinessDelegate {
	
   private BusinessLookUp lookupService;
   private BusinessService businessService;

	public BusinessDelegate(){
		//istanzia il modulo per la ricerca dei servizi (senza istanziare nulla)
		lookupService = new BusinessLookUp();
		
		//effettua il caricamento dell'application service appropriato
		businessService = lookupService.findService(null);
	}
	
	public void reset(Utente u){
		//effettua il caricamento dell'application service appropriato
		businessService = lookupService.findService(u);
	}
	
   
	public Object doTask(Command cmd){
		Object obj=null;
		
		try {
			//recupera il riferimento al metodo di interesse ed esegue quel determinato metodo
			//NB il metodo NON HA ALCUN PARAMETRO
			obj=this.businessService.getMethod(cmd).invoke(this.businessService, null);
		}
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException |
				SecurityException | NoSuchMethodException e) {
			try {
				//recupera il riferimento al metodo di interesse ed esegue quel determinato metodo
				//NB il metodo presenta dei parametri
				obj=this.businessService.getMethod(cmd).invoke(this.businessService, cmd.getDto());
				if (obj==null)
					obj=cmd.getDto();
			}
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException |
					SecurityException | NoSuchMethodException e1) {
				RCMException.showException(e1);
				String key="";
				   try{
					   //determino quale chiave mi serve per recuperare il form
					   key =cmd.getService().toString().toLowerCase() + "_" + cmd.getDto().getClass().getSimpleName().toLowerCase();//decommentare
				   }
				   catch(NullPointerException ex){
					   //eccezione: il dto � nullo
					   key =cmd.getService().toString().toLowerCase();
				   }
				   if (!key.contains("dimentica")){
						System.out.println("per il comando '" + key + "' non esiste il servizio appropriato");
						RCMException.showException(e1);
				   }
			}
			
//				if (cmd.isLoginCommand()){
//					//se l'utente sta effettuando il login, � necessario caricare l'application service
//					//pi� appropriato
//					this.businessService=lookupService.findService((Utente) obj);
//					
//				}
			
		}
		
		
//		if (cmd.isLoginCommand()){
//			//se l'utente sta effettuando il login, � necessario caricare l'application service
//			//pi� appropriato
//			this.businessService=lookupService.findService((Utente) obj);
//			
//		}
		
		return obj;
	}
	
	
}