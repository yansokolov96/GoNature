package gui;

import java.io.IOException;

import org.w3c.dom.views.AbstractView;

import Server.ServerUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ocsf.server.ConnectionToClient;

public class serverPortController {

	private static serverPortController sPC_instance = null;

	public static serverPortController getInstance() {
		if (sPC_instance == null)
			sPC_instance = new serverPortController();

		return sPC_instance;
	}

	@FXML
	private Button btnDone;

	@FXML
	private TextField portxt;

	@FXML
	private Button btnExit;

	@FXML
	private TextField statusTxt;

	@FXML
	private TextField hostTxt;

	@FXML
	private TextField ipTxt;

	private String getport() {
		return portxt.getText();
	}

	@FXML
	void Done(ActionEvent event) {
		String p;

		p = getport();
		portxt.setDisable(true);
		if (p.trim().isEmpty()) {
			System.out.println("You must enter a port number");

		} else {
			// ((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary
			// window
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			ServerUI.runServer(p);
		}

	}

	@FXML
	void getExitBtn(ActionEvent event) {
		System.out.println("exit tool");
		System.exit(0);
	}

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/ServerPort.fxml"));

		Scene scene = new Scene(root);
		// scene.getStylesheets().add(getClass().getResource("/gui/ServerPort.css").toExternalForm());
		primaryStage.setTitle("Client");
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public void setInfoClient(String ip, String host) {
		System.out.println(ip + host);
		System.out.println();

		ipTxt.setText(ip);
		hostTxt.setText(host);

	}

}