package application;

import java.awt.Desktop;
import java.net.URL;
import java.util.ResourceBundle;

import org.kordamp.ikonli.javafx.FontIcon;

import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;

import javafx.animation.RotateTransition;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SettingsController implements Initializable {
	
	@FXML
	private Pane settingsPane;
	
	@FXML
	private Pane animationPane;
	
	@FXML
	private Pane accountInfoPane;
	
	@FXML
	private Circle loadingCircle;
	
	@FXML
	private Label emailAddress;
	
	@FXML
	private Label username;
	
	@FXML
	private Label dateCreated;
	
	@FXML
	private JFXSlider musicSlider;
	
	@FXML
	private JFXSlider fxSlider;
	
	@FXML
	private JFXToggleButton lightSwitch;
	
	@FXML
	private FontIcon sunIcon;
	
	@FXML
	private FontIcon moonIcon;
	
	private boolean init;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		musicSlider.setValue(GameController.bgMusic.getVolume() * 100);
		musicSlider.valueProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				GameController.bgMusic.setVolume(musicSlider.getValue()/100);
			}
			
		});
		
		fxSlider.setValue(GameController.clip.getVolume() * 100);
		fxSlider.valueProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				GameController.clip.setVolume(fxSlider.getValue()/100);
			}
			
		});
		
		lightSwitch.selectedProperty().addListener(
				(observable, oldValue, newValue) -> {
					Parent curr = moonIcon.getScene().getRoot();
						
					if (init==false) {
						Main.database.setDarkLightMode(username.getText());
					}
						if (lightSwitch.isSelected()) {
							curr.getStylesheets().set(0,getClass().getResource("darkmode.css").toExternalForm());
							moonIcon.setDisable(false);
							moonIcon.setVisible(true);
							sunIcon.setDisable(true);
							sunIcon.setVisible(false);
						} else if(lightSwitch.isSelected()==false) {
							sunIcon.setDisable(false);
							sunIcon.setVisible(true);
							moonIcon.setDisable(true);
							moonIcon.setVisible(false);
							curr.getStylesheets().set(0,getClass().getResource("lightmode.css").toExternalForm());
						}
				});
	}
	
	public void setAccountInfo(String username) {
		this.username.setText(username);
	}
	
	public void setTheme(String username) {
		init = true;
		Boolean colorValue = Main.database.getDarkOrLight(username);
		if (colorValue==false) {
			lightSwitch.setSelected(false);
		} else {
			lightSwitch.setSelected(true);
		}
		init = false;
	}
	
	//hides the settings pane and temporarily displays animation before switching to account information pane
	private void transitionToAccountInfo() {
		settingsPane.setDisable(true);
		settingsPane.setVisible(false);
		animationPane.setVisible(true);
		RotateTransition rotation = new RotateTransition(Duration.seconds(.75), loadingCircle);
		rotation.setOnFinished(event -> {
			animationPane.setVisible(false);
			accountInfoPane.setDisable(false);
			accountInfoPane.setVisible(true);
		});
		rotation.setByAngle(360);
		rotation.play();
	}
	
	//hides the account information pane and temporarily displays animation before switching to settings pane
	private void transitionToSettings() {
		accountInfoPane.setDisable(true);
		accountInfoPane.setVisible(false);
		animationPane.setVisible(true);
		RotateTransition rotation = new RotateTransition(Duration.seconds(.75), loadingCircle);
		rotation.setOnFinished(event -> {
			animationPane.setVisible(false);
			settingsPane.setDisable(false);
			settingsPane.setVisible(true);
		});
		rotation.setByAngle(360);
		rotation.play();
	}
	
	//triggers the account information transition if the account information label is selected
	@FXML
	private void onAccountInfoSelect(MouseEvent event) {
		transitionToAccountInfo();
		emailAddress.setText(Main.database.getEmailAddress(username.getText()));
		dateCreated.setText(Main.database.getDateJoined(username.getText()));
	}
	
	//triggers the settings transition if the "back" arrow is selected
	@FXML
	private void onBackSelect(MouseEvent event) {
		transitionToSettings();
	}
	
	//closes this dialog box window when the "back" arrow on the settings pane is selected
	@FXML
	private void closeSettingsWindow(MouseEvent event) {
		Main.database.setVolume(username.getText(), musicSlider.getValue()/100, fxSlider.getValue()/100);;
		Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
		s.close();
	}
	
	//closes this dialog box window and closes main window as well when "leave game" on the settings pane is selected
	@FXML
	private void leaveGameSelect(MouseEvent event) {
		Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
		s.close();
		Main.primaryStage.close();
	}
	
	//transitions user to GitHub read-me through default browser when the about us pane is selected
	@FXML
	private void aboutUsSelect(MouseEvent event) throws Exception {
		 Desktop.getDesktop().browse(new URL("https://github.com/skhanal5/VLEAGUE/blob/main/README.md").toURI());
	}
	
	//transitions user to GitHub read-me through default browser when the need help pane is selected
	@FXML
	private void needHelpSelect(MouseEvent event) throws Exception {
		 Desktop.getDesktop().browse(new URL("https://github.com/skhanal5/VLEAGUE/blob/main/README.md").toURI());
	}
	
	//transitions user to GitHub issues wiki page through default browser when the report issue pane is selected
	@FXML
	private void reportIssueSelect(MouseEvent event) throws Exception {
		 Desktop.getDesktop().browse(new URL("https://github.com/skhanal5/VLEAGUE/issues/new").toURI());
	}
	
	@FXML
	private void onSunIconSelect(MouseEvent event) {
		lightSwitch.setSelected(true);
	}
	
	@FXML
	private void onMoonIconSelect(MouseEvent event) {
		lightSwitch.setSelected(false);
	}
	
	@FXML
	private void onNodeHover(MouseEvent event) {
		GameController.clip.play();
	}
}
