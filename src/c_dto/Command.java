package c_dto;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.stage.Stage;
import c_dto.a_abstract.DTOBase;
import b_tiers.b_business.a_businessDelegate.lookUpService.ServiceType;

public class Command implements Serializable{
	
	private ServiceType service;
	
	private DTOBase dto;
	private Stage stage;
	private ArrayList<DTOBase> array;
	
	public Command(){
//		service=null;
//		dto=null;
//		stage=null;
//		array=null;
	}
	

	public ServiceType getService() {
		return service;
	}

	public void setService(ServiceType service) {
		this.service = service;
	}

	public Object getDto() {
		Object obj;
		if (dto!=null){
			obj=dto;
		}
		else{
			if (stage!=null){
				obj=stage;
			}
			else{
				obj=array;
			}
		}
		return obj;
	}

	public void setDto(Object dto) {
		
		if (dto!=null){
			if (dto instanceof DTOBase){
				this.dto = (DTOBase) dto;
				this.stage = null;
				this.array=null;
			}
			else{
				if (dto instanceof Stage){
					this.dto = null;
					this.stage = (Stage) dto;
					this.array=null;
				}
				else{
					this.dto = null;
					this.stage = null;
					this.array=(ArrayList<DTOBase>) dto;
				}
			}
		}
		
	}


//	public Stage getStage() {
//		return stage;
//	}


//	public void setStage(Stage stage) {
//		this.stage = stage;
//	}
	
	
	public boolean isFormCommand(){
		return (service.ordinal()<ServiceType.readCommand.ordinal() && !isLoginCommand());
	}
	
	public boolean isPushCommand(){
		return (service.ordinal()==ServiceType.push.ordinal());
	}
	
	public boolean isFatherCommand(){
		return (service.ordinal()==ServiceType.father.ordinal());
	}
	
//	public boolean isPushElementCommand(){
//		return (service.ordinal()==ServiceType.pushElement.ordinal());
//	}
	
	public boolean isReadCommand(){
		return ((service.ordinal()<ServiceType.writeCommand.ordinal()) && (service.ordinal()>ServiceType.readCommand.ordinal()));
	}
	public boolean isWriteCommand(){
		return (service.ordinal()>ServiceType.writeCommand.ordinal());
	}
	
	public boolean isLoginCommand(){
		return (service.ordinal()==ServiceType.login.ordinal());
	}
	
	
	
	
//	public Boolean isRead(){
//		Boolean read =false;
//		 if (service.ordinal()<ServiceType.separator.ordinal()){
//			 read=true;
//		 }
//		return read;
//	 }
//	public Boolean isCommand(){
//		Boolean read =false;
//		 if (service.ordinal()<ServiceType.command.ordinal()){
//			 read=true;
//		 }
//		return read;
//	 }
//	
////	public Boolean isWrite(ServiceType service){
////		return !isRead();
////	 }


	
	
	
	
}
