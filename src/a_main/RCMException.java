package a_main;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class RCMException {
	
	public static void showException(Exception e) {
		e.printStackTrace();
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		
		  Alert alert= new Alert(AlertType.WARNING);
//		  alert.setTitle("Attenzione!");
		  alert.setHeaderText("Eccezione");
		  alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(sw.toString())));
		  alert.getDialogPane().setExpanded(true);
		  alert.show();
		  Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		  stage.setAlwaysOnTop(true);
		  stage.toFront(); // not sure if necessary		  
//		  alert.setContentText("Sei sicuro di voler chiudere il programma?\n\nI dati non salvati andranno persi.");
	}

}
