package application;

import java.awt.Desktop;
import java.net.URL;
import java.util.ResourceBundle;

import org.kordamp.ikonli.javafx.FontIcon;
import org.mindrot.jbcrypt.BCrypt;

import javafx.animation.RotateTransition;
import javafx.beans.binding.BooleanBinding;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class SignInController implements Initializable {
	
	@FXML
	private AnchorPane parent;
	
	@FXML
	private AnchorPane signInPane;
	
	@FXML
	private Pane loadingPane;
	
	@FXML
	private Circle loadingCircle;
	
	@FXML
	private TextField usernameField;
	
	@FXML
	private TextField plaintextField;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private Button loginButton;
	
	@FXML
	private Label loginInvalidLabel;
	
	@FXML
	private Label specialCharLabel;
	
	@FXML
	private FontIcon eyeIcon;
	
	private double xOffset = 0;
	private double yOffset = 0;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		usernameField.textProperty().addListener(
				(observable, oldValue, newValue) -> {
					if (!usernameField.getText().matches("[a-zA-Z0-9]*")) {
						specialCharLabel.setText("Special characters are not allowed.");
					} else if (usernameField.getText().matches("[a-zA-Z0-9]*")) {
						specialCharLabel.setText("");	
					}
				});
		
		usernameField.focusedProperty().addListener(
				(observable, oldValue, newValue) -> {
					if (usernameField.getText().length()>=1 && usernameField.getText().length()<=3) {
						specialCharLabel.setText("Username must be at least 3 characters long");
					} else if (usernameField.getText().length()>=15) {
						specialCharLabel.setText("Username must be less than 15 characters long");
					}
				});
		
		plaintextField.textProperty().addListener(
				(observable, oldValue, newValue) -> {
					passwordField.setText(plaintextField.getText());
					if (plaintextField.getText().equals("")){
						eyeIcon.setIconLiteral("fa-eye-slash");
						plaintextField.setVisible(false);
						passwordField.setVisible(true);
					}
				});
		
		BooleanBinding checkFields =
				specialCharLabel.textProperty().isNotEmpty()
					.or(usernameField.textProperty().length().lessThanOrEqualTo(3))
						.or(usernameField.textProperty().length().greaterThanOrEqualTo(15))
							.or(passwordField.textProperty().isEmpty());
		
		loginButton.disableProperty().bind(checkFields);
		eyeIcon.disableProperty().bind(passwordField.textProperty().isEmpty());
		eyeIcon.visibleProperty().bind(passwordField.textProperty().isNotEmpty());
		dragStage();
	}
	
	private void dragStage() {
		parent.setOnMousePressed((event) ->  {
			parent.requestFocus();
		});
		
		parent.setOnMousePressed((event) -> {
			xOffset = event.getSceneX();
			yOffset = event.getSceneY();
		}); 
		
		parent.setOnMouseDragged((event) -> {
			Main.primaryStage.setX(event.getScreenX() - xOffset);
			Main.primaryStage.setY(event.getScreenY() - yOffset);
		});
	}
	
	private void startLoadingAnimation() {
		signInPane.setDisable(true);
		loadingPane.setVisible(true);
		RotateTransition rotation = new RotateTransition(Duration.seconds(.75), loadingCircle);
		rotation.setByAngle(360);
		rotation.play();
		rotation.setOnFinished(event -> {
			loadingPane.setVisible(false);
			signInPane.setDisable(false);
		});
	}
	
	private void gameTransition() {
		loadWindow();
		signInPane.setDisable(true);
		loadingPane.setVisible(true);
		RotateTransition rotation = new RotateTransition(Duration.seconds(2), loadingCircle);
		rotation.setByAngle(720);
		rotation.play();
		rotation.setOnFinished(event -> {
			loadingPane.setVisible(false);
		});
	}
	
	private void loadWindow() {
		Task<Parent>loadTask = new Task<Parent>() {
			@Override
			public Parent call() throws Exception {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
				Parent root = loader.load();
				GameController controller = loader.getController();
		        controller.setUsername(usernameField.getText());
		        return root;
			}
		};
		
		loadTask.setOnSucceeded(e-> {
			Main.primaryStage.getScene().setRoot(loadTask.getValue());
		});
		loadTask.setOnFailed(e -> loadTask.getException().printStackTrace());
		new Thread(loadTask).start();
	}
	
	@FXML
	private void loginButtonOnAction(ActionEvent event) {
		if (usernameField.getText().isEmpty() == false && passwordField.getText().isEmpty() == false) {
			usernameField.requestFocus();
			checkLogin(usernameField.getText(), passwordField.getText());
		} else {
			loginInvalidLabel.setText("");
		}
	}
	
	@FXML
	private void onEnterPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER && loginButton.isDisabled() == false) {
			usernameField.requestFocus();
			checkLogin(usernameField.getText(), passwordField.getText());
		} else {
			loginInvalidLabel.setText("");
		}
	}
	
	private void checkLogin(String username, String password) {
		boolean checkUsername = Main.database.checkUsername(username);
		
		if (checkUsername) {
			if (BCrypt.checkpw(password, Main.database.getHashedPassword(username))) {
				gameTransition();
			} else {
				startLoadingAnimation();
				loginInvalidLabel.setText("Invalid credentials. Please try again");
				usernameField.setText("");
				passwordField.setText("");
				eyeIcon.setIconLiteral("fa-eye-slash");
				plaintextField.setVisible(false);;
				passwordField.setVisible(true);
			}
		} else {
			startLoadingAnimation();
			loginInvalidLabel.setText("Invalid credentials. Please try again");
			usernameField.setText("");
			passwordField.setText("");
			eyeIcon.setIconLiteral("fa-eye-slash");
			plaintextField.setVisible(false);;
			passwordField.setVisible(true);
		}
		
	}
	
	@FXML
	private void revealPassword(MouseEvent event) {
		if (eyeIcon.getIconLiteral().equals("fa-eye-slash")) {
			eyeIcon.setIconLiteral("fa-eye");
			plaintextField.setText(passwordField.getText());
			plaintextField.setVisible(true);
			passwordField.setVisible(false);
		} else {
			eyeIcon.setIconLiteral("fa-eye-slash");
			passwordField.setVisible(true);
			plaintextField.setVisible(false);;
		}
	}
	
	@FXML
	private void redirectWindow() throws Exception{
		 Desktop.getDesktop().browse(new URL("https://github.com/skhanal5/vleague").toURI());
	}
	
	@FXML
	private void createAccount() throws Exception{
		loginInvalidLabel.setText("");
		usernameField.setText("");
		passwordField.setText("");
		Stage dialogStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
		AnchorPane root = (AnchorPane)loader.load();
		root.setStyle(
	                "-fx-background-color: transparent; " +
	                "-fx-background-insets: 10; " +
	                "-fx-background-radius: 10; " +
	                "-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);"
	    );
		//RegisterController controller = (RegisterController) loader.getController();
		Scene scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		dialogStage.initStyle(StageStyle.TRANSPARENT);
		dialogStage.setScene(scene);
		dialogStage.initModality(Modality.APPLICATION_MODAL);
		dialogStage.setTitle("VLeague Client");
		dialogStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/iconlogo.png")));
		dialogStage.setX(Main.primaryStage.getX() + (Main.primaryStage.getWidth() / 2) - root.getPrefWidth() / 2);
		dialogStage.setY(Main.primaryStage.getY() + (Main.primaryStage.getHeight() / 2) - root.getPrefHeight() / 2);
		dialogStage.initOwner(Main.primaryStage);
		dialogStage.showAndWait();
	}
	
	@FXML
	private void redirectSignIn() throws Exception{
		 Desktop.getDesktop().browse(new URL("https://github.com/skhanal5/vleague").toURI());
	}
	
	@FXML
	private void minimizeWindow(MouseEvent event) {
		Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
		s.setIconified(true);
	}
	
	@FXML
	private void closeWindow(MouseEvent event) {
		Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
		s.close();
	}
}
