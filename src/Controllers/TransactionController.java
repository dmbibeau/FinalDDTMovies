package Controllers;

	import java.sql.ResultSet;
import java.sql.SQLException;

import application.Transaction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.DatePicker;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextField;
	
public class TransactionController {

	    @FXML
	    private Label First;

	    @FXML
	    private Label Last;

	    @FXML
	    private Label tCode;

	    @FXML
	    private Label Card;

	    @FXML
	    private Label Title;

	    @FXML
	    private TextField Barcode;

	    @FXML
	    private DatePicker Date;

	    @FXML
	    private DatePicker Due;

	    @FXML
	    private TextField Override;

	    @FXML
	    private Button Search;

	    @FXML
	    private Button Alerts;

	    @FXML
	    private Button Confirm;

	    @FXML
	    private Label Alearts;

	    @FXML
	    private Label BarError;

	    @FXML
	    private Label DateError;

	    @FXML
	    private Label PriceError;

	    @FXML
	    private TextField ID;

	    @FXML
	    private Button CustSearch;
	    
	    public void updateCode() throws SQLException {
			ResultSet rs = Transaction.getLastCode();
			rs.next();

			String strCode = rs.getString("code");
			int Code = Integer.valueOf(strCode);
			++Code;
			tCode.setText("" + Code);
		}
	    
	    @FXML
	    void submitTransaction(ActionEvent event) throws Exception{
	    	Transaction.addTransaction(Barcode,  ID,
	    			Override, tCode, Date,  Due);
	    }


		
		

	
}
