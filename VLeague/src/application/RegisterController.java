package application;

import java.net.URL;
import java.util.ResourceBundle;

import org.kordamp.ikonli.javafx.FontIcon;

import javafx.animation.RotateTransition;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RegisterController implements Initializable{
	
	@FXML
	private AnchorPane parent;
	
	@FXML
	private TextField registerUsernameField;
	
	@FXML
	private TextField registerEmailField;
	
	@FXML
	private TextField plaintextField;
	
	@FXML
	private PasswordField registerPasswordField;
	
	@FXML
	private Button registerButton;

	@FXML
	private Label registrationInvalidLabel;
	
	@FXML
	private Label signUp;
	
	@FXML
	private Label haveAccount;
	
	@FXML
	private Label welcomeMessage;
	
	@FXML
	private Label specialCharLabel;
	
	@FXML
	private FontIcon eyeIcon;
	
	@FXML
	private Pane signUpPane;
	
	@FXML
	private Pane successPane;
	
	@FXML
	private Pane loadingPane;
	
	@FXML
	private Circle loadingCircle;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		registerUsernameField.textProperty().addListener(
				(observable, oldValue, newValue) -> {
					if (!registerUsernameField.getText().matches("[a-zA-Z0-9]*")) {
						specialCharLabel.setText("Special characters are not allowed.");
					} else {
						specialCharLabel.setText("");
					}
				});
		
		registerUsernameField.focusedProperty().addListener(
				(observable, oldValue, newValue) -> {
					if (registerUsernameField.getText().length()>=1 && registerUsernameField.getText().length()<=3) {
						specialCharLabel.setText("Username must be at least 3 characters long");
					} else if (registerUsernameField.getText().length()>=20) {
						specialCharLabel.setText("Username must be less than 12 characters long");
					}
				});
		
		
		plaintextField.textProperty().addListener(
				(observable, oldValue, newValue) -> {
					registerPasswordField.setText(plaintextField.getText());
					if (plaintextField.getText().equals("")){
						eyeIcon.setIconLiteral("fa-eye-slash");
						plaintextField.setVisible(false);
						registerPasswordField.setVisible(true);
					}
				});
		
		
		BooleanBinding checkFields = 
				registerUsernameField.textProperty().isEmpty()
					.or(registerUsernameField.textProperty().length().lessThanOrEqualTo(3))
						.or(registerUsernameField.textProperty().length().greaterThanOrEqualTo(15))
							.or(registerEmailField.textProperty().isEmpty())
								.or(registerPasswordField.textProperty().isEmpty())
									.or(specialCharLabel.textProperty().isNotEmpty());
		
		registerButton.disableProperty().bind(checkFields);
		eyeIcon.disableProperty().bind(registerPasswordField.textProperty().isEmpty());
		eyeIcon.visibleProperty().bind(registerPasswordField.textProperty().isNotEmpty());
		
		registerButton.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
	        if (event.getCode() == KeyCode.SPACE){
	            event.consume();
	        }
	    });
	}
	
	private void startLoadingAnimation() {
		signUpPane.setDisable(true);
		signUpPane.setVisible(false);
		loadingPane.setVisible(true);
		RotateTransition rotation = new RotateTransition(Duration.seconds(.75), loadingCircle);
		rotation.setOnFinished(event -> {
			loadingPane.setVisible(false);
			signUpPane.setDisable(false);
			signUpPane.setVisible(true);
		});
		rotation.setByAngle(360);
		rotation.play();
	}
	
	private void successTransition() {
		signUpPane.setDisable(true);
		signUpPane.setVisible(false);
		loadingPane.setVisible(true);
		RotateTransition rotation = new RotateTransition(Duration.seconds(.75), loadingCircle);
		rotation.setOnFinished(event -> {
			loadingPane.setVisible(false);
			successPane.setVisible(true);
			welcomeMessage.setText("Congratuluations " + registerUsernameField.getText() + "! You have successfully created your VLEAGUE account. To start playing, please proceed to the sign in page using the button below.");
		});
		rotation.setByAngle(360);
		rotation.play();
	}
	
	@FXML
	private void revealPassword(MouseEvent event) {
		if (eyeIcon.getIconLiteral().equals("fa-eye-slash")) {
			eyeIcon.setIconLiteral("fa-eye");
			plaintextField.setText(registerPasswordField.getText());
			plaintextField.setVisible(true);
			registerPasswordField.setVisible(false);
		} else {
			eyeIcon.setIconLiteral("fa-eye-slash");
			plaintextField.setVisible(false);;
			registerPasswordField.setVisible(true);
		}
	} 
	
	@FXML
	private void closeRegisterWindow(MouseEvent event) {
		Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
		s.close();
	}
	
	@FXML
	private void createAccount(ActionEvent event) {
		if (registerUsernameField.getText().isEmpty() == false && registerEmailField.getText().isEmpty() == false && registerPasswordField.getText().isEmpty() == false) {
			registerUsernameField.requestFocus();
			checkCredentials(registerUsernameField.getText(), registerEmailField.getText(), registerPasswordField.getText());
		} else {
			registrationInvalidLabel.setText("");
		}
	}
	
	@FXML
	private void onEnterPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER && registerButton.isDisabled() == false) {
			registerUsernameField.requestFocus();
			checkCredentials(registerUsernameField.getText(), registerEmailField.getText(), registerPasswordField.getText());
		} else {
			registrationInvalidLabel.setText("");
		}
	}
	
	private void checkCredentials(String username, String email, String password) {
		boolean checkUsername = Main.database.checkUsername(username);
		boolean checkEmail = Main.database.checkEmail(email);
		
		if (checkUsername==true) {
			startLoadingAnimation();
			registrationInvalidLabel.setText("Username already exists. Please choose another.");
			registerUsernameField.setText("");
			registerEmailField.setText("");;
			registerPasswordField.setText("");;
			plaintextField.setText("");;
			eyeIcon.setIconLiteral("fa-eye-slash");
			plaintextField.setVisible(false);;
			registerPasswordField.setVisible(true);
		} else if(checkEmail == true){
			startLoadingAnimation();
			registrationInvalidLabel.setText("Email address already exists. Please use another.");
			registerUsernameField.setText("");
			registerEmailField.setText("");;
			registerPasswordField.setText("");;
			plaintextField.setText("");;
			eyeIcon.setIconLiteral("fa-eye-slash");
			plaintextField.setVisible(false);;
			registerPasswordField.setVisible(true);
		} else {
			Main.database.add(username, email, Main.database.hashPassword(password));
			successTransition();
		}
	}
}
