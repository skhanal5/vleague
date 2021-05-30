package application;

import java.awt.Desktop;
import java.net.URL;
import java.util.ResourceBundle;

import org.kordamp.ikonli.javafx.FontIcon;

import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class GameController implements Initializable{
	
	@FXML
	private AnchorPane parent;
	
	@FXML
	private ScrollPane scheduleScroll;
	
	@FXML
	private AnchorPane myTeamSelect;
	
	@FXML
	private AnchorPane myTeamLoad;
	
	@FXML
	private AnchorPane myTeamPane;
	
	@FXML
	private Tab homeTab;
	
	@FXML
	private Tab myTeamTab;
	
	@FXML
	private Tab scheduleTab;
	
	@FXML
	private Tab resultsTab;
	
	@FXML
	private Tab globalTab;
	
	@FXML
	private Tab profileTab;
	
	@FXML
	private Circle homeCircle;
	
	@FXML
	private Circle myTeamCircle;
	
	@FXML
	private Circle scheduleCircle;
	
	@FXML
	private Circle resultsCircle;
	
	@FXML
	private Circle globalCircle;
	
	@FXML
	private Circle profileCircle;
	
	@FXML
	private Circle leaderLoadCircle;
	
	@FXML
	private Circle teamLoadCircle;
	
	@FXML
	private Pane homePane1;
	
	@FXML
	private Pane homePane2;
	
	@FXML
	private Pane homePane3;
	
	@FXML
	private Pane leaderboardPane;
	
	@FXML
	private Pane leaderboardLoad;
	
	@FXML
	private Label username;
	
	@FXML
	private Label refreshLabel;
	
	@FXML
	private Label timeStamp;
	
	@FXML
	private Label profileUsername;
	
	@FXML
	private Label profileDateJoined;
	
	@FXML
	private Label goldTrophy;
	
	@FXML
	private Label silverTrophy;
	
	@FXML
	private Label bronzeTrophy;
	
	@FXML
	private Label matchesPlayed;
	
	@FXML
	private Label vpEarned;
	
	@FXML
	private Label globalRank;
	
	@FXML
	private Label topFinishes;
	
	@FXML
	private Label favTeam;
	
	@FXML
	private Label teamNameLabel;
	
	@FXML
	private Label playerOne;
	
	@FXML
	private Label playerTwo;
	
	@FXML
	private Label playerThree;
	
	@FXML
	private Label playerFour;
	
	@FXML
	private Label playerFive;
	
	@FXML
	private Label myTeamHeader;
	
	@FXML
	private ImageView playerOnePic;
	
	@FXML
	private ImageView playerTwoPic;
	
	@FXML
	private ImageView playerThreePic;
	
	@FXML
	private ImageView playerFourPic;
	
	@FXML
	private ImageView playerFivePic;
	
	@FXML
	private FontIcon editProfile;
	
	@FXML
	private Pane profilePicPane;
	
	@FXML
	private AnchorPane profileScreen;
	
	@FXML
	private AnchorPane profileSelectScreen;
	
	@FXML
	private TabPane tabpane;
	
	@FXML
	private ScrollPane profileScroll;
	
	@FXML
	private ScrollPane leaderboardScroll;
	
	@FXML
	private ScrollPane resultsScroll;
	
	@FXML
	private ImageView previewUserIcon;
	
	@FXML
	private ImageView largeUserIcon;
	
	@FXML
	private ImageView smallUserIcon;
	
	@FXML
	private ImageView teamIconPreview;
	
	@FXML
	private FontIcon refreshIcon;
	
	@FXML
	private Button equipIcon;
	
	@FXML
	private Button lockIn;

	private double xOffset;
	
	private double yOffset;
	
	private int pos = 0;
	
	public static MediaPlayer bgMusic;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		homeSlideshow();
		homeTab.selectedProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (homeTab.isSelected()) {
						homeCircle.setFill(Color.web("#fa4454"));
					} else {
						homeCircle.setFill(Color.web("#c7c7c7"));
					}
				});

		myTeamTab.selectedProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (myTeamTab.isSelected()) {
						myTeamCircle.setFill(Color.web("#fa4454"));
						if (Main.database.checkTeam(username.getText())) {
							myTeamLoad();
						} else {
							teamIconPreview.setImage(null);
							teamNameLabel.setText("");
							playerOne.setText("Player 1");
							playerTwo.setText("Player 2");
							playerThree.setText("Player 3");
							playerFour.setText("Player 4");
							playerFive.setText("Player 5");
							playerOnePic.setImage(new Image (getClass().getResourceAsStream("/VLEAGUE Assets/team icons/person-icon.png")));
							playerTwoPic.setImage(new Image (getClass().getResourceAsStream("/VLEAGUE Assets/team icons/person-icon.png")));
							playerThreePic.setImage(new Image (getClass().getResourceAsStream("/VLEAGUE Assets/team icons/person-icon.png")));
							playerFourPic.setImage(new Image (getClass().getResourceAsStream("/VLEAGUE Assets/team icons/person-icon.png")));
							playerFivePic.setImage(new Image (getClass().getResourceAsStream("/VLEAGUE Assets/team icons/person-icon.png")));
						}
					} else {
						myTeamCircle.setFill(Color.web("#c7c7c7"));
					}
				});

		scheduleTab.selectedProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (scheduleTab.isSelected()) {
						scheduleCircle.setFill(Color.web("#fa4454"));
					} else {
						scheduleCircle.setFill(Color.web("#c7c7c7"));
					}
				});

		resultsTab.selectedProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (resultsTab.isSelected()) {
						resultsCircle.setFill(Color.web("#fa4454"));
					} else {
						resultsScroll.setVvalue(0);
						resultsCircle.setFill(Color.web("#c7c7c7"));
					}
				});

		globalTab.selectedProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (globalTab.isSelected()) {
						globalCircle.setFill(Color.web("#fa4454"));
						timeStamp.setText("JUST NOW");
					} else {
						leaderboardScroll.setVvalue(0);
						globalCircle.setFill(Color.web("#c7c7c7"));
						;
					}
				});

		profileTab.selectedProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (profileTab.isSelected()) {
						profileCircle.setFill(Color.web("#fa4454"));
					} else {
						profileCircle.setFill(Color.web("#c7c7c7"));
						profileScroll.setHvalue(.5);
						profileScreen.setVisible(true);
						profileScreen.setDisable(false);
						profileSelectScreen.setDisable(true);
						profileSelectScreen.setVisible(false);
					}
				});

		// shows edit profile font icon if user is hovering otherwise it is not
		// visible in the profile pane
		profilePicPane.hoverProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (profilePicPane.isHover()) {
						editProfile.setDisable(false);
						editProfile.setVisible(true);
					} else {
						editProfile.setDisable(true);
						editProfile.setVisible(false);
					}
				});

		// prevents users from traversing through tabpane by using arrow keys on
		// keyboard
		tabpane.addEventFilter(KeyEvent.ANY, event -> {
			if (event.getCode().isArrowKey()) {
				event.consume();
			}
		});

		//locks team select button until player makes choice
		teamIconPreview.imageProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (teamIconPreview.getImage() == null) {
						lockIn.setDisable(true);
					} else {
						lockIn.setDisable(false);
					}
				});
		
		dragStage();
	}
	
	//sets username from previous controller
	public void setUsername(String user) {
		username.setText(user);
		initializeProfilePage(user);
		try {
			Media audioFile = new Media(getClass().getResource("/bgmusic.mp3").toURI().toString());
			bgMusic = new MediaPlayer(audioFile);
			
			//loops background music indefinitely
			bgMusic.setOnEndOfMedia(new Runnable() {
			       public void run() {
			         bgMusic.seek(Duration.ZERO);
			       }
			   });
			bgMusic.play();
			bgMusic.setVolume(Main.database.getMusicVolume(user));
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//retrieves values from user document in database to display in profile
	private void initializeProfilePage(String user) {
		profileUsername.setText(user);
		profileDateJoined.setText(Main.database.getDateJoined(user));
		smallUserIcon.setImage(new Image(getClass().getResourceAsStream(Main.database.getSmallIcon(user))));
		largeUserIcon.setImage(new Image(getClass().getResourceAsStream(Main.database.getLargeIcon(user))));
		previewUserIcon.setImage(largeUserIcon.getImage());
		goldTrophy.setText(Main.database.getGolds(user));
		silverTrophy.setText(Main.database.getSilvers(user));
		bronzeTrophy.setText(Main.database.getBronzes(user));
		matchesPlayed.setText(Main.database.getMatchTotal(user));
		vpEarned.setText(Main.database.getEarnings(user));
		globalRank.setText(Main.database.getRank(user));
		topFinishes.setText(Main.database.getFinishes(user));
		favTeam.setText(Main.database.getTeam(user));
	}
	
	//runs the "slideshow" at the right side of the home page at a 5 second interval
	private void homeSlideshow() {
		Pane[] infoPane = {homePane1, homePane2, homePane3};
		Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
			if (pos==infoPane.length-1) {
				infoPane[pos].setVisible(false);
				pos=0;
				infoPane[pos].setVisible(true);
			} else {
				infoPane[pos].setVisible(false);
				infoPane[++pos].setVisible(true);
			}	
		}));
		fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
		fiveSecondsWonder.play();
		
	}
	
	//makes current stage draggable
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
	
	//starts loading animation for leaderboard
	private void leaderboardLoad() {
		leaderboardPane.setDisable(true);
		leaderboardPane.setVisible(false);
		leaderboardLoad.setVisible(true);
		leaderboardScroll.setVmax(0);
		RotateTransition rotation = new RotateTransition(Duration.seconds(.75), leaderLoadCircle);
		rotation.setByAngle(360);
		rotation.play();
		rotation.setOnFinished(event -> {
			leaderboardScroll.setVmax(1);
			leaderboardPane.setDisable(false);
			leaderboardPane.setVisible(true);
			leaderboardLoad.setVisible(false);
		});
	}
	
	//starts loading animation for myTeam
	private void myTeamLoad() {
		myTeamPane.setVisible(false);
		myTeamSelect.setDisable(true);
		myTeamSelect.setVisible(false);
		myTeamLoad.setVisible(true);
		RotateTransition rotation = new RotateTransition(Duration.seconds(.75), teamLoadCircle);
		rotation.setByAngle(360);
		rotation.play();
		rotation.setOnFinished(event -> {
			myTeamLoad.setVisible(false);
			myTeamPane.setVisible(true);
			myTeamHeader.setText(Main.database.getMyTeam(username.getText()));
		});
	}
	
	@FXML
	private void onRefreshSelect(MouseEvent event) {
		leaderboardLoad();
	}
	
	//speeds up vertical scroll speed for the leaderboard scrollpane
	@FXML
	private void onLeaderboardScrolling(ScrollEvent event) {
		double deltaY = event.getDeltaY()*3;
        double width = leaderboardScroll.getContent().getBoundsInLocal().getWidth();
		double vvalue = leaderboardScroll.getVvalue();
        leaderboardScroll.setVvalue(vvalue - deltaY/width); 
	}
	
	//speeds up vertical scroll speed for the streaming scrollpane
	@FXML
	private void onStreamScrolling(ScrollEvent event) {
		double deltaY = event.getDeltaY()*3;
        double width = resultsScroll.getContent().getBoundsInLocal().getWidth();
		double vvalue = resultsScroll.getVvalue();
		resultsScroll.setVvalue(vvalue - deltaY/width); 
	}
	
	//will display the settings menu once clicked
	@FXML
	private void onGearSelect(MouseEvent event) throws Exception{
		Stage dialogStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
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
		dialogStage.getIcons().add(new Image(getClass().getResourceAsStream("/iconlogo.png")));
		dialogStage.setX(Main.primaryStage.getX() + (Main.primaryStage.getWidth() / 2) - root.getPrefWidth() / 2);
		dialogStage.setY(Main.primaryStage.getY() + (Main.primaryStage.getHeight() / 2) - root.getPrefHeight() / 2);
		SettingsController controller = loader.getController();
        controller.setAccountInfo(username.getText());
		dialogStage.initOwner(Main.primaryStage);
        dialogStage.showAndWait();
	}
	
	//redirects users to github page
	@FXML
	private void onPatchNotesSelect(MouseEvent event) throws Exception {
		Desktop.getDesktop().browse(new URL("https://github.com/skhanal5/vleague").toURI());
	}
	
	//shows pane with profile icons
	@FXML
	private void onEditProfileSelect(MouseEvent event) {
		profileScreen.setVisible(false);
		profileScreen.setDisable(true);
		profileSelectScreen.setDisable(false);
		profileSelectScreen.setVisible(true);
		profileScroll.setHvalue(.5);
	}
	
	//goes back to main profile pane
	@FXML
	private void onBackArrowSelect(MouseEvent event) {
		profileScreen.setVisible(true);
		profileScreen.setDisable(false);
		profileSelectScreen.setDisable(true);
		profileSelectScreen.setVisible(false);
		previewUserIcon.setImage(largeUserIcon.getImage());
	}
	
	private void playerIconShowcase(String largeIcon, String smallIcon) {
		previewUserIcon.setImage(new Image(getClass().getResourceAsStream(largeIcon)));
		equipIcon.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent actionEvent) {
		    	smallUserIcon.setImage(new Image(getClass().getResourceAsStream(smallIcon)));
		    	largeUserIcon.setImage(previewUserIcon.getImage());
		    	Main.database.setIcon(username.getText(), smallIcon, largeIcon);
		    }
		});
	}
	
	@FXML
	private void onBrimLabelSelect(MouseEvent event) {
		playerIconShowcase("/VLEAGUE Assets/large icons/brim-large-icon.png", "/VLEAGUE Assets/small icons/brim-small-icon.png");
	}
	
	@FXML
	private void onCypherLabelSelect(MouseEvent event) {
		playerIconShowcase("/VLEAGUE Assets/large icons/cypher-large-icon.png", "/VLEAGUE Assets/small icons/cypher-small-icon.png");
	}
	
	@FXML
	private void onSkyeLabelSelect(MouseEvent event) {
		playerIconShowcase("/VLEAGUE Assets/large icons/sky-large-icon.png", "/VLEAGUE Assets/small icons/skye-small-icon.png");
	}
	
	@FXML
	private void onPhoenixLabelSelect(MouseEvent event) {
		playerIconShowcase("/VLEAGUE Assets/large icons/phoenix-large-icon.png", "/VLEAGUE Assets/small icons/phoenix-small-icon.png");
	}
	
	@FXML
	private void onRazeLabelSelect(MouseEvent event) {
		playerIconShowcase("/VLEAGUE Assets/large icons/raze-large-icon.png", "/VLEAGUE Assets/small icons/raze-small-icon.png");
	}
	
	@FXML
	private void onJettLabelSelect(MouseEvent event) {
		playerIconShowcase("/VLEAGUE Assets/large icons/jett-large-icon.png", "/VLEAGUE Assets/small icons/jett-small-icon.png");
	}
	
	@FXML
	private void onReynaLabelSelect(MouseEvent event) {
		playerIconShowcase("/VLEAGUE Assets/large icons/reyna-large-icon.png", "/VLEAGUE Assets/small icons/reyna-small-icon.png");
	}
	
	@FXML
	private void onSovaLabelSelect(MouseEvent event) {
		playerIconShowcase("/VLEAGUE Assets/large icons/sova-large-icon.png", "/VLEAGUE Assets/small icons/sova-small-icon.png");
	}
	
	@FXML
	private void onKillJoyLabelSelect(MouseEvent event) {
		playerIconShowcase("/VLEAGUE Assets/large icons/sova-large-icon.png", "/VLEAGUE Assets/small icons/sova-small-icon.png");
	}
	
	@FXML
	private void onOmenLabelSelect(MouseEvent event) {
		playerIconShowcase("/VLEAGUE Assets/large icons/omen-large-icon.png", "/VLEAGUE Assets/small icons/omen-small-icon.png");
	}
	
	@FXML
	private void onSageLabelSelect(MouseEvent event) {
		playerIconShowcase("/VLEAGUE Assets/large icons/sage-large-icon.png", "/VLEAGUE Assets/small icons/sage-small-icon.png");
	}
	
	@FXML
	private void onYoruLabelSelect(MouseEvent event) {
		playerIconShowcase("/VLEAGUE Assets/large icons/yoru-large-icon.png", "/VLEAGUE Assets/small icons/yoru-small-icon.png");
	}
	
	@FXML
	private void onViperLabelSelect(MouseEvent event) {
		playerIconShowcase("/VLEAGUE Assets/large icons/viper-large-icon.png", "/VLEAGUE Assets/small icons/viper-small-icon.png");
	}
	
	@FXML
	private void onBreachLabelSelect(MouseEvent event) {
		playerIconShowcase("/VLEAGUE Assets/large icons/breach-large-icon.png", "/VLEAGUE Assets/small icons/breach-small-icon.png");
	}
	
	private void showcaseTeam(String teamName, String imageURL, String player1, String player2, String player3, String player4, String player5,
								String picOne, String picTwo, String picThree, String picFour, String picFive) {
		teamNameLabel.setText(teamName);
		teamIconPreview.setImage(new Image(getClass().getResourceAsStream(imageURL)));
		playerOne.setText(player1);
		playerTwo.setText(player2);
		playerThree.setText(player3);
		playerFour.setText(player4);
		playerFive.setText(player5);
		playerOnePic.setImage(new Image (getClass().getResourceAsStream(picOne)));
		playerTwoPic.setImage(new Image (getClass().getResourceAsStream(picTwo)));
		playerThreePic.setImage(new Image (getClass().getResourceAsStream(picThree)));
		playerFourPic.setImage(new Image (getClass().getResourceAsStream(picFour)));
		playerFivePic.setImage(new Image (getClass().getResourceAsStream(picFive)));
	}
	
	@FXML
	private void onTSMSelect(MouseEvent event) {
		showcaseTeam("TEAM SOLOMID","/VLEAGUE Assets/large team icon/tsm-large.png", "WARDELL", "hazed", "Drone", "Subroza", "brax",
					"/VLEAGUE Assets/team icons/tsm/TSM_Wardell_2020.png", "/VLEAGUE Assets/team icons/tsm/TSM_hazed_2020.png",
					"/VLEAGUE Assets/team icons/tsm/TSM_Drone_2020.png", "/VLEAGUE Assets/team icons/tsm/TSM_Subroza_2020.png",
					"/VLEAGUE Assets/team icons/tsm/TSM_Cutler_2020.png");
	}
	
	@FXML
	private void on100TSelect(MouseEvent event) {
		showcaseTeam("100 THIEVES","/VLEAGUE Assets/large team icon/100t-large.png", "Hiko", "Ethan", "Asuna", "nitr0", "steel",
				"/VLEAGUE Assets/team icons/100t/100T_Hiko_2020.png", "/VLEAGUE Assets/team icons/100t/100T_Ethan_2020.png",
				"/VLEAGUE Assets/team icons/100t/100T_Asuna_2020.png", "/VLEAGUE Assets/team icons/100t/100T_nitr0_2020.png",
				"/VLEAGUE Assets/team icons/100t/100T_steel_2020.png");
	}
	
	@FXML
	private void onC9Select(MouseEvent event) {
		showcaseTeam("CLOUD 9","/VLEAGUE Assets/large team icon/c9-large.png", "leaf", "xeta", "poiz", "mitch", "floppy",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onSentinelsSelect(MouseEvent event) {
		showcaseTeam("SENTINELS","/VLEAGUE Assets/large team icon/sen-large.png", "TenZ", "ShahZam", "SicK", "zombs", "dapr",
				"/VLEAGUE Assets/team icons/sentinels/SEN_TenZ_2020.png", "/VLEAGUE Assets/team icons/sentinels/SEN_ShahZaM_2020.png",
				"/VLEAGUE Assets/team icons/sentinels/SEN_SicK_2020.png", "/VLEAGUE Assets/team icons/sentinels/SEN_zombs_2020.png",
				"/VLEAGUE Assets/team icons/sentinels/SEN_dapr_2020.png");
	}
	
	@FXML
	private void onEnvySelect(MouseEvent event) {
		showcaseTeam("ENVY","/VLEAGUE Assets/large team icon/envy-large.png", "Victor", "crashies", "FNS", "mummAy", "kaboose",
				"/VLEAGUE Assets/team icons/envy/ENVY_Victor_2020.png", "/VLEAGUE Assets/team icons/envy/ENVY_Crashies_2020.png",
				"/VLEAGUE Assets/team icons/envy/ENVY_FNS_2020.png", "/VLEAGUE Assets/team icons/envy/ENVY_Mummay_2020.png",
				"/VLEAGUE Assets/team icons/envy/ENVY_Kaboose_2020.png");
	}
	
	@FXML
	private void onGenGSelect(MouseEvent event) {
		showcaseTeam("GEN.G","/VLEAGUE Assets/large team icon/geng-large.png", "huynh", "Mkael", "gMd", "koosta", "Shawn",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png");;
	}
	
	@FXML
	private void onLGSelect(MouseEvent event) {
		showcaseTeam("LUMINOSITY GAMING","/VLEAGUE Assets/large team icon/lg-large.png", "aproto", "stellar", "thief", "YaBoiDre", "moose",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onFazeSelect(MouseEvent event) {
		showcaseTeam("FAZE CLAN","/VLEAGUE Assets/large team icon/faze-large.png", "ZachaREEE", "BABYBAY", "Marved", "Rawkus", "corey",
				"/VLEAGUE Assets/team icons/faze/FaZe_Zacharee_2020.png", "/VLEAGUE Assets/team icons/faze/FaZe_babybay_2020.png",
				"/VLEAGUE Assets/team icons/faze/Faze_marved_2020.png", "/VLEAGUE Assets/team icons/faze/FaZe_Rawkus_2020.png",
				"/VLEAGUE Assets/team icons/faze/FaZe_Corey.png");
	}
	
	@FXML
	private void onXSETSelect(MouseEvent event) {
		showcaseTeam("XSET GAMING","/VLEAGUE Assets/large team icon/xset-large.png", "PureR", "AYRIN", "WeDid", "BcJ", "thwifo",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onNRGSelect(MouseEvent event) {
		showcaseTeam("NRG ESPORTS","/VLEAGUE Assets/large team icon/nrg-large.png", "ANDROID", "eeiu", "s0m", "daps", "tex",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onIMTSelect(MouseEvent event) {
		showcaseTeam("IMMORTALS","/VLEAGUE Assets/large team icon/imt-large.png", "N/A", "Kehmicals", "jcStani", "Genghsta", "ShoT_UP",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onT1Select(MouseEvent event) {
		showcaseTeam("T1 ESPORTS","/VLEAGUE Assets/large team icon/t1-large.png", "autimatic", "curry", "Skadoodle", "Spyder", "DaZeD",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onV1Select(MouseEvent event) {
		showcaseTeam("VERSION 1","/VLEAGUE Assets/large team icon/v1-large.png", "vanity", "effys", "Zellsis", "penny", "wippie",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onRNGSelect(MouseEvent event) {
		showcaseTeam("RENEGADES","/VLEAGUE Assets/large team icon/rng-large.png", "Stronglegs", "cp2", "randyySAVAGE", "Winsum", "RetrQ",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onBBGSelect(MouseEvent event) {
		showcaseTeam("BUILT BY GAMERS","/VLEAGUE Assets/large team icon/bbg-large.png", "Poach", "rarkar", "Critical", "Bjor", "Will",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onANDBOXSelect(MouseEvent event) {
		showcaseTeam("ANDBOX","/VLEAGUE Assets/large team icon/andbox-large.png", "jcStani", "vice", "yay", "seb", "mada",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png", "/VLEAGUE Assets/team icons/person-icon.png",
				"/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onLockInSelect(MouseEvent event) {
		Main.database.setTeam(username.getText(), true, teamNameLabel.getText());
		myTeamLoad();
	}
}
