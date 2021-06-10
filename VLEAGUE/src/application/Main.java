package application;
	
import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	
	public static Stage primaryStage = null;
	public static Database database = new Database();
	@Override
	public void start(Stage stage) throws Exception {
		Dimension screenRes= Toolkit.getDefaultToolkit().getScreenSize();
		Parent root = FXMLLoader.load(getClass().getResource("/application/sign-in.fxml"));
		stage.setTitle("VLeague Client");
		stage.setScene(new Scene(root, 1280, 720));
		stage.initStyle(StageStyle.UNDECORATED);
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/iconlogo.png")));
		primaryStage = stage;
		primaryStage.show();
		primaryStage.setX(screenRes.width/2-(primaryStage.getWidth()/2));
		primaryStage.setY(screenRes.height/2-(primaryStage.getHeight()/2));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
