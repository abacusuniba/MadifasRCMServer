package a_main;

import c_dto.Command;
import c_dto.b_real.Administrator;
import b_tiers.a_presentation.a_frontcontroller.FrontController;
import b_tiers.b_business.a_businessDelegate.lookUpService.ServiceType;
import b_tiers.c_integration.a_dao.DaoRCM;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	private FrontController fc;
	
//modificato??
	
	
	public static void main(String[] args) {
//		Indirizzo i = new Indirizzo();
//		i.setId(1);
//		
//		DaoRCM dao = new DaoRCM(Indirizzo.class);
//		
//		i= (Indirizzo) dao.read(i);
//		
//		System.out.println("indirizzo con id 1");
//		
//		
		launch(args);
		System.exit(0);
	}

	@Override
	public void start(Stage arg0){
		try{
			
			//recupero l'istanza del front controller
			fc=FrontController.getInstance();
			Command cmd = new Command();
			cmd.setService(ServiceType.start);//decommentare
			
			//do inizio al programma
			fc.execute(cmd);
		}
		catch (Exception e){
			RCMException.showException(e);
		}
	}
}

