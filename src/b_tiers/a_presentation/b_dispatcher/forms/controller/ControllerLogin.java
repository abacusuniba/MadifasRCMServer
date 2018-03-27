package b_tiers.a_presentation.b_dispatcher.forms.controller;

import java.net.URL;
import java.util.ResourceBundle;









import b_tiers.b_business.a_businessDelegate.lookUpService.ServiceType;
import c_dto.Command;
import c_dto.a_abstract.DTOBase;
import c_dto.b_real.Utente;
import javafx.event.Event;
//import business.delegate.ServiceType;
//import business.services.as.EmailException;
//import business.services.as.UsernameException;
//import dto.Utente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
*
* 
* @author Rosario
*
*/
public class ControllerLogin extends CBase implements Initializable{

//	@FXML private Button btnLogin;
//	@FXML private Button btnRegistrati;
//	@FXML private AnchorPane agroludosPane;
	@FXML private TextField txtUsername;
	@FXML private PasswordField txtPassword;
	
//	@FXML private Label lblTitolo;
//	@FXML private Label lblPassLost;
	@FXML private Label lblMessage;

//	@FXML protected void txtKeyPressed(KeyEvent event) {
////		if (event.getCode() == KeyCode.ENTER){
////			lblMessage.setVisible(true);
////			lblMessage.setText("Premere il tasto LOGIN");
////			lblMessage.setTextFill(Color.BLUE);
////			txtUsername.setText("");
////			txtPassword.setText("");
////		}
//	}

	@FXML protected void btnLogin(Event e) {	
		login(e);
	}
	
	private void login(Event e){
		Utente u = new Utente();
		u.setUsername(txtUsername.getText());
		u.setPassword(txtPassword.getText());
		
		Command cmd = new Command();
		cmd.setService(ServiceType.login);
		cmd.setDto(u);
		
		execute(cmd);
		
		unloadMe(e);
		
	}
	
	
	
	@FXML protected void lblPassLost(/*MouseEvent event*/) {
////		lblMessage.setVisible(true);
////		lblMessage.setText("Sei uno stronzo!!!!!");
////		lblMessage.setTextFill(Color.MAGENTA);
//		
//		try {
//			execute(ServiceType.recovery);
//		} catch (UsernameException | EmailException e) {
//			// TODO Auto-generated catch block
//		
//        
//		}
	}
	
	
	


	@FXML
	protected void btnSvuota(/*MouseEvent event*/){
		txtUsername.setText("");
		txtPassword.setText("");
	}

	@FXML
	protected void btnChiudi(Event e){
		unloadMe(e);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		startFC();//all'avvio, istanzia il frontcontroller
	}

	@Override
	public void injectElement(DTOBase dto) {
	}

	@Override
	public void reloadTables() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void discard() {
		// TODO Auto-generated method stub
		
	}

}