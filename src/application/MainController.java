package application;

import internet.connection.InternetConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {
	@FXML
	private TextField tf;
	@FXML
	private TextArea ta;

	
	public void search(ActionEvent event) {
		String word=tf.getText();
		//ta.scr
		InternetConnection ic=new InternetConnection();
		String decodeData=ic.getOnlineData(word);
		if(decodeData.equals("error")) {
			ta.setText("Something is Wrong !! \n Re-Connection Internet");
			
		}else {
			ta.setText(decodeData);
		}
		
		
	}
	

}
